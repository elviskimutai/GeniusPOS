/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import geniusapp.Constants;
import geniusapp.SalesOrder;
import geniusapp.ItemCombo;
import geniusapp.PurchaseOrder;
import geniusapp.RepClass;
import geniusapp.SalesQuotation;
import geniusapp.Security;
import geniusapp.SqlConnection;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class SalesOrders extends javax.swing.JDialog {

     static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
     Constants _Constants=new Constants();
            
       List<ItemCombo> Items = null;
     
         DefaultTableModel model = new DefaultTableModel(new String[]{ "Item", "ItemName","Customer","UnitPrice","Quantity","VAT","CostOfGoods","TotalCost","Invoice DueDate"}, 0);
  
    public SalesOrders() {
        initComponents();
             setModal(true);
        setLocationRelativeTo(null);
        fillitems();
        fillCustomers();
        txtCumTotal.setEnabled(false); 
        txtCost.setEnabled(false); 
        POtable.setModel(model);
        POtable.getTableHeader().setReorderingAllowed(false);
        POCODE.setEnabled(false);
        GenerateSO();
         POtable.getTableHeader().setReorderingAllowed(false);
    }

    public void fillitems(){
    try {
           Statement pst=con.createStatement();
            ResultSet rs= pst.executeQuery("{call SelectAllItems}");
          
           jComItems.addItem("ItemCode   /  ItemName");
             while(rs.next()){
                  String id = rs.getString("ItemCode");
            String nme = rs.getString("ItemName");
            String cmb = (id+ "  /  "+nme);
                
                 //Items.add(1, new ItemCombo(rs.getString("ItemName"),rs.getString("ItemName")));
                jComItems.addItem(cmb);    
                 
            }
         
        rs.close();
     pst.close();
            
         
      
        } catch (Exception e) {
            e.printStackTrace();
             System.out.println( e.getMessage() );
             
        }
}
    public void GenerateSO(){
    try {
           Statement pst=con.createStatement();
            ResultSet rs= pst.executeQuery("{call GenerateSO}");
            while(rs.next()){
                  String id = rs.getString("POCode");
                  POCODE.setText(id);                 
            }
         rs.close();
         pst.close();
         } catch (Exception e) {
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Initializing Salesorder code");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
}
public void fillCustomers(){
    try {
           Statement pst=con.createStatement();
            ResultSet rs= pst.executeQuery("{call SelectAllCustomers}");
          
           jComSupliers.addItem("Default /  Default Customer");
             while(rs.next()){
                  String id = rs.getString("CustCode");
            String nme = rs.getString("FullNames");
            String cmb = (id+ "  /  "+nme);
                
                 //Items.add(1, new ItemCombo(rs.getString("ItemName"),rs.getString("ItemName")));
                jComSupliers.addItem(cmb);    
                 
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPrint = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        btnInvoice = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        txtItemCostprice = new javax.swing.JTextField();
        jComItems = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        BTNAddItem = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtCost = new javax.swing.JTextField();
        jComSupliers = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        DeliverDate = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        POtable = new javax.swing.JTable();
        txtCumTotal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        POCODE = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SALES ORDER WINDOW");

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Lease_20px.png"))); // NOI18N
        btnPrint.setText("Generate sales quote");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        jButtonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Trash_Can_35px.png"))); // NOI18N
        jButtonEdit.setText("Remove");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        btnInvoice.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Data_Recovery_35px.png"))); // NOI18N
        btnInvoice.setText("Invoice this order");
        btnInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInvoiceActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Sales Orders Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(51, 51, 255))); // NOI18N

        txtName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtName.setDisabledTextColor(new java.awt.Color(102, 102, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Item Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Quantity");

        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });

        txtItemCostprice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtItemCostprice.setDisabledTextColor(new java.awt.Color(51, 255, 51));

        jComItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComItemsActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Select Item");

        BTNAddItem.setText("ADD ITEM");
        BTNAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNAddItemActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Cumulative Cost");

        txtCost.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCost.setDisabledTextColor(new java.awt.Color(255, 51, 51));

        jComSupliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComSupliersActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Select Customer");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Unit price");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Invoice Due Date");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtQuantity)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtName)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComSupliers, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComItems, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCost)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                        .addComponent(txtItemCostprice)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DeliverDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(BTNAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComItems, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComSupliers, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtItemCostprice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeliverDate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTNAddItem)
                .addGap(29, 29, 29))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ITMES SELECTED", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(51, 51, 255))); // NOI18N

        POtable.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        POtable.setModel(new javax.swing.table.DefaultTableModel(
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
        POtable.setGridColor(new java.awt.Color(255, 255, 255));
        POtable.setRowHeight(24);
        POtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                POtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(POtable);

        txtCumTotal.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        txtCumTotal.setForeground(new java.awt.Color(0, 255, 204));
        txtCumTotal.setText("0");
        txtCumTotal.setSelectedTextColor(new java.awt.Color(204, 204, 255));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("Total Amount");

        jLabel1.setText("SALES ORDER CODE");

        POCODE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        POCODE.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(POCODE, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 244, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCumTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(POCODE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCumTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed

        try {

            int row = POtable.getSelectedRow();
            model.removeRow(row);
        } catch (Exception e) {
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Selecting Supplier");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_jButtonEditActionPerformed

    private static InputStream imageToInputStream(ImageIcon img) {
        try {
                BufferedImage bimage=new BufferedImage(img.getImage().getWidth(null),img.getImage().getHeight(null),BufferedImage.TYPE_INT_ARGB);
                Graphics2D bGr=bimage.createGraphics();
                bGr.drawImage(img.getImage(),0,0,null);
                bGr.dispose();
                BufferedImage bimg=bimage;
                ByteArrayOutputStream baos=new ByteArrayOutputStream();
                ImageIO.write(bimg,"png", baos);
                return new ByteArrayInputStream(baos.toByteArray());
                } catch (Exception e) {
                    return null;
                }
       }
   

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        try {
           
               int rows=POtable.getRowCount();
            for(int row = 0; row<rows; row++)
            {
                String SOCode = POCODE.getText();
                String Item = (String)POtable.getValueAt(row, 0);
                String ItemName = (String)POtable.getValueAt(row, 1);
                String Customer = (String)POtable.getValueAt(row, 2);
                Double UnitPrice = Double.parseDouble(String.valueOf(POtable.getValueAt(row, 3)));
                Double Qty = Double.parseDouble(String.valueOf(POtable.getValueAt(row, 4)));
                Double LineTotal = Double.parseDouble(String.valueOf(POtable.getValueAt(row, 7)));
                Double VAT = Double.parseDouble(String.valueOf(POtable.getValueAt(row, 5)));
                Double CostOfGoods = Double.parseDouble(String.valueOf(POtable.getValueAt(row, 6)));
                String Status="Sales Quotation";
                 Date DeliverBy= (Date)POtable.getValueAt(row, 8);
                _Constants.setPOCODE(SOCode);
                SalesOrder _SalesOrder=new SalesOrder(  SOCode,  Item,  Customer,  Qty,  UnitPrice,  VAT,  LineTotal,CostOfGoods,Status,DeliverBy);
                if(_SalesOrder.SaveSalesOrder()){

                }
            }
            
            model.setRowCount(0);
                  SalesOrder _SalesOrder=new SalesOrder();
             
                   List<Map<String,Object>> datasource=new ArrayList<Map< String,Object >>();
                             
            for (SalesQuotation _SalesQuotation : _SalesOrder.PrintSalesOrder()) {
                  Map<String,Object> row = new HashMap<String,Object>();
                String SOCode=_SalesQuotation.getSOCode() ;
                String Item =_SalesQuotation.getItem();
                String Customer=_SalesQuotation.getCustomer() ;
                Float Qty=_SalesQuotation.getQty() ;
                Float UnitPrice=_SalesQuotation.getUnitPrice();
                Float VAT=_SalesQuotation.getVAT();
                Float LineTotal=_SalesQuotation.getLineTotal();
                Float CostOfGoods =_SalesQuotation.getCostOfGoods();        
                String CustomerNames=_SalesQuotation.getCustomerNames();
                String CustomerEmail=_SalesQuotation.getCustomerEmail();
                String CustomerPostal=_SalesQuotation.getCustomerPostal();            
                String Comapny=_SalesQuotation.getComapny(); 
                String ComapnyEmail=_SalesQuotation.getComapnyEmail();
                String ComapnyMobile=_SalesQuotation.getComapnyMobile();
                String ItemDesc=_SalesQuotation.getItemDesc();
                String UOM=_SalesQuotation.getUOM(); 
               String ComapnyWebsite=_SalesQuotation.getComapnyWebsite();
                String CompanyPhysical=_SalesQuotation.getCompanyPhysical();
            
                row.put("SOCode", SOCode);
                row.put("Item", Item);
                row.put("Customer", Customer);
                row.put("Qty", Qty);
                row.put("UnitPrice", UnitPrice);
                row.put("VAT", VAT);
                row.put("LineTotal",LineTotal);
                row.put("CostOfGoods", CostOfGoods);
                row.put("CustomerNames", CustomerNames);
                row.put("CustomerEmail", CustomerEmail);
                row.put("CustomerPostal", CustomerPostal);
                row.put("Comapny",Comapny);
                row.put("ComapnyEmail",ComapnyEmail);
                row.put("image",imageToInputStream(new ImageIcon(PrintImage.class.getResource("/Forms/citimax14.png"))));
                row.put("ComapnyMobile",ComapnyMobile);
                row.put("ItemDesc",ItemDesc);
                row.put("UOM",UOM);
                 
                row.put("CompanyPhysical",CompanyPhysical);
                 row.put("ComapnyWebsite",ComapnyWebsite);
                row.put("Approver1","Kimutai Cheruiyot");
                row.put("Approver1Title","Sotware Engineer");
                datasource.add(row);
            
            }
            
            JRDataSource jrDataSource=new JRBeanCollectionDataSource(datasource) ;
            //JasperCompileManager _JasperCompileManager=new JasperCompileManager();
            JasperReport jasperReport = JasperCompileManager.compileReport("src\\reports\\SalesQuoterpt.jrxml");
            JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,null,jrDataSource);
            JasperViewer jasperViewer=new JasperViewer(jasperPrint);
            //   jasperViewer.setVisible(true);

            JDialog dialog = new JDialog(this);//the owner
            dialog.setContentPane(jasperViewer.getContentPane());
            dialog.setSize(jasperViewer.getSize());
            dialog.setTitle("SALES QUOTATION");
            //dialog.setIconImage(Toolkit.getDefaultToolkit().getImage(
                //getClass().getResource("URL IMG")));
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

       
        } catch (Exception e) {
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Initializing Sales Order Report");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvoiceActionPerformed
        try {

            int rows=POtable.getRowCount();
            for(int row = 0; row<rows; row++)
            {
                String SOCode = POCODE.getText();
                String Item = (String)POtable.getValueAt(row, 0);
                String ItemName = (String)POtable.getValueAt(row, 1);
                String Customer = (String)POtable.getValueAt(row, 2);
                Double UnitPrice = Double.parseDouble(String.valueOf(POtable.getValueAt(row, 3)));
                Double Qty = Double.parseDouble(String.valueOf(POtable.getValueAt(row, 4)));
                Double LineTotal = Double.parseDouble(String.valueOf(POtable.getValueAt(row, 7)));
                Double VAT = Double.parseDouble(String.valueOf(POtable.getValueAt(row, 5)));
                Double CostOfGoods = Double.parseDouble(String.valueOf(POtable.getValueAt(row, 6)));
                String Status="Customer Invoice";
                Date DeliverBy= (Date)POtable.getValueAt(row, 8);
                _Constants.setPOCODE(SOCode);
                
                SalesOrder _SalesOrder=new SalesOrder(  SOCode,  Item,  Customer,  Qty,  UnitPrice,  VAT,  LineTotal,CostOfGoods,Status,DeliverBy);
                if(_SalesOrder.SaveSalesOrder()){

                }
            }
            JOptionPane.showMessageDialog(null,"Sales Order Saved Successfully");
            model.setRowCount(0);
            
             SalesOrder _SalesOrder=new SalesOrder();
                   List<Map<String,Object>> datasource=new ArrayList<Map< String,Object >>();                
            for (SalesQuotation _SalesQuotation : _SalesOrder.PrintCustomerInvoice()) {
                Map<String,Object> row = new HashMap<String,Object>();
               
            String Item=_SalesQuotation.getItem();
            String Customer=_SalesQuotation.getCustomer(); 
            String InvoiceCode=_SalesQuotation.getInvoiceCode();
            Float Qty=_SalesQuotation.getQty(); 
            Float UnitPrice=_SalesQuotation.getUnitPrice();
            Float VAT=_SalesQuotation.getVAT();
            Float LineTotal=_SalesQuotation.getLineTotal();
            Float CostOfGoods=_SalesQuotation.getCostOfGoods();
            String CustomerNames=_SalesQuotation.getCustomerNames();
            String CustomerEmail=_SalesQuotation.getCustomerEmail();
            String CustomerPostal=_SalesQuotation.getCustomerPostal();
            String Comapny=_SalesQuotation.getComapny();
            String ComapnyEmail=_SalesQuotation.getComapnyEmail();
            String ComapnyWebsite=_SalesQuotation.getComapnyWebsite();
            String ComapnyMobile=_SalesQuotation.getComapnyMobile();
            String ItemDesc=_SalesQuotation.getItemDesc();
            String UOM=_SalesQuotation.getUOM();
            java.util.Date InvoiceDueDate=_SalesQuotation.getInvoiceDueDate();
            String CompanyPhysical=_SalesQuotation.getCompanyPhysical();
                                                

                row.put("Item", Item);
               // row.put("CustomerNames", Customer);
                row.put("Quantity", Qty);
                row.put("UnitCost", UnitPrice);
                row.put("VATValue", VAT);
                row.put("Total",LineTotal);
                row.put("CostOfGood", CostOfGoods);
                row.put("CustomerNames", CustomerNames);
                row.put("CustomerEmail", CustomerEmail);
                row.put("CustomerPostal", CustomerPostal);
                row.put("Comapny",Comapny);
                row.put("ComapnyEmail",ComapnyEmail);
                row.put("ComapnyWebsite",ComapnyWebsite);
                row.put("Image",imageToInputStream(new ImageIcon(PrintImage.class.getResource("/Forms/citimax14.png"))));
                row.put("ComapnyMobile",ComapnyMobile);
                row.put("ItemDesc",ItemDesc);
                row.put("UOM",UOM);  
                row.put("InvoiceDueDate",InvoiceDueDate);
                row.put("Invoicecode",InvoiceCode);
                row.put("CompanyPhysical",CompanyPhysical);
                datasource.add(row);
            
            }
            
            JRDataSource jrDataSource=new JRBeanCollectionDataSource(datasource) ;
            //JasperCompileManager _JasperCompileManager=new JasperCompileManager();
            JasperReport jasperReport = JasperCompileManager.compileReport("src\\reports\\CustomerInvoicerpt.jrxml");
            JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,null,jrDataSource);
            JasperViewer jasperViewer=new JasperViewer(jasperPrint);
            //   jasperViewer.setVisible(true);

            JDialog dialog = new JDialog(this);//the owner
            dialog.setContentPane(jasperViewer.getContentPane());
            dialog.setSize(jasperViewer.getSize());
            dialog.setTitle("CUSTOMER INVOICE");
            //dialog.setIconImage(Toolkit.getDefaultToolkit().getImage(
                //getClass().getResource("URL IMG")));
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        
        } catch (Exception e) {
            e.printStackTrace();
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Initializing Saving sales ordeers");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_btnInvoiceActionPerformed

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
        Double cost=Double.parseDouble(txtItemCostprice.getText());
        Double Qty=Double.parseDouble(txtQuantity.getText());
        txtCost.setText(Double.toString(cost*Qty));
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void jComItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComItemsActionPerformed
        // TODO add your handling code here:
        try {

            // String   Item=jComItems.getSelectedItem().toString();
            String   Item1=jComItems.getSelectedItem().toString();
            String[] parts = Item1.split("/");
            String Item = parts[0];
            PreparedStatement pst=con.prepareStatement("{call SelectItems(?)}");
            pst.setString(1, Item);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                // JOptionPane.showMessageDialog(null,rs.getNString("UserName"));
                txtName.setText(rs.getNString("ItemName"));
                txtName.setEnabled(false);
                txtItemCostprice.setText(rs.getString("SellingPrice"));
                txtItemCostprice.setEnabled(false);
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

    }//GEN-LAST:event_jComItemsActionPerformed

    private void BTNAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNAddItemActionPerformed
        // TODO add your handling code here:
        try {
            int rows=POtable.getRowCount();
            Double CostPrice ;
            Double Quantity;
            Double tax;
            Date DelDate=null;
           
            if(rows==0){
                String   Item1=jComItems.getSelectedItem().toString();
                String[] parts = Item1.split("/");
                String Item = parts[0];
                if(Item.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Enter Item  To Continue");
                    return;
                }
                String POCOD = POCODE.getText();
                if(POCOD.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Enter POCOD  To Continue");
                    return;
                }
                String   Suplier1=jComSupliers.getSelectedItem().toString();
                String[] SuplierList = Suplier1.split("/");
                String Suplier = SuplierList[0];

                if(Suplier.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Enter Customer  To Continue");
                    return;
                }
                String ItemName=txtName.getText();
                if(ItemName.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Enter ItemName  To Continue");
                    return;
                }
                String c=txtItemCostprice.getText();
                if(c.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Enter unitPrice  To Continue");
                    return;
                }else{
                    CostPrice =Double.parseDouble(c);
                }
                String q=txtQuantity.getText();
                if(q.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Enter Quantity  To Continue");
                    return;
                }else{
                    Quantity=Double.parseDouble(q);
                }
                 if (DeliverDate.getDate()!=null) {
                     DelDate=new java.sql.Date(DeliverDate.getDate().getTime());
                }else{
                    JOptionPane.showMessageDialog(null, "Select date!");
              return;
                }
                try {
                    PreparedStatement pst=con.prepareStatement("{call GetVATValue(?)}");
                    pst.setString(1, Item);
                    ResultSet rs=pst.executeQuery();
                    while(rs.next()){

                        float VATValue=rs.getFloat("VATValue");
                        tax=((VATValue*CostPrice)/100)*Quantity;

                        Double TotalCost=(CostPrice*Quantity);
                        Double CostOfGoods=TotalCost-tax;
                        
                       
                        model.addRow(new Object[]{Item, ItemName,Suplier,CostPrice,Quantity,tax,CostOfGoods,TotalCost,DelDate});
                        txtCumTotal.setText(Double.toString(Double.parseDouble(txtCumTotal.getText()) + TotalCost));
                    }
                    rs.close();
                    pst.close();
                } catch (Exception e) {
                    Security sec=new Security();
                    sec.setMessage(e.getMessage());
                    sec.setModule("Initializing Sales Order");
                    sec.setRegSource(_Constants.getRegSource());
                    sec.setUserID(_Constants.getUserId());
                    sec.SaveErrors();
                }
            }else{
                boolean alreadyadded=false;
                for(int row = 0; row<rows; row++){

                    String tableItem = (String)POtable.getValueAt(row, 0);
                    String   Item1=jComItems.getSelectedItem().toString();
                    String[] parts = Item1.split("/");
                    String Item = parts[0];
                    if (tableItem.equals(Item)){
                        alreadyadded=true;
                        break;
                    }else{
                        alreadyadded=false;
                    }
                }
                if(alreadyadded){
                    JOptionPane.showMessageDialog(null, "You have already added this item to the busket!");
                }
                else{
                    String   Item1=jComItems.getSelectedItem().toString();
                    String[] parts = Item1.split("/");
                    String Item = parts[0];
                    String POCOD = POCODE.getText();
                    String   Suplier1=jComSupliers.getSelectedItem().toString();
                    String[] SuplierList = Suplier1.split("/");
                    String Suplier = SuplierList[0];
                    // JOptionPane.showMessageDialog(null,rs.getNString("UserName"));
                    String ItemName=txtName.getText();

                    String c=txtItemCostprice.getText();
                    if(c.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Enter CostPrice  To Continue");
                        return;
                    }else{
                        CostPrice =Double.parseDouble(c);
                    }
                    String q=txtQuantity.getText();
                    if(q.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Enter Quantity  To Continue");
                        return;
                    }else{
                        Quantity=Double.parseDouble(q);
                    }
                       if (DeliverDate.getDate()!=null) {
                     DelDate=new java.sql.Date(DeliverDate.getDate().getTime());
                }else{
                    JOptionPane.showMessageDialog(null, "Select date!");
              return;
                }
                    try {
                        PreparedStatement pst=con.prepareStatement("{call GetVATValue(?)}");
                        pst.setString(1, Item);
                        ResultSet rs=pst.executeQuery();
                        while(rs.next()){

                            float VATValue=rs.getFloat("VATValue");
                            tax=((VATValue*CostPrice)/100)*Quantity;

                            Double TotalCost=(CostPrice*Quantity);
                             Double CostOfGoods=TotalCost-tax;
                             
                        model.addRow(new Object[]{Item, ItemName,Suplier,CostPrice,Quantity,tax,CostOfGoods,TotalCost,DelDate});
                        txtCumTotal.setText(Double.toString(Double.parseDouble(txtCumTotal.getText()) + TotalCost));
                         }
                        rs.close();
                        pst.close();
                    } catch (Exception e) {
                        Security sec=new Security();
                        sec.setMessage(e.getMessage());
                        sec.setModule("Initializing Customer invoicing");
                        sec.setRegSource(_Constants.getRegSource());
                        sec.setUserID(_Constants.getUserId());
                        sec.SaveErrors();
                    }
                }
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
    }//GEN-LAST:event_BTNAddItemActionPerformed

    private void jComSupliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComSupliersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComSupliersActionPerformed

    private void POtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_POtableMouseClicked
        // TODO add your handling code he
        // getRowValue();
    }//GEN-LAST:event_POtableMouseClicked

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
            java.util.logging.Logger.getLogger(SalesOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesOrders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNAddItem;
    private com.toedter.calendar.JDateChooser DeliverDate;
    private javax.swing.JTextField POCODE;
    public javax.swing.JTable POtable;
    private javax.swing.JButton btnInvoice;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JComboBox jComItems;
    private javax.swing.JComboBox jComSupliers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCost;
    private javax.swing.JTextField txtCumTotal;
    private javax.swing.JTextField txtItemCostprice;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
