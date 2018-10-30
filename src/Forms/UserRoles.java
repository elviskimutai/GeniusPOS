
package Forms;

import geniusapp.Constants;

import geniusapp.Security;
import geniusapp.SqlConnection;
import geniusapp.UserRolesClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class UserRoles extends javax.swing.JDialog {

     static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
     Constants _Constants=new Constants();
     DefaultTableModel model = new DefaultTableModel(new String[]{ "UserGroup", "GroupName","SecurityModule","View","Add","Edit","Delete","Export","Import"}, 0);
   
    public UserRoles() {
        initComponents();
         TblItems.setModel(model);        
        setModal(true);
        setLocationRelativeTo(null);
        LoadItemss();
        fillUserGroups();
        fillSecurityRoles();
    }
    public void LoadItemss(){
        try {
           Statement pst=con.createStatement();
            ResultSet rs= pst.executeQuery("{call SelectAllUserSecurityRoles}");
            model.setRowCount(0);
             while(rs.next()){
                
                String UserGroup=rs.getNString("UserGroup");
                String GroupName=rs.getNString("GroupName");
                String SecurityModule=rs.getNString("SecurityModule");
                Boolean View=rs.getBoolean("View");
                Boolean Add=rs.getBoolean("Add");
                 Boolean Edit=rs.getBoolean("Edit");
                  Boolean Delete=rs.getBoolean("Delete");
                   Boolean Export=rs.getBoolean("Export");
                    Boolean Import=rs.getBoolean("Import");
                     Boolean U=rs.getBoolean("View");
                   
              
                model.addRow(new Object[]{UserGroup, GroupName,SecurityModule,View,Add,Edit,Delete,Export,Import});
                              
            }
         rs.close();
            pst.close();
           // UsersTable.setModel(DbUtils.resultSetToTableModel(rs));
      
        } catch (Exception e) {
              Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Loading Items to jtable");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
             
        }
    }
 public void fillSecurityRoles(){
    try {
           Statement pst=con.createStatement();
            ResultSet rs= pst.executeQuery("{call SelectSecurityRoles}");
          
          
             while(rs.next()){
                  String id = rs.getString("RoleName");
          
            String cmb = (id);
                
                 //Items.add(1, new ItemCombo(rs.getString("ItemName"),rs.getString("ItemName")));
                cmbRoles.addItem(cmb);    
                 
            }
         
        rs.close();
     pst.close();
            
         
      
        } catch (Exception e) {
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Initializing Security roles");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
}
  public void fillUserGroups(){
    try {
           Statement pst=con.createStatement();
            ResultSet rs= pst.executeQuery("{call SelectAllSecurityGroups}");
          
          
             while(rs.next()){
                  String id = rs.getString("GroupCode");
            String nme = rs.getString("GroupName");
            String cmb = (id+ "  /  "+nme);
                
                 //Items.add(1, new ItemCombo(rs.getString("ItemName"),rs.getString("ItemName")));
                combUsersGroups.addItem(cmb);    
                 
            }
         
        rs.close();
     pst.close();
            
         
      
        } catch (Exception e) {
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Initializing User Groups");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtKeyword = new javax.swing.JTextField();
        jButtonEdit = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        BTNSearch = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ckAdd = new javax.swing.JCheckBox();
        ckView1 = new javax.swing.JCheckBox();
        ckExport = new javax.swing.JCheckBox();
        ckDelete = new javax.swing.JCheckBox();
        ckImport = new javax.swing.JCheckBox();
        ckEdit = new javax.swing.JCheckBox();
        combUsersGroups = new javax.swing.JComboBox();
        cmbRoles = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblItems = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Map User Roles");

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        txtKeyword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKeywordActionPerformed(evt);
            }
        });

        jButtonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Compose_35px.png"))); // NOI18N
        jButtonEdit.setText("Edit");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Data_Recovery_35px.png"))); // NOI18N
        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        BTNSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Search_35px.png"))); // NOI18N
        BTNSearch.setText("Serach");
        BTNSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSearchActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Map Security Roles Here", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel1.setText(" Role");

        jLabel2.setText("UserGroup");

        ckAdd.setText("Add");
        ckAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckAddActionPerformed(evt);
            }
        });

        ckView1.setText("View");
        ckView1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckView1ActionPerformed(evt);
            }
        });

        ckExport.setText("Export");
        ckExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckExportActionPerformed(evt);
            }
        });

        ckDelete.setText("Delete");
        ckDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckDeleteActionPerformed(evt);
            }
        });

        ckImport.setText("Import");
        ckImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckImportActionPerformed(evt);
            }
        });

        ckEdit.setText("Edit");
        ckEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckEditActionPerformed(evt);
            }
        });

        combUsersGroups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combUsersGroupsActionPerformed(evt);
            }
        });

        cmbRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRolesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ckAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(ckView1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ckEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combUsersGroups, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(201, 201, 201)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ckImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ckExport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(148, 148, 148))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(combUsersGroups, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ckView1)
                .addGap(12, 12, 12)
                .addComponent(ckAdd)
                .addGap(18, 18, 18)
                .addComponent(ckEdit)
                .addGap(88, 88, 88))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(cmbRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ckDelete)
                .addGap(18, 18, 18)
                .addComponent(ckExport)
                .addGap(18, 18, 18)
                .addComponent(ckImport)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TblItems.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        TblItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TblItems.setGridColor(new java.awt.Color(255, 255, 255));
        TblItems.setRowHeight(20);
        TblItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblItemsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblItems);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(407, 407, 407)
                .addComponent(txtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTNSearch)
                .addContainerGap(56, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtKeyword)
                        .addComponent(BTNSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonEdit)
                            .addComponent(jButtonSave))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtKeywordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKeywordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKeywordActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        EnableFields();
    }//GEN-LAST:event_jButtonEditActionPerformed
