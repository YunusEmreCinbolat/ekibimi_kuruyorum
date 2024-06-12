package dao;

import entity.Bolum;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Stateless
public class BolumDAO {

    @PersistenceContext(unitName = "ekibimi_kuruyorumPU")
    private EntityManager em;

    public void create(Bolum entity) {
        em.persist(entity);
    }

    public void update(Bolum entity) {
        em.merge(entity);
    }

    @Transactional
    public void delete(Bolum entity) {
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

    public Bolum getTitle(int id) {
        return em.createQuery("SELECT b FROM Bolum b WHERE b.id = :id", Bolum.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<Bolum> readList(int hangiSayfa, int gorunenVeri) {
        return em.createQuery("SELECT b FROM Bolum b", Bolum.class)
                .setFirstResult((hangiSayfa - 1) * gorunenVeri)
                .setMaxResults(gorunenVeri)
                .getResultList();
    }
       @Transactional
    public void truncate() {
        try {
            em.createQuery("DELETE FROM Bolum").executeUpdate();
        } catch (Exception e) {
            System.err.println("Exception in truncate method: " + e.getMessage());
            throw e;
        }
    }
}
