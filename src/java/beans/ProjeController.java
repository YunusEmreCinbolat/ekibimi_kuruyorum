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
public class ProjeController extends BaseController<Proje ,ProjeDAO> implements Serializable {
    
    
    public ProjeController() {
        super(Proje.class,ProjeDAO.class);
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
 

    
    public List<Proje> getList() {
       this.list=this.getDao().readList();
        return list;
    }

   
   
    
    
}
