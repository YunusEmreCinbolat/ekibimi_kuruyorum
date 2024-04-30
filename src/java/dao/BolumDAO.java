/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Admin;
import entity.Bolum;
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
public class BolumDAO extends Connector {

    public void create(Bolum bolum) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into bolumler (bolumadi,fakulteid) values('" + bolum.getBolumadi() + "', '" + bolum.getFakulteid() + "' )");
        } catch (SQLException ex) {
            Logger.getLogger(BolumDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int id) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("DELETE from bolumler where bolumid=" + id);
        } catch (SQLException ex) {
            Logger.getLogger(BolumDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Bolum> readList(int hangiSayfa,int gorunenVeri) {
        List<Bolum> list = new ArrayList<>();

        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from bolumler LIMIT " + gorunenVeri + " OFFSET " + (hangiSayfa - 1) * gorunenVeri);

            while (rs.next()) {
                list.add(new Bolum(rs.getLong("bolumid"), rs.getLong("fakulteid"), rs.getString("bolumadi")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(BolumDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void update(Bolum bolum) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update bolumler set bolumadi='" + bolum.getBolumadi() + "',  fakulteid='" + bolum.getFakulteid() + "' where bolumid=" + bolum.getId());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Bolum getTitle(int id) {
        Bolum entity =  null;

        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from bolumler where bolumid="+id);

            while (rs.next()) {
               entity = new Bolum(rs.getLong("bolumid"), rs.getLong("fakulteid"), rs.getString("bolumadi"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(BolumDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }
    
      public int getBolumCount() {
              int veriSayisi=0;
        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select count(bolumid) as bolumSayisi from bolumler");

          rs.next();
          veriSayisi=rs.getInt("bolumSayisi");

        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return veriSayisi;
    }

}
