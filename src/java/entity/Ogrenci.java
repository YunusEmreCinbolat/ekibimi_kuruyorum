/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

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
    private Long sinifid;
    private Long bolumid;

    public Ogrenci() {
    }
    
    

    public Ogrenci(Long id, String kullaniciadi, String email, String sifre, String ad, String soyad, String universite, Long sinifid, Long bolumid) {
        this.id = id;
        this.kullaniciadi = kullaniciadi;
        this.email = email;
        this.sifre = sifre;
        this.ad = ad;
        this.soyad = soyad;
        this.universite = universite;
        this.sinifid = sinifid;
        this.bolumid = bolumid;
    }

    public Ogrenci(String kullaniciadi, String email, String sifre, String ad, String soyad, String universite, Long sinifid, Long bolumid) {
        this.kullaniciadi = kullaniciadi;
        this.email = email;
        this.sifre = sifre;
        this.ad = ad;
        this.soyad = soyad;
        this.universite = universite;
        this.sinifid = sinifid;
        this.bolumid = bolumid;
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

    public Long getSinifid() {
        return sinifid;
    }

    public void setSinifid(Long sinifid) {
        this.sinifid = sinifid;
    }

    public Long getBolumid() {
        return bolumid;
    }

    public void setBolumid(Long bolumid) {
        this.bolumid = bolumid;
    }
    
    
    
}
