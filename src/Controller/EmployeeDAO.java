/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dark Slayer
 */
public class EmployeeDAO {
    public static PreparedStatement ps;
    public static ResultSet rs;
    public static void addEmployee(Employee employee) {
        String sql = "INSERT INTO Employees (name, email, address, description) VALUES (?, ?, ?, ?);";
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getAddress());
            ps.setString(4, employee.getDescription());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã Thêm Nhân Viên Thành Công!" , "Thông báo", 1);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Nhân Viên Không Được Thêm" , "Thông báo", 1);
        }
    }
    public ArrayList<Employee>  getlistEmployee() {
        ArrayList<Employee> list_employees = new ArrayList<>();
        String sql = "SELECT * FROM Employees;";
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                Employee employee = new Employee(rs.getString("name"), rs.getString("address"), rs.getString("email"), rs.getString("description"));
                list_employees.add(employee);
            }
        } catch(Exception e) {
        }
        return list_employees;
    }
}
