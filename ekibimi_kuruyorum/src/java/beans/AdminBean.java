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
 * @author admın
 */
@Named(value = "adminBean")
@SessionScoped
public class AdminBean implements Serializable {
      private Admin entity;
      private AdminDAO dao;
      private List <Admin> list;
    public AdminBean() {
    }
    
    public void create(){
        
    }
    public Admin getEntity() {
        if(this.entity==null){
            this.entity=new Admin();
        }
        return entity;
    }

    public void setEntity(Admin entity) {
        this.entity = entity;
    }

    public AdminDAO getDao() {
        if(this.dao==null){
            this.dao=new AdminDAO();
        }
        return dao;
    }

    public void setDao(AdminDAO dao) {
        this.dao = dao;
    }

    public List<Admin> getList() {
        return list;
    }

    public void setList(List<Admin> list) {
        this.list = list;
    }
     
    
}
