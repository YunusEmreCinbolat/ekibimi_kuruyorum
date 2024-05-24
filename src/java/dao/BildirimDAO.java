/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Bildirim;
import entity.Ogrenci;
import entity.Proje;
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
public class BildirimDAO extends Connector {

    private OgrenciDAO odao;
    private ProjeDAO pdao;

    public List<Bildirim> readList(int hangiSayfa, int gorunenVeri) {
        List<Bildirim> list = new ArrayList<>();

        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM bildirimler LIMIT " + gorunenVeri + " OFFSET " + (hangiSayfa - 1) * gorunenVeri);

            while (rs.next()) {
                Ogrenci aliciOgrenci = this.getOdao().getFromOgrenci(rs.getInt("aliciogrenciid"));
                Proje proje = this.getPdao().getTitle(rs.getInt("proje_id"));
                Ogrenci gondericiOgrenci = this.getOdao().getFromOgrenci(rs.getInt("gonderenogrenciid"));

                list.add(new Bildirim(rs.getLong("bildirimid"), aliciOgrenci, rs.getString("bildirimicerigi"), rs.getDate("bildirimtarihivesaati"), proje, gondericiOgrenci));

            }

        } catch (SQLException ex) {
            Logger.getLogger(BildirimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
     public List<Bildirim> readFromAlici(int id) {
        List<Bildirim> list = new ArrayList<>();

        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM bildirimler where aliciogrenciid="+id);

            while (rs.next()) {
                Ogrenci aliciOgrenci = this.getOdao().getFromOgrenci(rs.getInt("aliciogrenciid"));
                Proje proje = this.getPdao().getTitle(rs.getInt("projeid"));
                Ogrenci gondericiOgrenci = this.getOdao().getFromOgrenci(rs.getInt("gonderenogrenciid"));
                System.out.println("dao"+id);
                list.add(new Bildirim(rs.getLong("bildirimid"), aliciOgrenci, rs.getString("bildirimicerigi"), rs.getDate("bildirimtarihivesaati"), proje, gondericiOgrenci));

            }

        } catch (SQLException ex) {
            Logger.getLogger(BildirimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }


   
    public void delete(int id) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("DELETE from bildirimler where bildirimid=" + id);
        } catch (SQLException ex) {
            Logger.getLogger(BildirimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  

    public int getBildirimCount(int id) {
        int veriSayisi = 0;
        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select count(bildirimid) as bildirimSayisi from bildirimler where aliciogrenciid= "+id);

            rs.next();
            veriSayisi = rs.getInt("bildirimSayisi");

        } catch (SQLException ex) {
            Logger.getLogger(BildirimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return veriSayisi;
    }

    public List<Bildirim> allList() {
        List<Bildirim> list = new ArrayList<>();

        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM bildirimler");

                while (rs.next()) {
                    Ogrenci aliciOgrenci = this.getOdao().getFromOgrenci(rs.getInt("aliciogrenciid"));
                    Proje proje = this.getPdao().getTitle(rs.getInt("proje_id"));
                    Ogrenci gondericiOgrenci = this.getOdao().getFromOgrenci(rs.getInt("gonderenogrenciid"));

                    list.add(new Bildirim(rs.getLong("bildirimid"), aliciOgrenci, rs.getString("bildirimicerigi"), rs.getDate("bildirimtarihivesaati"), proje, gondericiOgrenci));

                    
                }


        } catch (SQLException ex) {
            Logger.getLogger(BildirimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public OgrenciDAO getOdao() {
        if (this.odao == null) {
            this.odao = new OgrenciDAO();
        }
        return odao;
    }

    public void setOdao(OgrenciDAO odao) {
        this.odao = odao;
    }

    public ProjeDAO getPdao() {
        if (this.pdao == null) {
            this.pdao = new ProjeDAO();
        }
        return pdao;
    }

    public void setPdao(ProjeDAO pdao) {
        this.pdao = pdao;
    }

}
