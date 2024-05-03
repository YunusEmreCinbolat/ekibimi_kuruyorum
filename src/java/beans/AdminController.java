/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dao.AdminDAO;
import entity.Admin;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Dell
 */
@Named(value = "adminBean")
@SessionScoped
public class AdminController extends BaseController<Admin, AdminDAO> implements Serializable, Controller {

    private Admin entity;

    public AdminController() {
        super(Admin.class, AdminDAO.class);
    }

    @Override
    public void update() {
        this.getDao().update(entity);
        this.entity = entity;
    }

    @Override
    public void create() {
        this.getDao().create(entity);
        this.entity = new Admin();
    }

    @Override
    public void delete(int id) {
        this.getDao().delete(id);

    }

    public List<Admin> getList() {
        this.list = this.getDao().readList(this.hangiSayfa, this.gorunenVeri);
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
