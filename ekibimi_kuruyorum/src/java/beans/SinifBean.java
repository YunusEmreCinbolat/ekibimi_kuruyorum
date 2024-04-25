/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dao.AdminDAO;
import dao.SinifDAO;
import entity.Fakulte;
import entity.Sinif;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
@Named(value = "sinifBean")
@SessionScoped
public class SinifBean implements Serializable {
    
     private Sinif entity;
    private List<Sinif> list;
    private SinifDAO dao;


    /**
     * Creates a new instance of SinifBean
     */
    public SinifBean() {
    }
    
    public void create(){
        this.getDao().create(entity);
        this.entity= new Sinif();
    }
    
     public int getSinifAdi(int sinifid) {
        Sinif s = this.getDao().getSinifAdi(sinifid);
        return s.getSinifadi();

    }
    
     public void delete(int id) {
        this.getDao().delete(id);

    }
     
      public void update(){
        this.getDao().update(entity);
        this.entity=new Sinif();
    }
 

    public Sinif getEntity() {
      if(this.entity==null){
            this.entity=new Sinif();
        }
        return entity;
    }

    public String setEntity(Sinif entity) {
        this.entity = entity;
        return "/panel/admin/sinif/AdminSinifDetay.xhtml?faces-redirect=true";
    }

    public List<Sinif> getList() {
       this.list=this.getDao().readList();
        return list;
    }

    public void setList(List<Sinif> list) {
        this.list = list;
    }

    public SinifDAO getDao() {
           if (this.dao == null) {
            this.dao = new SinifDAO();
        }
        return dao;
    }

    public void setDao(SinifDAO dao) {
        this.dao = dao;
    }
    
    
    
}
