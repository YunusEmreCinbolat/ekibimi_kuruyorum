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
@Table(name = "proje")
public class Proje  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projeAdi;
    private String projeAciklamasi;
    private String kullanilanTeknolojiler;

    @ManyToOne
    @JoinColumn(name = "sahip_ogrenci_id")
    private Ogrenci sahipOgrenciId;

    @ManyToOne
    @JoinColumn(name = "kategori_id")
    private Kategori kategori;

    public Proje() {
    }

    public Proje(String projeAdi, String projeAciklamasi, String kullanilanTeknolojiler, Ogrenci sahipOgrenciId, Kategori kategori) {
        this.projeAdi = projeAdi;
        this.projeAciklamasi = projeAciklamasi;
        this.kullanilanTeknolojiler = kullanilanTeknolojiler;
        this.sahipOgrenciId = sahipOgrenciId;
        this.kategori = kategori;
    }

    public Proje(Long id, String projeAdi, String projeAciklamasi, String kullanilanTeknolojiler, Ogrenci sahipOgrenciId, Kategori kategori) {
        this.id = id;
        this.projeAdi = projeAdi;
        this.projeAciklamasi = projeAciklamasi;
        this.kullanilanTeknolojiler = kullanilanTeknolojiler;
        this.sahipOgrenciId = sahipOgrenciId;
        this.kategori = kategori;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjeAdi() {
        return projeAdi;
    }

    public void setProjeAdi(String projeAdi) {
        this.projeAdi = projeAdi;
    }

    public String getProjeAciklamasi() {
        return projeAciklamasi;
    }

    public void setProjeAciklamasi(String projeAciklamasi) {
        this.projeAciklamasi = projeAciklamasi;
    }

    public String getKullanilanTeknolojiler() {
        return kullanilanTeknolojiler;
    }

    public void setKullanilanTeknolojiler(String kullanilanTeknolojiler) {
        this.kullanilanTeknolojiler = kullanilanTeknolojiler;
    }

    public Ogrenci getSahipOgrenciId() {
        return sahipOgrenciId;
    }

    public void setSahipOgrenciId(Ogrenci sahipOgrenciId) {
        this.sahipOgrenciId = sahipOgrenciId;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

   

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Proje other = (Proje) obj;
        return Objects.equals(this.id, other.id);
    }
}
