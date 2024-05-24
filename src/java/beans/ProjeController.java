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
public class ProjeController extends BaseController<Proje ,ProjeDAO> implements Serializable,Controller {
     private Proje entity;
     
     protected List<Proje> someProject;
     
     protected List<Proje> aliciFromOgrenci;
    
    public ProjeController() {
        super(Proje.class,ProjeDAO.class);
    }
   
    
    public String getTitle(int id){
        Proje b= this.getDao().getTitle(id);
        
        return b.getProjeAdi();
    
    }
    
   
     @Override
    public void create(){
        this.getDao().create(entity);
        this.entity= new Proje();
    }
    
     @Override
     public void delete(int id) {
        this.getDao().delete(id);

    }
     
     @Override
      public void update(){
        this.getDao().update(entity);
        this.entity=new Proje();
    }
 

    
    public List<Proje> getList() {
       this.list=this.getDao().readList(this.hangiSayfa,this.gorunenVeri);
        return list;
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

    public List<Proje> getSomeProject(int id) {
        this.someProject=this.getDao().ogrenciFromProject(this.hangiSayfa, this.gorunenVeri, id);
        return someProject;
    }

    public void setSomeProject(List<Proje> someProject) {
        this.someProject = someProject;
    }

    public List<Proje> getAliciFromOgrenci(int id) {
        this.aliciFromOgrenci=this.getDao().aliciogrenciFromProject(id);
        return aliciFromOgrenci;
    }

    public void setAliciFromOgrenci(List<Proje> aliciFromOgrenci) {
        this.aliciFromOgrenci = aliciFromOgrenci;
    }
    
   
  

   
   
    
    
}
