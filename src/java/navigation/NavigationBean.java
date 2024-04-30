/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package navigation;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dell
 */
@Named
@SessionScoped
public class NavigationBean implements Serializable {

  private Map<String,String> pages;
    public NavigationBean() {
    }

    public Map<String, String> getPages() {
                pages.put("index", "/panel/admin/admin/AdminKaydet.xhtm?faces-redirect=true");
        return pages;
    }

    public String goToPage(String page){
        pages= new HashMap();
        pages.put(page, "active");
        pages.put("index", "/panel/admin/admin/AdminKaydet.xhtml");
        return page;
    } 
}
