/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Dark Slayer
 */
public class Connect {

    private static Connection conn;

    public static Connection getConnect() {
        try {
            String link_jdbc = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String link_to_database = "jdbc:sqlserver://localhost:1433;databaseName=Karaoke;Username=sa;Password = 123456";
            Class.forName(link_jdbc);
            conn = DriverManager.getConnection(link_to_database);
        } catch (Exception e) {
            System.out.println("Kết Nối Không Thành Công");
        }
        return conn;
    }

    public static String testConnect() {
        try {
            conn = Connect.getConnect();
            return "Kết nối thành công";
        } catch (Exception e) {
            return "Kết nối thất bại";
        }
    }
}
