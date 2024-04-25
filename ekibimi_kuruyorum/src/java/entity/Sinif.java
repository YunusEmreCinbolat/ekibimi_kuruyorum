/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Dell
 */
public class Sinif {
    private Long id;
    private Long bolumId;
    private int sinifAdi;

    public Sinif() {
    }

    public Sinif(Long id, Long bolumId, int sinifAdi) {
        this.id = id;
        this.bolumId = bolumId;
        this.sinifAdi = sinifAdi;
    }

    public Sinif(Long bolumId, int sinifAdi) {
        this.bolumId = bolumId;
        this.sinifAdi = sinifAdi;
    }

    public Sinif(int sinifAdi) {
        this.sinifAdi = sinifAdi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBolumid() {
        return bolumId;
    }

    public void setBolumid(Long bolumId) {
        this.bolumId = bolumId;
    }

    public int getSinifadi() {
        return sinifAdi;
    }

    public void setSinifadi(int sinifAdi) {
        this.sinifAdi = sinifAdi;
    }
    
    
    
}
