/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Admin;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Connector;

/**
 *
 * @author admın
 */
public class AdminDAO extends Connector {
     
    public void create(Admin admin){
        try {
            Statement st =this.getConnect().createStatement();
            st.executeUpdate("insert into admins(name,surname,username,email,password) values('"+ admin.getAd()+"' ,'"+admin.getSoyad()+"' , '"+admin.getEmail()+"', '"+ admin.getSifre()+"' )");
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
