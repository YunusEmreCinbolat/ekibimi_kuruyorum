/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dao.BasvuruDAO;
import entity.Basvuru;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Dell
 */
@Named(value = "basvuruBean")
@SessionScoped
public class BasvuruController extends BaseController<Basvuru, BasvuruDAO> implements Serializable, Controller {

    private Basvuru entity;

    public BasvuruController() {
        super(Basvuru.class, BasvuruDAO.class);
    }

    @Override
    public void update() {
        this.getDao().update(entity);
        this.entity = entity;
    }

    
    public void create(int oid,int pid ){
        this.getDao().create(oid,pid );
        this.entity = new Basvuru();
    }

    @Override
    public void delete(int id) {
        this.getDao().delete(id);

    }

    public List<Basvuru> getList() {
        this.list = this.getDao().readList(this.hangiSayfa, this.gorunenVeri);
        return this.list;
    }

    public Basvuru getEntity() {
        if (this.entity == null) {
            this.entity = new Basvuru();
        }
        return entity;
    }

    public String setEntity(Basvuru entity) {
        this.entity = entity;
        return "/panel/basvuru/basvuru/BasvuruGuncelle.xhtml?faces-redirect=true";
    }

    @Override
    public void create() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
