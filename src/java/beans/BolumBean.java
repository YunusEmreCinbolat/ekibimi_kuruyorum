/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dao.AdminDAO;
import dao.BolumDAO;
import entity.Bolum;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
@Named(value = "bolumBean")
@SessionScoped
public class BolumBean implements Serializable {
    
     private Bolum entity;
    private List<Bolum> list;
    private BolumDAO dao;


    /**
     * Creates a new instance of BolumBean
     */
    public BolumBean() {
    }
    
    public String getTitle(int id){
        Bolum b= this.getDao().getTitle(id);
        
        return b.getBolumadi();
    
    }
    
    public void create(){
        this.getDao().create(entity);
        this.entity= new Bolum();
    }
    
     public void delete(int id) {
        this.getDao().delete(id);

    }
     
      public void update(){
        this.getDao().update(entity);
        this.entity=new Bolum();
    }
 

    public Bolum getEntity() {
      if(this.entity==null){
            this.entity=new Bolum();
        }
        return entity;
    }

    public String setEntity(Bolum entity) {
        this.entity = entity;
        return "/panel/admin/bolum/AdminBolumGuncelle.xhtml?faces-redirect=true";
    }

    public List<Bolum> getList() {
       this.list=this.getDao().readList();
        return list;
    }

    public void setList(List<Bolum> list) {
        this.list = list;
    }

    public BolumDAO getDao() {
           if (this.dao == null) {
            this.dao = new BolumDAO();
        }
        return dao;
    }

    public void setDao(BolumDAO dao) {
        this.dao = dao;
    }
    
    
    
}
