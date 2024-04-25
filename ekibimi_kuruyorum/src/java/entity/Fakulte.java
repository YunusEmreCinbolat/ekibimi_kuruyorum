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
    private String fakulteadi;

    public Fakulte() {
    }

    public Fakulte(Long id, String fakulteadi) {
        this.id = id;
        this.fakulteadi = fakulteadi;
    }

    public Fakulte(String fakulteadi) {
        this.fakulteadi = fakulteadi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFakulteadi() {
        return fakulteadi;
    }

    public void setFakulteadi(String fakulteadi) {
        this.fakulteadi = fakulteadi;
    }
    
    
    
}
