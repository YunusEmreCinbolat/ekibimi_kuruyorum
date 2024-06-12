package beans;

import dao.BildirimDAO;
import entity.Bildirim;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "bildirimBean")
@Stateless
public class BildirimController extends BaseController<Bildirim, BildirimDAO> implements Serializable, Controller<Bildirim> {

    private Bildirim entity;
    private List<Bildirim> list;

    @EJB
    private BildirimDAO BD;
    
    public BildirimController() {
        super(Bildirim.class, BildirimDAO.class);
    }

    @Override
    public void delete(Bildirim entity) {
        BD.delete(entity);
    }

    public List<Bildirim> getList() {
        if (this.list == null) {
            this.list = BD.readList(this.hangiSayfa, this.gorunenVeri);
        }
        return this.list;
    }

    public List<Bildirim> readFromAlici(int id) {
        System.out.println("cont " + id);
        return BD.readFromAlici(id);
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
        throw new UnsupportedOperationException("Not supported yet."); // Implement if needed
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); // Implement if needed
    }

    public int getBildirimCount(int id) {
        return this.getDao().getBildirimCount(id);
    }
}
