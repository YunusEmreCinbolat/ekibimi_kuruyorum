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
public class OgrenciController extends BaseController<Ogrenci,OgrenciDAO> implements Serializable,Controller {

     private Ogrenci entity;
     private Ogrenci projeOgrenci;
    public OgrenciController() {
        super(Ogrenci.class,OgrenciDAO.class);
    }
    
    public String getFromOgrenci(int id){
        Ogrenci o = this.getDao().getFromOgrenci(id);
        return o.getAd();
    }
     @Override
    public void create() {
        this.getDao().create(entity);
        this.entity = new Ogrenci();
    }
    
     @Override
      public void delete(int id) {
        this.getDao().delete(id);

    }
     @Override
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
         return "/panel/admin/ogrenci/AdminOgrenciDetay.xhtml?faces-redirect=true";
    }
     
     public String detailOgrenci(Ogrenci o){
         this.projeOgrenci=o;
         return "/panel/ogrenci/ogrenci/OgrenciBilgileriniGoster.xhtml?faces-redirect=true";
     }

    public Ogrenci getProjeOgrenci() {
        if(this.projeOgrenci==null){
            this.projeOgrenci=new Ogrenci();
        }
        return projeOgrenci;
    }

    public void setProjeOgrenci(Ogrenci projeOgrenci) {
        this.projeOgrenci = projeOgrenci;
    }
    
   
   

   
}
