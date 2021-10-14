package DataPackage;

import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AdminLog extends javax.swing.JFrame {
    
    // Database connection establishment
    private static final String username = "root";
    private static final String password = "admin";
    private static final String conn_string = "jdbc:mysql://localhost/eat_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";    
   
    public AdminLog() {
        initComponents();
        
        // Center the form once opened
        // Note: Set the property first from "undecorated" to TRUE para mawala yung nasa taas na bar and mag-apply ang rounded corner        
        this.setLocationRelativeTo(null);     
        
        // Transparency range: 0.0 - 1.0 float value
        // SetOpacity(0.7f); //30% transparent
        // For rounded corner
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 60, 50));
        setFocusable(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldID = new javax.swing.JTextField();
        jButtonCancel = new javax.swing.JButton();
        jLabelID = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabelPass = new javax.swing.JLabel();
        jButtonConfirm = new javax.swing.JButton();
        jPanelMinimize = new javax.swing.JPanel();
        jLabelMinimize = new javax.swing.JLabel();
        jLabelClose = new javax.swing.JLabel();
        jLabelLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(53, 19, 39));

        jPanel1.setBackground(new java.awt.Color(53, 19, 39));

        jTextFieldID.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jTextFieldID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldIDKeyTyped(evt);
            }
        });

        jButtonCancel.setBackground(new java.awt.Color(177, 57, 16));
        jButtonCancel.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jButtonCancel.setText("Cancel");
        jButtonCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCancelMouseClicked(evt);
            }
        });

        jLabelID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelID.setForeground(new java.awt.Color(255, 255, 255));
        jLabelID.setText("Employee ID:");

        jPasswordField1.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyTyped(evt);
            }
        });

        jLabelPass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelPass.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPass.setText("Password:");

        jButtonConfirm.setBackground(new java.awt.Color(238, 169, 13));
        jButtonConfirm.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jButtonConfirm.setText("Confirm");
        jButtonConfirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonConfirmMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelID)
                            .addComponent(jLabelPass))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldID)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelID)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPass))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanelMinimize.setBackground(new java.awt.Color(246, 138, 13));

        jLabelMinimize.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelMinimize.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMinimize.setText("-");
        jLabelMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinimizeMouseClicked(evt);
            }
        });

        jLabelClose.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(53, 19, 39));
        jLabelClose.setText("x");
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
        });

        jLabelLogin.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabelLogin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLogin.setText("Admin Log");

        javax.swing.GroupLayout jPanelMinimizeLayout = new javax.swing.GroupLayout(jPanelMinimize);
        jPanelMinimize.setLayout(jPanelMinimizeLayout);
        jPanelMinimizeLayout.setHorizontalGroup(
            jPanelMinimizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMinimizeLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabelLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelMinimize)
                .addGap(26, 26, 26)
                .addComponent(jLabelClose)
                .addGap(24, 24, 24))
        );
        jPanelMinimizeLayout.setVerticalGroup(
            jPanelMinimizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMinimizeLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanelMinimizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMinimize)
                    .addComponent(jLabelClose)
                    .addComponent(jLabelLogin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 390, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMinimizeMouseClicked

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void jButtonCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCancelMouseClicked
        
        this.dispose();
        EmployeeLog lg = new EmployeeLog();
        lg.setVisible(true);
        
    }//GEN-LAST:event_jButtonCancelMouseClicked

    private void jButtonConfirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonConfirmMouseClicked
            
        try {
            // Input fields checker
            if (jTextFieldID.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Input ID", "Warning!", 2);
            }
            else if (jPasswordField1.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Input Password", "Warning!", 2);
            }
            else 
            {
                // ID and password validation
                Connection connect = DriverManager.getConnection(conn_string, username, password);
                PreparedStatement ps;
                String EmpType = "Staff"; // Only staff can access the admin log
                ps = connect.prepareStatement("SELECT * FROM employee_tbl WHERE EmpID = ? AND Password = ? AND EmpType = '"+EmpType+"'");
                ps.setString(1, jTextFieldID.getText());
                ps.setString(2, jPasswordField1.getText());
                ResultSet rs = ps.executeQuery();
                
            if(rs.next()) // Scans the database
            {
                // Exits the current window then will go to Data Management Form
                DataManagement dm = new DataManagement();
                dm.setVisible(true);
                dm.pack();
                dm.setLocationRelativeTo(null);
                dm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please Try Again", "Warning!", 2);
            }
        }
            
        } catch (SQLException ex) {
            System.out.println(ex);   
        }

    }//GEN-LAST:event_jButtonConfirmMouseClicked

    private void jTextFieldIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIDKeyTyped
        
        // Limit input fields
        if(jTextFieldID.getText().length() >= 6) {  
        evt.consume();
        }
    }//GEN-LAST:event_jTextFieldIDKeyTyped

    private void jPasswordField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyTyped
        if(jPasswordField1.getText().length() >= 30) {  
        evt.consume();
        }
    }//GEN-LAST:event_jPasswordField1KeyTyped

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
            java.util.logging.Logger.getLogger(AdminLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonConfirm;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelMinimize;
    private javax.swing.JLabel jLabelPass;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelMinimize;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextFieldID;
    // End of variables declaration//GEN-END:variables
}
