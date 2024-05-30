package filter;

import beans.LoginController;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebFilter("/*")
public class LoginFilter implements Filter {

    private static final Set<String> adminOnlyUrls = new HashSet<>();
    private static final Set<String> studentOnlyUrls = new HashSet<>();
    private static final Set<String> publicUrls = new HashSet<>();

    static {
        // Admin'e özel sayfalar
        adminOnlyUrls.add("/panel/admin");

        // Öğrenciye özel sayfalar
        studentOnlyUrls.add("/panel/ogrenci");

        // Herkese açık sayfalar
        publicUrls.add("/panel/admin/admin/AdminGiris.xhtml");
        publicUrls.add("/panel/admin/admin/AdminKaydol.xhtml");
        publicUrls.add("/panel/ogrenci/ogrenci/OgrenciGiris.xhtml");
        publicUrls.add("/panel/ogrenci/ogrenci/OgrenciKaydol.xhtml");
        publicUrls.add("/panel/ogrenci/ogrenci/OgrenciAnasayfa.xhtml");
        publicUrls.add("/panel/admin/admin/AdminAnasayfa.xhtml");
        publicUrls.add("/index.html"); // İlk açılışta izin verilen sayfa
        publicUrls.add("/"); // Root URI izin verildi
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Filtre başlatma kodları (gerekirse)
    }
@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;
    HttpSession session = req.getSession(false);

    LoginController loginBean = (session != null) ? (LoginController) session.getAttribute("loginController") : null;
    System.out.println("loginbean: " + loginBean);
    String loginURI = req.getContextPath() + "/";
    System.out.println("loginuri: " + loginURI);
    String logoutURI = req.getContextPath() + "/logout.xhtml";
    System.out.println("logouturi: " + logoutURI);

    String requestURI = req.getRequestURI().substring(req.getContextPath().length());
    System.out.println("requri: " + requestURI);
    boolean loggedIn = loginBean != null && loginBean.getRole() != null;
    System.out.println("loggedin: " + loggedIn);
    boolean loginRequest = publicUrls.contains(requestURI) || requestURI.equals("/");
    System.out.println("loginreq: " + loginRequest);
    boolean resourceRequest = req.getRequestURI().startsWith(req.getContextPath() + "/jakarta.faces.resource");

    boolean isAdmin = loggedIn && "admin".equals(loginBean.getRole());
    System.out.println("admin: " + isAdmin);
    boolean isStudent = loggedIn && "student".equals(loginBean.getRole());
    System.out.println("student: " + isStudent);

    if (requestURI.equals(logoutURI)) {
        if (session != null) {
            session.invalidate();
        }
        // Çıkış yapan kullanıcının rolüne göre yönlendirme
        if (isAdmin) {
            res.sendRedirect(req.getContextPath() + "/panel/admin/admin/AdminGiris.xhtml");
        } else if (isStudent) {
            res.sendRedirect(req.getContextPath() + "/panel/ogrenci/ogrenci/OgrenciGiris.xhtml");
        } else {
            res.sendRedirect(loginURI);
        }
        return;
    }

    if (loggedIn || loginRequest || resourceRequest) {
        if (loggedIn) {
            if (isAdmin && adminOnlyUrls.stream().anyMatch(requestURI::startsWith)) {
                chain.doFilter(request, response);
            } else if (isStudent && studentOnlyUrls.stream().anyMatch(requestURI::startsWith)) {
                chain.doFilter(request, response);
            } else if (publicUrls.contains(requestURI)) {
                // Redirect to respective homepages after successful login
                if (isAdmin) {
                    res.sendRedirect(req.getContextPath() + "/panel/admin/admin/AdminPanelAnasayfa.xhtml");
                } else if (isStudent) {
                    res.sendRedirect(req.getContextPath() + "/panel/ogrenci/ogrenci/OgrenciProjeGoruntule.xhtml");
                } else {
                    chain.doFilter(request, response);
                }
            } else {
                // Kullanıcı giriş yaptı ve doğru role sahip ama izin verilen URL'lerden birine gitmiyor
                // Kendi ana sayfasına yönlendir
                if (isAdmin) {
                    res.sendRedirect(req.getContextPath() + "/panel/admin/anasayfa/AdminPanelAnasayfa.xhtml");
                } else if (isStudent) {
                    res.sendRedirect(req.getContextPath() + "/panel/ogrenci/proje/OgrenciProjeGoruntule.xhtml");
                } else {
                    res.sendRedirect(loginURI);
                }
            }
        } else {
            chain.doFilter(request, response);
        }
    } else {
        if (!publicUrls.contains(requestURI) && !resourceRequest) {
            res.sendRedirect(loginURI);
        } else {
            chain.doFilter(request, response);
        }
    }
}


    @Override
    public void destroy() {
        // Filtreyi sonlandırma kodları (gerekirse)
    }
}
