package beans;

import dao.AdminDAO;
import entity.Admin;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "adminBean")
@SessionScoped
public class AdminController extends BaseController<Admin, AdminDAO> implements Serializable, Controller<Admin> {

    private Admin entity;
    private List<Admin> list;
    
    @EJB
    private AdminDAO AD;

    public AdminController() {
        super(Admin.class, AdminDAO.class);
    }

    @Override
    public void update() {
        try {
            AD.update(this.entity);
            this.entity = new Admin();
        } catch (Exception e) {
            System.err.println("Exception in update method: " + e.getMessage());
        }
    }

    @Override
    public void create() {
        try {
            AD.create(this.entity);
            this.entity = new Admin();
        } catch (Exception e) {
            System.err.println("Exception in create method: " + e.getMessage());
        }
    }

    @Override
    public void delete(Admin entity) {
        try {
            AD.delete(entity);
            this.entity = new Admin(); // after deletion, reset the entity
        } catch (Exception e) {
            System.err.println("Exception in delete method: " + e.getMessage());
        }
    }

    public List<Admin> getList() {
        if (this.list == null) {
            this.list = AD.readList(this.hangiSayfa, this.gorunenVeri);
        }
        return this.list;
    }

    public Admin getEntity() {
        if (this.entity == null) {
            this.entity = new Admin();
        }
        return entity;
    }

    public String setEntity(Admin entity) {
        this.entity = entity;
        return "/panel/admin/admin/AdminGuncelle.xhtml?faces-redirect=true";
    }
}
