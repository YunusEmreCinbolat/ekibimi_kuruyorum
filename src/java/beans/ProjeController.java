package beans;

import dao.ProjeDAO;
import entity.Proje;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "projeBean")
@SessionScoped
public class ProjeController extends BaseController<Proje, ProjeDAO> implements Serializable, Controller<Proje> {

    private Proje entity;
    protected List<Proje> someProject;
    protected List<Proje> aliciFromOgrenci;

    @EJB
    private ProjeDAO PD;

    public ProjeController() {
        super(Proje.class, ProjeDAO.class);
    }

    public String getTitle(int id) {
        Proje b = PD.getTitle(id);
        return b.getProjeAdi();
    }

    @Override
    public void create() {
        PD.create(entity);
        this.entity = new Proje();
    }

    @Override
    public void delete(Proje entity) {
        PD.delete(entity);
    }

    @Override
    public void update() {
        PD.update(entity);
        this.entity = new Proje();
    }

    public List<Proje> getList() {
        this.list = PD.readList(this.hangiSayfa, this.gorunenVeri);
        return list;
    }

    public Proje getEntity() {
        if (this.entity == null) {
            this.entity = new Proje();
        }
        return entity;
    }
      public String setEntityForogrenci(Proje entity) {
        this.entity = entity;
        return "/panel/ogrenci/proje/OgrenciProjeDetay.xhtml?faces-redirect=true";
    }
    public String setEntity(Proje entity) {
        this.entity = entity;
        return "/panel/admin/proje/AdminProjeDetay.xhtml?faces-redirect=true";
    }

    public List<Proje> getSomeProject(int id) {
        this.someProject = PD.ogrenciFromProject(this.hangiSayfa, this.gorunenVeri, id);
        return someProject;
    }

    public void setSomeProject(List<Proje> someProject) {
        this.someProject = someProject;
    }

    public List<Proje> getAliciFromOgrenci(int id) {
        this.aliciFromOgrenci = PD.aliciogrenciFromProject(id);
        return aliciFromOgrenci;
    }

    public void setAliciFromOgrenci(List<Proje> aliciFromOgrenci) {
        this.aliciFromOgrenci = aliciFromOgrenci;
    }
}
