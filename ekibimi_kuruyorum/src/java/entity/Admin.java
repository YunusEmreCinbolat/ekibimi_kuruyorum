/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Dell
 */
public class Admin {
    private Long id;
    private String ad;
    private String soyad;
    private String kullaniciAdi;
    private String email;
    private String sifre;
     private String sifreTekrar;

    public Admin() {
    }

    public Admin(Long id, String ad, String soyad, String kullaniciAdi, String email, String sifre) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.kullaniciAdi = kullaniciAdi;
        this.email = email;
        this.sifre = sifre;
    }

    public Admin(String ad, String soyad, String kullaniciAdi, String email, String sifre) {
        this.ad = ad;
        this.soyad = soyad;
        this.kullaniciAdi = kullaniciAdi;
        this.email = email;
        this.sifre = sifre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSifretekrar() {
        return sifreTekrar;
    }

    public void setSifretekrar(String sifreTekrar) {
        this.sifreTekrar = sifreTekrar;
    }
    
    
}
