package dao;

import entity.Ogrenci;
import entity.Proje;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
        }
    }

    public void update(Proje entity) {
        em.merge(entity);
    }

    public void delete(Proje entity) {
        try {
            if (entity != null) {
                em.remove(em.merge(entity));
                em.flush();
            } else {
                System.err.println("Proje entity with id " + entity.getId() + " not found.");
            }
        } catch (Exception e) {
            System.err.println("Exception in delete method: " + e.getMessage());
            throw new EJBException(e);
        }
    }

    public Proje getTitle(int id) {
        try {
            return em.find(Proje.class, id);
        } catch (Exception e) {
            System.err.println("Exception in getTitle method: " + e.getMessage());
            throw new EJBException(e);
        }
    }

    public List<Proje> readList(int hangiSayfa, int gorunenVeri) {
        return em.createQuery("SELECT p FROM Proje p", Proje.class)
                 .setFirstResult((hangiSayfa - 1) * gorunenVeri)
                 .setMaxResults(gorunenVeri)
                 .getResultList();
    }

    public List<Proje> ogrenciFromProject(int hangiSayfa, int gorunenVeri, int id) {
        try {
            return em.createQuery("SELECT p FROM Proje p WHERE p.sahipOgrenciId.id = :id", Proje.class)
                     .setParameter("id", id)
                     .setFirstResult((hangiSayfa - 1) * gorunenVeri)
                     .setMaxResults(gorunenVeri)
                     .getResultList();
        } catch (Exception e) {
            System.err.println("Exception in ogrenciFromProject method: " + e.getMessage());
            throw new EJBException(e);
        }
    }

    public List<Proje> aliciogrenciFromProject(int id) {
        try {
            return em.createQuery("SELECT p FROM Proje p WHERE p.aliciOgrenci.id = :id", Proje.class)
                     .setParameter("id", id)
                     .getResultList();
        } catch (Exception e) {
            System.err.println("Exception in aliciogrenciFromProject method: " + e.getMessage());
            throw new EJBException(e);
        }
    }
}
