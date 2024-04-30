/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dao.AdminDAO;
import dao.KategoriDAO;
import entity.Kategori;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
@Named(value = "kategoriBean")
@SessionScoped
public class KategoriController implements Serializable {
    
     private Kategori entity;
    private List<Kategori> list;
    private KategoriDAO dao;


    /**
     * Creates a new instance of KategoriBean
     */
    public KategoriController() {
    }
    
    public String getTitle(int id){
        Kategori b= this.getDao().getTitle(id);
        
        return b.getKategoriAdi();
    
    }
    
    public void create(){
        this.getDao().create(entity);
        this.entity= new Kategori();
    }
    
     public void delete(int id) {
        this.getDao().delete(id);

    }
     
      public void update(){
        this.getDao().update(entity);
        this.entity=new Kategori();
    }
 

    public Kategori getEntity() {
      if(this.entity==null){
            this.entity=new Kategori();
        }
        return entity;
    }

    public String setEntity(Kategori entity) {
        this.entity = entity;
        return "/panel/admin/kategori/AdminProjeKategoriDetay.xhtml?faces-redirect=true";
    }

    public List<Kategori> getList() {
       this.list=this.getDao().readList();
        return list;
    }

    public void setList(List<Kategori> list) {
        this.list = list;
    }

    public KategoriDAO getDao() {
           if (this.dao == null) {
            this.dao = new KategoriDAO();
        }
        return dao;
    }

    public void setDao(KategoriDAO dao) {
        this.dao = dao;
    }
    
    
    
}
