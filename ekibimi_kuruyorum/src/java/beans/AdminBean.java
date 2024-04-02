/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Dell
 */
@Named(value = "adminBean")
@SessionScoped
public class AdminBean implements Serializable {

    /**
     * Creates a new instance of AdminBean
     */
    public AdminBean() {
    }
    
}
