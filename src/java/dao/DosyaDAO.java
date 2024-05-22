/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Dosya;
import entity.Ogrenci;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Connector;

/**
 *
 * @author Dell
 */
public class DosyaDAO extends Connector {

    private OgrenciDAO dao;

    public void create(Dosya dosya) {

        try {
            String sql = "INSERT INTO dosyalar (fpath, fname, ftype, ogrenci_id) VALUES ('"
                    + dosya.getFpath() + "', '"
                    + dosya.getFname() + "', '"
                    + dosya.getFtype() + "', "
                    + dosya.getOgrenci().getId() + ")";

            Statement stmt = this.getConnect().createStatement();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DosyaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Dosya> readList() {
        List<Dosya> list = new ArrayList();
        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("Select * from dosyalar");

            while (rs.next()) {
                Ogrenci o = this.getDao().getFromOgrenci(rs.getInt("ogrenci_id"));

                list.add(new Dosya(rs.getLong("id"), o, rs.getString("fpath"), rs.getString("fname"), rs.getString("ftype")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DosyaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Dosya readDosya(Long id) {
        Dosya entity = new Dosya();
        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("Select * from files dosalar id=" + id);

            while (rs.next()) {
                Ogrenci o = this.getDao().getFromOgrenci(rs.getInt("ogrenci_id"));

                entity = new Dosya(rs.getLong("id"), o, rs.getString("fname"), rs.getString("fpath"), rs.getString("ftype"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DosyaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }

    public OgrenciDAO getDao() {
        if (this.dao == null) {
            this.dao = new OgrenciDAO();
        }
        return dao;
    }

    public void setDao(OgrenciDAO dao) {
        this.dao = dao;
    }

}
