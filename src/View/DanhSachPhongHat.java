/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.RoomDAO;
import Model.Room;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dark Slayer
 */
public class DanhSachPhongHat extends javax.swing.JFrame {
    RoomDAO roomDAO = new RoomDAO();
    /**
     * Creates new form DanhSachPhongHat
     */
    public DanhSachPhongHat() {
        initComponents();
        ArrayList<Room> list_rooms = roomDAO.getlistRooms();
        DefaultTableModel model = (DefaultTableModel) jRoomsTable.getModel();
        Object[] row = new Object[4];
        for (int i = 0; i < list_rooms.size(); i++) {
            row[0] = list_rooms.get(i).getName();
            row[1] = list_rooms.get(i).getPrice();
            if (list_rooms.get(i).getType() == 2) {
                row[2] = "VIP";
            } else {
                row[2] = "Thường";
            }
            if (list_rooms.get(i).getStatus() == 1) {
                row[3] = "Còn Trống";
            } else {
                row[3] = "Đã Đặt";
            }
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jAddRoom = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jRoomsTable = new javax.swing.JTable();
        jQuayLaiMenuCapNhat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Danh Sách Phòng Hát");

        jAddRoom.setText("Thêm Phòng Hát");
        jAddRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddRoomActionPerformed(evt);
            }
        });

        jRoomsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Phòng", "Giá Phòng", "Loại Phòng", "Trạng Thái"
            }
        ));
        jScrollPane1.setViewportView(jRoomsTable);

        jQuayLaiMenuCapNhat.setText("Hủy");
        jQuayLaiMenuCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jQuayLaiMenuCapNhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jAddRoom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jQuayLaiMenuCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
            .addGroup(layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAddRoom)
                    .addComponent(jQuayLaiMenuCapNhat))
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAddRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddRoomActionPerformed
        // TODO add your handling code here:
        ThemPhong themPhong = new ThemPhong();
        themPhong.setVisible(true);
        dispose();
    }//GEN-LAST:event_jAddRoomActionPerformed

    private void jQuayLaiMenuCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jQuayLaiMenuCapNhatActionPerformed
        // TODO add your handling code here:
        MenuCapNhat menuCapNhat = new MenuCapNhat();
        menuCapNhat.setVisible(true);
        dispose();
    }//GEN-LAST:event_jQuayLaiMenuCapNhatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DanhSachPhongHat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhSachPhongHat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhSachPhongHat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhSachPhongHat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DanhSachPhongHat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAddRoom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jQuayLaiMenuCapNhat;
    private javax.swing.JTable jRoomsTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
