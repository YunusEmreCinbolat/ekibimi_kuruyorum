package dao;

import entity.Ogrenci;
import entity.Proje;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Stateless
public class ProjeDAO {

    @PersistenceContext(unitName = "ekibimi_kuruyorumPU")
    private EntityManager em;

    public void create(Proje entity) {
              Ogrenci ogrenci = em.find(Ogrenci.class, entity.getSahipOgrenciId().getId());
        if (ogrenci != null) {
            entity.setSahipOgrenciId(ogrenci);
            em.persist(entity);
        } else {
            throw new IllegalArgumentException("Ogrenci not found");
        }    }

    public void update(Proje entity) {
        em.merge(entity);
    }
    

    @Transactional
    public void delete(Proje entity) {
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

    public Proje getTitle(int id) {
        return em.find(Proje.class, id);
    }

    public List<Proje> readList(int hangiSayfa, int gorunenVeri) {
        return em.createQuery("SELECT p FROM Proje p", Proje.class)
                 .setFirstResult((hangiSayfa - 1) * gorunenVeri)
                 .setMaxResults(gorunenVeri)
                 .getResultList();
    }

    public List<Proje> ogrenciFromProject(int hangiSayfa, int gorunenVeri, int id) {
        return em.createQuery("SELECT p FROM Proje p WHERE p.ogrenci.id = :id", Proje.class)
                 .setParameter("id", id)
                 .setFirstResult((hangiSayfa - 1) * gorunenVeri)
                 .setMaxResults(gorunenVeri)
                 .getResultList();
    }

    public List<Proje> aliciogrenciFromProject(int id) {
        return em.createQuery("SELECT p FROM Proje p WHERE p.aliciOgrenci.id = :id", Proje.class)
                 .setParameter("id", id)
                 .getResultList();
    }
    
       @Transactional
    public void truncate() {
        try {
            em.createQuery("DELETE FROM Proje").executeUpdate();
        } catch (Exception e) {
            System.err.println("Exception in truncate method: " + e.getMessage());
            throw e;
        }
    }
}
