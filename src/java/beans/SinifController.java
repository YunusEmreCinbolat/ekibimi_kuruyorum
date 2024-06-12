package beans;

import dao.SinifDAO;
import entity.Sinif;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Managed Bean for handling Sinif entities.
 * Provides CRUD operations and interacts with the view layer.
 * The bean is session-scoped, maintaining state across multiple requests within a user's session.
 * 
 * Author: Dell
 */
@Named(value = "sinifBean")
@SessionScoped
public class SinifController extends BaseController<Sinif, SinifDAO> implements Serializable, Controller<Sinif> {
    
    private Sinif entity;
    
    @EJB
    private SinifDAO SD;

    public SinifController() {
        super(Sinif.class, SinifDAO.class);
    }

    /**
     * Creates a new Sinif entity.
     * After creation, the entity is reset to a new instance.
     */
    @Override
    public void create() {
        SD.create(entity);
        this.entity = new Sinif();
    }

    /**
     * Retrieves the name of the class (Sinif) based on its ID.
     *
     * @param sinifid The ID of the class.
     * @return The name of the class.
     */
    public String getSinifAdi(int sinifid) {
        Sinif s = SD.getSinifAdi(sinifid);
        return s.getSinifAdi();
    }

    /**
     * Deletes a Sinif entity based on its ID.
     *
     * @param id The ID of the class to be deleted.
     */
    @Override
    public void delete(Sinif entity) {
        SD.delete(entity);
    }

    /**
     * Updates an existing Sinif entity.
     * After updating, the entity is reset to a new instance.
     */
    @Override
    public void update() {
        SD.update(entity);
        this.entity = new Sinif();
    }

    /**
     * Retrieves a paginated list of Sinif entities.
     *
     * @return A list of Sinif entities.
     */
    public List<Sinif> getList() {
        this.list = SD.readList(this.hangiSayfa, this.gorunenVeri);
        return list;
    }

    /**
     * Retrieves the current Sinif entity. 
     * If the entity is null, initializes a new Sinif instance.
     *
     * @return The current Sinif entity.
     */
    public Sinif getEntity() {
        if (this.entity == null) {
            this.entity = new Sinif();
        }
        return entity;
    }

    /**
     * Sets the current Sinif entity and redirects to the update page.
     *
     * @param entity The Sinif entity to be set.
     * @return A navigation string to the update page.
     */
    public String setEntity(Sinif entity) {
        this.entity = entity;
        return "/panel/admin/sinif/AdminSinifGuncelle.xhtml?faces-redirect=true";
    }
}
