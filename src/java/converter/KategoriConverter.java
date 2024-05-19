/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.KategoriDAO;
import entity.Kategori;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author Dell
 */

@FacesConverter("kategoriConverter")
public class KategoriConverter implements Converter {
    
    private KategoriDAO dao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id=Integer.valueOf(string);
        Kategori f= this.getDao().getTitle(id);
        return f;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Kategori f = (Kategori)t;
        return String.valueOf(f.getId());
    }

    public KategoriDAO getDao() {
        if(this.dao==null){
            this.dao=new KategoriDAO();
        }
        return dao;
    }

    public void setDao(KategoriDAO dao) {
        this.dao = dao;
    }

    
}
