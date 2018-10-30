
package geniusapp;
    

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SalesOrder {
      String SOCode,  Item,  Customer,Status;
      Double Qty,  UnitPrice,  VAT,  LineTotal, CostOfGoods    ;             
       Date InvoiceDuedate;           
                  
                
	
static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
Constants _coConstants=new Constants(); 

    public Date getInvoiceDuedate() {
        return InvoiceDuedate;
    }

    public void setInvoiceDuedate(Date InvoiceDuedate) {
        this.InvoiceDuedate = InvoiceDuedate;
    }

   

    public Double getCostOfGoods() {
        return CostOfGoods;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setCostOfGoods(Double CostOfGoods) {
        this.CostOfGoods = CostOfGoods;
    }

    public String getSOCode() {
        return SOCode;
    }

    public void setSOCode(String SOCode) {
        this.SOCode = SOCode;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String Item) {
        this.Item = Item;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String Customer) {
        this.Customer = Customer;
    }

    public Double getQty() {
        return Qty;
    }

    public void setQty(Double Qty) {
        this.Qty = Qty;
    }

    public Double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(Double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public Double getVAT() {
        return VAT;
    }

    public void setVAT(Double VAT) {
        this.VAT = VAT;
    }

    public Double getLineTotal() {
        return LineTotal;
    }

    public void setLineTotal(Double LineTotal) {
        this.LineTotal = LineTotal;
    }

    public SalesOrder() {
    }
//
//    public SalesOrder(String SOCode, String Item, String Customer, Double Qty, Double UnitPrice, Double VAT, Double LineTotal, Double CostOfGoods, String CustomerNames, String CustomerEmail, String CustomerPostal, String Comapny, String ComapnyEmail, String ComapnyMobile, String ItemDesc, String UOM) {
//        this.SOCode = SOCode;
//        this.Item = Item;
//        this.Customer = Customer;
//        this.Qty = Qty;
//        this.UnitPrice = UnitPrice;
//        this.VAT = VAT;
//        this.LineTotal = LineTotal;
//        this.CostOfGoods = CostOfGoods;
//        this.CustomerNames = CustomerNames;
//        this.CustomerEmail = CustomerEmail;
//        this.CustomerPostal = CustomerPostal;
//        this.Comapny = Comapny;
//        this.ComapnyEmail = ComapnyEmail;
//        this.ComapnyMobile = ComapnyMobile;
//        this.ItemDesc = ItemDesc;
//        this.UOM = UOM;
//    }

    public SalesOrder(String SOCode, String Item, String Customer, Double Qty, Double UnitPrice, Double VAT, Double LineTotal,Double CostOfGoods,String Status,Date InvoiceDuedate) {
        this.SOCode = SOCode;
        this.Item = Item;
        this.Customer = Customer;
        this.Qty = Qty;
        this.UnitPrice = UnitPrice;
        this.VAT = VAT;
        this.LineTotal = LineTotal;
        this.CostOfGoods=CostOfGoods;
        this.Status=Status;
        this.InvoiceDuedate= InvoiceDuedate;
    }
     public  List<SalesQuotation>  PrintCustomerInvoice(){
       List<SalesQuotation> Items=new ArrayList<SalesQuotation>();
        try {
                 PreparedStatement pst=con.prepareStatement("{call SelectCustomerInvoicesrpt(?,?,?)}");
                 pst.setString(1, _coConstants.getPOCODE());
                 pst.setString(2, _coConstants.getUserId());
                 pst.setString(3, _coConstants.getRegSource());
                ResultSet rs=pst.executeQuery();
         
             while(rs.next()){
                  String SOCode=rs.getNString("InvoiceCode");
                  String Item=rs.getNString("Item");
                  String CustomerNames=rs.getNString("CustFullnames");
                  String CustomerEmail=rs.getNString("CustEmail");
                  String CustomerPostal=rs.getNString("CustPostal");
                  String Comapny=rs.getNString("Companyname"); 
                  String ComapnyEmail=rs.getNString("CompanyEmail");
                  String ComapnyMobile=rs.getNString("CompanyMobile");
                  String ItemDesc=rs.getNString("ItemDesc");
                  String UOM=rs.getNString("UOM");
                  float Quantity=rs.getFloat("Qty");
                  float VATValue=rs.getFloat("VATValue");
                  float UnitCost=rs.getFloat("UnitCost");
                  float CostOfGood=rs.getFloat("CostOfGoods");
                  float Total=rs.getFloat("LineTotal");
                  Date InvoiceDueDate=rs.getDate("InvoicedueDate");
                   String InvoiceCode=rs.getNString("InvoiceCode");
                 String ComapnyWebsite=rs.getNString("CompanyWebsite");
                String CompanyPhysical=rs.getNString("CompanyPhysical");
//                          String Customer; String InvoiceCode, Float Qty, Float UnitPrice, Float VAT, Float LineTotal, Float CostOfGoods, String CustomerNames, String CustomerEmail, String CustomerPostal, String Comapny, String ComapnyEmail, String ComapnyWebsite, String ComapnyMobile, String ItemDesc, String UOM, InputStream image, Date InvoiceDueDate
              
                   Items.add(new SalesQuotation(  SOCode,  Item,  CustomerNames,  InvoiceCode,  Quantity,  UnitCost,  VATValue,  Total,  CostOfGood,  CustomerNames,  CustomerEmail,  CustomerPostal,  Comapny,  ComapnyEmail,  ComapnyWebsite,  ComapnyMobile,  ItemDesc,  UOM,  InvoiceDueDate,CompanyPhysical) );
          
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
     public  List<SalesQuotation>  PrintSalesOrder(){
       List<SalesQuotation> Items=new ArrayList<SalesQuotation>();
        try {
                 PreparedStatement pst=con.prepareStatement("{call SelectSalesOrders(?,?,?)}");
                pst.setString(1, _coConstants.getPOCODE());
                pst.setString(2, _coConstants.getUserId());
                pst.setString(3, _coConstants.getRegSource());
              ResultSet rs=pst.executeQuery();
         
             while(rs.next()){
                 String orderCode=rs.getNString("POCode");
                  String Item=rs.getNString("Item");
                  String CustomerNames=rs.getNString("CustFullnames");
                  String CustomerEmail=rs.getNString("CustEmail");
                  String CustomerPostal=rs.getNString("CustPostal");
                  String Comapny=rs.getNString("Companyname"); 
                  String ComapnyEmail=rs.getNString("CompanyEmail");
                  String ComapnyMobile=rs.getNString("CompanyMobile");
                  String ItemDesc=rs.getNString("ItemDesc");
                  String UOM=rs.getNString("UOM");
                  float Quantity=rs.getFloat("Qty");
                  float VATValue=rs.getFloat("VATValue");
                  float UnitCost=rs.getFloat("UnitCost");
                  float CostOfGood=rs.getFloat("CostOfGoods");
                  float Total=rs.getFloat("LineTotal");
                  
                 Date InvoiceDueDate=rs.getDate("InvoicedueDate");
                   String InvoiceCode="Invoice Code";
                 String ComapnyWebsite=rs.getNString("CompanyWebsite");
                String CompanyPhysical=rs.getNString("CompanyPhysical");
                   Items.add(new SalesQuotation(  orderCode,  Item,  CustomerNames,  InvoiceCode,  Quantity,  UnitCost,  VATValue,  Total,  CostOfGood,  CustomerNames,  CustomerEmail,  CustomerPostal,  Comapny,  ComapnyEmail,  ComapnyWebsite,  ComapnyMobile,  ItemDesc,  UOM,  InvoiceDueDate,CompanyPhysical) );
          
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
public boolean SaveSalesOrder(){
      try {
           PreparedStatement pstmt = con.prepareStatement("{call SaveSalesOrders(?,?,?,?,?,?,?,?,?,?,?,?)}");
 
                    pstmt.setString(1, Item);
                    pstmt.setString(2, Customer);
                    pstmt.setDouble(3, Qty);
                    pstmt.setDouble(4, UnitPrice);
                    pstmt.setDouble(5, LineTotal);                    
                    pstmt.setString(6, _coConstants.getRegSource());
                    pstmt.setString(7, _coConstants.getUserId());
                    pstmt.setString(8, SOCode);
                    pstmt.setDouble(9, VAT);
                    pstmt.setDouble(10, CostOfGoods);
                     pstmt.setString(11, Status);
                     pstmt.setDate(12, InvoiceDuedate);
                    pstmt.execute();
                    pstmt.close();
                    return true;
      } catch (Exception e) {
           Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving Sales Order");
            sec.setRegSource(_coConstants.getRegSource());
            sec.setUserID(_coConstants.getUserId());
            sec.SaveErrors();
          return false;
      }
  }
}
