/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Dark Slayer
 */
public class PaymentsDAO {
    public static PreparedStatement ps;
    public static ResultSet rs;

    public static void addBill(int idBooking, float amount) {
        String sql = "INSERT INTO Payments (idBooking, amount) VALUES (?, ?);";
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setInt(1, idBooking);
            ps.setFloat(2, amount);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cập Nhật Hóa Đơn Thành Công!", "Thông báo", 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hóa Đơn Không Được Thêm", "Thông báo", 1);
        }
    }
}
