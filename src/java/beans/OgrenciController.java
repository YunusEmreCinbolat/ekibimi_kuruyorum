package beans;

import dao.OgrenciDAO;
import entity.Ogrenci;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author admın
 */
@Named(value = "ogrenciBean")
@SessionScoped
public class OgrenciController extends BaseController<Ogrenci, OgrenciDAO> implements Serializable, Controller<Ogrenci> {

    private Ogrenci entity;
    private Ogrenci projeOgrenci;
    
    @EJB
    private OgrenciDAO OD;
    
    public OgrenciController() {
        super(Ogrenci.class, OgrenciDAO.class);
    }

    public String getFromOgrenci(int id) {
        Ogrenci o = OD.getFromOgrenci(id);
        return o.getAd();
    }

    @Override
    public void create() {
         OD.create(entity);
        this.entity = new Ogrenci();
    }

    @Override
    public void delete(Ogrenci entity) {
        OD.delete(entity);
    }

    @Override
    public void update() {
        OD.update(entity);
        this.entity = new Ogrenci();
    }

    public List<Ogrenci> getList() {
        this.list = OD.readList(this.hangiSayfa, this.gorunenVeri);
        return list;
    }

    public Ogrenci getEntity() {
        if (this.entity == null) {
            this.entity = new Ogrenci();
        }
        return entity;
    }

    public String setEntity(Ogrenci entity) {
        this.entity = entity;
        return "/panel/admin/ogrenci/AdminOgrenciDetay.xhtml?faces-redirect=true";
    }

    public String detailOgrenci(Ogrenci o) {
        this.projeOgrenci = o;
        return "/panel/ogrenci/ogrenci/OgrenciBilgileriniGoster.xhtml?faces-redirect=true";
    }

    public Ogrenci getProjeOgrenci() {
        if (this.projeOgrenci == null) {
            this.projeOgrenci = new Ogrenci();
        }
        return projeOgrenci;
    }

    public void setProjeOgrenci(Ogrenci projeOgrenci) {
        this.projeOgrenci = projeOgrenci;
    }
}
