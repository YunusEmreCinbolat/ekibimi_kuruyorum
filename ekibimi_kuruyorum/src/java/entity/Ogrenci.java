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
    private String kullaniciAdi;
    private String email;
    private String sifre;
    private String ad;
    private String soyad;
    private String universite;
    private Long sinifId;
    private Long bolumId;

    public Ogrenci() {
    }
    
    

    public Ogrenci(Long id, String kullaniciAdi, String email, String sifre, String ad, String soyad, String universite, Long sinifId, Long bolumId) {
        this.id = id;
        this.kullaniciAdi = kullaniciAdi;
        this.email = email;
        this.sifre = sifre;
        this.ad = ad;
        this.soyad = soyad;
        this.universite = universite;
        this.sinifId = sinifId;
        this.bolumId = bolumId;
    }

    public Ogrenci(String kullaniciAdi, String email, String sifre, String ad, String soyad, String universite, Long sinifId, Long bolumId) {
        this.kullaniciAdi = kullaniciAdi;
        this.email = email;
        this.sifre = sifre;
        this.ad = ad;
        this.soyad = soyad;
        this.universite = universite;
        this.sinifId = sinifId;
        this.bolumId = bolumId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKullaniciadi() {
        return kullaniciAdi;
    }

    public void setKullaniciadi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
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
        return sinifId;
    }

    public void setSinifid(Long sinifId) {
        this.sinifId = sinifId;
    }

    public Long getBolumid() {
        return bolumId;
    }

    public void setBolumid(Long bolumId) {
        this.bolumId = bolumId;
    }
    
    
    
}
