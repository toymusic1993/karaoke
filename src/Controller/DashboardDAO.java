/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Dashboard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dark Slayer
 */
public class DashboardDAO {

    public static PreparedStatement ps;
    public static Connection con = Connect.getConnect();
    public static ResultSet rs;

    public static ArrayList<Integer> getListYearInDatabase() {
        String sql1 =  "SELECT DISTINCT YEAR(day) as nam FROM Payments;";
        ArrayList<Integer> list_year = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql1);
            rs = ps.executeQuery();
            while(rs.next()) {
                list_year.add(rs.getInt("nam"));
            }
        } catch (Exception e) {
        }

        return list_year;
    }
    
    public  static ArrayList<Dashboard> getDashboardByMonth() {
        String sql = "SELECT SUM(amount) as tong_doanh_thu FROM Payments WHERE MONTH(day) = ? AND YEAR(day) = ?;";
        ArrayList<Integer> list_year = getListYearInDatabase();
        ArrayList<Dashboard> list_sum = new ArrayList<>();
        try {
            for (int i = 0; i < list_year.size(); i++) {
                for (int j = 1; j <= 12; j++) {
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, j);
                    ps.setInt(2, list_year.get(i));
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        Dashboard dashboard = new Dashboard(rs.getInt("tong_doanh_thu"), j, 0, list_year.get(i));
                        list_sum.add(dashboard);
                        
                    }
                }
            }

        } catch (Exception ex) {
            return null;
        }
        return list_sum;
    }
    public static ArrayList<Dashboard> getDashboardBy3Month() {
        String sql = "SELECT SUM(amount) as tong_doanh_thu FROM Payments WHERE MONTH(day) IN (?, ?, ?) AND YEAR(day) = ?;";
        ArrayList<Integer> list_year = getListYearInDatabase();
        ArrayList<Dashboard> list_payment_theo_quy = new ArrayList<>();
        try {
            for (int i = 0; i < list_year.size(); i++) {
                for (int j = 1; j <= 12; j+= 3) {
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, j);
                    ps.setInt(2, j + 1);
                    ps.setInt(3, j + 2);
                    ps.setInt(4, list_year.get(i));
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        Dashboard dashboard = null;
                        if (j <=3) {
                            dashboard = new Dashboard(rs.getInt("tong_doanh_thu"), 0, 1,  list_year.get(i));
                        } else if (4 <= j && j <= 6) {
                            dashboard = new Dashboard(rs.getInt("tong_doanh_thu"), 0, 2,  list_year.get(i));
                        } else if (7 <= j && j <= 9) {
                            dashboard = new Dashboard(rs.getInt("tong_doanh_thu"), 0, 3,  list_year.get(i));
                        } else {
                            dashboard = new Dashboard(rs.getInt("tong_doanh_thu"), 0, 4,  list_year.get(i));
                        }
                        list_payment_theo_quy.add(dashboard);
                    }
                }
            }

        } catch (Exception ex) {
            return null;
        }
        return list_payment_theo_quy;
    }
    public static ArrayList<Dashboard> getDashboardByYear() {
        ArrayList<Integer> list_year = getListYearInDatabase();
        String sql = "SELECT SUM(amount) as tong_doanh_thu FROM Payments WHERE YEAR(day) = ?;";
        ArrayList<Dashboard> list_sum = new ArrayList<>();
        try {
            for (int i = 0; i < list_year.size(); i++) {
                ps = con.prepareStatement(sql);
                ps.setInt(1, list_year.get(i));
                rs = ps.executeQuery();
                while (rs.next()) {
                    Dashboard dashboard = new Dashboard(rs.getInt("tong_doanh_thu"), 0, 0, list_year.get(i));
                    list_sum.add(dashboard);
                }
            }

        } catch (Exception ex) {
            return null;
        }
        return list_sum;
    }
}
