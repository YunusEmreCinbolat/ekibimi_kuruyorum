/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
abstract public class BaseController<E, T> {
    protected E entity;
    protected T dao;
    protected List<E> list;
    
    private Class<E> entityClass;
    private Class<T> daoClass;

    public BaseController(Class<E> entityClass, Class<T> daoClass) {
        this.entityClass = entityClass;
        this.daoClass = daoClass;
    }

   public E getEntity() {
    if (this.entity == null) {
        try {
            this.entity = entityClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace(); // Hatanın nedenini raporla
        } 
    }
    return entity;
}


    public void setEntity(E entity) {
        this.entity = entity;
    }

    public T getDao() {
      if(this.dao==null){
         try {
            this.dao = daoClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace(); // Hatanın nedenini raporla
        } 
    }
    return dao;
      
    }

    public void setDao(T dao) {
        this.dao = dao;
    }

    

    public void setList(List<E> list) {
        this.list = list;
    }

  
    
}
