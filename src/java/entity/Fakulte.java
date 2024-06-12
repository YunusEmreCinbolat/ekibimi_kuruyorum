/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "fakulte")
public class Fakulte  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Fakulte other = (Fakulte) obj;
        return Objects.equals(this.id, other.id);
    }
}
