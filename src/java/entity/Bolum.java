/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author Dell
 */
public class Bolum {
    private Long id;
    private Fakulte fakulte;
    private String bolumadi;

    public Bolum() {
    }

    public Bolum(Fakulte fakulte, String bolumadi) {
        this.fakulte = fakulte;
        this.bolumadi = bolumadi;
    }

    public Bolum(Long id, Fakulte fakulte, String bolumadi) {
        this.id = id;
        this.fakulte = fakulte;
        this.bolumadi = bolumadi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fakulte getFakulte() {
        return fakulte;
    }

    public void setFakulte(Fakulte fakulte) {
        this.fakulte = fakulte;
    }

    public String getBolumadi() {
        return bolumadi;
    }

    public void setBolumadi(String bolumadi) {
        this.bolumadi = bolumadi;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bolum other = (Bolum) obj;
        return Objects.equals(this.id, other.id);
    }

    
  
    
    
}
