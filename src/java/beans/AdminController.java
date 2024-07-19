package beans;

import dao.AdminDAO;
import entity.Admin;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "adminBean")
@SessionScoped
public class AdminController implements Serializable {

    private Admin entity;
    private List<Admin> list;
    
    @EJB
    private AdminDAO AD;

    public AdminController() {
        // AdminDAO ve Admin entity sınıfına dayalı olarak bu sınıfı başlatır
    }

    public void create() {
        try {
            AD.create(entity);
            this.entity = new Admin();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Admin başarıyla oluşturuldu!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Admin oluşturulurken hata oluştu: " + e.getMessage()));
        }
    }

    public void delete(Admin entity) {
        try {
            AD.delete(entity);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Admin başarıyla silindi!"));
            this.list = null; // Listeyi güncellemek için null yaparak yeniden yüklenmesini sağlayın
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Admin silinirken hata oluştu: " + e.getMessage()));
        }
    }

    public void update() {
        try {
            AD.update(entity);
            this.entity = new Admin();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Admin başarıyla güncellendi!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Admin güncellenirken hata oluştu: " + e.getMessage()));
        }
    }

    public List<Admin> getList() {
        if (this.list == null) {
            this.list = AD.readList(1, 10); // Default sayfa ve gösterilecek veri sayısı
        }
        return this.list;
    }

    public String setEntity(Admin entity) {
        this.entity = entity;
        return "/panel/admin//admin/AdminGuncelle.xhtml?faces-redirect=true";
    }

    public Admin getEntity() {
        if (this.entity == null) {
            this.entity = new Admin();
        }
        return entity;
    }
}