/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import geniusapp.Constants;
import geniusapp.Item;
import geniusapp.Security;
import geniusapp.SqlConnection;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eng.Joseph Gitahi
 */
public class ItemMaster extends javax.swing.JDialog   {

    /**
     * Creates new form ItemMaster
     */
     static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
     Constants _Constants=new Constants();
     DefaultTableModel model = new DefaultTableModel(new String[]{ "ItemCode", "ItemName","ItemDescription","CostPrice","SellingPrice","VATInclusive","VATValue","UOM"}, 0);
           
    public ItemMaster() {
        initComponents();
          TblItems.setModel(model);        
        setModal(true);
        setLocationRelativeTo(null);
        LoadItemss();
    }
public void LoadItemss(){
        try {
           Statement pst=con.createStatement();
            ResultSet rs= pst.executeQuery("{call SelectAllItems}");
             while(rs.next()){
                String U=rs.getNString("ItemCode");
                String N=rs.getNString("ItemName");
                String E=rs.getNString("ItemDescription");
                
                String Em=rs.getString("CostPrice") ;//.getNString("CostPrice");
                String T=rs.getString("CostPrice") ;//getNString("SellingPrice");
                
                Boolean Nm= rs.getBoolean("VATInclusive");// getNString("VATInclusive");
                float Ek=rs.getFloat("VATValue");// getNString("VATValue");
                String Emm=rs.getNString("UOM");
              
                model.addRow(new Object[]{U, N,E,Em,T,Nm,Ek,Emm});
                              
            }
         
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblItems = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtKeyword = new javax.swing.JTextField();
        BTNUpdate = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        BTNSearch = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtVATValue = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtSellingPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Itemdesc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ItemCode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ItemCode1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtItemName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtItemCostprice = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        TXTUOM = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DEFINE NEW ITEM HERE");
        setBackground(new java.awt.Color(204, 204, 255));
        setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        txtKeyword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKeywordActionPerformed(evt);
            }
        });

        BTNUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Update_35px.png"))); // NOI18N
        BTNUpdate.setText("Update");
        BTNUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNUpdateActionPerformed(evt);
            }
        });

        jButtonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Compose_35px.png"))); // NOI18N
        jButtonEdit.setText("Edit");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Trash_Can_35px.png"))); // NOI18N
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Define New Item Here", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N

        txtVATValue.setText("16");

        jLabel10.setText("VAT Value");

        jLabel6.setText("Selling Price");

        jLabel4.setText("Item Description");

        jLabel1.setText("BarCode");

        jLabel2.setText("Item Code");

        jLabel3.setText("Item Name");

        jLabel5.setText("Buying Price");

        jCheckBox1.setText("VAT Inclusive");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Unit of Measure");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ItemCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtItemCostprice, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(TXTUOM, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSellingPrice)
                    .addComponent(txtVATValue)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ItemCode)
                    .addComponent(Itemdesc)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                .addGap(181, 181, 181))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ItemCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtItemCostprice, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXTUOM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Itemdesc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVATValue, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTNUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119)
                .addComponent(txtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTNSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKeyword)
                            .addComponent(BTNSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BTNUpdate)
                        .addComponent(jButtonEdit)
                        .addComponent(jButton1)
                        .addComponent(jButtonSave)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void TblItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblItemsMouseClicked
        // TODO add your handling code he
        getRowValue();
    }//GEN-LAST:event_TblItemsMouseClicked
