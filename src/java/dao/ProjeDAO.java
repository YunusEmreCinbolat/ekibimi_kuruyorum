/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

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
public class ProjeDAO extends Connector {

    public List<Proje> readList(int hangiSayfa, int gorunenVeri) {
        List<Proje> list = new ArrayList<>();

        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from projeler LIMIT " + gorunenVeri + " OFFSET " + (hangiSayfa - 1) * gorunenVeri);

            while (rs.next()) {
                list.add(new Proje(rs.getLong("projeid"), rs.getString("projeadi"), rs.getString("projeaciklamasi"), rs.getString("kullanilanteknolojiler"), rs.getLong("sahipogrenciid"), rs.getLong("kategoriid")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProjeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void create(Proje proje) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into projeler (projeadi,projeaciklamasi,kullanilanteknolojiler,sahipogrenciid,kategoriid) values('" + proje.getProjeAdi() + "' ,'" + proje.getProjeAciklamasi() + "' , '" + proje.getKullanilanTeknolojiler() + "', '" + proje.getSahipOgrenciId() + "','" + proje.getKategoriId() + "' )");
        } catch (SQLException ex) {
            Logger.getLogger(ProjeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int id) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("DELETE from projeler where projeid=" + id);
        } catch (SQLException ex) {
            Logger.getLogger(ProjeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Proje proje) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update projeler set projeadi='" + proje.getProjeAdi() + "', projeaciklamasi='" + proje.getProjeAciklamasi() + "', kullanilanteknolojiler='" + proje.getKullanilanTeknolojiler() + "', sahipogrenciid='" + proje.getSahipOgrenciId() + ", kategoriid='" + proje.getKategoriId() + "  where projeid=" + proje.getId());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Proje getTitle(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getProjeCount() {
        int veriSayisi = 0;
        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select count(projeid) as projeSayisi from projeler");

            rs.next();
            veriSayisi = rs.getInt("projeSayisi");

        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return veriSayisi;
    }
}
