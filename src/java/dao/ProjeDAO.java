/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kategori;
import entity.Ogrenci;
import entity.Proje;
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

    private OgrenciDAO odao;
    private KategoriDAO kdao;

    public List<Proje> readList(int hangiSayfa, int gorunenVeri) {
        List<Proje> list = new ArrayList<>();

        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from projeler LIMIT " + gorunenVeri + " OFFSET " + (hangiSayfa - 1) * gorunenVeri);

            while (rs.next()) {
                Ogrenci o = this.getOdao().getFromOgrenci(rs.getInt("sahipogrenciid"));
                Kategori k = this.getKdao().getTitle(rs.getInt("kategoriid"));
                list.add(new Proje(rs.getLong("projeid"), rs.getString("projeadi"), rs.getString("projeaciklamasi"), rs.getString("kullanilanteknolojiler"), o, k));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProjeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void create(Proje proje) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into projeler (projeadi,projeaciklamasi,kullanilanteknolojiler,sahipogrenciid,kategoriid) values('" + proje.getProjeAdi() + "' ,'" + proje.getProjeAciklamasi() + "' , '" + proje.getKullanilanTeknolojiler() + "', '" + proje.getSahipOgrenciId().getId() + "','" + proje.getKategori().getId() + "' )");
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
            st.executeUpdate("update projeler set projeadi='" + proje.getProjeAdi() + "', projeaciklamasi='" + proje.getProjeAciklamasi() + "', kullanilanteknolojiler='" + proje.getKullanilanTeknolojiler() + "', sahipogrenciid='" + proje.getSahipOgrenciId().getId() + ", kategoriid='" + proje.getKategori().getId() + "  where projeid=" + proje.getId());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Proje getTitle(int id) {

        Proje entity = null;
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("Select * from projeler where projeid=" + id);

            while (rs.next()) {
                Ogrenci o = this.getOdao().getFromOgrenci(rs.getInt("sahipogrenciid"));
                Kategori k = this.getKdao().getTitle(rs.getInt("kategoriid"));
                entity = new Proje(rs.getLong("projeid"), rs.getString("projeadi"), rs.getString("projeaciklamasi"), rs.getString("kullanilanteknolojiler"), o, k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;

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

    public List<Proje> ogrenciFromProject(int hangiSayfa, int gorunenVeri, int id) {
        List<Proje> list = new ArrayList<>();

        Statement st;
        try {
            st = this.getConnect().createStatement();

            String query = "SELECT * FROM projeler WHERE sahipogrenciid = " + id
                    + " LIMIT " + gorunenVeri
                    + " OFFSET " + ((hangiSayfa - 1) * gorunenVeri);
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Ogrenci o = this.getOdao().getFromOgrenci(rs.getInt("sahipogrenciid"));
                Kategori k = this.getKdao().getTitle(rs.getInt("kategoriid"));
                list.add(new Proje(rs.getLong("projeid"), rs.getString("projeadi"), rs.getString("projeaciklamasi"), rs.getString("kullanilanteknolojiler"), o, k));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProjeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Proje> aliciogrenciFromProject( int id) {
        List<Proje> list = new ArrayList<>();

        Statement st;
        try {
            st = this.getConnect().createStatement();

            String query = "SELECT\n"
                    + "    p.*\n"
                    + "FROM\n"
                    + "    public.projeler p\n"
                    + "    JOIN public.ekipuyeleri eu ON p.projeid = eu.projeid\n"
                    + "WHERE\n"
                    + "    eu.ogrenciid =" + id;
                  
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Ogrenci o = this.getOdao().getFromOgrenci(rs.getInt("sahipogrenciid"));
                Kategori k = this.getKdao().getTitle(rs.getInt("kategoriid"));
                list.add(new Proje(rs.getLong("projeid"), rs.getString("projeadi"), rs.getString("projeaciklamasi"), rs.getString("kullanilanteknolojiler"), o, k));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProjeDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public KategoriDAO getKdao() {
        if (this.kdao == null) {
            this.kdao = new KategoriDAO();
        }
        return kdao;
    }

    public void setKdao(KategoriDAO kdao) {
        this.kdao = kdao;
    }

}
