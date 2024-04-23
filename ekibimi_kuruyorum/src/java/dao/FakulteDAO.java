/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Admin;
import entity.Fakulte;
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
public class FakulteDAO extends Connector {
    
       public void create(Fakulte fakulte) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into fakulteler (fakulteadi) values('" + fakulte.getFakulteadi()+ "' )");
        } catch (SQLException ex) {
            Logger.getLogger(FakulteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
        public void delete (int  id){
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("DELETE from fakulteler where fakulteid="+ id);
        } catch (SQLException ex) {
            Logger.getLogger(FakulteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
         public List<Fakulte> readList() {
        List<Fakulte> entity = new ArrayList<>();

        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from fakulteler");

            while (rs.next()) {
                entity.add(new Fakulte(rs.getLong("fakulteid"),rs.getString("fakulteadi")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(FakulteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }
           public void update(Fakulte fakulte) {
         try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update fakulteler set fakulteadi='"+fakulte.getFakulteadi()+"' where fakulteid="+fakulte.getId());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Fakulte getFakulteAdi(int fakulteid) {
        Fakulte entity = null;

        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from fakulteler where fakulteid="+fakulteid);

            while (rs.next()) {
                entity =new Fakulte(rs.getLong("fakulteid"),rs.getString("fakulteadi"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(FakulteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }
    
    
}
