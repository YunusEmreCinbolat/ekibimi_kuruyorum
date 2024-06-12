package dao;

import entity.EkipUye;
import entity.Ogrenci;
import entity.Proje;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Stateless
public class EkipUyeDAO {

    @PersistenceContext(unitName = "ekibimi_kuruyorumPU")
    private EntityManager em;

    public void create(EkipUye entity) {
       Ogrenci ogrenci = em.find(Ogrenci.class, entity.getOgrenci().getId());
        Proje proje = em.find(Proje.class, entity.getProje().getId());
        
        if (ogrenci != null && proje != null) {
            entity.setOgrenci(ogrenci);
            entity.setProje(proje);
            em.persist(entity);
        } else {
            throw new IllegalArgumentException("Ogrenci or Proje not found");
        }
    }

    public void update(EkipUye entity) {
        em.merge(entity);
    }

    @Transactional
    public void delete(EkipUye entity) {
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

    public List<EkipUye> getFromAOgrenci(int id) {
        return em.createQuery("SELECT e FROM EkipUye e WHERE e.ogrenci.id = :id", EkipUye.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<EkipUye> readList(int hangiSayfa, int gorunenVeri) {
        return em.createQuery("SELECT e FROM EkipUye e", EkipUye.class)
                .setFirstResult((hangiSayfa - 1) * gorunenVeri)
                .setMaxResults(gorunenVeri)
                .getResultList();
    }
        @Transactional
    public void truncate() {
        try {
            em.createQuery("DELETE FROM EkipUye").executeUpdate();
        } catch (Exception e) {
            System.err.println("Exception in truncate method: " + e.getMessage());
            throw e;
        }
    }
}