public void DisableFields(){
        ckDelete.enable(false);
            ckView1.enable(false);
            ckAdd.enable(false);
             ckExport.enable(false);
             ckEdit.enable(false);
             ckImport.enable(false);
              combUsersGroups.setEditable(false);               
             
               cmbRoles.setEditable(false);
}
public void EnableFields(){
        
             ckDelete.enable(true);
            ckView1.enable(true);
            ckAdd.enable(true);
             ckExport.enable(true);
             ckEdit.enable(true);
             ckImport.enable(true);
              combUsersGroups.setEditable(true);               
             
               cmbRoles.setEditable(true);
            
            
}
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
        try {
            String   UserGroup,  SecurityModule;
            Boolean View,Delete,Add,Export,Edit,Import;
            Delete=ckDelete.isSelected();
            View=ckView1.isSelected();
            Add=ckAdd.isSelected();
             Export=ckExport.isSelected();
             Edit=ckEdit.isSelected();
             Import=ckImport.isSelected();
              String   Item1=combUsersGroups.getSelectedItem().toString();
                String[] parts = Item1.split("/");
                UserGroup = parts[0];
             
               SecurityModule=cmbRoles.getSelectedItem().toString();
            UserRolesClass _Item=new UserRolesClass(  UserGroup,  SecurityModule,  View,  Delete,  Add,  Export,  Edit,  Import);
            if(_Item.SaveUserRoles()){
                JOptionPane.showMessageDialog(null,"User Role Saved Successfully");
                LoadItemss();
            }else{
                JOptionPane.showMessageDialog(null,"User Role Could not be saved ");
            }
        } catch (Exception e) {
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving User Roles");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void BTNSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSearchActionPerformed
        try {
            String keyWord=txtKeyword.getText();
            try (PreparedStatement pstmt = con.prepareStatement("{call SearchUserRoles(?)}")) {
                pstmt.setString(1, keyWord);

                ResultSet rs=pstmt.executeQuery();
                model.setRowCount(0);
                while(rs.next()){
                    String UserGroup=rs.getNString("UserGroup");
                String GroupName=rs.getNString("GroupName");
                String SecurityModule=rs.getNString("SecurityModule");
                Boolean View=rs.getBoolean("View");
                Boolean Add=rs.getBoolean("Add");
                 Boolean Edit=rs.getBoolean("Edit");
                  Boolean Delete=rs.getBoolean("Delete");
                   Boolean Export=rs.getBoolean("Export");
                    Boolean Import=rs.getBoolean("Import");
                   
                     model.addRow(new Object[]{UserGroup, GroupName,SecurityModule,View,Add,Edit,Delete,Export,Import});
                   }
                pstmt.close();

            }

        } catch (Exception e) {
            e.printStackTrace();
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Initializing Items");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();

        }
    }//GEN-LAST:event_BTNSearchActionPerformed

    private void ckAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckAddActionPerformed

    private void TblItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblItemsMouseClicked
      
        getRowValue();
    }//GEN-LAST:event_TblItemsMouseClicked
