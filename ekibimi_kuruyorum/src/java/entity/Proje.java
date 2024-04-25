/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Dell
 */
public class Proje {
    private Long id;
    private String projeAdi;
    private String projeAciklamasi;
    private String kullanilanTeknolojiler;
    private Long sahipOgrenciId;
    private Long kategoriId;

    public Proje() {
    }

    public Proje(Long id, String projeAdi, String projeAciklamasi, String kullanilanTeknolojiler, Long sahipOgrenciId, Long kategoriId) {
        this.id = id;
        this.projeAdi = projeAdi;
        this.projeAciklamasi = projeAciklamasi;
        this.kullanilanTeknolojiler = kullanilanTeknolojiler;
        this.sahipOgrenciId = sahipOgrenciId;
        this.kategoriId = kategoriId;
    }

    public Proje(String projeAdi, String projeAciklamasi, String kullanilanTeknolojiler, Long sahipOgrenciId, Long kategoriId) {
        this.projeAdi = projeAdi;
        this.projeAciklamasi = projeAciklamasi;
        this.kullanilanTeknolojiler = kullanilanTeknolojiler;
        this.sahipOgrenciId = sahipOgrenciId;
        this.kategoriId = kategoriId;
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

    public Long getSahipOgrenciId() {
        return sahipOgrenciId;
    }

    public void setSahipOgrenciId(Long sahipOgrenciId) {
        this.sahipOgrenciId = sahipOgrenciId;
    }

    public Long getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(Long kategoriId) {
        this.kategoriId = kategoriId;
    }
    
    
            
    
}
