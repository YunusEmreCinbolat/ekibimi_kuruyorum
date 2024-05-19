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
public class Ogrenci {
    
    private Long id;
    private String kullaniciadi;
    private String email;
    private String sifre;
    private String ad;
    private String soyad;
    private String universite;
    private Sinif sinif;
    private Bolum bolum;

    public Ogrenci() {
    }

    public Ogrenci(String kullaniciadi, String email, String sifre, String ad, String soyad, String universite, Sinif sinif, Bolum bolumid) {
        this.kullaniciadi = kullaniciadi;
        this.email = email;
        this.sifre = sifre;
        this.ad = ad;
        this.soyad = soyad;
        this.universite = universite;
        this.sinif = sinif;
        this.bolum = bolumid;
    }

    public Ogrenci(Long id, String kullaniciadi, String email, String sifre, String ad, String soyad, String universite, Sinif sinif, Bolum bolum) {
        this.id = id;
        this.kullaniciadi = kullaniciadi;
        this.email = email;
        this.sifre = sifre;
        this.ad = ad;
        this.soyad = soyad;
        this.universite = universite;
        this.sinif = sinif;
        this.bolum = bolum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKullaniciadi() {
        return kullaniciadi;
    }

    public void setKullaniciadi(String kullaniciadi) {
        this.kullaniciadi = kullaniciadi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getUniversite() {
        return universite;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }

    public Sinif getSinif() {
        return sinif;
    }

    public void setSinif(Sinif sinif) {
        this.sinif = sinif;
    }

    public Bolum getBolum() {
        return bolum;
    }

    public void setBolum(Bolum bolum) {
        this.bolum = bolum;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Ogrenci other = (Ogrenci) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    

    
    
}
