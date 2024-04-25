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
    private Long fakulteid;
    private String bolumadi;

    public Bolum() {
    }

    public Bolum(Long id, Long fakulteid, String bolumadi) {
        this.id = id;
        this.fakulteid = fakulteid;
        this.bolumadi = bolumadi;
    }

    public Bolum(Long fakulteid, String bolumadi) {
        this.fakulteid = fakulteid;
        this.bolumadi = bolumadi;
    }

    public Bolum(String bolumadi) {
        this.bolumadi = bolumadi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFakulteid() {
        return fakulteid;
    }

    public void setFakulteid(Long fakulteid) {
        this.fakulteid = fakulteid;
    }

    public String getBolumadi() {
        return bolumadi;
    }

    public void setBolumadi(String bolumadi) {
        this.bolumadi = bolumadi;
    }
    
    
    
}
