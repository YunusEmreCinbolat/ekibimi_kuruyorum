package converter;

import dao.ProjeDAO;
import entity.Proje;
import jakarta.ejb.EJB;
import jakarta.ejb.EJBException;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
@FacesConverter(value="projeConverter",managed = true)
public class ProjeConverter implements Converter<Proje>, Serializable {

    @EJB
    private ProjeDAO dao;

    @Override
    public Proje getAsObject(FacesContext fc, UIComponent uic, String string) {
        try {
            int id = Integer.parseInt(string);
            return dao.getTitle(id);
        } catch (NumberFormatException e) {
            System.err.println("NumberFormatException in ProjeConverter.getAsObject: " + e.getMessage());
            return null;
        } catch (EJBException e) {
            System.err.println("EJBException in ProjeConverter.getAsObject: " + e.getMessage());
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Proje proje) {
        if (proje == null) {
            return "";
        }
        return String.valueOf(proje.getId());
    }

    public ProjeDAO getDao() {
        return dao;
    }

    public void setDao(ProjeDAO dao) {
        this.dao = dao;
    }
}
