/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kategori;
import entity.Kategori;
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
 * @author Dell
 */
public class KategoriDAO extends Connector {

    public void create(Kategori kategori) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into kategoriler (kategoriadi,aciklama) values('" + kategori.getKategoriAdi() + "', '" + kategori.getAciklama() + "' )");
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int id) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("DELETE from kategoriler where kategoriid=" + id);
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Kategori> readList(int hangiSayfa, int gorunenVeri) {
        List<Kategori> list = new ArrayList<>();

        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from kategoriler LIMIT " + gorunenVeri + " OFFSET " + (hangiSayfa - 1) * gorunenVeri);

            while (rs.next()) {
                list.add(new Kategori(rs.getLong("kategoriid"), rs.getString("kategoriadi"), rs.getString("aciklama")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(KategoriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void update(Kategori kategori) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update kategoriler set kategoriadi='" + kategori.getKategoriAdi() + "',  aciklama='" + kategori.getAciklama() + "' where kategoriid=" + kategori.getId());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Kategori getTitle(int id) {
        Kategori entity = null;

        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from kategoriler where kategoriid=" + id);

            while (rs.next()) {
                entity = new Kategori(rs.getLong("kategoriid"), rs.getString("kategoriadi"), rs.getString("aciklama"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(KategoriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }

    public int getKaetegoriCount() {
        int veriSayisi = 0;
        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select count(kategoriid) as kategoriSayisi from kategoriler");

            rs.next();
            veriSayisi = rs.getInt("kategoriSayisi");

        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return veriSayisi;
    }

}
