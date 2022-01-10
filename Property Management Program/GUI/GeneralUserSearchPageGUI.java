package GUI;
import javax.swing.table.DefaultTableModel;
import com.mysql.cj.protocol.Resultset;
import java.sql.*;
import DatabaseControllers.DataBaseManager;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author henriqueandras
 */

public class GeneralUserSearchPageGUI extends javax.swing.JFrame {

    /** Creates new form GeneralUserSearchPageGUI */
    public GeneralUserSearchPageGUI() {
        initComponents();
        setRecordsToTable();
    }
    
    DefaultTableModel model;
    public void setRecordsToTable() {
        Connection dbConnect =  DataBaseManager.getInstance().getConnection();
        if(dbConnect == null){return;}
        try{
            String query = "SELECT * FROM property WHERE feePaid = 1";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            ResultSet rs = myStmt.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String type  = rs.getString("propType");
                String quadrant = rs.getString("quadrant");
                int bedrooms = rs.getInt("numberOfBedrooms");
                int bathrooms = rs.getInt("numberOfBathrooms");;
                boolean furnished = rs.getBoolean("furnished");
                String status = rs.getString("propStatus");
                double price = rs.getDouble("price");
                
                Object[] obj = {id, type, quadrant, bedrooms, bathrooms, furnished, status, price};
                
                model = (DefaultTableModel)TTable.getModel();
                model.addRow(obj);
            }
            
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void search(String str) {
        model = (DefaultTableModel) TTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        TTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }
    
    public void searchType(String str) {
        model = (DefaultTableModel) TTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        TTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str, 1));
    }
    
     public void searchQuadrant(String str) {
        model = (DefaultTableModel) TTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        TTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str, 2));
    }
    
    public void searchBed(String str) {
        model = (DefaultTableModel) TTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        TTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str, 3));
    }
    
    public void searchBath(String str) {
        model = (DefaultTableModel) TTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        TTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str, 4));
    }
    
    public void searchStatus(String str) {
        model = (DefaultTableModel) TTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        TTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str, 6));
    }
    
    public void searchPrice(String str) {
        model = (DefaultTableModel) TTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        TTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str, 7));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PBackground = new javax.swing.JPanel();
        LSearch = new javax.swing.JLabel();
        CPropertyType = new javax.swing.JComboBox<>();
        LPropertyType = new javax.swing.JLabel();
        LQuadrant = new javax.swing.JLabel();
        CQuadrant = new javax.swing.JComboBox<>();
        LNumberOfBathrooms = new javax.swing.JLabel();
        LNumberOfBedrooms = new javax.swing.JLabel();
        TNumberOfBathrooms = new javax.swing.JTextField();
        TNumberOfBedrooms = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        PBackground.setBackground(new java.awt.Color(51, 153, 255));

        LSearch.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 24)); // NOI18N
        LSearch.setForeground(new java.awt.Color(255, 255, 255));
        LSearch.setText("Search");

        CPropertyType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Apartment", "Attached House", "Detached House", "Townhouse" }));
        CPropertyType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPropertyTypeActionPerformed(evt);
            }
        });
        CPropertyType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CPropertyTypeKeyReleased(evt);
            }
        });

        LPropertyType.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        LPropertyType.setForeground(new java.awt.Color(255, 255, 255));
        LPropertyType.setText("Property Type");

        LQuadrant.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        LQuadrant.setForeground(new java.awt.Color(255, 255, 255));
        LQuadrant.setText("Quadrant");

        CQuadrant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "NW", "NE", "SW", "SE" }));
        CQuadrant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CQuadrantActionPerformed(evt);
            }
        });

        LNumberOfBathrooms.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        LNumberOfBathrooms.setForeground(new java.awt.Color(255, 255, 255));
        LNumberOfBathrooms.setText("Number of Bathrooms");

        LNumberOfBedrooms.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        LNumberOfBedrooms.setForeground(new java.awt.Color(255, 255, 255));
        LNumberOfBedrooms.setText("Number or Bedrooms");

        TNumberOfBathrooms.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TNumberOfBathroomsKeyReleased(evt);
            }
        });

        TNumberOfBedrooms.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TNumberOfBedroomsKeyReleased(evt);
            }
        });

        TTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Type", "Quadrant", "Bedrooms", "Bathrooms", "Furnished", "Status", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TTable);

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Logout/Exit");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("General Search");

        TSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TSearchActionPerformed(evt);
            }
        });
        TSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TSearchKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Click on property to message the owner. You may need to double click it.");

        org.jdesktop.layout.GroupLayout PBackgroundLayout = new org.jdesktop.layout.GroupLayout(PBackground);
        PBackground.setLayout(PBackgroundLayout);
        PBackgroundLayout.setHorizontalGroup(
            PBackgroundLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PBackgroundLayout.createSequentialGroup()
                .add(475, 475, 475)
                .add(LSearch)
                .add(0, 0, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, PBackgroundLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .add(PBackgroundLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, PBackgroundLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, PBackgroundLayout.createSequentialGroup()
                            .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 101, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(21, 21, 21))
                        .add(PBackgroundLayout.createSequentialGroup()
                            .add(242, 242, 242)
                            .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 133, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(TSearch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 301, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(91, 91, 91))
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, PBackgroundLayout.createSequentialGroup()
                            .add(PBackgroundLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                .add(PBackgroundLayout.createSequentialGroup()
                                    .add(LPropertyType)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(CPropertyType, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(18, 18, 18)
                                    .add(LQuadrant)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                    .add(CQuadrant, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 88, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(18, 18, 18)
                                    .add(LNumberOfBathrooms)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                    .add(TNumberOfBathrooms, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 83, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(18, 18, 18)
                                    .add(LNumberOfBedrooms)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                    .add(TNumberOfBedrooms))
                                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 962, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(30, 30, 30)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, PBackgroundLayout.createSequentialGroup()
                        .add(jLabel2)
                        .add(245, 245, 245))))
        );
        PBackgroundLayout.setVerticalGroup(
            PBackgroundLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PBackgroundLayout.createSequentialGroup()
                .add(PBackgroundLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(PBackgroundLayout.createSequentialGroup()
                        .add(16, 16, 16)
                        .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(71, 71, 71))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, PBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(LSearch)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(24, 24, 24)))
                .add(PBackgroundLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(TSearch)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .add(18, 18, 18)
                .add(PBackgroundLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(LNumberOfBedrooms)
                    .add(TNumberOfBedrooms, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(LNumberOfBathrooms)
                    .add(TNumberOfBathrooms, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(LPropertyType)
                    .add(CPropertyType, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(CQuadrant, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(LQuadrant))
                .add(34, 34, 34)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 357, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(22, 22, 22))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PBackground, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PBackground, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LoginPageGUI login = new LoginPageGUI();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TNumberOfBathroomsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNumberOfBathroomsKeyReleased
        // TODO add your handling code here:
        String searchString = TNumberOfBathrooms.getText();
        searchBath(searchString);
    }//GEN-LAST:event_TNumberOfBathroomsKeyReleased

    private void TSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TSearchActionPerformed

    private void TSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TSearchKeyReleased
        // TODO add your handling code here:
        String searchString = TSearch.getText();
        search(searchString);
    }//GEN-LAST:event_TSearchKeyReleased

    private void CPropertyTypeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CPropertyTypeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_CPropertyTypeKeyReleased

    private void CPropertyTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPropertyTypeActionPerformed
        // TODO add your handling code here:
        String searchString = CPropertyType.getSelectedItem().toString();
        searchString = searchString.replaceAll(" ", "_");
        if(searchString.equals("All")) {
            search("");
            return;
        }
        searchType(searchString);
    }//GEN-LAST:event_CPropertyTypeActionPerformed

    private void TNumberOfBedroomsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNumberOfBedroomsKeyReleased
        // TODO add your handling code here:
        String searchString = TNumberOfBedrooms.getText();
        searchBed(searchString);
    }//GEN-LAST:event_TNumberOfBedroomsKeyReleased

    private void CQuadrantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CQuadrantActionPerformed
        // TODO add your handling code here:
        String searchString = CQuadrant.getSelectedItem().toString();
        if(searchString.equals("All")) {
            search("");
            return;
        }
        searchQuadrant(searchString);
    }//GEN-LAST:event_CQuadrantActionPerformed

    private void TTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TTableMouseClicked
        // TODO add your handling code here:
        int index = TTable.getSelectedRow();
        TableModel model = TTable.getModel();
        int id = Integer.parseInt(model.getValueAt(index, 0).toString());
        String anonymous = "Anonymous User";
        GeneralStartChatGUI chat = new GeneralStartChatGUI(anonymous, id);
        chat.setVisible(true);
        dispose();
    }//GEN-LAST:event_TTableMouseClicked

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
            java.util.logging.Logger.getLogger(GeneralUserSearchPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeneralUserSearchPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeneralUserSearchPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeneralUserSearchPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeneralUserSearchPageGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CPropertyType;
    private javax.swing.JComboBox<String> CQuadrant;
    private javax.swing.JLabel LNumberOfBathrooms;
    private javax.swing.JLabel LNumberOfBedrooms;
    private javax.swing.JLabel LPropertyType;
    private javax.swing.JLabel LQuadrant;
    private javax.swing.JLabel LSearch;
    private javax.swing.JPanel PBackground;
    private javax.swing.JTextField TNumberOfBathrooms;
    private javax.swing.JTextField TNumberOfBedrooms;
    private javax.swing.JTextField TSearch;
    private javax.swing.JTable TTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

}