/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dao.OgrenciDAO;
import entity.Ogrenci;
import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import java.util.List;

/**
 *
 * @author admın
 */
@Named(value = "ogrenciBean")
@Dependent
public class OgrenciBean {

    private Ogrenci entity;
    private OgrenciDAO dao;
    private List<Ogrenci> list;

    public OgrenciBean() {
    }

    public Ogrenci getEntity() {
        if(this.entity==null){
            this.entity=new Ogrenci();
        }
        return entity;
    }

    public void setEntity(Ogrenci entity) {
        this.entity = entity;
    }

 
    
    public OgrenciDAO getDao() {
        if(this.dao==null){
            this.dao=new OgrenciDAO();
        }
        return dao;
    }

    public void setDao(OgrenciDAO dao) {
        this.dao = dao;
    }

    public List<Ogrenci> getList() {
        this.list=this.getDao().readList();
        return list;
    }

    public void setList(List<Ogrenci> list) {
        this.list = list;
    }

}
