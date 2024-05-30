package beans;

import dao.AdminDAO;
import dao.OgrenciDAO;
import entity.Admin;
import entity.Ogrenci;
import entity.Proje;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    private OgrenciDAO ogrenciDao;
    private AdminDAO adminDao;
    private Ogrenci o;
    private Admin a;

    @Inject
    private OgrenciController autho;

    @Inject
    private AdminController autha;

    private Proje projeEntity;

    private String role;

    // Getters and setters
    public String loginOgrenci() {
        List<Ogrenci> ogrenciler = this.getOgrenciDao().allList();
        for (Ogrenci ogrenci : ogrenciler) {
            if (this.o.getKullaniciadi().equals(ogrenci.getKullaniciadi()) && this.o.getSifre().equals(ogrenci.getSifre())) {
                role = "student";
                autho.setEntity(ogrenci);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("loginController", this);

                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Giriş başarılı", null));

               
                // JavaScript kullanarak bekleme ve yönlendirme
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                return "/panel/ogrenci/proje/OgrenciProjeGoruntule?faces-redirect=true&includeViewParams=true";
            }
        }

        // Hata mesajı ekleyin
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Giriş Hatası", "Kullanıcı adı veya şifre yanlış"));
        return "/panel/ogrenci/ogrenci/OgrenciGiris?faces-redirect=true";
    }

    public String loginAdmin() {
        List<Admin> adminler = this.getAdminDao().allList();
        for (Admin admin : adminler) {
            if (this.a.getKullaniciadi().equals(admin.getKullaniciadi()) && this.a.getSifre().equals(admin.getSifre())) {
                role = "admin";
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("loginController", this);
                autha.setEntity(admin);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Giriş başarılı, yönlendiriliyorsunuz...", null));

                // JavaScript kullanarak bekleme ve yönlendirme
            

                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                return "/panel/admin/anasayfa/AdminPanelAnasayfa?faces-redirect=true&includeViewParams=true";
            }
        }

        // Hata mesajı ekleyin
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Giriş Hatası", "Kullanıcı adı veya şifre yanlış"));
        return "/panel/admin/admin/AdminGiris?faces-redirect=true";
    }

    public String logoutAdmin() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/panel/admin/admin/AdminGiris.xhtml?faces-redirect=true";
    }

    public String logoutOgrenci() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/panel/ogrenci/ogrenci/OgrenciGiris.xhtml?faces-redirect=true";
    }

    public OgrenciDAO getOgrenciDao() {
        if (ogrenciDao == null) {
            this.ogrenciDao = new OgrenciDAO();
        }
        return ogrenciDao;
    }

    public void setOgrenciDao(OgrenciDAO ogrenciDao) {
        this.ogrenciDao = ogrenciDao;
    }

    public AdminDAO getAdminDao() {
        if (adminDao == null) {
            this.adminDao = new AdminDAO();
        }
        return adminDao;
    }

    public void setAdminDao(AdminDAO adminDao) {
        this.adminDao = adminDao;
    }

    public Ogrenci getO() {
        if (this.o == null) {
            this.o = new Ogrenci();
        }
        return o;
    }

    public void setO(Ogrenci o) {
        this.o = o;
    }

    public Admin getA() {
        if (this.a == null) {
            this.a = new Admin();
        }
        return a;
    }

    public void setA(Admin a) {
        this.a = a;
    }

    public Proje getProjeEntity() {
        if (this.projeEntity == null) {
            this.projeEntity = new Proje();
        }
        return projeEntity;
    }

    public void setProjeEntity(Proje projeEntity) {
        this.projeEntity = projeEntity;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
