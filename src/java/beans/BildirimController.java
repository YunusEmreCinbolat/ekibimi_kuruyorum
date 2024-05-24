/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dao.BildirimDAO;
import entity.Bildirim;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
@Named(value = "bildirimBean")
@SessionScoped
public class BildirimController extends BaseController<Bildirim, BildirimDAO> implements Serializable, Controller {

    private Bildirim entity;

    public BildirimController() {
        super(Bildirim.class, BildirimDAO.class);
    }

   
 
    @Override
    public void delete(int id) {
        this.getDao().delete(id);

    }

    public List<Bildirim> getList() {
        this.list = this.getDao().readList(this.hangiSayfa, this.gorunenVeri);
        return this.list;
    }
    
    public List<Bildirim> readFromAlici(int id){
        System.out.println("cont "+id);
        List<Bildirim> gorunenList=  this.getDao().readFromAlici( id);
        return gorunenList;
    }

    public Bildirim getEntity() {
        if (this.entity == null) {
            this.entity = new Bildirim();
        }
        return entity;
    }

    public String setEntity(Bildirim entity) {
        this.entity = entity;
        return "/panel/bildirim/bildirim/BildirimGuncelle.xhtml?faces-redirect=true";
    }

    @Override
    public void create() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public int getBildirimCount(int id){
        
        return this.getDao().getBildirimCount(id);
    }

}
