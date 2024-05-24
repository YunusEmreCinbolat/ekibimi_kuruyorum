/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Basvuru;
import entity.Ogrenci;
import entity.Proje;
import jakarta.inject.Inject;
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
public class BasvuruDAO extends Connector {
    private OgrenciDAO odao;
    private ProjeDAO pdao;
    public List<Basvuru> readList(int hangiSayfa,int gorunenVeri) {
        List<Basvuru> list = new ArrayList<>();

        Statement st;
        try {
            st = this.getConnect().createStatement();
           ResultSet rs = st.executeQuery("SELECT * FROM basvurular LIMIT " + gorunenVeri + " OFFSET " + (hangiSayfa - 1) * gorunenVeri);

           while (rs.next()) {
               Ogrenci o=this.getOdao().getFromOgrenci(rs.getInt("ogrenci_id"));
               Proje p=this.getPdao().getTitle(rs.getInt("proje_id"));
                list.add(new Basvuru(rs.getLong("id"),o,p ,rs.getString("durum")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(BasvuruDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void create(int oid,int pid ) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into basvurular (ogrenci_id,proje_id) values('" + oid+ "' ,'" + pid + "' )");
        } catch (SQLException ex) {
            Logger.getLogger(BasvuruDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete (int  id){
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("DELETE from basvurular where basvuru_id="+ id);
        } catch (SQLException ex) {
            Logger.getLogger(BasvuruDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Basvuru basvuru) {
         try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update basvurular set ogrenci_id='"+basvuru.getOgrenci().getId()+"', proje_id='"+basvuru.getProje().getId()+"' where basvuru_id="+basvuru.getId());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    } 
    
       public int getBasvuruCount() {
              int veriSayisi=0;
        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select count(id) as basvuruSayisi from basvurular");

          rs.next();
          veriSayisi=rs.getInt("basvuruSayisi");

        } catch (SQLException ex) {
            Logger.getLogger(BasvuruDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return veriSayisi;
    }

    public List<Basvuru> allList() {
         List<Basvuru> list = new ArrayList<>();

        Statement st;
        try {
            st = this.getConnect().createStatement();
           ResultSet rs = st.executeQuery("SELECT * FROM basvurular");

           while (rs.next()) {
               Ogrenci o=this.getOdao().getFromOgrenci(rs.getInt("ogrenci_id"));
               Proje p=this.getPdao().getTitle(rs.getInt("proje_id"));
                list.add(new Basvuru(rs.getLong("id"),o,p, rs.getString("durum")));

           }

        } catch (SQLException ex) {
            Logger.getLogger(BasvuruDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public OgrenciDAO getOdao() {
        if(this.odao==null){
            this.odao=new OgrenciDAO();
        }
        return odao;
    }

    public void setOdao(OgrenciDAO odao) {
        this.odao = odao;
    }

    public ProjeDAO getPdao() {
         if(this.pdao==null){
            this.pdao=new ProjeDAO();
        }
        return pdao;
    }

    public void setPdao(ProjeDAO pdao) {
        this.pdao = pdao;
    }
    
}
