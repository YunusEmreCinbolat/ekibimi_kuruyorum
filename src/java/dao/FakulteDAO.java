package dao;

import entity.Fakulte;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class FakulteDAO {

    @PersistenceContext(unitName = "ekibimi_kuruyorumPU")
    private EntityManager em;

    public void create(Fakulte entity) {
        em.persist(entity);
    }

    public void update(Fakulte entity) {
        em.merge(entity);
    }

    
    public void delete(Fakulte entity) {
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

    public Fakulte getFakulteAdi(int id) {
        return em.createQuery("SELECT f FROM Fakulte f WHERE f.id = :id", Fakulte.class)
                .setParameter("id", id)
                .getSingleResult();
    }

   public Fakulte getFromOgrenciFakulteAdi(int id) {
        try {
            System.out.println("dao"+id);
            return em.createQuery(
                    "SELECT f FROM Fakulte f JOIN f.bolum b JOIN b.ogrencis o WHERE o.id = :id",
                    Fakulte.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.err.println("No Fakulte found for Ogrenci ID: " + id);
            return null;
        }
    }
    public List<Fakulte> readList(int hangiSayfa, int gorunenVeri) {
        return em.createQuery("SELECT f FROM Fakulte f", Fakulte.class)
                .setFirstResult((hangiSayfa - 1) * gorunenVeri)
                .setMaxResults(gorunenVeri)
                .getResultList();
    }
}
