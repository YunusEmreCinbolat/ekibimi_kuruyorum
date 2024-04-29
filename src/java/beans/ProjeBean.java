/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dao.AdminDAO;
import dao.ProjeDAO;
import entity.Proje;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
@Named(value = "projeBean")
@SessionScoped
public class ProjeBean implements Serializable {
    
     private Proje entity;
    private List<Proje> list;
    private ProjeDAO dao;


    /**
     * Creates a new instance of ProjeBean
     */
    public ProjeBean() {
    }
    
    public String getTitle(int id){
        Proje b= this.getDao().getTitle(id);
        
        return b.getProjeAdi();
    
    }
    
    public void create(){
        this.getDao().create(entity);
        this.entity= new Proje();
    }
    
     public void delete(int id) {
        this.getDao().delete(id);

    }
     
      public void update(){
        this.getDao().update(entity);
        this.entity=new Proje();
    }
 

    public Proje getEntity() {
      if(this.entity==null){
            this.entity=new Proje();
        }
        return entity;
    }

    public String setEntity(Proje entity) {
        this.entity = entity;
        return "/panel/admin/proje/AdminProjeDetay.xhtml?faces-redirect=true";
    }

    public List<Proje> getList() {
       this.list=this.getDao().readList();
        return list;
    }

    public void setList(List<Proje> list) {
        this.list = list;
    }

    public ProjeDAO getDao() {
           if (this.dao == null) {
            this.dao = new ProjeDAO();
        }
        return dao;
    }

    public void setDao(ProjeDAO dao) {
        this.dao = dao;
    }
    
    
    
}
