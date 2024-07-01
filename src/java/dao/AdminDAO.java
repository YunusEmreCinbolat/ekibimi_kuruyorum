package dao;

import entity.Admin;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Stateless
public class AdminDAO {

    @PersistenceContext(unitName = "ekibimi_kuruyorumPU")
    private EntityManager em;

    @Transactional
    public void create(Admin entity) {
        try {
            em.persist(entity);
        } catch (Exception e) {
            System.err.println("Exception in create method: " + e.getMessage());
            throw e;
        }
    }

    @Transactional
    public void update(Admin entity) {
        try {
            em.merge(entity);
        } catch (Exception e) {
            System.err.println("Exception in update method: " + e.getMessage());
            throw e;
        }
    }

  
    public void delete(Admin entity) {
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

    public List<Admin> readList(int hangiSayfa, int gorunenVeri) {
        try {
            return em.createQuery("SELECT a FROM Admin a", Admin.class)
                     .setFirstResult((hangiSayfa - 1) * gorunenVeri)
                     .setMaxResults(gorunenVeri)
                     .getResultList();
        } catch (Exception e) {
            System.err.println("Exception in readList method: " + e.getMessage());
            throw e;
        }
    }

    public List<Admin> allList() {
        try {
            return em.createQuery("SELECT a FROM Admin a", Admin.class)
                     .getResultList();
        } catch (Exception e) {
            System.err.println("Exception in allList method: " + e.getMessage());
            throw e;
        }
    }
}
