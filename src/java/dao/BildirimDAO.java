package dao;

import entity.Bildirim;
import entity.Ogrenci;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BildirimDAO {

    @PersistenceContext(unitName = "ekibimi_kuruyorumPU")
    private EntityManager em;

    public void create(Bildirim entity) {
        Ogrenci gonderen = em.find(Ogrenci.class, entity.getGonderenOgrenci().getId());
        Ogrenci alici = em.find(Ogrenci.class, entity.getAliciOgrenci().getId());

        if (gonderen != null && alici != null) {
            entity.setGonderenOgrenci(gonderen);
            entity.setAliciOgrenci(alici);
            em.persist(entity);
        } else {
            throw new IllegalArgumentException("Gonderen or Alici not found");
        }
    }

    public void update(Bildirim entity) {
        em.merge(entity);
    }

    
    public void delete(Bildirim entity) {
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

    public List<Bildirim> readList(int hangiSayfa, int gorunenVeri) {
        return em.createQuery("SELECT b FROM Bildirim b", Bildirim.class)
                 .setFirstResult((hangiSayfa - 1) * gorunenVeri)
                 .setMaxResults(gorunenVeri)
                 .getResultList();
    }

    public List<Bildirim> readFromAlici(int id) {
        return em.createQuery("SELECT b FROM Bildirim b WHERE b.alici.id = :id", Bildirim.class)
                 .setParameter("id", id)
                 .getResultList();
    }

    public int getBildirimCount(int id) {
        return ((Long) em.createQuery("SELECT COUNT(b) FROM Bildirim b WHERE b.alici.id = :id")
                         .setParameter("id", id)
                         .getSingleResult()).intValue();
    }
}
