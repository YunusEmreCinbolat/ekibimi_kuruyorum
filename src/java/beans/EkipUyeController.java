/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dao.EkipUyeDAO;
import entity.EkipUye;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Dell
 */
@Named(value = "ekipuyeBean")
@SessionScoped
public class EkipUyeController extends BaseController<EkipUye, EkipUyeDAO> implements Serializable, Controller {

    private EkipUye entity;

    public EkipUyeController() {
        super(EkipUye.class, EkipUyeDAO.class);
    }

    @Override
    public void update() {
        this.getDao().update(entity);
        this.entity = entity;
    }

    @Override
    public void create() {
        this.getDao().create(entity);
        this.entity = new EkipUye();
    }

    @Override
    public void delete(int id) {
        this.getDao().delete(id);

    }
    
    public List<EkipUye> getFromAOgrenci(int id){
        return this.getDao().getFromAOgrenci(id);
    }

    public List<EkipUye> getList() {
        this.list = this.getDao().readList(this.hangiSayfa, this.gorunenVeri);
        return this.list;
    }

    public EkipUye getEntity() {
        if (this.entity == null) {
            this.entity = new EkipUye();
        }
        return entity;
    }

    public String setEntity(EkipUye entity) {
        this.entity = entity;
        return "/panel/admin/admin/EkipUyeGuncelle.xhtml?faces-redirect=true";
    }

}
