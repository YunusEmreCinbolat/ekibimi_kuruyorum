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
    private Long ogrenciid;
    private Long projeid;
    private String ekiprolu;

    public EkipUye() {
    }

    public EkipUye(Long id, Long ogrenciid, Long projeid, String ekiprolu) {
        this.id = id;
        this.ogrenciid = ogrenciid;
        this.projeid = projeid;
        this.ekiprolu = ekiprolu;
    }

    public EkipUye(Long ogrenciid, Long projeid, String ekiprolu) {
        this.ogrenciid = ogrenciid;
        this.projeid = projeid;
        this.ekiprolu = ekiprolu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOgrenciid() {
        return ogrenciid;
    }

    public void setOgrenciid(Long ogrenciid) {
        this.ogrenciid = ogrenciid;
    }

    public Long getProjeid() {
        return projeid;
    }

    public void setProjeid(Long projeid) {
        this.projeid = projeid;
    }

    public String getEkiprolu() {
        return ekiprolu;
    }

    public void setEkiprolu(String ekiprolu) {
        this.ekiprolu = ekiprolu;
    }
    
}
