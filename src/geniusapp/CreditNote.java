
package geniusapp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author Eng.Joseph Gitahi
 */
public class CreditNote {
    	String DocNo ,DocType,InvoiceNo,ItemCode,SuppCode,Remarks;
	Date DocDate ,InvoiceDate;	
	float Qty ;
	Double UnitCost ,ExtendedCost ;
static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
     Constants _Contants=new Constants();
    public String getDocNo() {
        return DocNo;
    }

    public void setDocNo(String DocNo) {
        this.DocNo = DocNo;
    }

    public String getDocType() {
        return DocType;
    }

    public void setDocType(String DocType) {
        this.DocType = DocType;
    }

    public String getInvoiceNo() {
        return InvoiceNo;
    }

    public void setInvoiceNo(String InvoiceNo) {
        this.InvoiceNo = InvoiceNo;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String ItemCode) {
        this.ItemCode = ItemCode;
    }

    public String getSuppCode() {
        return SuppCode;
    }

    public void setSuppCode(String SuppCode) {
        this.SuppCode = SuppCode;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String Remarks) {
        this.Remarks = Remarks;
    }

    public Date getDocDate() {
        return DocDate;
    }

    public void setDocDate(Date DocDate) {
        this.DocDate = DocDate;
    }

    public Date getInvoiceDate() {
        return InvoiceDate;
    }

    public void setInvoiceDate(Date InvoiceDate) {
        this.InvoiceDate = InvoiceDate;
    }

    public float getQty() {
        return Qty;
    }

    public void setQty(float Qty) {
        this.Qty = Qty;
    }

    public Double getUnitCost() {
        return UnitCost;
    }

    public void setUnitCost(Double UnitCost) {
        this.UnitCost = UnitCost;
    }

    public Double getExtendedCost() {
        return ExtendedCost;
    }

    public void setExtendedCost(Double ExtendedCost) {
        this.ExtendedCost = ExtendedCost;
    }

    public CreditNote() {
    }

    public CreditNote(String DocNo, String DocType, String InvoiceNo, String ItemCode, String SuppCode, String Remarks, Date DocDate, Date InvoiceDate, float Qty, Double UnitCost, Double ExtendedCost) {
        this.DocNo = DocNo;
        this.DocType = DocType;
        this.InvoiceNo = InvoiceNo;
        this.ItemCode = ItemCode;
        this.SuppCode = SuppCode;
        this.Remarks = Remarks;
        this.DocDate = DocDate;
        this.InvoiceDate = InvoiceDate;
        this.Qty = Qty;
        this.UnitCost = UnitCost;
        this.ExtendedCost = ExtendedCost;
    }
	 public boolean DeleteSupplierCreditNote(){
      try {
           PreparedStatement pstmt = con.prepareStatement("{call DeleteSuppliers(?,?,?)}");
   
                    pstmt.setString(1, this.getSuppCode());                    
                    pstmt.setString(2, _Contants.getUserId());
                    pstmt.setString(3, _Contants.getRegSource());
                    
                  
                    pstmt.execute();
                    pstmt.close();
                   
          return true;
      } catch (Exception e) {
           Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Deleting Suppliers");
            sec.setRegSource(_Contants.getRegSource());
            sec.setUserID(_Contants.getUserId());
            sec.SaveErrors();
          return false;
      }
  }
     public boolean SaveSupplierCreditNote(){
           try {
           PreparedStatement pstmt = con.prepareStatement("{call SaveSupplierCreditNotes(?,?,?,?,?,?,?,?,?,?,?,?,?)}");

                    pstmt.setString(1, getDocNo());
                    pstmt.setString(2, getDocType());
                    pstmt.setDate(3, getDocDate());
                    pstmt.setString(4, getInvoiceNo());
                    pstmt.setDate(5, getInvoiceDate());
                    pstmt.setString(6, getItemCode());
                    
                    pstmt.setFloat(7, getQty());
                    pstmt.setDouble(8, getUnitCost());
                    pstmt.setDouble(9, getExtendedCost());
                    pstmt.setString(10, getSuppCode());
                     pstmt.setString(11, getRemarks());
                 
                  pstmt.setString(12, _Contants.getRegSource());
                  pstmt.setString(13, _Contants.getUserId());
                    pstmt.execute();
                    pstmt.close();
                   
              
          return true;
      } catch (Exception e) {
           Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving Suppliers CreditNotes");
            sec.setRegSource(_Contants.getRegSource());
            sec.setUserID(_Contants.getUserId());
            sec.SaveErrors();
                return false;
            }
      }   
}
