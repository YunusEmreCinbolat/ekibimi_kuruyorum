/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "bolum")
public class Bolum  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bolumAdi;

    @ManyToOne
    @JoinColumn(name = "fakulte_id")
    private Fakulte fakulte;

    public Bolum() {
    }

    public Bolum(String bolumAdi, Fakulte fakulte) {
        this.bolumAdi = bolumAdi;
        this.fakulte = fakulte;
    }

    public Bolum(Long id, String bolumAdi, Fakulte fakulte) {
        this.id = id;
        this.bolumAdi = bolumAdi;
        this.fakulte = fakulte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBolumAdi() {
        return bolumAdi;
    }

    public void setBolumAdi(String bolumAdi) {
        this.bolumAdi = bolumAdi;
    }

    public Fakulte getFakulte() {
        return fakulte;
    }

    public void setFakulte(Fakulte fakulte) {
        this.fakulte = fakulte;
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
        final Bolum other = (Bolum) obj;
        return Objects.equals(this.id, other.id);
    }
}
