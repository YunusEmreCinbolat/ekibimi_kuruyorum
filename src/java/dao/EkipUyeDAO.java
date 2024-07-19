package dao;

import entity.EkipUye;
import entity.Ogrenci;
import entity.Proje;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EkipUyeDAO {

    @PersistenceContext(unitName = "ekibimi_kuruyorumPU")
    private EntityManager em;

    public void create(EkipUye entity) {
        try {
         

       
          
                entity.setOgrenci(entity.getOgrenci());
                entity.setProje(entity.getProje());
                em.persist(entity);
          
        } catch (Exception e) {
            System.err.println("Exception in create method: " + e.getMessage());
            throw new EJBException(e);
        }
    }

    public void update(EkipUye entity) {
        try {
            em.merge(entity);
        } catch (Exception e) {
            System.err.println("Exception in update method: " + e.getMessage());
            throw new EJBException(e);
        }
    }

    public void delete(EkipUye entity) {
        try {
            if (entity != null) {
                em.remove(em.merge(entity));
                em.flush();
            } else {
                System.err.println("EkipUye entity with id " + entity.getId() + " not found.");
            }
        } catch (Exception e) {
            System.err.println("Exception in delete method: " + e.getMessage());
            throw new EJBException(e);
        }
    }

    public List<EkipUye> getFromAOgrenci(int id) {
        try {
            return em.createQuery("SELECT e FROM EkipUye e WHERE e.ogrenci.id = :id", EkipUye.class)
                    .setParameter("id", id)
                    .getResultList();
        } catch (Exception e) {
            System.err.println("Exception in getFromAOgrenci method: " + e.getMessage());
            throw new EJBException(e);
        }
    }

    public List<EkipUye> readList(int hangiSayfa, int gorunenVeri) {
        try {
            return em.createQuery("SELECT e FROM EkipUye e", EkipUye.class)
                    .setFirstResult((hangiSayfa - 1) * gorunenVeri)
                    .setMaxResults(gorunenVeri)
                    .getResultList();
        } catch (Exception e) {
            System.err.println("Exception in readList method: " + e.getMessage());
            throw new EJBException(e);
        }
    }
}