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
public class AdminBean implements Serializable {

    private Admin entity;
    private List<Admin> list;
    private AdminDAO dao;

    /**
     * Creates a new instance of AdminBean
     */
    public AdminBean() {
    }
    
    public void create(){
        this.getDao().create(entity);
        this.entity=new Admin();
    }

    public Admin getEntity() {
        if (this.entity == null) {
            this.entity = new Admin();
        }
        return entity;
    }

    public void setEntity(Admin entity) {
        this.entity = entity;
    }

    public List<Admin> getList() {
        this.list= this.getDao().readList();
        return list;
    }

    public void setList(List<Admin> list) {
        this.list = list;
    }

    public AdminDAO getDao() {
        if (this.dao == null) {
            this.dao = new AdminDAO();
        }
        return dao;
    }

    public void setDao(AdminDAO dao) {
        this.dao = dao;
    }

}
