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

    public void update(Dosya dosya) {
        try {
            String sql = "UPDATE dosyalar SET fpath = ?, fname = ?, ftype = ?, ogrenci_id = ? WHERE id = ?";

            PreparedStatement pstmt = this.getConnect().prepareStatement(sql);
            pstmt.setString(1, dosya.getFpath());
            pstmt.setString(2, dosya.getFname());
            pstmt.setString(3, dosya.getFtype());
            pstmt.setLong(4, dosya.getOgrenci().getId());
            pstmt.setLong(5, dosya.getId());

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DosyaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int dosyaId) {
        try {
            String sql = "DELETE FROM dosyalar WHERE id = ?";

            PreparedStatement pstmt = this.getConnect().prepareStatement(sql);
            pstmt.setInt(1, dosyaId);

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DosyaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Dosya> readList(Long id) {
        List<Dosya> list = new ArrayList();
        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("SELECT d.*\n"
                    + "FROM public.dosyalar d \n"
                    + "JOIN public.ogrenciler o ON d.ogrenci_id = " + id);

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

            ResultSet rs = st.executeQuery("SELECT d.*\n"
                    + "FROM public.dosyalar d \n"
                    + "JOIN public.ogrenciler o ON d.ogrenci_id = " + id);

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
