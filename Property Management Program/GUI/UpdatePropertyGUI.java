/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DatabaseControllers.DataBaseManager;
import Entities.propStatus;

/**
 *
 * @author henriqueandras
 */
public class UpdatePropertyGUI extends javax.swing.JFrame {

    /**
     * Creates new form UpdatePropertyGUI
     */
    public static String username = null;
    public static int id;
    public UpdatePropertyGUI(String username, int id) {
        initComponents();
        this.username = username;
        this.LId.setText(Integer.toString(id));
        this.id = id;
    }
    
    public static boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false;
    }
    try {
        double d = Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
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
        BBack = new javax.swing.JButton();
        LEdit = new javax.swing.JLabel();
        LId = new javax.swing.JLabel();
        LStatus = new javax.swing.JLabel();
        LPrice = new javax.swing.JLabel();
        BSubmit = new javax.swing.JButton();
        CStatus = new javax.swing.JComboBox<>();
        CPrice = new javax.swing.JTextField();
        LError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        BBack.setBackground(new java.awt.Color(51, 153, 255));
        BBack.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        BBack.setForeground(new java.awt.Color(255, 255, 255));
        BBack.setText("Back");
        BBack.setBorder(null);
        BBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBackActionPerformed(evt);
            }
        });

        LEdit.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 24)); // NOI18N
        LEdit.setForeground(new java.awt.Color(255, 255, 255));
        LEdit.setText("Edit Property of ID");

        LId.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 24)); // NOI18N
        LId.setForeground(new java.awt.Color(255, 255, 255));

        LStatus.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        LStatus.setForeground(new java.awt.Color(255, 255, 255));
        LStatus.setText("Status");

        LPrice.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        LPrice.setForeground(new java.awt.Color(255, 255, 255));
        LPrice.setText("Price");

        BSubmit.setBackground(new java.awt.Color(255, 204, 0));
        BSubmit.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 13)); // NOI18N
        BSubmit.setForeground(new java.awt.Color(255, 255, 255));
        BSubmit.setText("Submit");
        BSubmit.setBorderPainted(false);
        BSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSubmitActionPerformed(evt);
            }
        });

        CStatus.setBackground(new java.awt.Color(255, 255, 255));
        CStatus.setForeground(new java.awt.Color(102, 102, 102));
        CStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Rented", "Cancelled", "Suspended" }));
        CStatus.setBorder(null);

        CPrice.setBackground(new java.awt.Color(255, 255, 255));
        CPrice.setForeground(new java.awt.Color(102, 102, 102));
        CPrice.setBorder(null);
        CPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPriceActionPerformed(evt);
            }
        });

        LError.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        LError.setForeground(new java.awt.Color(255, 51, 0));
        LError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(BBack, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(LEdit)
                                .addGap(18, 18, 18)
                                .addComponent(LId, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(LError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(LStatus)
                                        .addComponent(LPrice))
                                    .addGap(42, 42, 42)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(BSubmit)
                                        .addComponent(CStatus, 0, 201, Short.MAX_VALUE)
                                        .addComponent(CPrice)))))))
                .addContainerGap(214, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(BBack, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LEdit)
                    .addComponent(LId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LStatus)
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LPrice)
                            .addComponent(CPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41)
                .addComponent(BSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LError, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
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

    private void BBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBackActionPerformed
        // TODO add your handling code here:
        if (DataBaseManager.getInstance().SelectManager(username) != null) {
            ManagerEditPropertyGUI edit = new ManagerEditPropertyGUI(username);
            edit.setVisible(true);
            dispose();
        } else {
            EditPropertyGUI edit = new EditPropertyGUI(username);
            edit.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_BBackActionPerformed

    private void CPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPriceActionPerformed

    private void BSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSubmitActionPerformed
        // TODO add your handling code here:
        String status = CStatus.getSelectedItem().toString();
        String strPrice = CPrice.getText();
        
        if(strPrice.equals("")) {
            LError.setText("Failed: all the fields are required.");
            return;
        }
        
        if(!isNumeric(strPrice)) {
            LError.setText("Failed: invalid data types.");
            return;
        }
        
        int index;
        if (status.equals("Active")) {
            index = 0;
        } else if (status.equals("Rented")) {
            index = 1;
        } else if (status.equals("Cancelled")) {
            index = 2;
        } else {index = 3;}
        DataBaseManager.getInstance().updatePropertyStatus(id, propStatus.values()[index]);
        double price = Double.parseDouble(strPrice);
        DataBaseManager.getInstance().updatePropertyPrice(id, price);
        
        if (DataBaseManager.getInstance().SelectManager(username) != null) {
            ManagerEditPropertyGUI edit = new ManagerEditPropertyGUI(username);
            edit.setVisible(true);
            dispose();
        } else {
            EditPropertyGUI edit = new EditPropertyGUI(username);
            edit.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_BSubmitActionPerformed

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
            java.util.logging.Logger.getLogger(UpdatePropertyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdatePropertyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdatePropertyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdatePropertyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdatePropertyGUI(username, id).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BBack;
    private javax.swing.JButton BSubmit;
    private javax.swing.JTextField CPrice;
    private javax.swing.JComboBox<String> CStatus;
    private javax.swing.JLabel LEdit;
    private javax.swing.JLabel LError;
    private javax.swing.JLabel LId;
    private javax.swing.JLabel LPrice;
    private javax.swing.JLabel LStatus;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
