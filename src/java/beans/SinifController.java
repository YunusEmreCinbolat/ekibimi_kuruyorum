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
public class SinifController extends BaseController<Sinif,SinifDAO> implements Serializable,Controller {
    
       private Sinif entity;
    public SinifController() {
        super(Sinif.class,SinifDAO.class);
    }
    
       @Override
    public void create(){
        this.getDao().create(entity);
        this.entity= new Sinif();
    }
    
     public int getSinifAdi(int sinifid) {
        Sinif s = this.getDao().getSinifAdi(sinifid);
        return s.getSinifadi();

    }
    
       @Override
     public void delete(int id) {
        this.getDao().delete(id);

    }
     
       @Override
      public void update(){
        this.getDao().update(entity);
        this.entity=new Sinif();
    }
 

    public List<Sinif> getList() {
       this.list=this.getDao().readList(this.hangiSayfa,this.gorunenVeri);
        return list;
    }

    public Sinif getEntity() {
        if(this.entity==null){
            this.entity=new Sinif();
        }
        return entity;
    }

    public String setEntity(Sinif entity) {
        this.entity = entity;
         return "/panel/admin/sinif/AdminSinifGuncelle.xhtml?faces-redirect=true";
    }
    


}
