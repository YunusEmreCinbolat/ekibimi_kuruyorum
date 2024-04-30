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
   
    protected T dao;
    protected List<E> list;
    
    private Class<E> entityClass;
    private Class<T> daoClass;
    
    protected int gorunenVeri=10;
    protected int hangiSayfa=1;
    
    public void prev(){
        hangiSayfa--;
    }

      public void next(){
        hangiSayfa++;
    }

    public int getGorunenVeri() {
        return gorunenVeri;
    }

    public void setGorunenVeri(int gorunenVeri) {
        this.gorunenVeri = gorunenVeri;
    }

    public int getHangiSayfa() {
        return hangiSayfa;
    }

    public void setHangiSyfa(int hangiSyfa) {
        this.hangiSayfa = hangiSyfa;
    }
    
    
    

    public BaseController(Class<E> entityClass, Class<T> daoClass) {
        this.entityClass = entityClass;
        this.daoClass = daoClass;
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
