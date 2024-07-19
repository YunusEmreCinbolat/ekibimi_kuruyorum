package dao;

import entity.Bolum;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
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

    public void delete(Bolum entity) {
        try {
            Bolum managedEntity = em.find(Bolum.class, entity.getId());
            if (managedEntity != null) {
                em.remove(em.merge(managedEntity));
                em.flush();
            } else {
                System.err.println("Bolum entity with id " + entity.getId() + " not found.");
            }
        } catch (Exception e) {
            System.err.println("Exception in delete method: DAO " + e.getMessage());
            throw e;
        }
    }

    public Bolum getTitle(int id) {
        try {
            return em.createQuery("SELECT b FROM Bolum b WHERE b.id = :id", Bolum.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.err.println("No Bolum found for ID: " + id);
            return null;
        }
    }

    public List<Bolum> readList(int hangiSayfa, int gorunenVeri) {
        return em.createQuery("SELECT b FROM Bolum b", Bolum.class)
                .setFirstResult((hangiSayfa - 1) * gorunenVeri)
                .setMaxResults(gorunenVeri)
                .getResultList();
    }
}