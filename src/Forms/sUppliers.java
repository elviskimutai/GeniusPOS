
package Forms;

import geniusapp.*;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class sUppliers extends javax.swing.JDialog {

    /**
     * Creates new form sUppliers
     */
   public String RegSource,UserID;
   static SqlConnection _SqlConnection =new SqlConnection();
        Connection con=_SqlConnection.connect();  
        DefaultTableModel model = new DefaultTableModel(new String[]{ "SuppCode", "Suppliernames","PostalAdress","PhysicalAdress","Mobile","Email","Telephone","Fax","IsActive"}, 0);
        Constants _Constants=new Constants();
        public String SuppCode;
    public sUppliers() {
        initComponents();
        LoadSupliers();
        setModal(true);
        setLocationRelativeTo(null);
         SuppliersTable.setModel(model);
        GenerateSUPCODE();
        txtSUPCODE.setEditable(false); 
        
    }
public void GenerateSUPCODE(){
    try {
           Statement pst=con.createStatement();
            ResultSet rs= pst.executeQuery("{call GenerateSuppCode}");
          
          
             while(rs.next()){
                  String id = rs.getString("SuppCode");
          txtSUPCODE.setText(id);
                 
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
}
public void LoadSupliers(){
        try {
            model.setRowCount(0);
           Statement pst=con.createStatement();
            ResultSet rs= pst.executeQuery("{call SelectAllSuppliers}");
            while(rs.next()){
                String SuppCode=rs.getNString("SuppCode");
                String Suppliernames=rs.getNString("Suppliernames");
                String PostalAdress=rs.getNString("PostalAdress");
                String PhysicalAdress=rs.getNString("PhysicalAdress");
                String Mobile=rs.getNString("Mobile");
                
                String Email=rs.getNString("Email");
                
                String Telephone=rs.getNString("Telephone");
                
                String Fax=rs.getNString("Fax");
                 Boolean IsActive = rs.getBoolean("IsActive") ;
                
                model.addRow(new Object[]{SuppCode, Suppliernames,PostalAdress,PhysicalAdress,Mobile,Email,Telephone,Fax,IsActive});
                              
            }
          
            rs.close();
            pst.close();
            
           // UsersTable.setModel(DbUtils.resultSetToTableModel(rs));
      
        } catch (Exception e) {
              Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Load fields Suppliers");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
             
        }
    }
public void getRowValue(){
    try {
        int column = 0;
        int row = SuppliersTable.getSelectedRow();
        String S = SuppliersTable.getModel().getValueAt(row, column).toString();
        SuppCode=S;
        txtSUPCODE.setText(S);
        fillFiields(S);
    } catch (Exception e) {
        Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Selecting Supplier");
            sec.setRegSource(RegSource);
            sec.setUserID(UserID);
            sec.SaveErrors();
    }
}
public void DisableFields(){
            txtSuppName.setEditable(false); 
            txtPostal.setEditable(false); 
            txtPhysical.setEditable(false); 
            txtMobile.setEditable(false); 
            txtEmail.setEditable(false); 
            txtTelephone.setEditable(false); 
            txtFax.setEditable(false); 
            jCheckIsActive.setEnabled(false); 
}
public void EnableFields(){
            txtSuppName.setEditable(true); 
            txtPostal.setEditable(true); 
            txtPhysical.setEditable(true); 
            txtMobile.setEditable(true); 
            txtEmail.setEditable(true); 
            txtTelephone.setEditable(true); 
            txtFax.setEditable(true); 
            jCheckIsActive.setEnabled(true);
}
public void fillFiields(String SuppCode){
    try {
//             Statement pst=con.createStatement();
//                ResultSet rs= pst.executeQuery("{call SelectUser}");
                 PreparedStatement pstmt = con.prepareStatement("{call SelectSuppliers(?,?,?)}");
                pstmt.setString(1, SuppCode);
                pstmt.setString(2, UserID);
                pstmt.setString(3, RegSource);
                ResultSet rs=pstmt.executeQuery();
                while(rs.next()){
                    // JOptionPane.showMessageDialog(null,rs.getNString("UserName"));
            txtSuppName.setText(rs.getNString("FullNames"));
            txtPostal.setText(rs.getNString("PostalAdress"));
            txtPhysical.setText(rs.getNString("PhysicalAdress"));
            txtMobile.setText(rs.getNString("Mobile"));
            txtEmail.setText(rs.getNString("Email"));
            txtTelephone.setText(rs.getNString("Telephone"));
            txtFax.setText(rs.getNString("Fax"));
            jCheckIsActive.setSelected(rs.getBoolean("isActive"));
                            
            }
               DisableFields();
               pstmt.close();
               
               
    } catch (Exception e) {
             Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Filling Fields Suppliers");
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
        jPanel3 = new javax.swing.JPanel();
        txtFax = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTelephone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMobile = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPostal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSuppName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPhysical = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jCheckIsActive = new javax.swing.JCheckBox();
        txtSUPCODE = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SuppliersTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtKeyword = new javax.swing.JTextField();
        jButtonEdit = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DEFINE NEW SUPPLIER");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "ADD NEW SUPPLIER HERE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel10.setText("Fax");

        jLabel6.setText("Telephone");

        jLabel4.setText("Mobile");

        jLabel1.setText("PostalAdress ");

        jLabel2.setText("Suppier Names");

        txtSuppName.setMinimumSize(new java.awt.Dimension(7, 22));

        jLabel3.setText("PhysicalAdress ");

        jLabel5.setText("Email");

        jCheckIsActive.setText("Is Active");
        jCheckIsActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckIsActiveActionPerformed(evt);
            }
        });

        jLabel7.setText("Supplier Id");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSuppName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhysical, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFax, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(214, 214, 214)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSUPCODE, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtMobile, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPostal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jCheckIsActive, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTelephone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSuppName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhysical, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jCheckIsActive))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFax, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSUPCODE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SuppliersTable.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        SuppliersTable.setModel(new javax.swing.table.DefaultTableModel(
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
        SuppliersTable.setGridColor(new java.awt.Color(0, 0, 0));
        SuppliersTable.setOpaque(false);
        SuppliersTable.setRowHeight(24);
        SuppliersTable.setSelectionBackground(new java.awt.Color(204, 204, 255));
        SuppliersTable.setShowHorizontalLines(false);
        SuppliersTable.setShowVerticalLines(false);
        SuppliersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SuppliersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(SuppliersTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jButtonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Compose_35px.png"))); // NOI18N
        jButtonEdit.setText("Edit");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Trash_Can_35px.png"))); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Data_Recovery_35px.png"))); // NOI18N
        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Search_35px.png"))); // NOI18N
        btnSearch.setText("Seach");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonEdit)
                        .addComponent(jButtonDelete)
                        .addComponent(jButtonSave)))
                .addGap(725, 725, 725))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckIsActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckIsActiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckIsActiveActionPerformed

    private void SuppliersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SuppliersTableMouseClicked
        getRowValue();
        
    }//GEN-LAST:event_SuppliersTableMouseClicked

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
        EnableFields();
        
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
         try {
            String FullNames,PostalAdress,PhysicalAdress,Mobile,Email,Telephone,Fax;           
            Boolean IsActive;
            String SuppCode=txtSUPCODE.getText();
             if(SuppCode.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter SuppCode  To Continue");
                return;
            }
            FullNames=txtSuppName.getText();
             if(FullNames.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter FullNames  To Continue");
                return;
            }
            PostalAdress=txtPostal.getText();
            if(PostalAdress.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter PostalAdress  To Continue");
                return;
            }
            PhysicalAdress=txtPhysical.getText();
            if(PhysicalAdress.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter PhysicalAdress  To Continue");
                return;
            }
            Mobile=txtMobile.getText();
            if(Mobile.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter Mobile  To Continue");
                return;
            }
            Email=txtEmail.getText();
            if(Email.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter Email  To Continue");
                return;
            }
            Telephone=txtTelephone.getText();
             if(Telephone.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter Telephone  To Continue");
                return;
            }
            Fax=txtFax.getText();
             if(Fax.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter Fax  To Continue");
                return;
            }
            
            IsActive=jCheckIsActive.isSelected();
            //model.addRow(new Object[]{SuppCode, FullNames,PostalAdress,PhysicalAdress,Mobile,Email,Telephone,Fax,IsActive});
                
            Supplier _Supplier=new Supplier( SuppCode,FullNames,  PostalAdress,  PhysicalAdress,  Mobile,  _Constants.getRegSource(),  _Constants.getUserId(),  Email,  Telephone,  Fax,  IsActive);
            if(_Supplier.SaveSupplier()){
                JOptionPane.showMessageDialog(null,"Supllier Saved Successfully");
                LoadSupliers();
                GenerateSUPCODE();
            }
            else{
            JOptionPane.showMessageDialog(null,"Supllier Could Not Be Saved ");
        }
        } catch (Exception e) {
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving Suppliers");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        try {
            
            Supplier _Supplier=new Supplier();
             _Supplier.setSuppCode(txtSUPCODE.getText());
            if(_Supplier.DeleteSupplier()){
                JOptionPane.showMessageDialog(null,"Supplier Deleted Successfully");
                 LoadSupliers();
            }
        } catch (Exception e) {
             Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Deleting Items");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
             String keyWord=txtKeyword.getText();
             try (PreparedStatement pstmt = con.prepareStatement("{call SearchSuppliers(?)}")) {
            pstmt.setString(1, keyWord);
            
            ResultSet rs=pstmt.executeQuery();
            model.setRowCount(0);
            while(rs.next()){
                String SuppCode=rs.getNString("SuppCode");
                String Suppliernames=rs.getNString("Suppliernames");
                String PostalAdress=rs.getNString("PostalAdress");
                String PhysicalAdress=rs.getNString("PhysicalAdress");
                String Mobile=rs.getNString("Mobile");
                
                String Email=rs.getNString("Email");
                
                String Telephone=rs.getNString("Telephone");
                
                String Fax=rs.getNString("Fax");
                 Boolean IsActive = rs.getBoolean("IsActive") ;
                
                model.addRow(new Object[]{SuppCode, Suppliernames,PostalAdress,PhysicalAdress,Mobile,Email,Telephone,Fax,IsActive});
                  
                
            }
            pstmt.close();
           
        }                   
                    
        } catch (Exception e) {
            e.printStackTrace();
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Initializing Suppliers");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
             
        }
    }//GEN-LAST:event_btnSearchActionPerformed

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
            java.util.logging.Logger.getLogger(sUppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sUppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sUppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sUppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sUppliers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable SuppliersTable;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JCheckBox jCheckIsActive;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFax;
    private javax.swing.JTextField txtKeyword;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtPhysical;
    private javax.swing.JTextField txtPostal;
    private javax.swing.JTextField txtSUPCODE;
    private javax.swing.JTextField txtSuppName;
    private javax.swing.JTextField txtTelephone;
    // End of variables declaration//GEN-END:variables
}
