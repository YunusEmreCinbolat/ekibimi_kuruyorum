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
public class OgrenciBean implements Serializable {

    private Ogrenci entity;
    private OgrenciDAO dao;
    private List<Ogrenci> list;

    public OgrenciBean() {
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
    public Ogrenci getEntity() {
        if (this.entity == null) {
            this.entity = new Ogrenci();
        }
        return entity;
    }

    public String setEntity(Ogrenci entity) {
        this.entity = entity;
        return "/panel/admin/AdminOgrenciDetay.xhtml?faces-redirect=true";

    }

    public OgrenciDAO getDao() {
        if (this.dao == null) {
            this.dao = new OgrenciDAO();
        }
        return dao;
    }

    public void setDao(OgrenciDAO dao) {
        this.dao = dao;
    }

    public List<Ogrenci> getList() {
        this.list = this.getDao().readList();
        return list;
    }

    public void setList(List<Ogrenci> list) {
        this.list = list;
    }

}
