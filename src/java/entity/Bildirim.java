/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "bildirim")
public class Bildirim   implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "alici_ogrenci_id")
    private Ogrenci aliciOgrenci;

    private String bidirimIcerigi;

    private Date tarihSaat;

    @ManyToOne
    @JoinColumn(name = "proje_id")
    private Proje proje;

    @ManyToOne
    @JoinColumn(name = "gonderen_ogrenci_id")
    private Ogrenci gonderenOgrenci;

    public Bildirim() {
    }

    public Bildirim(Ogrenci aliciOgrenci, String bidirimIcerigi, Date tarihSaat, Proje proje, Ogrenci gonderenOgrenci) {
        this.aliciOgrenci = aliciOgrenci;
        this.bidirimIcerigi = bidirimIcerigi;
        this.tarihSaat = tarihSaat;
        this.proje = proje;
        this.gonderenOgrenci = gonderenOgrenci;
    }

    public Bildirim(Long id, Ogrenci aliciOgrenci, String bidirimIcerigi, Date tarihSaat, Proje proje, Ogrenci gonderenOgrenci) {
        this.id = id;
        this.aliciOgrenci = aliciOgrenci;
        this.bidirimIcerigi = bidirimIcerigi;
        this.tarihSaat = tarihSaat;
        this.proje = proje;
        this.gonderenOgrenci = gonderenOgrenci;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ogrenci getAliciOgrenci() {
        return aliciOgrenci;
    }

    public void setAliciOgrenci(Ogrenci aliciOgrenci) {
        this.aliciOgrenci = aliciOgrenci;
    }

    public String getBidirimIcerigi() {
        return bidirimIcerigi;
    }

    public void setBidirimIcerigi(String bidirimIcerigi) {
        this.bidirimIcerigi = bidirimIcerigi;
    }

    public Date getTarihSaat() {
        return tarihSaat;
    }

    public void setTarihSaat(Date tarihSaat) {
        this.tarihSaat = tarihSaat;
    }

    public Proje getProje() {
        return proje;
    }

    public void setProje(Proje proje) {
        this.proje = proje;
    }

    public Ogrenci getGonderenOgrenci() {
        return gonderenOgrenci;
    }

    public void setGonderenOgrenci(Ogrenci gonderenOgrenci) {
        this.gonderenOgrenci = gonderenOgrenci;
    }


}
