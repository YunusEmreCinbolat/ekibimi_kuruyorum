/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Dell
 */
public class Bolum {
    private Long id;
    private Long fakulteId;
    private String bolumAdi;

    public Bolum() {
    }

    public Bolum(Long id, Long fakulteId, String bolumAdi) {
        this.id = id;
        this.fakulteId = fakulteId;
        this.bolumAdi = bolumAdi;
    }

    public Bolum(Long fakulteId, String bolumAdi) {
        this.fakulteId = fakulteId;
        this.bolumAdi = bolumAdi;
    }

    public Bolum(String bolumAdi) {
        this.bolumAdi = bolumAdi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFakulteid() {
        return fakulteId;
    }

    public void setFakulteid(Long fakulteId) {
        this.fakulteId = fakulteId;
    }

    public String getBolumadi() {
        return bolumAdi;
    }

    public void setBolumadi(String bolumAdi) {
        this.bolumAdi = bolumAdi;
    }
    
    
    
}
