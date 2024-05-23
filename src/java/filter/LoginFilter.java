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
        publicUrls.add("/panel/ogrenci/ogrenci/OgrenciGiris.xhtml");
        publicUrls.add("/panel/ogrenci/ogrenci/OgrenciKaydol.xhtml");
        publicUrls.add("/panel/ogrenci/proje/OgrenciProjeGoruntule.xhtml");
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

        LoginController loginBean = (session != null) ? (LoginController) session.getAttribute("validUser") : null;
        String loginURI = req.getContextPath() + "/login.xhtml";

        String requestURI = req.getRequestURI().substring(req.getContextPath().length());
        boolean loggedIn = loginBean != null && loginBean.getA().getKullaniciadi()!= null;
        boolean loginRequest = req.getRequestURI().equals(loginURI);
        boolean resourceRequest = req.getRequestURI().startsWith(req.getContextPath() + "/jakarta.faces.resource");

        boolean isAdmin = loginBean != null && "admin".equals(loginBean.getRole());
        boolean isStudent = loginBean != null && "student".equals(loginBean.getRole());

        if (loggedIn || publicUrls.contains(requestURI) || resourceRequest || loginRequest) {
            if (loggedIn) {
                if ((isAdmin && adminOnlyUrls.stream().anyMatch(requestURI::startsWith)) ||
                    (isStudent && studentOnlyUrls.stream().anyMatch(requestURI::startsWith)) ||
                    publicUrls.contains(requestURI)) {
                    chain.doFilter(request, response);
                } else {
                    res.sendRedirect(loginURI);
                }
            } else {
                chain.doFilter(request, response);
            }
        } else {
            res.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() {
        // Filtreyi sonlandırma kodları (gerekirse)
    }
}
