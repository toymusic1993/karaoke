/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.EmployeeDAO.ps;
import static Controller.EmployeeDAO.rs;
import Model.Booking;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dark Slayer
 */
public class BookingDAO {

    public static PreparedStatement ps;
    public static ResultSet rs;
    public static void addBooking(Booking booking) {
        String sql = "INSERT INTO Booking (idRoom, idClient) VALUES (?, ?);";
        String sql2 = "UPDATE Rooms SET status = 0 WHERE id = ?;";
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setInt(1, booking.getRoomId());
            ps.setInt(2, booking.getClientId());
            ps.execute();
            ps = Connect.getConnect().prepareStatement(sql2);
            ps.setInt(1, booking.getRoomId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã Đặt Phòng Thành Công!", "Thông báo", 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Đặt Phòng Không Thành Công", "Thông báo", 1);
        }
    }
    public static void checkoutRoom(String id_booking, String name_room) {
        String sql1 = "UPDATE Booking SET timeEnd = GETDATE() WHERE id = ?;";
        String sql2 = "UPDATE Rooms SET status = 1 WHERE name = ?;";
        String sql3 = "SELECT DATEDIFF(minute, timeStart, timeEnd) as result FROM Booking WHERE id = ?;";
        String sql4 = "SELECT price FROM Rooms WHERE name = ?;";
        int get_minute = 0;
        int price = 0;
        try {
            ps = Connect.getConnect().prepareStatement(sql1);
            ps.setInt(1, Integer.parseInt(id_booking));
            ps.execute();
            
            ps = Connect.getConnect().prepareStatement(sql2);
            ps.setString(1, name_room);
            ps.execute();
            
            ps = Connect.getConnect().prepareStatement(sql3);
            ps.setInt(1, Integer.parseInt(id_booking));
            rs = ps.executeQuery();
            while (rs.next()) {
                get_minute = rs.getInt("result");
            }
            
            ps = Connect.getConnect().prepareStatement(sql4);
            ps.setString(1, name_room);
            rs = ps.executeQuery();
            while (rs.next()) {
                price = rs.getInt("price");
            }
            float amount = price * (get_minute/60);
            if (amount == 0) {
                amount = price;
            }
            PaymentsDAO.addBill(Integer.parseInt(id_booking), amount);
        } catch (SQLException ex) {
            Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public ArrayList<Booking> get_list_booking() {
        ArrayList<Booking> list_booking = new ArrayList();
        String sql = "SELECT * FROM Booking;";
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Booking booking = new Booking(rs.getInt("id"), rs.getInt("idClient"), rs.getInt("idRoom"), rs.getTimestamp("timeStart"), rs.getTimestamp("timeEnd"), rs.getDate("day"));
                list_booking.add(booking);
            }
        } catch (Exception e) {
        }
        return list_booking;
    }
    public static void deleteBooking(int id) {
        String sql = "SELECT idRoom FROM Booking WHERE id = ?";
        int id_room = 0;
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                id_room = rs.getInt("idRoom");
            }
        } catch (Exception e) {
            
        }
        String sql_update_again_status_room = "UPDATE Rooms SET status = 1 WHERE id = ?;";
        try {
            ps = Connect.getConnect().prepareStatement(sql_update_again_status_room);
            ps.setInt(1, id_room);
            ps.execute();
        } catch (Exception e) {
        }
        String sql1 = "DELETE Booking WHERE id = ?";
        try {
            ps = Connect.getConnect().prepareStatement(sql1);
            ps.setInt(1, id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Xóa Đặt Phòng Thành Công!", "Thông báo", 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Xóa Đặt Phòng Không Thành Công!", "Thông báo", 1);
        }
    }
}
