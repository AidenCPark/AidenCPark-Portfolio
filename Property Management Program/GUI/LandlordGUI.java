package GUI;

import Entities.Landlord;
import javax.swing.JLabel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


/**
 *
 * @author henriqueandras
 */
public class LandlordGUI extends javax.swing.JFrame {

    /**
     * Creates new form LandlordGUI
     */
    public static String username = null;
    public LandlordGUI(String username) {
        initComponents();
        this.LUsername.setText(username);
        this.username = username;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PBackground = new javax.swing.JPanel();
        LUsername = new javax.swing.JLabel();
        BRegisterProperty = new javax.swing.JButton();
        BPayment = new javax.swing.JButton();
        BEditProperty = new javax.swing.JButton();
        BLogout = new javax.swing.JButton();
        BChats = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PBackground.setBackground(new java.awt.Color(51, 153, 255));

        LUsername.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 24)); // NOI18N
        LUsername.setForeground(new java.awt.Color(255, 255, 255));
        LUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LUsername.setToolTipText("");

        BRegisterProperty.setBackground(new java.awt.Color(255, 204, 0));
        BRegisterProperty.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 13)); // NOI18N
        BRegisterProperty.setForeground(new java.awt.Color(255, 255, 255));
        BRegisterProperty.setText("Register Property");
        BRegisterProperty.setBorderPainted(false);
        BRegisterProperty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRegisterPropertyActionPerformed(evt);
            }
        });

        BPayment.setBackground(new java.awt.Color(255, 204, 0));
        BPayment.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 13)); // NOI18N
        BPayment.setForeground(new java.awt.Color(255, 255, 255));
        BPayment.setText("Payment");
        BPayment.setBorderPainted(false);
        BPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPaymentActionPerformed(evt);
            }
        });

        BEditProperty.setBackground(new java.awt.Color(255, 204, 0));
        BEditProperty.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 13)); // NOI18N
        BEditProperty.setForeground(new java.awt.Color(255, 255, 255));
        BEditProperty.setText("Edit Property");
        BEditProperty.setBorderPainted(false);
        BEditProperty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEditPropertyActionPerformed(evt);
            }
        });

        BLogout.setBackground(new java.awt.Color(51, 153, 255));
        BLogout.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        BLogout.setForeground(new java.awt.Color(255, 255, 255));
        BLogout.setText("Logout/Exit");
        BLogout.setBorder(null);
        BLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLogoutActionPerformed(evt);
            }
        });

        BChats.setBackground(new java.awt.Color(255, 204, 0));
        BChats.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 13)); // NOI18N
        BChats.setForeground(new java.awt.Color(255, 255, 255));
        BChats.setText("Chats");
        BChats.setBorderPainted(false);
        BChats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BChatsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PBackgroundLayout = new javax.swing.GroupLayout(PBackground);
        PBackground.setLayout(PBackgroundLayout);
        PBackgroundLayout.setHorizontalGroup(
            PBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PBackgroundLayout.createSequentialGroup()
                .addContainerGap(430, Short.MAX_VALUE)
                .addGroup(PBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BChats, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PBackgroundLayout.createSequentialGroup()
                            .addComponent(BLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PBackgroundLayout.createSequentialGroup()
                            .addGroup(PBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(BEditProperty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BRegisterProperty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(404, 404, 404)))))
        );
        PBackgroundLayout.setVerticalGroup(
            PBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PBackgroundLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(BLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(LUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(BRegisterProperty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(BPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(BEditProperty, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(BChats, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BRegisterPropertyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRegisterPropertyActionPerformed
        // TODO add your handling code here:
        RegisterPropertyGUI RegisterFrame = new RegisterPropertyGUI(username);
        RegisterFrame.setVisible(true); // display RegisterPropertyGUI here
        dispose(); // close current frame
    }//GEN-LAST:event_BRegisterPropertyActionPerformed

    private void BLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLogoutActionPerformed
        // TODO add your handling code here:
        LoginPageGUI login = new LoginPageGUI();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_BLogoutActionPerformed

    private void BPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPaymentActionPerformed
        // TODO add your handling code here:
        EditPaymentGUI payment = new EditPaymentGUI(username);
        payment.setVisible(true);
        dispose();
    }//GEN-LAST:event_BPaymentActionPerformed

    private void BEditPropertyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEditPropertyActionPerformed
        // TODO add your handling code here:
        EditPropertyGUI edit = new EditPropertyGUI(username);
        edit.setVisible(true);
        dispose();
    }//GEN-LAST:event_BEditPropertyActionPerformed

    private void BChatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BChatsActionPerformed
        // TODO add your handling code here:
        ChatListGUI edit = new ChatListGUI(username);
        edit.setVisible(true);
        dispose();
    }//GEN-LAST:event_BChatsActionPerformed

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
            java.util.logging.Logger.getLogger(LandlordGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LandlordGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LandlordGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LandlordGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LandlordGUI(username).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BChats;
    private javax.swing.JButton BEditProperty;
    private javax.swing.JButton BLogout;
    private javax.swing.JButton BPayment;
    private javax.swing.JButton BRegisterProperty;
    private javax.swing.JLabel LUsername;
    private javax.swing.JPanel PBackground;
    // End of variables declaration//GEN-END:variables
}
