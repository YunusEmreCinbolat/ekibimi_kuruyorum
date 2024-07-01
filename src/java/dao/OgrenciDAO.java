package dao;

import entity.Bolum;
import entity.Ogrenci;
import entity.Sinif;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class OgrenciDAO {

    @PersistenceContext(unitName = "ekibimi_kuruyorumPU")
    private EntityManager em;

    public void create(Ogrenci entity) {
          Bolum bolum = em.find(Bolum.class, entity.getBolum().getId());
        Sinif sinif = em.find(Sinif.class, entity.getSinif().getId());

        if (bolum != null && sinif != null) {
            entity.setBolum(bolum);
            entity.setSinif(sinif);
            em.persist(entity);
        } else {
            throw new IllegalArgumentException("Bolum or Sinif not found");
        }
    }

    public void update(Ogrenci entity) {
        em.merge(entity);
    }

    
    public void delete(Ogrenci entity) {
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

    public Ogrenci getFromOgrenci(int id) {
        return em.createQuery("SELECT o FROM Ogrenci o WHERE o.id = :id", Ogrenci.class)
                 .setParameter("id", id)
                 .getSingleResult();
    }

    public List<Ogrenci> readList(int hangiSayfa, int gorunenVeri) {
        return em.createQuery("SELECT o FROM Ogrenci o", Ogrenci.class)
                 .setFirstResult((hangiSayfa - 1) * gorunenVeri)
                 .setMaxResults(gorunenVeri)
                 .getResultList();
    }
    public List<Ogrenci> allList() {
    return em.createQuery("SELECT o FROM Ogrenci o", Ogrenci.class)
             .getResultList();
}

}
