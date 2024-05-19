/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Dell
 */
public class EkipUye {
    private Long id;
    private Ogrenci ogrenci;
    private Proje proje;
    private String ekiprolu;

    public EkipUye() {
    }

    public EkipUye(Ogrenci ogrenci, Proje proje, String ekiprolu) {
        this.ogrenci = ogrenci;
        this.proje = proje;
        this.ekiprolu = ekiprolu;
    }

    public EkipUye(Long id, Ogrenci ogrenci, Proje proje, String ekiprolu) {
        this.id = id;
        this.ogrenci = ogrenci;
        this.proje = proje;
        this.ekiprolu = ekiprolu;
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

    public String getEkiprolu() {
        return ekiprolu;
    }

    public void setEkiprolu(String ekiprolu) {
        this.ekiprolu = ekiprolu;
    }

   
    
    
}
