/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.BolumDAO;
import entity.Bolum;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author Dell
 */

@FacesConverter("bolumConverter")
public class BolumConverter implements Converter {
    
    private BolumDAO dao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id=Integer.valueOf(string);
        Bolum f= this.getDao().getTitle(id);
        return f;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Bolum f = (Bolum)t;
        return String.valueOf(f.getId());
    }

    public BolumDAO getDao() {
        if(this.dao==null){
            this.dao=new BolumDAO();
        }
        return dao;
    }

    public void setDao(BolumDAO dao) {
        this.dao = dao;
    }

    
}
