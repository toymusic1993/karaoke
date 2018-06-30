/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dark Slayer
 */
public class ClientDAO {

    public static PreparedStatement ps;
    public static ResultSet rs;

    public static void addClient(Client client) {
        String sql = "INSERT INTO Clients (name, email, address, description) VALUES (?, ?, ?, ?);";
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, client.getName());
            ps.setString(2, client.getEmail());
            ps.setString(3, client.getAddress());
            ps.setString(4, client.getDescription());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã Thêm Khách Hàng Thành Công!", "Thông báo", 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Khách Hàng Không Được Thêm", "Thông báo", 1);
        }
    }

    public ArrayList<Client> getlistClient() {
        ArrayList<Client> list_client = new ArrayList<>();
        String sql = "SELECT * FROM Clients;";
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Client client = new Client(rs.getString("name"), rs.getString("email"), rs.getString("description"), rs.getString("address"));
                list_client.add(client);
            }
        } catch (Exception e) {
        }
        return list_client;
    }

    public int get_id_client(String tenkhachhang) {
        String sql1 = "SELECT id FROM Clients WHERE name = ?";
        int i = 0;
        try {
            PreparedStatement ps1 = Connect.getConnect().prepareStatement(sql1);
            ps1.setString(1, tenkhachhang);
            ResultSet rs1 = ps1.executeQuery();
            while (rs1.next()) {
                i = rs1.getInt("id");
            }
        } catch (Exception e) {
            i = 0;
        }

        return i;
    }
    public String get_name_client_by_id(int id) {
        String sql1 = "SELECT name FROM Clients WHERE id = ?";
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
    public static void main(String[] args) {
        ClientDAO clientDAO = new ClientDAO();
        System.out.println(clientDAO.get_name_client_by_id(4));
    }
}
