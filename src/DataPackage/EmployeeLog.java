package DataPackage;

import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EmployeeLog extends javax.swing.JFrame {

    // Database connection establishment
    private static final String username = "root";
    private static final String password = "admin";
    private static final String conn_string = "jdbc:mysql://localhost/eat_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";    
    
    public EmployeeLog() {
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

        jPanelBody = new javax.swing.JPanel();
        jPanelTopBar = new javax.swing.JPanel();
        jLabelLogin = new javax.swing.JLabel();
        jLabelMinimize = new javax.swing.JLabel();
        jLabelClose = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jTextFieldID = new javax.swing.JTextField();
        jLabelID4 = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jLabelPass3 = new javax.swing.JLabel();
        jButtonTimeOut = new javax.swing.JButton();
        jButtonTimeIn = new javax.swing.JButton();
        jLabelManageData = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(320, 320));

        jPanelBody.setBackground(new java.awt.Color(53, 19, 39));
        jPanelBody.setMinimumSize(new java.awt.Dimension(310, 320));
        jPanelBody.setPreferredSize(new java.awt.Dimension(390, 320));

        jPanelTopBar.setBackground(new java.awt.Color(246, 138, 13));

        jLabelLogin.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabelLogin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLogin.setText("Employee Log");

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

        javax.swing.GroupLayout jPanelTopBarLayout = new javax.swing.GroupLayout(jPanelTopBar);
        jPanelTopBar.setLayout(jPanelTopBarLayout);
        jPanelTopBarLayout.setHorizontalGroup(
            jPanelTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTopBarLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabelLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelMinimize)
                .addGap(18, 18, 18)
                .addComponent(jLabelClose)
                .addGap(32, 32, 32))
        );
        jPanelTopBarLayout.setVerticalGroup(
            jPanelTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTopBarLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanelTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLogin)
                    .addComponent(jLabelMinimize)
                    .addComponent(jLabelClose))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(53, 19, 39));

        jTextFieldID.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jTextFieldID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldIDKeyTyped(evt);
            }
        });

        jLabelID4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelID4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelID4.setText("Employee ID:");

        jPasswordField.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordFieldKeyTyped(evt);
            }
        });

        jLabelPass3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelPass3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPass3.setText("Password:");

        jButtonTimeOut.setBackground(new java.awt.Color(177, 57, 16));
        jButtonTimeOut.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jButtonTimeOut.setText("Time Out");
        jButtonTimeOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonTimeOutMouseClicked(evt);
            }
        });

        jButtonTimeIn.setBackground(new java.awt.Color(238, 169, 13));
        jButtonTimeIn.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jButtonTimeIn.setText("Time In");
        jButtonTimeIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonTimeInMouseClicked(evt);
            }
        });

        jLabelManageData.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelManageData.setForeground(new java.awt.Color(255, 255, 255));
        jLabelManageData.setText("Click here to manage data");
        jLabelManageData.setAlignmentX(0.5F);
        jLabelManageData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelManageDataMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelID4)
                            .addComponent(jLabelPass3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jPasswordField))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 36, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabelManageData)
                                .addGap(73, 73, 73))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jButtonTimeIn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButtonTimeOut, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelID4)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPass3))
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTimeOut, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTimeIn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jLabelManageData))
        );

        javax.swing.GroupLayout jPanelBodyLayout = new javax.swing.GroupLayout(jPanelBody);
        jPanelBody.setLayout(jPanelBodyLayout);
        jPanelBodyLayout.setHorizontalGroup(
            jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTopBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelBodyLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanelBodyLayout.setVerticalGroup(
            jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBodyLayout.createSequentialGroup()
                .addComponent(jPanelTopBar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelManageDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelManageDataMouseClicked
        
        // Exits the current window then will go to Admin Log Form
        AdminLog dmfl = new AdminLog();
        dmfl.setVisible(true);
        dmfl.pack();
        dmfl.setLocationRelativeTo(null);
        dmfl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabelManageDataMouseClicked

    private void jButtonTimeInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonTimeInMouseClicked

        // Set system time retrieval 
        String printDate = new String("");
        SimpleDateFormat sqlDate = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        printDate = (sqlDate.format(date));

        String printTime = new String("");
        SimpleDateFormat sqlTime = new SimpleDateFormat("HH:mm:ss");
        Date time = new Date();
        printTime = (sqlTime.format(time));

        try{
            // Input fields checker
            if (jTextFieldID.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Input ID", "Warning!", 2);
            }
            else if (jPasswordField.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Input Password", "Warning!", 2);
            }
            else 
            {
                // After verification, do the following:
                Connection connect = DriverManager.getConnection(conn_string, username, password);
                PreparedStatement ps;
                ps = connect.prepareStatement("SELECT * FROM employee_tbl WHERE EmpID = ? AND Password = ?");
                ps.setString(1, jTextFieldID.getText());
                ps.setString(2, jPasswordField.getText());
                
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    
                    // Record a TimeIn to attendance (database) IF validated
                    Statement stmt = (Statement) connect.createStatement();
                    String insertAttendanceIn = "INSERT INTO attendanceLog_tbl (EmpID, Date, TimeIn) "
                            + "VALUES ('"+jTextFieldID.getText()+"', '"+printDate+"', '"+printTime+"')";
                    stmt.executeUpdate(insertAttendanceIn);
                    stmt.close();
            
                    JOptionPane.showMessageDialog(null,"Time In Successful!");
                }
                else 
                {
                    JOptionPane.showMessageDialog(null, "Please Try Again!", "Warning!", 2);
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Please Try Again!", "Warning!", 2);
        }

    }//GEN-LAST:event_jButtonTimeInMouseClicked

    private void jButtonTimeOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonTimeOutMouseClicked
        
        // Set system time retrieval 
        String printDate = new String("");
        SimpleDateFormat sqlDate = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        printDate = (sqlDate.format(date));

        String printTime = new String("");
        SimpleDateFormat sqlTime = new SimpleDateFormat("HH:mm:ss");
        Date time = new Date();
        printTime = (sqlTime.format(time));

        try{
            // Input fields checker
            if (jTextFieldID.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Input ID", "Warning!", 2);
            }
            else if (jPasswordField.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Input Password", "Warning!", 2);
            } 
            else 
            {
                // After verification, do the following:
                Connection connect = DriverManager.getConnection(conn_string, username, password);
                PreparedStatement ps;
                ps = connect.prepareStatement("SELECT * FROM employee_tbl WHERE EmpID = ? AND Password = ?");
                ps.setString(1, jTextFieldID.getText());
                ps.setString(2, jPasswordField.getText());
                
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    // Record a TimeOut to attendance (database) IF validated
                    Statement stmt = (Statement) connect.createStatement();
                    String updateData = "UPDATE attendanceLog_tbl SET TimeOut = '"+printTime+"' "
                            + "WHERE EmpID = '"+jTextFieldID.getText()+"' AND Date = '"+printDate+"'";
                    stmt.executeUpdate(updateData);
                    stmt.close();
                    
                    JOptionPane.showMessageDialog(null,"Time Out Successful!");
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Please Try Again!", "Warning", 2);
                }
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Please Try Again!", "Warning", 2);
        }
    }//GEN-LAST:event_jButtonTimeOutMouseClicked

    private void jPasswordFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldKeyTyped
        if(jPasswordField.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_jPasswordFieldKeyTyped

    private void jTextFieldIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIDKeyTyped
        if(jTextFieldID.getText().length() >= 6) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldIDKeyTyped

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void jLabelMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMinimizeMouseClicked

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
            java.util.logging.Logger.getLogger(EmployeeLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeLog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonCancel1;
    private javax.swing.JButton jButtonCancel2;
    private javax.swing.JButton jButtonConfirm;
    private javax.swing.JButton jButtonConfirm1;
    private javax.swing.JButton jButtonConfirm2;
    private javax.swing.JButton jButtonTimeIn;
    private javax.swing.JButton jButtonTimeOut;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelID1;
    private javax.swing.JLabel jLabelID2;
    private javax.swing.JLabel jLabelID3;
    private javax.swing.JLabel jLabelID4;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelManageData;
    private javax.swing.JLabel jLabelMinimize;
    private javax.swing.JLabel jLabelPass;
    private javax.swing.JLabel jLabelPass1;
    private javax.swing.JLabel jLabelPass2;
    private javax.swing.JLabel jLabelPass3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelBody;
    private javax.swing.JPanel jPanelTopBar;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldID1;
    private javax.swing.JTextField jTextFieldID2;
    private javax.swing.JTextField jTextFieldID3;
    // End of variables declaration//GEN-END:variables

}
