package dao;

import entity.Kategori;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Stateless
public class KategoriDAO {

    @PersistenceContext(unitName = "ekibimi_kuruyorumPU")
    private EntityManager em;

    public void create(Kategori entity) {
        em.persist(entity);
    }

    public void update(Kategori entity) {
        em.merge(entity);
    }

    @Transactional
    public void delete(Kategori entity) {
        try {
            if (entity != null) {
              	em.remove(em.merge(entity));
                em.flush();
            } else {
                // Log that the entity was not found
                System.err.println("Admin entity with id " + entity.getId() + " not found.");
            }
        } catch (Exception e) {
            System.err.println("Exception in delete method: DAO" + e.getMessage());
            throw e;
        }
    }

    public Kategori getTitle(int id) {
        return em.createQuery("SELECT k FROM Kategori k WHERE k.id = :id", Kategori.class)
                 .setParameter("id", id)
                 .getSingleResult();
    }

    public List<Kategori> readList(int hangiSayfa, int gorunenVeri) {
        return em.createQuery("SELECT k FROM Kategori k", Kategori.class)
                 .setFirstResult((hangiSayfa - 1) * gorunenVeri)
                 .setMaxResults(gorunenVeri)
                 .getResultList();
    }
      @Transactional
    public void truncate() {
        try {
            em.createQuery("DELETE FROM Kategori").executeUpdate();
        } catch (Exception e) {
            System.err.println("Exception in truncate method: " + e.getMessage());
            throw e;
        }
    }
}
