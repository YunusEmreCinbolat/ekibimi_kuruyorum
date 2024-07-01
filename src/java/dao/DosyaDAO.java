package dao;

import entity.Dosya;
import entity.Ogrenci;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DosyaDAO {

    @PersistenceContext(unitName = "ekibimi_kuruyorumPU")
    private EntityManager em;

    public void create(Dosya entity) {
         Ogrenci ogrenci = em.find(Ogrenci.class, entity.getOgrenci().getId());
        if (ogrenci != null) {
            entity.setOgrenci(ogrenci);
            em.persist(entity);
        } else {
            throw new IllegalArgumentException("Ogrenci not found");
        }
    }

    public void update(Dosya entity) {
        em.merge(entity);
    }

    
    public void delete(Dosya entity) {
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

    public List<Dosya> readList(Long ogrenciId) {
        return em.createQuery("SELECT d FROM Dosya d WHERE d.ogrenci.id = :ogrenciId", Dosya.class)
                .setParameter("ogrenciId", ogrenciId)
                .getResultList();
    }

    public Dosya readDosya(Long id) {
        return em.find(Dosya.class, id);
    }
}
