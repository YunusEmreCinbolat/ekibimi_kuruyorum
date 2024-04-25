/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Dell
 */
public class Fakulte {
    
    private Long id;
    private String fakulteAdi;

    public Fakulte() {
    }

    public Fakulte(Long id, String fakulteAdi) {
        this.id = id;
        this.fakulteAdi = fakulteAdi;
    }

    public Fakulte(String fakulteAdi) {
        this.fakulteAdi = fakulteAdi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFakulteadi() {
        return fakulteAdi;
    }

    public void setFakulteadi(String fakulteAdi) {
        this.fakulteAdi = fakulteAdi;
    }
    
    
    
}
