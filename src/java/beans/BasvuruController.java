package beans;

import dao.BasvuruDAO;
import entity.Basvuru;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "basvuruBean")
@Stateless
public class BasvuruController extends BaseController<Basvuru, BasvuruDAO> implements Serializable, Controller<Basvuru> {

    private Basvuru entity;
    private List<Basvuru> list;
    
    @EJB
    private BasvuruDAO bd;

    public BasvuruController() {
        super(Basvuru.class, BasvuruDAO.class);
    }

    @Override
    public void update() {
        bd.update(this.entity);
        this.entity = new Basvuru();
    }

    public void create(int oid, int pid) {
        bd.create(entity,oid, pid);
        this.entity = new Basvuru();
    }

    @Override
    public void delete(Basvuru entity) {
        bd.delete(entity);
        this.entity = new Basvuru(); // after deletion, reset the entity
    }

    public List<Basvuru> getList() {
        if (this.list == null) {
            this.list = bd.readList(this.hangiSayfa, this.gorunenVeri);
        }
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
        throw new UnsupportedOperationException("Not supported yet."); // Implement if needed
    }
}
