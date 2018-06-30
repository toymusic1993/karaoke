/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Dark Slayer
 */
public class AdminDAO {

    public static PreparedStatement ps;
    public static ResultSet rs;

    public Admin dangNhap(String username, String password) {
        Admin admin = null;
        try {
            ps = Connect.getConnect().prepareStatement("SELECT * FROM Admin where username = ? and password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                admin = new Admin();
            }
        } catch (Exception e) {
            admin = null;
        }
        return admin;
    }
}
