/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.FakulteDAO;
import entity.Fakulte;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author Dell
 */
@Named
@RequestScoped
@FacesConverter(value="fakulteConverter",managed=true)
public class FakulteConverter implements Converter, Serializable {
    
    @EJB
    private FakulteDAO dao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id=Integer.valueOf(string);
        Fakulte f= this.dao.getFakulteAdi(id);
        return f;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Fakulte f = (Fakulte)t;
        return String.valueOf(f.getId());
    }

    public FakulteDAO getDao() {
        if(this.dao==null){
            this.dao=new FakulteDAO();
        }
        return dao;
    }

    public void setDao(FakulteDAO dao) {
        this.dao = dao;
    }

    
}
