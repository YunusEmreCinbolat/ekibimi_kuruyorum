/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Dell
 */
public class Dosya {
    private Long id;
    private Ogrenci ogrenci;
    private String fpath;
    private String fname;
    private String ftype;

    public Dosya() {
    }

    public Dosya(Ogrenci ogrenci, String fpath, String fname, String ftype) {
        this.ogrenci = ogrenci;
        this.fpath = fpath;
        this.fname = fname;
        this.ftype = ftype;
    }

    public Dosya(Long id, Ogrenci ogrenci, String fpath, String fname, String ftype) {
        this.id = id;
        this.ogrenci = ogrenci;
        this.fpath = fpath;
        this.fname = fname;
        this.ftype = ftype;
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

    public String getFpath() {
        return fpath;
    }

    public void setFpath(String fpath) {
        this.fpath = fpath;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
    }
    
    
    
}
