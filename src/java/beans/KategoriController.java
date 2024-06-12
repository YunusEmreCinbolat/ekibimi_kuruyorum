package beans;

import dao.KategoriDAO;
import entity.Kategori;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "kategoriBean")
@SessionScoped
public class KategoriController extends BaseController<Kategori, KategoriDAO> implements Serializable, Controller<Kategori> {

    private Kategori entity;
    
    @EJB
    private KategoriDAO KD;
    

    public KategoriController() {
        super(Kategori.class, KategoriDAO.class);
    }

    public String getTitle(int id) {
        Kategori b = KD.getTitle(id);
        return b.getKategoriAdi();
    }

    @Override
    public void create() {
        KD.create(entity);
        this.entity = new Kategori();
    }

    @Override
    public void delete(Kategori entity) {
        KD.delete(entity);
    }

    @Override
    public void update() {
        KD.update(entity);
        this.entity = new Kategori();
    }

    public List<Kategori> getList() {
        this.list = KD.readList(this.hangiSayfa, this.gorunenVeri);
        return list;
    }

    public Kategori getEntity() {
        if (this.entity == null) {
            this.entity = new Kategori();
        }
        return entity;
    }

    public String setEntity(Kategori entity) {
        this.entity = entity;
        return "/panel/admin/kategori/AdminProjeKategoriEkle.xhtml?faces-redirect=true";
    }
}
