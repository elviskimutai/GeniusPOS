/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import geniusapp.Constants;
import geniusapp.Security;
import geniusapp.SqlConnection;
import geniusapp.Supplier;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class CustomerPayments extends javax.swing.JDialog {

    static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
     Constants _Constants=new Constants();
      DefaultTableModel model = new DefaultTableModel(new String[]{ "DocNo", "Customer","InvoiceNo","PaymentDate","InvoiceAmount","AmountPaid","PayMode"}, 0);

    public CustomerPayments() {
        initComponents();
       fillCustomers();
       GeneratePAYCNO();
        addPaymodes();
          setModal(true);
        setLocationRelativeTo(null);
        inventoryReceipt.setModel(model);
        inventoryReceipt.setEnabled(false);
        inventoryReceipt.getTableHeader().setReorderingAllowed(false);
        jTextFieldDoCNo.setEditable(false);
        LoadcustomerPayments();
        loadInvoice();
    }
    public void fillCustomers(){
    try {
           Statement pst=con.createStatement();
            ResultSet rs= pst.executeQuery("{call SelectAllCustomers}");
          
        //   jComSupliers1.addItem("SuppCode   /  Suppliernames");
             while(rs.next()){
                  String id = rs.getString("CUSTCode");
            String nme = rs.getString("FullNames");
            String cmb = (id+ "  /  "+nme);
                
                 //Items.add(1, new ItemCombo(rs.getString("ItemName"),rs.getString("ItemName")));
                jComSupliers1.addItem(cmb);    
                 
            }
         
        rs.close();
     pst.close();
            
         
      
        } catch (Exception e) {
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Initializing Customers");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
}
public void addPaymodes(){
    jComPayMode.addItem("Cash at Hand");
    jComPayMode.addItem("Mpesa");
    jComPayMode.addItem("Bank");
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jCominvoices = new javax.swing.JComboBox();
        jComSupliers1 = new javax.swing.JComboBox();
        jTextFieldRemarks = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDOCType = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDoCNo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jComPayMode = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        AMNTPaid = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldInvoiceamnt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldbalance = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldAMNT = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventoryReceipt = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButtonSave = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnSearchu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CUSTOMER PAYMENTS");

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "SUPPLIER PAYMENTS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N
        jPanel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel11.setText("OPEN INVOICES");

        jLabel13.setText("Select Suplier");

        jCominvoices.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCominvoices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCominvoicesActionPerformed(evt);
            }
        });

        jComSupliers1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComSupliers1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComSupliers1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Remarks");

        jLabel2.setText("DOC Type");

        jTextFieldDOCType.setEditable(false);
        jTextFieldDOCType.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldDOCType.setForeground(new java.awt.Color(0, 0, 255));
        jTextFieldDOCType.setText("CUSTPYT");

        jLabel3.setText("PAYMENT CODE");

        jTextFieldDoCNo.setForeground(new java.awt.Color(0, 0, 255));

        jLabel12.setText("PAYMENT MODE");

        jComPayMode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComPayMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComPayModeActionPerformed(evt);
            }
        });

        jLabel4.setText("AMOUNT PAID");

        AMNTPaid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AMNTPaid.setForeground(new java.awt.Color(255, 51, 51));

        jLabel6.setText("INVOICE AMOUNT");

        jTextFieldInvoiceamnt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldInvoiceamnt.setForeground(new java.awt.Color(255, 51, 51));

        jLabel7.setText("BALANCE");

        jTextFieldbalance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldbalance.setForeground(new java.awt.Color(255, 51, 51));

        jLabel8.setText("AMOUNT");

        jTextFieldAMNT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldAMNT.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComSupliers1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComPayMode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldAMNT, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(jTextFieldInvoiceamnt, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AMNTPaid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCominvoices, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldDOCType)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldRemarks)
                    .addComponent(jTextFieldbalance)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldDoCNo)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(144, 144, 144))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComSupliers1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComPayMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldInvoiceamnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(3, 3, 3)
                        .addComponent(jTextFieldAMNT, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AMNTPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCominvoices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDOCType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDoCNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldbalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldRemarks, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        inventoryReceipt.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        inventoryReceipt.setModel(new javax.swing.table.DefaultTableModel(
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
        inventoryReceipt.setGridColor(new java.awt.Color(255, 255, 255));
        inventoryReceipt.setRowHeight(25);
        inventoryReceipt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inventoryReceiptKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(inventoryReceipt);

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jButtonSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Data_Recovery_35px.png"))); // NOI18N
        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        btnSearchu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Search_35px.png"))); // NOI18N
        btnSearchu.setText("Search");
        btnSearchu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearchu, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSearchu, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCominvoicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCominvoicesActionPerformed
        // TODO add your handling code here:
        try {
            GeneratePAYCNO();
            // String   Item=jComItems.getSelectedItem().toString();
            String   invoice=jCominvoices.getSelectedItem().toString();
            String[] parts = invoice.split("/");
            String inv = parts[0];

            String invamnt = parts[1];
            String amntpaid = parts[2];
            String bal = parts[3];
            String invdate = parts[4];
            AMNTPaid.setText(amntpaid);
            jTextFieldInvoiceamnt.setText(invamnt);
            jTextFieldbalance.setText(bal);
            AMNTPaid.setEditable(false);
            jTextFieldInvoiceamnt.setEditable(false);
            jTextFieldbalance.setEditable(false);
        } catch (Exception e) {
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Initializing PO");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_jCominvoicesActionPerformed
public void GeneratePAYCNO(){
    try {
        jTextFieldDoCNo.setText(null);
           Statement pst=con.createStatement();
            ResultSet rs= pst.executeQuery("{call GenerateCustomerPayNO}");
           
          
             while(rs.next()){
                  String id = rs.getString("DOCCode");
          jTextFieldDoCNo.setText(id);
                 
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
public void loadInvoice(){
         try {

            // String   Item=jComItems.getSelectedItem().toString();
            String   Supplier=jComSupliers1.getSelectedItem().toString();
            String[] parts = Supplier.split("/");
            String Item = parts[0];
            PreparedStatement pst=con.prepareStatement("{call spGetCustomerOpenInvoices(?)}");
            pst.setString(1, Item);
            ResultSet rs=pst.executeQuery();
            jCominvoices.removeAllItems();
            jCominvoices.addItem("Select Invoice(Invoice / Invoice Amount / AmountPaid / Balance / InvoiceDate)");
            while(rs.next()){
                // JOptionPane.showMessageDialog(null,rs.getNString("UserName"));
                String id = rs.getString("InvoiceNo");
                Double invoiceAmt = rs.getDouble("InvoiceAmount");
                Double amntpaid = rs.getDouble("AmountPaid");
                Date invdate = rs.getDate("InvoiceDate");
                Double bal = rs.getDouble("OpenAmount");

                String cmb = (id+ "/  "+invoiceAmt+" / "+amntpaid+" /  "+bal+" / "+invdate);

                //Items.add(1, new ItemCombo(rs.getString("ItemName"),rs.getString("ItemName")));
                jCominvoices.addItem(cmb);
            }

            rs.close();
            pst.close();
        } catch (Exception e) {
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Initializing PO");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
}
    private void jComSupliers1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComSupliers1ActionPerformed
loadInvoice();   
    }//GEN-LAST:event_jComSupliers1ActionPerformed

    private void jComPayModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComPayModeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComPayModeActionPerformed

    private void inventoryReceiptKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inventoryReceiptKeyPressed
        try {
            int columnTotal = 4;

            int row = inventoryReceipt.getSelectedRow();
            Double QTy=Double.parseDouble(inventoryReceipt.getModel().getValueAt(row, 2).toString());
            Double UnitCost=Double.parseDouble(inventoryReceipt.getModel().getValueAt(row, 3).toString());
            Double TotalCost=QTy*UnitCost;
            String s=TotalCost.toString();
            model.setValueAt(s, row, columnTotal);

            // POReTable.getModel().getValueAt(row_index, col_index);
        } catch (Exception e) {
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Selecting Supplier");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_inventoryReceiptKeyPressed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        try {

            String   Supplier=jComSupliers1.getSelectedItem().toString();
            String[] parts = Supplier.split("/");
            String Supp = parts[0];
            if(Supp.isEmpty()){
                JOptionPane.showMessageDialog(null,"Select Supplier  To Continue");
                return;
            }
            String   invoice=jCominvoices.getSelectedItem().toString();
            String[] parts2 = invoice.split("/");
            String inv = parts2[0];
            if(inv.isEmpty()){
                JOptionPane.showMessageDialog(null,"Select Invoice  To Continue");
                return;
            }
          //  Double invamnt = Double.parseDouble(String.valueOf(parts2[1]));
          //  Double amntpaid = Double.parseDouble(String.valueOf(parts2[2]));
          //  String bal = parts2[3];
           // Date invdate = Date.valueOf(parts2[4]);

            Double Amount=Double.parseDouble(String.valueOf(jTextFieldAMNT.getText()));

            Supplier _Supplier=new Supplier();
            _Supplier.setDocNo(jTextFieldDoCNo.getText());
            _Supplier.setDocType(jTextFieldDOCType.getText());
            _Supplier.setSuppCode(Supp);
            _Supplier.setInvoiceNumber(inv);
           // _Supplier.setInvoiceAmount(invamnt);
          //  _Supplier.setInvoiceDate(invdate);
            _Supplier.setAmount(Amount);
            _Supplier.setBatchNo(jTextFieldDoCNo.getText());
            _Supplier.setRefNo(jTextFieldDoCNo.getText());
            _Supplier.setPayMode(jComPayMode.getSelectedItem().toString());
            _Supplier.setBankAccount("0");
            String rem=jTextFieldRemarks.getText();
            if(rem.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter Remarks  To Continue");
                return;
            }
            _Supplier.setRemarks(rem);
            _Supplier.setPaymentStatus("Paid");
            if(_Supplier.SaveCustomerPayment()){
               JOptionPane.showMessageDialog(null,"Customer Payment Saved Successfully");
            LoadcustomerPayments();  
            }else{
                JOptionPane.showMessageDialog(null,"Customer Payment could not be saved.");
            }

           
        } catch (Exception e) {
            e.printStackTrace();
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Initializing Suppliers payments ");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void btnSearchuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchuActionPerformed
        SearchPayment(txtSearch.getText());
    }//GEN-LAST:event_btnSearchuActionPerformed
 public void SearchPayment(String Id){
    try {

                 PreparedStatement pstmt = con.prepareStatement("{call SearchCustomerPayments(?)}");
                  pstmt.setString(1, Id);
                  ResultSet rs=pstmt.executeQuery();
                   model.setRowCount(0);
                while(rs.next()){
                       String DocNo=rs.getNString("DocNo");
                String Supplier=rs.getNString("Customer");
                String PayMode=rs.getNString("PayMode");
                String InvoiceNo=rs.getNString("InvoiceNumber");
                Date PaymentDate=rs.getDate("PaymentDate");
                Double InvoiceAmount=rs.getDouble("InvoiceAmount");
                Double AmountPaid=rs.getDouble("Amount");
                 Double Balance=InvoiceAmount-AmountPaid;
 
                
                model.addRow(new Object[]{DocNo,Supplier, InvoiceNo,PaymentDate,InvoiceAmount,AmountPaid,Balance,PayMode});
                             
                 }
                rs.close();
                pstmt.close();
    } catch (Exception e) {
         Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Searching user");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
    }
}
    public void LoadcustomerPayments(){
        try {
            model.setRowCount(0);
           Statement pst=con.createStatement();
            ResultSet rs= pst.executeQuery("{call SelectAllCustomerPayments}");
            while(rs.next()){
                String DocNo=rs.getNString("DocNo");
                String Supplier=rs.getNString("Customer");
                String PayMode=rs.getNString("PayMode");
                String InvoiceNo=rs.getNString("InvoiceNumber");
                Date PaymentDate=rs.getDate("PaymentDate");
                Double InvoiceAmount=rs.getDouble("InvoiceAmount");
                Double AmountPaid=rs.getDouble("Amount");
                // Double Balance=InvoiceAmount-AmountPaid;
 
               // { "DocNo", "Customer","InvoiceNo","PaymentDate","InvoiceAmount","AmountPaid","Balance","PayMode"}, 0);
                model.addRow(new Object[]{DocNo,Supplier, InvoiceNo,PaymentDate,InvoiceAmount,AmountPaid,PayMode});
                              
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
            java.util.logging.Logger.getLogger(CustomerPayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerPayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerPayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerPayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerPayments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AMNTPaid;
    private javax.swing.JButton btnSearchu;
    public javax.swing.JTable inventoryReceipt;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox jComPayMode;
    private javax.swing.JComboBox jComSupliers1;
    private javax.swing.JComboBox jCominvoices;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldAMNT;
    private javax.swing.JTextField jTextFieldDOCType;
    private javax.swing.JTextField jTextFieldDoCNo;
    private javax.swing.JTextField jTextFieldInvoiceamnt;
    private javax.swing.JTextField jTextFieldRemarks;
    private javax.swing.JTextField jTextFieldbalance;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
