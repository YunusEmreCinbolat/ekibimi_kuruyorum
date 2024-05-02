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
    private Long bolumid;
    private int sinifadi;
    

    public Sinif() {
    }

    public Sinif(Long id, Long bolumid, int sinifadi) {
        this.id = id;
        this.bolumid = bolumid;
        this.sinifadi = sinifadi;
    }

    public Sinif(Long bolumid, int sinifadi) {
        this.bolumid = bolumid;
        this.sinifadi = sinifadi;
    }

    public Sinif(int sinifadi) {
        this.sinifadi = sinifadi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBolumid() {
        return bolumid;
    }

    public void setBolumid(Long bolumid) {
        this.bolumid = bolumid;
    }

    public int getSinifadi() {
        return sinifadi;
    }

    public void setSinifadi(int sinifadi) {
        this.sinifadi = sinifadi;
    }
    
    
    
}
