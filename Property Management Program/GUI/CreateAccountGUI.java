package GUI;

import DatabaseControllers.DataBaseManager;
import Entities.Landlord;
import Entities.Manager;
import Entities.RegisteredRenter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author henriqueandras
 */
public class CreateAccountGUI extends javax.swing.JFrame {

    /**
     * Creates new form CreateAccountGUI
     */
    public CreateAccountGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LCreateAccount = new javax.swing.JLabel();
        LUsername = new javax.swing.JLabel();
        LPassword = new javax.swing.JLabel();
        BCreateAccount = new javax.swing.JButton();
        LFailed = new javax.swing.JLabel();
        TPassword = new javax.swing.JPasswordField();
        TUsername = new javax.swing.JTextField();
        LAlreadyHave = new javax.swing.JLabel();
        BLogin = new javax.swing.JButton();
        CManager = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        LEmail = new javax.swing.JLabel();
        TEmail = new javax.swing.JTextField();
        LName = new javax.swing.JLabel();
        TName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        LCreateAccount.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 24)); // NOI18N
        LCreateAccount.setForeground(new java.awt.Color(255, 255, 255));
        LCreateAccount.setText("Create Account");

        LUsername.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 18)); // NOI18N
        LUsername.setForeground(new java.awt.Color(14, 73, 131));
        LUsername.setText("username");

        LPassword.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 18)); // NOI18N
        LPassword.setForeground(new java.awt.Color(14, 73, 131));
        LPassword.setText("password");

        BCreateAccount.setBackground(new java.awt.Color(255, 204, 0));
        BCreateAccount.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 13)); // NOI18N
        BCreateAccount.setForeground(new java.awt.Color(255, 255, 255));
        BCreateAccount.setText("Create Account");
        BCreateAccount.setBorderPainted(false);
        BCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCreateAccountActionPerformed(evt);
            }
        });

        LFailed.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        LFailed.setForeground(new java.awt.Color(255, 51, 51));
        LFailed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        TPassword.setBackground(new java.awt.Color(255, 255, 255));
        TPassword.setForeground(new java.awt.Color(153, 153, 153));
        TPassword.setBorder(null);

        TUsername.setBackground(new java.awt.Color(255, 255, 255));
        TUsername.setForeground(new java.awt.Color(102, 102, 102));
        TUsername.setBorder(null);

        LAlreadyHave.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        LAlreadyHave.setForeground(new java.awt.Color(255, 255, 255));
        LAlreadyHave.setText("Do you already have an account?");

        BLogin.setBackground(new java.awt.Color(255, 204, 0));
        BLogin.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 13)); // NOI18N
        BLogin.setForeground(new java.awt.Color(255, 255, 255));
        BLogin.setText("Login");
        BLogin.setBorderPainted(false);
        BLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLoginActionPerformed(evt);
            }
        });

        CManager.setBackground(new java.awt.Color(255, 255, 255));
        CManager.setForeground(new java.awt.Color(102, 102, 102));
        CManager.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Landlord", "Renter" }));
        CManager.setBorder(null);

        jLabel1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(14, 73, 131));
        jLabel1.setText("account type");

        LEmail.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 18)); // NOI18N
        LEmail.setForeground(new java.awt.Color(14, 73, 131));
        LEmail.setText("email");

        TEmail.setBackground(new java.awt.Color(255, 255, 255));
        TEmail.setBorder(null);

        LName.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 18)); // NOI18N
        LName.setForeground(new java.awt.Color(14, 73, 131));
        LName.setText("name");

        TName.setBackground(new java.awt.Color(255, 255, 255));
        TName.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(377, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(BCreateAccount)
                                .addGap(90, 90, 90))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LPassword)
                                    .addComponent(LUsername)
                                    .addComponent(jLabel1)
                                    .addComponent(LEmail)
                                    .addComponent(LName))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TPassword)
                                    .addComponent(TUsername)
                                    .addComponent(TEmail)
                                    .addComponent(TName, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))))
                        .addGap(342, 342, 342))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LAlreadyHave, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(BLogin)
                                .addGap(71, 71, 71)))
                        .addGap(396, 396, 396))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(LFailed, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(367, 367, 367))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(LCreateAccount)
                        .addGap(401, 401, 401))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(LCreateAccount)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LName)
                    .addComponent(TName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LEmail)
                    .addComponent(TEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LUsername))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LPassword))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(BCreateAccount)
                .addGap(18, 18, 18)
                .addComponent(LFailed, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(LAlreadyHave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BLogin)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLoginActionPerformed
        // TODO add your handling code here:
        LoginPageGUI login = new LoginPageGUI();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_BLoginActionPerformed

    private void BCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCreateAccountActionPerformed
        // TODO add your handling code here:
        String username = TUsername.getText();
        String password = TPassword.getText();
        String name = TName.getText();
        String email = TEmail.getText();
        
        String accountType = CManager.getSelectedItem().toString();
        
        if(username.equals("") || password.equals("") || name.equals("") || email.equals("")) {
            LFailed.setText("Failed: all the fields are required.");
            return;
        }
        
        if(DataBaseManager.getInstance().registerVerify(username, password)) {
            if(accountType.equals("Landlord"))  {
                Landlord newLandlord = new Landlord(name, email, password, username);
                DataBaseManager.getInstance().addLandlord(newLandlord);
                LandlordGUI landlord = new LandlordGUI(newLandlord.getUsername());
                landlord.setVisible(true);
                dispose();
            } else if(accountType.equals("Renter"))  {
                RegisteredRenter newRenter = new RegisteredRenter(name, email, password, username);
                DataBaseManager.getInstance().addRenter(newRenter);
                GeneralUserSearchPageGUI search = new GeneralUserSearchPageGUI();
                search.setVisible(true);
                dispose();
            } else {
                Manager newManager = new Manager(name, email, password, username);
                DataBaseManager.getInstance().addManager(newManager);
                ManagerGUI manager = new ManagerGUI(newManager.getUsername());
                manager.setVisible(true);
                dispose();
            }
        } else {
            LFailed.setText("Failed: username/email already exists.");
        }
    }//GEN-LAST:event_BCreateAccountActionPerformed

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
            java.util.logging.Logger.getLogger(CreateAccountGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateAccountGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateAccountGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateAccountGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateAccountGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCreateAccount;
    private javax.swing.JButton BLogin;
    private javax.swing.JComboBox<String> CManager;
    private javax.swing.JLabel LAlreadyHave;
    private javax.swing.JLabel LCreateAccount;
    private javax.swing.JLabel LEmail;
    private javax.swing.JLabel LFailed;
    private javax.swing.JLabel LName;
    private javax.swing.JLabel LPassword;
    private javax.swing.JLabel LUsername;
    private javax.swing.JTextField TEmail;
    private javax.swing.JTextField TName;
    private javax.swing.JPasswordField TPassword;
    private javax.swing.JTextField TUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}