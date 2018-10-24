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
public class Supplier {
   public String SuppCode, FullNames,PostalAdress,PhysicalAdress,Mobile,RegSource,UserID,Email,Telephone,Fax;
           
         public   Boolean IsActive;
         
        String DocNo ,DocType ,InvoiceNumber,BatchNo,RefNo,PayMode,BankAccount,PaymentStatus,Remarks;
	 int LineNumber;
	
	Double InvoiceAmount ,Amount;
	Date InvoiceDate ,PaymentDate ;

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

    public String getInvoiceNumber() {
        return InvoiceNumber;
    }

    public void setInvoiceNumber(String InvoiceNumber) {
        this.InvoiceNumber = InvoiceNumber;
    }

    public String getBatchNo() {
        return BatchNo;
    }

    public void setBatchNo(String BatchNo) {
        this.BatchNo = BatchNo;
    }

    public String getRefNo() {
        return RefNo;
    }

    public void setRefNo(String RefNo) {
        this.RefNo = RefNo;
    }

    public String getPayMode() {
        return PayMode;
    }

    public void setPayMode(String PayMode) {
        this.PayMode = PayMode;
    }

    public String getBankAccount() {
        return BankAccount;
    }

    public void setBankAccount(String BankAccount) {
        this.BankAccount = BankAccount;
    }

    public String getPaymentStatus() {
        return PaymentStatus;
    }

    public void setPaymentStatus(String PaymentStatus) {
        this.PaymentStatus = PaymentStatus;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String Remarks) {
        this.Remarks = Remarks;
    }

    public Double getInvoiceAmount() {
        return InvoiceAmount;
    }

    public void setInvoiceAmount(Double InvoiceAmount) {
        this.InvoiceAmount = InvoiceAmount;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double Amount) {
        this.Amount = Amount;
    }

    public Date getInvoiceDate() {
        return InvoiceDate;
    }

    public void setInvoiceDate(Date InvoiceDate) {
        this.InvoiceDate = InvoiceDate;
    }
	
	
        
static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
     Constants _Contants=new Constants();
    public Supplier(String SuppCode,String FullNames, String PostalAdress, String PhysicalAdress, String Mobile, String RegSource, String UserID, String Email, String Telephone, String Fax, Boolean IsActive) {
       this.SuppCode=SuppCode;
        this.FullNames = FullNames;
        this.PostalAdress = PostalAdress;
        this.PhysicalAdress = PhysicalAdress;
        this.Mobile = Mobile;
        this.RegSource = RegSource;
        this.UserID = UserID;
        this.Email = Email;
        this.Telephone = Telephone;
        this.Fax = Fax;
        this.IsActive = IsActive;
    }

    

    public Supplier() {
    }
    public String getSuppCode() {
        return SuppCode;
    }
    public void setSuppCode(String SuppCode) {
        this.SuppCode = SuppCode;
    }
    public void setFullNames(String FullNames) {
        this.FullNames = FullNames;
    }
      public String getFullNames() {
        return FullNames;
    }
    public String getPostalAdress() {
        return PostalAdress;
    }

    public void setPostalAdress(String PostalAdress) {
        this.PostalAdress = PostalAdress;
    }

    public String getPhysicalAdress() {
        return PhysicalAdress;
    }

    public void setPhysicalAdress(String PhysicalAdress) {
        this.PhysicalAdress = PhysicalAdress;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getRegSource() {
        return RegSource;
    }

    public void setRegSource(String RegSource) {
        this.RegSource = RegSource;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }

    public Boolean getIsActive() {
        return IsActive;
    }

    public void setIsActive(Boolean IsActive) {
        this.IsActive = IsActive;
    }
    public boolean DeleteSupplier(){
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
            sec.setRegSource(RegSource);
            sec.setUserID(UserID);
            sec.SaveErrors();
          return false;
      }
  }
     public boolean SaveSupplierPayment(){
           try {
           PreparedStatement pstmt = con.prepareStatement("{call SaveSupplierPayments(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
 
                    pstmt.setString(1, getDocNo());
                    pstmt.setString(2, getDocType());
                    pstmt.setString(3, getSuppCode());
                    pstmt.setString(4, getInvoiceNumber());
                    pstmt.setDouble(5, getInvoiceAmount());
                    pstmt.setDate(6, getInvoiceDate());
                    pstmt.setDouble(7, getAmount());
                    pstmt.setString(8, getBatchNo());
                    pstmt.setString(9, getRefNo());
                    pstmt.setString(10, getPayMode());
                     pstmt.setString(11, getBankAccount());
                  pstmt.setString(12, getRemarks());
                  pstmt.setString(13, getPaymentStatus());
                  pstmt.setString(14, _Contants.getRegSource());
                  pstmt.setString(15, _Contants.getUserId());
                    pstmt.execute();
                    pstmt.close();
                   
              
          return true;
      } catch (Exception e) {
           Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving Suppliers Payments");
            sec.setRegSource(RegSource);
            sec.setUserID(UserID);
            sec.SaveErrors();
                return false;
            }
      }   
  public boolean SaveSupplier(){
           try {
           PreparedStatement pstmt = con.prepareStatement("{call SaveSuppliers(?,?,?,?,?,?,?,?,?,?,?)}");
  
                    pstmt.setString(1, FullNames);
                    pstmt.setString(2, PostalAdress);
                    pstmt.setString(3, PhysicalAdress);
                    pstmt.setString(4, Mobile);
                    pstmt.setString(5, Email);
                    pstmt.setString(6, Telephone);
                    pstmt.setString(7, Fax);
                    pstmt.setBoolean(8, IsActive);
                    pstmt.setString(9, RegSource);
                    pstmt.setString(10, UserID);
                     pstmt.setString(11, SuppCode);
                  
                    pstmt.execute();
                    pstmt.close();
                   
              
          return true;
      } catch (Exception e) {
           Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving Suppliers");
            sec.setRegSource(RegSource);
            sec.setUserID(UserID);
            sec.SaveErrors();
                return false;
            }
      }   
}