public void getRowValue(){
    try {
        int column = 0;
        int row = TblItems.getSelectedRow();
        String ItemCode = TblItems.getModel().getValueAt(row, column).toString();
       // JOptionPane.showMessageDialog(null,value);
        fillFiields(ItemCode);
    } catch (Exception e) {
         Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Getting Items from jtable");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
    }
}
public void DisableFields(){
       ItemCode1.setEditable(false);
            txtItemName.setEditable(false);
            Itemdesc.setEditable(false);
            TXTUOM.setEditable(false);
          
            txtVATValue.setEditable(false);
            jCheckBox1.enable(false);
           txtSellingPrice.setEditable(false);
            txtItemCostprice.setEditable(false);
         
}
public void EnableFields(){
        ItemCode1.setEditable(true);
            txtItemName.setEditable(true);
            Itemdesc.setEditable(true);
            TXTUOM.setEditable(true);
          
            txtVATValue.setEditable(true);
            jCheckBox1.enable(true);
           txtSellingPrice.setEditable(true);
            txtItemCostprice.setEditable(true);
            
            
}
public void fillFiields(String ItemCode){
    try {

        try (PreparedStatement pstmt = con.prepareStatement("{call SelectItems(?)}")) {
            pstmt.setString(1, ItemCode);
            
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                ItemCode1.setText(rs.getNString("ItemCode"));
                txtItemName.setText(rs.getNString("ItemName"));
                Itemdesc.setText(rs.getNString("ItemDescription"));
                TXTUOM.setText(rs.getNString("UOM"));
                
                txtVATValue.setText(String.valueOf(rs.getFloat("VATValue")));
                jCheckBox1.setSelected(rs.getBoolean("VATInclusive"));
              //  String s=String.valueOf(rs.getFloat("VATValue"));
                txtSellingPrice.setText(String.valueOf(rs.getFloat("SellingPrice")));
                txtItemCostprice.setText(String.valueOf(rs.getFloat("CostPrice")));
                
                
                
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
 
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
          try {
            String ItemCode,ItemName,ItemDescription,UOM;
            Double SellingPrice,CostPrice;
            Float VATValue;
            Boolean VATInclusive;

            ItemCode=ItemCode1.getText();
             if(ItemCode.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter ItemCode  To Continue");
                return;
            }
            ItemName=txtItemName.getText();
             if(ItemName.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter ItemName  To Continue");
                return;
            }
            ItemDescription=Itemdesc.getText();
             if(ItemDescription.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter ItemDescription  To Continue");
                return;
            }
            UOM=TXTUOM.getText();
            if(UOM.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter UOM  To Continue");
                return;
            }
            String va=txtVATValue.getText();
                        
              if(va.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter VATValue  To Continue");
                return;
            }else{
                  VATValue=Float.parseFloat(va);
              }
            VATInclusive=jCheckBox1.isSelected();
            String se=txtSellingPrice.getText();
           
            if(se.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter SellingPrice  To Continue");
                return;
            }else{
                 SellingPrice=Double.parseDouble(se);
            }
            String co=txtItemCostprice.getText();
            
            if(co.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter CostPrice  To Continue");
                return;
            }else{
                CostPrice=Double.parseDouble(co);
            }
                       
            Item _Item=new Item( ItemCode,  ItemName,  ItemDescription,  UOM,  _Constants.getRegSource(),  _Constants.getUserId(),  SellingPrice, CostPrice,  VATValue,  VATInclusive);
            if(_Item.SaveItem()){
                JOptionPane.showMessageDialog(null,"Item Saved Successfully");
                 LoadItemss();
            }
        } catch (Exception e) {
             Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving Items");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        EnableFields();
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void BTNUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNUpdateActionPerformed
        // TODO add your handling code here:
         try {
            String ItemCode,ItemName,ItemDescription,UOM;
            Double SellingPrice,CostPrice;
            Float VATValue;
            Boolean VATInclusive;

            ItemCode=ItemCode1.getText();
            ItemName=txtItemName.getText();
            ItemDescription=Itemdesc.getText();
            UOM=TXTUOM.getText();
           
            VATValue=Float.parseFloat(txtVATValue.getText());
            VATInclusive=jCheckBox1.isSelected();
            SellingPrice=Double.parseDouble(txtSellingPrice.getText());
            CostPrice=Double.parseDouble(txtItemCostprice.getText());
            Item _Item=new Item( ItemCode,  ItemName,  ItemDescription,  UOM,  _Constants.getRegSource(),  _Constants.getUserId(),  SellingPrice, CostPrice,  VATValue,  VATInclusive);
            if(_Item.SaveItem()){
                JOptionPane.showMessageDialog(null,"Item Saved Successfully");
                 LoadItemss();
            }
        } catch (Exception e) {
             Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving Items");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_BTNUpdateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         try {
            String ItemCode,ItemName;
          

            ItemCode=ItemCode1.getText();
            ItemName=txtItemName.getText();
            
            Item _Item=new Item();
             _Item.setItemCode(ItemCode);
             _Item.setItemName(ItemName);
            if(_Item.DeleteItem()){
                JOptionPane.showMessageDialog(null,"Item Deleted Successfully");
                 LoadItemss();
            }
        } catch (Exception e) {
             Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Deleting Items");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BTNSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSearchActionPerformed
         try {
             String keyWord=txtKeyword.getText();
             try (PreparedStatement pstmt = con.prepareStatement("{call SearchItem(?)}")) {
            pstmt.setString(1, keyWord);
            
            ResultSet rs=pstmt.executeQuery();
            model.setRowCount(0);
            while(rs.next()){
                String U=rs.getNString("ItemCode");
                String N=rs.getNString("ItemName");
                String E=rs.getNString("ItemDescription");
                
                String Em=rs.getString("CostPrice") ;//.getNString("CostPrice");
                String T=rs.getString("CostPrice") ;//getNString("SellingPrice");
                
                Boolean Nm= rs.getBoolean("VATInclusive");// getNString("VATInclusive");
                float Ek=rs.getFloat("VATValue");// getNString("VATValue");
                String Emm=rs.getNString("UOM");
              
                model.addRow(new Object[]{U, N,E,Em,T,Nm,Ek,Emm});
                
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

    private void txtKeywordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKeywordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKeywordActionPerformed

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
            java.util.logging.Logger.getLogger(ItemMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ItemMaster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNSearch;
    private javax.swing.JButton BTNUpdate;
    private javax.swing.JTextField ItemCode;
    private javax.swing.JTextField ItemCode1;
    private javax.swing.JTextField Itemdesc;
    private javax.swing.JTextField TXTUOM;
    public javax.swing.JTable TblItems;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtItemCostprice;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtKeyword;
    private javax.swing.JTextField txtSellingPrice;
    private javax.swing.JTextField txtVATValue;
    // End of variables declaration//GEN-END:variables
}