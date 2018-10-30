/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import geniusapp.Constants;
import geniusapp.Security;
import geniusapp.SqlConnection;
import geniusapp.User_Group;
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
public class User_Groups extends javax.swing.JDialog {

   static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
     Constants _Constants=new Constants();
     DefaultTableModel model = new DefaultTableModel(new String[]{ "UserGroup", "UserName"}, 0);
   
    public User_Groups() {
        initComponents();
        TblItems.setModel(model);        
        setModal(true);
        setLocationRelativeTo(null);
        LoadItemss();
        fillUserGroups();
        fillUsers();
    }

  public void LoadItemss(){
        try {
           Statement pst=con.createStatement();
            ResultSet rs= pst.executeQuery("{call selectAllUserGroups}");
            model.setRowCount(0);
             while(rs.next()){
                
                String GroupCode=rs.getNString("GroupCode");
                String UserName=rs.getNString("UserName");
                model.addRow(new Object[]{GroupCode, UserName});
                              
            }
         rs.close();
            pst.close();
          
      
        } catch (Exception e) {
              Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Loading Items to jtable");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
             
        }
    }
 public void fillUsers(){
    try {
           Statement pst=con.createStatement();
            ResultSet rs= pst.executeQuery("{call spSelectAllUsers}");
            while(rs.next()){
            String id = rs.getString("username");
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
  public void DisableFields(){
     
              combUsersGroups.setEditable(false);               
             
               cmbRoles.setEditable(false);
}
public void EnableFields(){
        
           
              combUsersGroups.setEditable(true);               
             
               cmbRoles.setEditable(true);
            
            
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        txtKeyword2 = new javax.swing.JTextField();
        jButtonEdit2 = new javax.swing.JButton();
        jButtonSave2 = new javax.swing.JButton();
        BTNSearch2 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        combUsersGroups2 = new javax.swing.JComboBox();
        cmbRoles2 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblItems = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel6.setBackground(new java.awt.Color(153, 153, 255));

        txtKeyword2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKeyword2ActionPerformed(evt);
            }
        });

        jButtonEdit2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Compose_35px.png"))); // NOI18N
        jButtonEdit2.setText("Edit");
        jButtonEdit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEdit2ActionPerformed(evt);
            }
        });

        jButtonSave2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Data_Recovery_35px.png"))); // NOI18N
        jButtonSave2.setText("Save");
        jButtonSave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSave2ActionPerformed(evt);
            }
        });

        BTNSearch2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Search_35px.png"))); // NOI18N
        BTNSearch2.setText("Serach");
        BTNSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSearch2ActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Map Security Roles Here", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel5.setText("UserName");

        jLabel6.setText("UserGroup");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(combUsersGroups2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(201, 201, 201)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbRoles2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addComponent(combUsersGroups2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(3, 3, 3)
                .addComponent(cmbRoles2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jButtonSave2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEdit2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(407, 407, 407)
                .addComponent(txtKeyword2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTNSearch2)
                .addContainerGap(75, Short.MAX_VALUE))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtKeyword2)
                        .addComponent(BTNSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonEdit2)
                            .addComponent(jButtonSave2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtKeyword2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKeyword2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKeyword2ActionPerformed

    private void jButtonEdit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEdit2ActionPerformed
        EnableFields();
    }//GEN-LAST:event_jButtonEdit2ActionPerformed

    private void jButtonSave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSave2ActionPerformed
        // TODO add your handling code here:
        try {
            String   UserGroup,  UserName;
         
            String   Item1=combUsersGroups.getSelectedItem().toString();
            String[] parts = Item1.split("/");
            UserGroup = parts[0];

            UserName=cmbRoles.getSelectedItem().toString();
            User_Group _Item=new User_Group(  UserGroup,  UserName);
            if(_Item.SaveUserGroups()){
                JOptionPane.showMessageDialog(null,"Saved Successfully");
                LoadItemss();
            }else{
                JOptionPane.showMessageDialog(null,"Record Could not be saved ");
            }
        } catch (Exception e) {
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving User Roles");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_jButtonSave2ActionPerformed

    private void BTNSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSearch2ActionPerformed
        try {
            String keyWord=txtKeyword.getText();
            try (PreparedStatement pstmt = con.prepareStatement("{call searchUserGroups(?)}")) {
                pstmt.setString(1, keyWord);

                ResultSet rs=pstmt.executeQuery();
                model.setRowCount(0);
                while(rs.next()){
                     String GroupCode=rs.getNString("GroupCode");
                String UserName=rs.getNString("UserName");               
                   
              
                model.addRow(new Object[]{GroupCode, UserName});
                              
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
    }//GEN-LAST:event_BTNSearch2ActionPerformed

    private void TblItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblItemsMouseClicked

        getRowValue();
    }//GEN-LAST:event_TblItemsMouseClicked

  public void getRowValue(){
    try {
        int column = 0;
        int row = TblItems.getSelectedRow();
        String ItemCode = TblItems.getModel().getValueAt(row, column).toString();
          String Module = TblItems.getModel().getValueAt(row, 1).toString();
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

        try (PreparedStatement pstmt = con.prepareStatement("{call selectUserGroups(?,?)}")) {
            pstmt.setString(1, ItemCode);
               pstmt.setString(2, Module);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                String UserGroup=rs.getNString("GroupCode");
                String UserName=rs.getNString("UserName");
             
                    
                    
              combUsersGroups.setSelectedItem(UserGroup);
             
               cmbRoles.setSelectedItem(UserName);
                
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
            java.util.logging.Logger.getLogger(User_Groups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Groups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Groups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Groups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Groups().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNSearch;
    private javax.swing.JButton BTNSearch1;
    private javax.swing.JButton BTNSearch2;
    public javax.swing.JTable TblItems;
    private javax.swing.JCheckBox ckAdd;
    private javax.swing.JCheckBox ckAdd1;
    private javax.swing.JCheckBox ckDelete;
    private javax.swing.JCheckBox ckDelete1;
    private javax.swing.JCheckBox ckEdit;
    private javax.swing.JCheckBox ckEdit1;
    private javax.swing.JCheckBox ckExport;
    private javax.swing.JCheckBox ckExport1;
    private javax.swing.JCheckBox ckImport;
    private javax.swing.JCheckBox ckImport1;
    private javax.swing.JCheckBox ckView1;
    private javax.swing.JCheckBox ckView2;
    private javax.swing.JComboBox cmbRoles;
    private javax.swing.JComboBox cmbRoles1;
    private javax.swing.JComboBox cmbRoles2;
    private javax.swing.JComboBox combUsersGroups;
    private javax.swing.JComboBox combUsersGroups1;
    private javax.swing.JComboBox combUsersGroups2;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonEdit1;
    private javax.swing.JButton jButtonEdit2;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSave1;
    private javax.swing.JButton jButtonSave2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtKeyword;
    private javax.swing.JTextField txtKeyword1;
    private javax.swing.JTextField txtKeyword2;
    // End of variables declaration//GEN-END:variables
}
