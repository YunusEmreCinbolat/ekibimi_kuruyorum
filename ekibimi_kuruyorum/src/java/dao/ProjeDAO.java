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

    public List<Proje> readList() {
        List<Proje> list = new ArrayList<>();

        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from projeler");

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
    
    public void delete (int  id){
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("DELETE from projes where id="+ id);
        } catch (SQLException ex) {
            Logger.getLogger(ProjeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Proje proje) {
         try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update projeler set projeadi='"+proje.getProjeAdi()+"', projeaciklamasi='"+proje.getProjeAciklamasi()+"', kullanilanteknolojiler='"+proje.getKullanilanTeknolojiler()+"', sahipogrenciid='"+proje.getSahipOgrenciId()+", kategoriid='"+proje.getKategoriId()+"  where id="+proje.getId());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    } 
}
