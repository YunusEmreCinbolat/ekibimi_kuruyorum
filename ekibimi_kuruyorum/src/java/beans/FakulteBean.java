/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dao.AdminDAO;
import dao.FakulteDAO;
import entity.Fakulte;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
@Named(value = "fakulteBean")
@SessionScoped
public class FakulteBean implements Serializable {

    private Fakulte entity;
    private List<Fakulte> list;
    private FakulteDAO dao;

    /**
     * Creates a new instance of FakulteBean
     */
    public FakulteBean() {
    }

    public void create() {
        this.getDao().create(entity);
        this.entity = new Fakulte();
    }

    public void delete(int id) {
        this.getDao().delete(id);

    }

    public String getFakulteAdi(int fakulteid) {
        Fakulte f = this.getDao().getFakulteAdi(fakulteid);
        return f.getFakulteadi();

    }
    
      public String getFromOgrenciFakulteAdi(int fakulteid) {
        Fakulte f = this.getDao().getFromOgrenciFakulteAdi(fakulteid);
        return f.getFakulteadi();

    }
    
    

    public void update() {
        this.getDao().update(entity);
        this.entity = new Fakulte();
    }

    public Fakulte getEntity() {
        if (this.entity == null) {
            this.entity = new Fakulte();
        }
        return entity;
    }

    public String setEntity(Fakulte entity) {
        this.entity = entity;
        return "/panel/admin/fakultee/AdminFakulteGuncelle.xhtml?faces-redirect=true";
    }

    public List<Fakulte> getList() {
        this.list = this.getDao().readList();
        return list;
    }

    public void setList(List<Fakulte> list) {
        this.list = list;
    }

    public FakulteDAO getDao() {
        if (this.dao == null) {
            this.dao = new FakulteDAO();
        }
        return dao;
    }

    public void setDao(FakulteDAO dao) {
        this.dao = dao;
    }

}
