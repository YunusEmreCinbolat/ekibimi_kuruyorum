package beans;

import dao.BolumDAO;
import entity.Bolum;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "bolumBean")
@SessionScoped
public class BolumController extends BaseController<Bolum, BolumDAO> implements Serializable, Controller<Bolum> {

    private Bolum entity;
    private List<Bolum> list;
    
    @EJB
    private BolumDAO BD;

    public BolumController() {
        super(Bolum.class, BolumDAO.class);
    }

    public String getTitle(int id) {
        Bolum b = BD.getTitle(id);
        return b.getBolumAdi();
    }

    @Override
    public void create() {
        BD.create(entity);
        this.entity = new Bolum();
    }

    @Override
    public void delete(Bolum entity) {
        BD.delete(entity);
    }

    @Override
    public void update() {
        BD.update(entity);
        this.entity = new Bolum();
    }

    public List<Bolum> getList() {
        if (this.list == null) {
            this.list = BD.readList(this.hangiSayfa, this.gorunenVeri);
        }
        return this.list;
    }

    public String setEntity(Bolum entity) {
        this.entity = entity;
        return "/panel/admin/bolum/AdminBolumGuncelle.xhtml?faces-redirect=true";
    }

    public Bolum getEntity() {
        if (this.entity == null) {
            this.entity = new Bolum();
        }
        return entity;
    }
}
