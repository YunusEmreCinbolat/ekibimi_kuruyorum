/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.ProjeDAO;
import entity.Proje;
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
@FacesConverter(value="projeConverter",managed = true)
public class ProjeConverter implements Converter,Serializable {
    
    @EJB
    private ProjeDAO dao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id=Integer.valueOf(string);
        Proje f= this.dao.getTitle(id);
        return f;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Proje f = (Proje)t;
        return String.valueOf(f.getId());
    }

    public ProjeDAO getDao() {
        if(this.dao==null){
            this.dao=new ProjeDAO();
        }
        return dao;
    }

    public void setDao(ProjeDAO dao) {
        this.dao = dao;
    }

    
}
