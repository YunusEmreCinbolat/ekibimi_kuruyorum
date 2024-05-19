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
public class Sinif {
    private Long id;
    private Bolum bolum;
    private int sinifadi;
    

    public Sinif() {
    }

    public Sinif(Bolum bolum, int sinifadi) {
        this.bolum = bolum;
        this.sinifadi = sinifadi;
    }

    public Sinif(Long id, Bolum bolum, int sinifadi) {
        this.id = id;
        this.bolum = bolum;
        this.sinifadi = sinifadi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bolum getBolum() {
        return bolum;
    }

    public void setBolum(Bolum bolum) {
        this.bolum = bolum;
    }

    public int getSinifadi() {
        return sinifadi;
    }

    public void setSinifadi(int sinifadi) {
        this.sinifadi = sinifadi;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final Sinif other = (Sinif) obj;
        return Objects.equals(this.id, other.id);
    }

  
    
}
