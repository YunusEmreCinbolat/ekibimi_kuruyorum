/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Dell
 */
public class Basvuru {
    private Long id;
    private Ogrenci ogrenci;
    private Proje proje;
    private String durum;

    public Basvuru() {
    }

    public Basvuru(Ogrenci ogrenci, Proje proje, String durum) {
        this.ogrenci = ogrenci;
        this.proje = proje;
        this.durum = durum;
    }

    public Basvuru(Long id, Ogrenci ogrenci, Proje proje, String durum) {
        this.id = id;
        this.ogrenci = ogrenci;
        this.proje = proje;
        this.durum = durum;
    }

    public Basvuru(Long id, Ogrenci ogrenci, Proje proje) {
        this.id = id;
        this.ogrenci = ogrenci;
        this.proje = proje;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ogrenci getOgrenci() {
        return ogrenci;
    }

    public void setOgrenci(Ogrenci ogrenci) {
        this.ogrenci = ogrenci;
    }

    public Proje getProje() {
        return proje;
    }

    public void setProje(Proje proje) {
        this.proje = proje;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }
    
    
    
    
    
}
