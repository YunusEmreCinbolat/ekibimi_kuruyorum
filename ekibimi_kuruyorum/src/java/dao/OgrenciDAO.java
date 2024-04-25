/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Ogrenci;
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
public class OgrenciDAO extends Connector {
    
    public  List<Ogrenci> readList(){
        List<Ogrenci> list= new ArrayList<>();
        try {
            Statement st=this.getConnect().createStatement();
            ResultSet rs=st.executeQuery("Select * from ogrenciler");
            
            while(rs.next()){
            list.add(new Ogrenci(rs.getLong("ogrenciid"),rs.getString("kullaniciadi"),rs.getString("eposta"), rs.getString("sifre"), rs.getString("ad"), rs.getString("soyad"), rs.getString("universite"),rs.getLong("sinifid"),rs.getLong("bolumid")));
        }
        } catch (SQLException ex) {
            Logger.getLogger(OgrenciDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public void create(Ogrenci ogrenci){
        try {
            Statement st=this.getConnect().createStatement();
            
            st.executeUpdate("insert into ogrenciler (kullaniciadi,eposta,sifre,ad,soyad,universite,sinifid,bolumid) values ('" + ogrenci.getKullaniciadi() +"' , '" + ogrenci.getEmail() +"' , '" + ogrenci.getSifre() +"', '" + ogrenci.getAd() +"' , '" + ogrenci.getSoyad()+"' , '" + ogrenci.getUniversite() +"' ,'" + ogrenci.getSinifid() +"' , '" + ogrenci.getBolumid() +"')");
        } catch (SQLException ex) {
            Logger.getLogger(OgrenciDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     public void update(Ogrenci ogrenci){
        try {
            Statement st=this.getConnect().createStatement();
            st.executeUpdate("update ogrenciler set kullaniciadi='" +ogrenci.getKullaniciadi() +"' , eposta='" +ogrenci.getEmail() +"' , sifre='" +ogrenci.getSifre()+"' , ad= '" +ogrenci.getAd() +"' , soyad= '" +ogrenci.getSoyad() +"' , universite= '" +ogrenci.getUniversite() +"' , sinifid='" +ogrenci.getSinifid() +"' , bolumid='" +ogrenci.getBolumid() +"' where ogrenciid="+ogrenci.getId());
        } catch (SQLException ex) {
            Logger.getLogger(OgrenciDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     public void delete (int id){
         Statement st;
        try {
            st = this.getConnect().createStatement();
            st.executeUpdate("delete from ogrenciler where ogrenciid="+id);
        } catch (SQLException ex) {
            Logger.getLogger(OgrenciDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
     }
}