public void getRowValue(){
    try {
        int column = 0;
        int row = TblItems.getSelectedRow();
        String ItemCode = TblItems.getModel().getValueAt(row, column).toString();
          String Module = TblItems.getModel().getValueAt(row, 2).toString();
       // JOptionPane.showMessageDialog(null,value);
        fillFiields(ItemCode,Module);
    } catch (Exception e) {
         Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Getting Items from jtable");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
    }
}

public void fillFiields(String ItemCode,String Module){
    try {

        try (PreparedStatement pstmt = con.prepareStatement("{call SelectUserSecurityRoles(?,?)}")) {
            pstmt.setString(1, ItemCode);
               pstmt.setString(2, Module);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                String UserGroup=rs.getNString("UserGroup");
                String GroupName=rs.getNString("GroupName");
                String SecurityModule=rs.getNString("SecurityModule");
                Boolean View=rs.getBoolean("View");
                Boolean Add=rs.getBoolean("Add");
                 Boolean Edit=rs.getBoolean("Edit");
                  Boolean Delete=rs.getBoolean("Delete");
                   Boolean Export=rs.getBoolean("Export");
                    Boolean Import=rs.getBoolean("Import");
                    
                     ckDelete.setSelected(Delete);
            ckView1.setSelected(View);
            ckAdd.setSelected(Add);
             ckExport.setSelected(Export);
             ckEdit.setSelected(Edit);
             ckImport.setSelected(Import);
              combUsersGroups.setSelectedItem(UserGroup);
             
               cmbRoles.setSelectedItem(SecurityModule);
                
            }
            pstmt.close();
            DisableFields();
        }
               // con.close();
    } catch (Exception e) {
             Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Filling Fields Item Master");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
    }
}
    private void ckView1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckView1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckView1ActionPerformed

    private void ckExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckExportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckExportActionPerformed

    private void ckDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckDeleteActionPerformed

    private void ckImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckImportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckImportActionPerformed

    private void ckEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckEditActionPerformed

    private void combUsersGroupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combUsersGroupsActionPerformed
        // TODO add your handling code here:
        try {

            // String   Item=jComItems.getSelectedItem().toString();
            String   Item1=combUsersGroups.getSelectedItem().toString();
            String[] parts = Item1.split("/");
            String Item = parts[0];
            PreparedStatement pst=con.prepareStatement("{call SelectItems(?)}");
            pst.setString(1, Item);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                // JOptionPane.showMessageDialog(null,rs.getNString("UserName"));
//                txtName.setText(rs.getNString("ItemName"));
//                txtName.setEnabled(false);
//                txtItemCostprice.setText(rs.getString("CostPrice"));
//                txtItemCostprice.setEnabled(false);
                //  jComItems.addItem(rs.getString("ItemName"));
            }

            rs.close();
            pst.close();
        } catch (Exception e) {
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Initializing Suppliers");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }

    }//GEN-LAST:event_combUsersGroupsActionPerformed

    private void cmbRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRolesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRolesActionPerformed

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
            java.util.logging.Logger.getLogger(UserRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserRoles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNSearch;
    public javax.swing.JTable TblItems;
    private javax.swing.JCheckBox ckAdd;
    private javax.swing.JCheckBox ckDelete;
    private javax.swing.JCheckBox ckEdit;
    private javax.swing.JCheckBox ckExport;
    private javax.swing.JCheckBox ckImport;
    private javax.swing.JCheckBox ckView1;
    private javax.swing.JComboBox cmbRoles;
    private javax.swing.JComboBox combUsersGroups;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtKeyword;
    // End of variables declaration//GEN-END:variables
}
