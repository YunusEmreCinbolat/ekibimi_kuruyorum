/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Admin;
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
 * @author Dell
 */
public class SinifDAO extends Connector {
    
       public void create(Sinif sinif) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into siniflar (bolumid,sinifadi) values('" +sinif.getBolumid()+ "', '" +sinif.getSinifadi()+ "' )");
        } catch (SQLException ex) {
            Logger.getLogger(SinifDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
        public void delete (int  id){
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("DELETE from siniflar where sinifid="+ id);
        } catch (SQLException ex) {
            Logger.getLogger(SinifDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
         public List<Sinif> readList() {
        List<Sinif> list = new ArrayList<>();

        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from siniflar");

            while (rs.next()) {
                list.add(new Sinif(rs.getLong("sinifid"),rs.getLong("bolumid"),rs.getInt("sinifadi")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SinifDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
           public void update(Sinif sinif) {
         try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update siniflar set sinifadi='"+sinif.getSinifadi()+"',  bolumid='"+sinif.getBolumid()+"' where sinifid="+sinif.getId());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Sinif getSinifAdi(int sinifid) {
          
        Sinif entity = null;

        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from siniflar where sinifid = "+sinifid);

            while (rs.next()) {
                entity=new Sinif(rs.getLong("sinifid"),rs.getLong("bolumid"),rs.getInt("sinifadi"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SinifDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    
    }
    
    
}
