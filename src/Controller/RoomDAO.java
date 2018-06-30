/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Room;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dark Slayer
 */
public class RoomDAO {

    public static PreparedStatement ps;
    public static ResultSet rs;

    public static void addRoom(Room room) {
        String sql = "INSERT INTO Rooms (name, price, type) VALUES (?, ?, ?);";
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, room.getName());
            ps.setInt(2, room.getPrice());
            ps.setInt(3, room.getType());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã Thêm Phòng Thành Công!", "Thông báo", 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Phòng Không Được Thêm", "Thông báo", 1);
        }
    }

    public ArrayList<Room> getlistRooms() {
        ArrayList<Room> list_rooms = new ArrayList<>();
        String sql = "SELECT * FROM Rooms;";
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Room room = new Room(rs.getString("name"), rs.getInt("type"), rs.getInt("price"), rs.getInt("status"));
                list_rooms.add(room);
            }
        } catch (Exception e) {
        }
        return list_rooms;
    }

    public int get_id_room(String tenphong) {
        String sql1 = "SELECT id FROM Rooms WHERE name = ?";
        int i = 0;
        try {
            PreparedStatement ps1 = Connect.getConnect().prepareStatement(sql1);
            ps1.setString(1, tenphong);
            ResultSet rs1 = ps1.executeQuery();
            while (rs1.next()) {
                i = rs1.getInt("id");
            }
        } catch (Exception e) {
            i = 0;
        }

        return i;
    }
    public String get_name_room_by_id(int id) {
        String sql1 = "SELECT name FROM Rooms WHERE id = ?";
        String name = null;
        try {
            PreparedStatement ps1 = Connect.getConnect().prepareStatement(sql1);
            ps1.setInt(1, id);
            ResultSet rs1 = ps1.executeQuery();
            while (rs1.next()) {
                name = rs1.getString("name");
            }
        } catch (Exception e) {
            name = null;
        }

        return name;
    }
    public Room get_information_room_by_id(int id) {
        String sql = "SELECT * FROM Rooms WHERE id = ?";
        Room room = null;
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()) {
                room = new Room(rs.getString("name"),rs.getInt("type") , rs.getInt("price"), rs.getInt("status"));
            }
        } catch (Exception e) {
        }
        return room;
    }
}
