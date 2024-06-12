/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package beans;

/**
 *
 * @author Dell
 */
public interface Controller<T> {
    
    public void create();
    public void delete(T id);
    public void update();
  
    
}
