package beans;

import dao.EkipUyeDAO;
import entity.EkipUye;
import entity.Ogrenci;
import entity.Proje;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "ekipuyeBean")
@SessionScoped
public class EkipUyeController extends BaseController<EkipUye, EkipUyeDAO> implements Serializable, Controller<EkipUye> {

    private EkipUye entity;

    @EJB
    private EkipUyeDAO EUD;

    public EkipUyeController() {
        super(EkipUye.class, EkipUyeDAO.class);
    }

    @Override
    public void update() {
        EUD.update(entity);
        this.entity = new EkipUye();
    }

    @Override
    public void create() {
      
        EUD.create(entity);
        this.entity = new EkipUye();
    }

    @Override
    public void delete(EkipUye entity) {
        EUD.delete(entity);
    }

    public List<EkipUye> getFromAOgrenci(int id) {
        return EUD.getFromAOgrenci(id);
    }

    public List<EkipUye> getList() {
        this.list = EUD.readList(this.hangiSayfa, this.gorunenVeri);
        return this.list;
    }

    public EkipUye getEntity() {
        if (this.entity == null) {
            this.entity = new EkipUye();
        }
        return entity;
    }

    public void setEntity(EkipUye entity) {
        this.entity = entity;
    }

    public void setOgrenci(Ogrenci ogrenci) {
        if (this.entity != null) {
            this.entity.setOgrenci(ogrenci);
        }
    }

    public void setProje(Proje proje) {
        if (this.entity != null) {
            this.entity.setProje(proje);
        }
    }
}