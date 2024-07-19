package beans;

import dao.FakulteDAO;
import entity.Fakulte;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "fakulteBean")
@SessionScoped
public class FakulteController extends BaseController<Fakulte, FakulteDAO> implements Serializable, Controller<Fakulte> {

    private Fakulte entity;
    
    @EJB
    private FakulteDAO FD;

    public FakulteController() {
        super(Fakulte.class, FakulteDAO.class);
    }

    @Override
    public void create() {
        FD.create(entity);
        this.entity = new Fakulte();
    }

    @Override
    public void delete(Fakulte entity) {
        try {
            FD.delete(entity);
        } catch (Exception e) {
            System.err.println("Exception in FakulteController delete method: " + e.getMessage());
        }
    }

    public String getFakulteAdi(int fakulteid) {
        Fakulte f = FD.getFakulteAdi(fakulteid);
        return f.getFakulteadi();
    }

    public String getFromOgrenciFakulteAdi(int fakulteid) {
         System.out.println("cont"+fakulteid);
        Fakulte f = FD.getFromOgrenciFakulteAdi(fakulteid);
        return f.getFakulteadi();
    }

    @Override
    public void update() {
        FD.update(entity);
        this.entity = new Fakulte();
    }

    public List<Fakulte> getList() {
        this.list = FD.readList(this.hangiSayfa, this.gorunenVeri);
        return list;
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
}