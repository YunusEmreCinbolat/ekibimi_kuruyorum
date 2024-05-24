/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Admin;
import entity.EkipUye;
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
 * @author Dell
 */
public class EkipUyeDAO extends Connector {

    private OgrenciDAO odao;
    private ProjeDAO pdao;

    public List<EkipUye> readList(int hangiSayfa, int gorunenVeri) {
        List<EkipUye> list = new ArrayList<>();

        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ekipuyeleri LIMIT " + gorunenVeri + " OFFSET " + (hangiSayfa - 1) * gorunenVeri);

            while (rs.next()) {
                Ogrenci o = this.getOdao().getFromOgrenci(rs.getInt("ogrenciid"));
                Proje p = this.getPdao().getTitle(rs.getInt("projeid"));
                list.add(new EkipUye(rs.getLong("ekipuyeid"), o, p, rs.getString("ekiprolu")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EkipUyeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void create(EkipUye ekipuye) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into ekipuyeleri (ogrenciid,projeid,ekiprolu) values('" + ekipuye.getOgrenci().getId() + "' ,'" + ekipuye.getProje().getId() + "' , '" + ekipuye.getEkiprolu() + "' )");
        } catch (SQLException ex) {
            Logger.getLogger(EkipUyeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int id) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("DELETE from ekipuyeleri where ekipuyeid=" + id);
        } catch (SQLException ex) {
            Logger.getLogger(EkipUyeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(EkipUye ekipuye) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update ekipuyeleri set ogrenciid='" + ekipuye.getOgrenci().getId() + "', projeid='" + ekipuye.getProje().getId() + "', ekiprolu='" + ekipuye.getEkiprolu() + "' ,   where ekipuyeid=" + ekipuye.getId());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int getEkipUyeCount() {
        int veriSayisi = 0;
        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select count(ekipuyeid) as ekipsayisi from ekipuyeleri");

            rs.next();
            veriSayisi = rs.getInt("ekipsayisi");

        } catch (SQLException ex) {
            Logger.getLogger(EkipUyeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return veriSayisi;
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

    public List<EkipUye> getFromAOgrenci(int id) {
        List<EkipUye> list = new ArrayList<>();

        Statement st;
        try {
            st = this.getConnect().createStatement();
            String sql = "SELECT \n"
                    + "    eu.ekipuyeid,\n"
                    + "    eu.ogrenciid,\n"
                    + "    eu.projeid,\n"
                    + "    eu.ekiprolu\n"
                    + "FROM \n"
                    + "    ekipuyeleri eu\n"
                    + "INNER JOIN \n"
                    + "    projeler p ON eu.projeid = p.projeid\n"
                    + "WHERE \n"
                    + "    p.sahipogrenciid ="+id;

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Ogrenci o = this.getOdao().getFromOgrenci(rs.getInt("ogrenciid"));
                Proje p = this.getPdao().getTitle(rs.getInt("projeid"));
                list.add(new EkipUye(rs.getLong("ekipuyeid"), o, p, rs.getString("ekiprolu")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EkipUyeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  list;
    }

}
