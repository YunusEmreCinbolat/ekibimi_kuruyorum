/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.SinifDAO;
import entity.Sinif;
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
@FacesConverter(value="sinifConverter",managed = true)
public class SinifConverter implements Converter,Serializable {
    @EJB
    private SinifDAO dao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id=Integer.valueOf(string);
        Sinif f= this.dao.getSinifAdi(id);
        return f;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Sinif f = (Sinif)t;
        return String.valueOf(f.getId());
    }

    public SinifDAO getDao() {
        if(this.dao==null){
            this.dao=new SinifDAO();
        }
        return dao;
    }

    public void setDao(SinifDAO dao) {
        this.dao = dao;
    }

    
}
