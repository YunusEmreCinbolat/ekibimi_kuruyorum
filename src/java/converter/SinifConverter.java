/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.SinifDAO;
import entity.Sinif;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author Dell
 */

@FacesConverter("sinifConverter")
public class SinifConverter implements Converter {
    
    private SinifDAO dao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id=Integer.valueOf(string);
        Sinif f= this.getDao().getSinifAdi(id);
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
