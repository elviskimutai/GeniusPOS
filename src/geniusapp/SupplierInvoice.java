/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geniusapp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author Eng.Joseph Gitahi
 */
public class SupplierInvoice {
    	public String Remarks,Status,ItemCode,DocNo ,DocType ,Supplier ,Ledger ,PONumber ,InvoiceNo ,PaymentTerms ;
	Date InvoiceDate,DueDate ;	
	float Qty,VAT ;

    public float getVAT() {
        return VAT;
    }

    public void setVAT(float VAT) {
        this.VAT = VAT;
    }
	Double UnitCost ,ExtendedCost ;
static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
     Constants _Constants=new Constants();
    public SupplierInvoice() {
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String Remarks) {
        this.Remarks = Remarks;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String ItemCode) {
        this.ItemCode = ItemCode;
    }

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

    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String Supplier) {
        this.Supplier = Supplier;
    }

    public String getLedger() {
        return Ledger;
    }

    public void setLedger(String Ledger) {
        this.Ledger = Ledger;
    }

    public String getPONumber() {
        return PONumber;
    }

    public void setPONumber(String PONumber) {
        this.PONumber = PONumber;
    }

    public String getInvoiceNo() {
        return InvoiceNo;
    }

    public void setInvoiceNo(String InvoiceNo) {
        this.InvoiceNo = InvoiceNo;
    }

    public String getPaymentTerms() {
        return PaymentTerms;
    }

    public void setPaymentTerms(String PaymentTerms) {
        this.PaymentTerms = PaymentTerms;
    }

    public Date getInvoiceDate() {
        return InvoiceDate;
    }

    public void setInvoiceDate(Date InvoiceDate) {
        this.InvoiceDate = InvoiceDate;
    }

    public Date getDueDate() {
        return DueDate;
    }

    public void setDueDate(Date DueDate) {
        this.DueDate = DueDate;
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

    public SupplierInvoice(String Remarks, String Status, String ItemCode, String DocNo, String DocType, String Supplier, String Ledger, String PONumber, String InvoiceNo, String PaymentTerms, Date InvoiceDate, Date DueDate, float Qty, Double UnitCost, Double ExtendedCost,float VAT) {
        this.Remarks = Remarks;
        this.Status = Status;
        this.ItemCode = ItemCode;
        this.DocNo = DocNo;
        this.DocType = DocType;
        this.Supplier = Supplier;
        this.Ledger = Ledger;
        this.PONumber = PONumber;
        this.InvoiceNo = InvoiceNo;
        this.PaymentTerms = PaymentTerms;
        this.InvoiceDate = InvoiceDate;
        this.DueDate = DueDate;
        this.Qty = Qty;
        this.UnitCost = UnitCost;
        this.ExtendedCost = ExtendedCost;
        this.VAT=VAT;
    }
	public boolean SaveSupplierInvoices(){
      try {
           PreparedStatement pstmt = con.prepareStatement("{call SaveSupplierInvoices(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
 	
                    pstmt.setString(1, DocNo);
                    pstmt.setString(2, DocType);
                    pstmt.setString(3, Supplier);
                    pstmt.setString(4, Ledger);
                    pstmt.setString(5, PONumber);
                    pstmt.setString(6, InvoiceNo);
                    pstmt.setString(7, PaymentTerms);
                    pstmt.setDate(8, InvoiceDate);
                    pstmt.setDate(9, DueDate);
                    pstmt.setString(10, ItemCode);
                    pstmt.setFloat(11, Qty);
                    pstmt.setDouble(12, UnitCost);
                    pstmt.setDouble(13, ExtendedCost);
                    pstmt.setString(14, Remarks);
                    pstmt.setString(15, Status);
                    pstmt.setString(16, _Constants.getRegSource());
                    pstmt.setString(17, _Constants.getUserId());
                    pstmt.setFloat(18, VAT);
                  
                    pstmt.execute();
                    pstmt.close();
                   
                   
          return true;
      } catch (Exception e) {
           Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving SaveSupplierInvoices");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
          return false;
      }
  }
}
