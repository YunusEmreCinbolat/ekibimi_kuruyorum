package dao;

import entity.Basvuru;
import entity.Ogrenci;
import entity.Proje;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Stateless
public class BasvuruDAO {

    @PersistenceContext(unitName = "ekibimi_kuruyorumPU")
    private EntityManager em;

     public void create(Basvuru entity,int oid,int pid) {
        Ogrenci ogrenci = em.find(Ogrenci.class, oid);
        Proje proje = em.find(Proje.class, pid);

        if (ogrenci != null && proje != null) {
            entity.setOgrenci(ogrenci);
            entity.setProje(proje);
            em.persist(entity);
        } else {
            throw new IllegalArgumentException("Ogrenci or Proje not found");
        }
    }

    public void update(Basvuru entity) {
        em.merge(entity);
    }

    @Transactional
    public void delete(Basvuru entity) {
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

    public List<Basvuru> readList(int hangiSayfa, int gorunenVeri) {
        // Implement pagination and data fetching logic
        return em.createQuery("SELECT b FROM Basvuru b", Basvuru.class)
                 .setFirstResult((hangiSayfa - 1) * gorunenVeri)
                 .setMaxResults(gorunenVeri)
                 .getResultList();
    }
     @Transactional
    public void truncate() {
        try {
            em.createQuery("DELETE FROM Basvuru").executeUpdate();
        } catch (Exception e) {
            System.err.println("Exception in truncate method: " + e.getMessage());
            throw e;
        }
    }
}
