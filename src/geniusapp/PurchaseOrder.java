/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geniusapp;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eng.Joseph Gitahi
 */
public class PurchaseOrder {
        String POCode ;
	String Item ;
	String Supplier ;
	Double Qty ;
	Double UnitCost,VAT;
	Double LineTotal ;
	Date DeliverBy ;
static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
Constants _coConstants=new Constants();
    public PurchaseOrder() {
    }

    public Double getVAT() {
        return VAT;
    }

    public void setVAT(Double VAT) {
        this.VAT = VAT;
    }

    public String getPOCode() {
        return POCode;
    }

    public void setPOCode(String POCode) {
        this.POCode = POCode;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String Item) {
        this.Item = Item;
    }

    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String Supplier) {
        this.Supplier = Supplier;
    }

    public Double getQty() {
        return Qty;
    }

    public void setQty(Double Qty) {
        this.Qty = Qty;
    }

    public Double getUnitCost() {
        return UnitCost;
    }

    public void setUnitCost(Double UnitCost) {
        this.UnitCost = UnitCost;
    }

    public Double getLineTotal() {
        return LineTotal;
    }

    public void setLineTotal(Double LineTotal) {
        this.LineTotal = LineTotal;
    }

    public Date getDeliverBy() {
        return DeliverBy;
    }

    public void setDeliverBy(Date DeliverBy) {
        this.DeliverBy = DeliverBy;
    }

    public PurchaseOrder(String POCode, String Item, String Supplier, Double Qty, Double UnitCost, Double LineTotal, Date DeliverBy,Double VAT) {
        this.POCode = POCode;
        this.Item = Item;
        this.Supplier = Supplier;
        this.Qty = Qty;
        this.UnitCost = UnitCost;
        this.LineTotal = LineTotal;
        this.DeliverBy = DeliverBy;
        this.VAT=VAT;
    }
public boolean SavePurchaseOrder(){
      try {
           PreparedStatement pstmt = con.prepareStatement("{call SavePurchaseOrders(?,?,?,?,?,?,?,?,?,?)}");
 
                    pstmt.setString(1, Item);
                    pstmt.setString(2, Supplier);
                    pstmt.setDouble(3, Qty);
                    pstmt.setDouble(4, UnitCost);
                    pstmt.setDouble(5, LineTotal);
                    pstmt.setDate(6, DeliverBy);
                    pstmt.setString(7, _coConstants.getRegSource());
                    pstmt.setString(8, _coConstants.getUserId());
                    pstmt.setString(9, POCode);
                      pstmt.setDouble(10, VAT);
                  
                    pstmt.execute();
                    pstmt.close();
                   
                    System.out.println( "Saved Succesffuly" );
          return true;
      } catch (Exception e) {
           Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving Purchase Order");
            sec.setRegSource(_coConstants.getRegSource());
            sec.setUserID(_coConstants.getUserId());
            sec.SaveErrors();
          return false;
      }
  }
	//@RegSource nvarchar(300),
	//@UserID nvarchar(50)
    public List<PoItems>  PrintPO(){
       List<PoItems> Items=new ArrayList<PoItems>();
        try {
                
           PreparedStatement pst=con.prepareStatement("{call SelectPurchaseOrders(?,?,?)}");
              pst.setString(1, _coConstants.getPOCODE());
               pst.setString(2, _coConstants.getUserId());
                pst.setString(3, _coConstants.getRegSource());
              ResultSet rs=pst.executeQuery();
         
             while(rs.next()){
                  String SuppName=rs.getNString("suppFullnames");
                  String SuppEmail=rs.getNString("suppEmail");
                  String SuppPostal=rs.getNString("suppPostal");
                  String ShipToname=rs.getNString("ShipToname"); 
                  String ShipToEmail=rs.getNString("ShipToEmail");
                  String ShipToMobile=rs.getNString("ShipToMobile");
                  String ItemDesc=rs.getNString("ItemDesc");
                  String UOM=rs.getNString("UOM");
                  float Qty=rs.getFloat("Qty");
                  float VATValue=rs.getFloat("VATValue");
                  float UnitPrice=rs.getFloat("UnitCost");
                  float Tax=((VATValue*UnitPrice)/100)*Qty;
                  float LineTotal=rs.getFloat("LineTotal")+Tax;
                  Date DeliverBy=rs.getDate("DeliverBy");
           Items.add(new PoItems( SuppName,  SuppEmail,  SuppPostal,  ShipToname,  ShipToEmail, ShipToMobile, ItemDesc, Qty, UnitPrice, LineTotal,DeliverBy,Tax,UOM) );
            }
              rs.close();
                pst.close();
          return Items;
       
           
        } catch (Exception e) {
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving Purchase Order");
            sec.setRegSource(_coConstants.getRegSource());
            sec.setUserID(_coConstants.getUserId());
            sec.SaveErrors();
            return null;
        }
   }
}
