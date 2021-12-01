package custompackage.pk;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PageNo_1_1_AdminHospitalLogin extends javax.swing.JFrame {

    String adminLoginId = "", adminPassword = "";
    static int getidfromdatabase, availableicubed, availablenormalbed, totalICU, totalNormalBed, availableTotalBed, totalBed, status;
    static String hospitalName, hospitalAddress;

    public PageNo_1_1_AdminHospitalLogin() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    void displayUsers(String userName, String uPassword) throws ClassNotFoundException, Exception {
        Statement statement;
        ResultSet results;
        try {
            Connection sqlConn = CodeSQLConnection.getConnection();
            statement = sqlConn.createStatement();
            if (userName.length() > 0 && uPassword.length() > 0) {
                String query = "Select * from hospital_details where hospital_userName='" + userName + "' and hospital_password='" + uPassword + "'";
                results = statement.executeQuery(query);
                if (results.next()) {
                    getidfromdatabase = results.getInt("id");
                    hospitalName = results.getString("hospital_name");
                    hospitalAddress = results.getString("address");

                    availableicubed = results.getInt("available_icu");
                    availablenormalbed = results.getInt("available_seat");
                    availableTotalBed = availableicubed + availablenormalbed;

                    totalICU = results.getInt("total_icu");
                    totalNormalBed = results.getInt("total_normal_seat");
                    totalBed = totalICU + totalNormalBed;

                    status = results.getInt("status");
                    if (status != 1) {
                        JOptionPane.showMessageDialog(null, "<html><b><p style='color:red'>Your Account is pending !<br/>Wait for Admin Approval.</p></b></html>");
                    } else {
                        PageNo_2_2_UpdateHospitalSeat updateHospitalSeat = new PageNo_2_2_UpdateHospitalSeat();
                        dispose();
                        updateHospitalSeat.setVisible(true);

                    }
                    System.out.println("" + getidfromdatabase);
                } else {
                    JOptionPane.showMessageDialog(null, "<html><b><p style='color:red'>Username and password are wrong </p></b></html>");
                }
            } else {
                JOptionPane.showMessageDialog(null, "<html><b><p style='color:red'>Please field username and password.</p></b></html>");
            }
        } catch (SQLException sql) {
            out.println(sql);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        hospitalLoginBtn = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        adminLoginBtn = new javax.swing.JButton();
        adminLoginIdTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        adminPasswordTxt = new javax.swing.JTextField();

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Admin"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 157, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 184, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(481, 369));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setToolTipText("");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login Panel", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N

        jPanel1.setBackground(new java.awt.Color((202, 211, 200)));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hospital", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));

        jLabel3.setText("User Name:");

        jLabel4.setText("Password:");

        hospitalLoginBtn.setText("Login");
        hospitalLoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hospitalLoginBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                        .addGap(90, 90, 90))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(password, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(username, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(hospitalLoginBtn)
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(hospitalLoginBtn)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color((202, 211, 200)));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Admin", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel2.setText("User Name:");

        adminLoginBtn.setText("Login");
        adminLoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminLoginBtnActionPerformed(evt);
            }
        });

        adminLoginIdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminLoginIdTxtActionPerformed(evt);
            }
        });

        jLabel5.setText("Password:");

        adminPasswordTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminPasswordTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminLoginIdTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(adminPasswordTxt))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(adminLoginBtn)
                .addGap(40, 40, 40))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(adminLoginIdTxt)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adminPasswordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(adminLoginBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(41, 41, 41)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(161, 161, 161))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(100, 100, 100))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void adminLoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminLoginBtnActionPerformed

        adminLoginId = adminLoginIdTxt.getText();
        adminPassword = adminPasswordTxt.getText();
        try {
            Connection sqlConn = CodeSQLConnection.getConnection();
            Statement statement = sqlConn.createStatement();
            if (adminLoginId.length() > 0 && adminPassword.length() > 0) {
                String query = "Select * from admin where login_id ='" + adminLoginId + "' and login_password='" + adminPassword + "'";
                ResultSet results = statement.executeQuery(query);
                if (results.next()) {
                    String loginId = results.getString("login_id");
                    String loginPassword = results.getString("login_password");
                    if (adminLoginId.equals(loginId) && adminPassword.equals(loginPassword)) {
                        PageNo_1_2_AdminForm adminForm = new PageNo_1_2_AdminForm();
                        adminForm.setVisible(true);
                        PageNo_1_1_AdminHospitalLogin loginPage = new PageNo_1_1_AdminHospitalLogin();
                        loginPage.setVisible(false);
                        dispose();
                    } else {
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "Wrong Password.", "Login error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "<html><b><p style='color:red'>Username and password are wrong </p></b></html>");
                }
            } else {
                JOptionPane.showMessageDialog(null, "<html><b><p style='color:red'>Please field username and password.</p></b></html>");
            }
        } catch (SQLException sql) {
            out.println(sql);
        } catch (Exception ex) {
            Logger.getLogger(PageNo_1_1_AdminHospitalLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_adminLoginBtnActionPerformed

    private void adminLoginIdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminLoginIdTxtActionPerformed
        // TODO add your handling code here:      
    }//GEN-LAST:event_adminLoginIdTxtActionPerformed

    private void hospitalLoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hospitalLoginBtnActionPerformed

        String userName = username.getText();
        String uPassword = password.getText();

        try {
            displayUsers(userName, uPassword);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PageNo_1_1_AdminHospitalLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PageNo_1_1_AdminHospitalLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_hospitalLoginBtnActionPerformed

    private void adminPasswordTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminPasswordTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminPasswordTxtActionPerformed

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
            java.util.logging.Logger.getLogger(PageNo_1_1_AdminHospitalLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PageNo_1_1_AdminHospitalLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PageNo_1_1_AdminHospitalLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PageNo_1_1_AdminHospitalLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        new PageNo_1_1_AdminHospitalLogin().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminLoginBtn;
    private javax.swing.JTextField adminLoginIdTxt;
    private javax.swing.JTextField adminPasswordTxt;
    private javax.swing.JButton hospitalLoginBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
