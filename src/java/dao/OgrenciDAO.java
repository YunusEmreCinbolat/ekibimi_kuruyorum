/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Bolum;
import entity.Ogrenci;
import entity.Sinif;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Connector;

/**
 *
 * @author admın
 */
public class OgrenciDAO extends Connector {
    
    private SinifDAO sdao;
    private BolumDAO bdao;

    public List<Ogrenci> readList(int hangiSayfa,int gorunenVeri) {
        List<Ogrenci> list = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("Select * from ogrenciler LIMIT " + gorunenVeri + " OFFSET " + (hangiSayfa - 1) * gorunenVeri);

            while (rs.next()) {
                Sinif s=this.getSdao().getSinifAdi(rs.getInt("sinifid"));
                Bolum b=this.getBdao().getTitle(rs.getInt("bolumid"));
                list.add(new Ogrenci(rs.getLong("ogrenciid"), rs.getString("kullaniciadi"), rs.getString("eposta"), rs.getString("sifre"), rs.getString("ad"), rs.getString("soyad"), rs.getString("universite"), s, b));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OgrenciDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void create(Ogrenci ogrenci) {
        try {
            Statement st = this.getConnect().createStatement();

            st.executeUpdate("insert into ogrenciler (kullaniciadi,eposta,sifre,ad,soyad,universite,sinifid,bolumid) values ('" + ogrenci.getKullaniciadi() + "' , '" + ogrenci.getEmail() + "' , '" + ogrenci.getSifre() + "', '" + ogrenci.getAd() + "' , '" + ogrenci.getSoyad() + "' , '" + ogrenci.getUniversite() + "' ,'" + ogrenci.getSinif().getId()+ "' , '" + ogrenci.getBolum().getId()+ "')");
        } catch (SQLException ex) {
            Logger.getLogger(OgrenciDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void update(Ogrenci ogrenci) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update ogrenciler set kullaniciadi='" + ogrenci.getKullaniciadi() + "' , eposta='" + ogrenci.getEmail() + "' , sifre='" + ogrenci.getSifre() + "' , ad= '" + ogrenci.getAd() + "' , soyad= '" + ogrenci.getSoyad() + "' , universite= '" + ogrenci.getUniversite() + "' , sinifid='" + ogrenci.getSinif().getId()+ "' , bolumid='" + ogrenci.getBolum().getId()+ "' where ogrenciid=" + ogrenci.getId());
        } catch (SQLException ex) {
            Logger.getLogger(OgrenciDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete(int id) {
        Statement st;
        try {
            st = this.getConnect().createStatement();
            st.executeUpdate("delete from ogrenciler where ogrenciid=" + id);
        } catch (SQLException ex) {
            Logger.getLogger(OgrenciDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Ogrenci getFromOgrenci(int id) {
        Ogrenci entity = null;
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("Select * from ogrenciler where ogrenciid=" + id);

            while (rs.next()) {
                 Sinif s=this.getSdao().getSinifAdi(rs.getInt("sinifid"));
                Bolum b=this.getBdao().getTitle(rs.getInt("bolumid"));
                entity = new Ogrenci(rs.getLong("ogrenciid"), rs.getString("kullaniciadi"), rs.getString("eposta"), rs.getString("sifre"), rs.getString("ad"), rs.getString("soyad"), rs.getString("universite"), s,b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OgrenciDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }
    
      public int getOgrenciCount() {
              int veriSayisi=0;
        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select count(ogrenciid) as ogrenciSayisi from ogrenciler");

          rs.next();
          veriSayisi=rs.getInt("ogrenciSayisi");

        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return veriSayisi;
    }

    public SinifDAO getSdao() {
        if(this.sdao==null){
            this.sdao=new SinifDAO();
        }
        return sdao;
    }

    public void setSdao(SinifDAO sdao) {
        this.sdao = sdao;
    }

    public BolumDAO getBdao() {
        if(this.bdao==null){
            this.bdao=new BolumDAO();
        }
        return bdao;
    }

    public void setBdao(BolumDAO bdao) {
        this.bdao = bdao;
    }

    public List<Ogrenci> allList() {
        List<Ogrenci> list = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("Select * from ogrenciler");

            while (rs.next()) {
                Sinif s=this.getSdao().getSinifAdi(rs.getInt("sinifid"));
                Bolum b=this.getBdao().getTitle(rs.getInt("bolumid"));
                list.add(new Ogrenci(rs.getLong("ogrenciid"), rs.getString("kullaniciadi"), rs.getString("eposta"), rs.getString("sifre"), rs.getString("ad"), rs.getString("soyad"), rs.getString("universite"), s, b));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OgrenciDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
      
      
}
