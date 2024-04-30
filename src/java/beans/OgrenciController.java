/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dao.OgrenciDAO;
import entity.Fakulte;
import entity.Ogrenci;
import entity.Sinif;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author admın
 */
@Named(value = "ogrenciBean")
@SessionScoped
public class OgrenciController extends BaseController<Ogrenci,OgrenciDAO> implements Serializable {

     private Ogrenci entity;
    public OgrenciController() {
        super(Ogrenci.class,OgrenciDAO.class);
    }
    
    public String getFromOgrenci(int id){
        Ogrenci o = this.getDao().getFromOgrenci(id);
        return o.getAd();
    }
    public void create() {
        this.getDao().create(entity);
        this.entity = new Ogrenci();
    }
    
      public void delete(int id) {
        this.getDao().delete(id);

    }
        public void update() {
        this.getDao().update(entity);
        this.entity = new Ogrenci();
    }
    
    public List<Ogrenci> getList() {
        this.list = this.getDao().readList(this.hangiSayfa,this.gorunenVeri);
        return list;
    }

    public Ogrenci getEntity() {
        if(this.entity==null){
            this.entity=new Ogrenci();
        }
        return entity;
    }

     public String setEntity(Ogrenci entity) {
        this.entity = entity;
         return "/panel/admin/ogrenci/AdminOgrenciKaydet.xhtml?faces-redirect=true";
    }
    
   
   

   
}
