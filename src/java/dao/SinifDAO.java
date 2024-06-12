package dao;

import entity.Bolum;
import entity.Sinif;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class SinifDAO {

    @PersistenceContext(unitName = "ekibimi_kuruyorumPU")
    private EntityManager em;

    public void create(Sinif entity) {
        Bolum bolum = em.find(Bolum.class, entity.getBolum().getId());
        if (bolum != null) {
            entity.setBolum(bolum);
            em.persist(entity);
        } else {
            throw new IllegalArgumentException("Bolum not found");
        }
    }

    public void update(Sinif entity) {
        em.merge(entity);
    }

    
    public void delete(Sinif entity) {
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

    public Sinif getSinifAdi(int id) {
             return em.createQuery("SELECT s FROM Sinif s WHERE s.id = :id", Sinif.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<Sinif> readList(int hangiSayfa, int gorunenVeri) {
        
        return em.createQuery("SELECT s FROM Sinif s", Sinif.class)
                 .setFirstResult((hangiSayfa - 1) * gorunenVeri)
                 .setMaxResults(gorunenVeri)
                 .getResultList();
    }
}
