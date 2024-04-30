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
public class BolumController extends BaseController<Bolum ,BolumDAO> implements Serializable {
    
     


    /**
     * Creates a new instance of BolumBean
     */
    public BolumController() {
       super(Bolum.class ,BolumDAO.class);
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
 

    public List<Bolum> getList() {
       this.list=this.getDao().readList();
        return list;
    }

    public void setList(List<Bolum> list) {
        this.list = list;
    }
}
    