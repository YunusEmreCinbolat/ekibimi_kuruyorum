/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Dell
 */
public class Kategori {
    
    private Long id;
    private String kategoriAdi;
    private String aciklama;

    public Kategori() {
    }

    public Kategori(Long id, String kategoriAdi, String aciklama) {
        this.id = id;
        this.kategoriAdi = kategoriAdi;
        this.aciklama = aciklama;
    }

    public Kategori(String kategoriAdi, String aciklama) {
        this.kategoriAdi = kategoriAdi;
        this.aciklama = aciklama;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKategoriAdi() {
        return kategoriAdi;
    }

    public void setKategoriAdi(String kategoriAdi) {
        this.kategoriAdi = kategoriAdi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
    
    
    
}
