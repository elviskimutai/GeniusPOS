/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geniusapp;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Administrator
 */
public class Customer {
    public String FullNames ,PostalAdress ,PhysicalAdress ,Mobile ,Email ,Telephone ,Fax ,RegSource ,UserID ,CustCode ;
    Boolean IsActive ;
static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
     Constants _Contants=new Constants();
    public Customer() {
    }

    public String getFullNames() {
        return FullNames;
    }

    public void setFullNames(String FullNames) {
        this.FullNames = FullNames;
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

    public String getCustCode() {
        return CustCode;
    }

    public void setCustCode(String CustCode) {
        this.CustCode = CustCode;
    }

    public Boolean getIsActive() {
        return IsActive;
    }

    public void setIsActive(Boolean IsActive) {
        this.IsActive = IsActive;
    }

    public Customer(String CustCode,String FullNames, String PostalAdress, String PhysicalAdress, String Mobile, String Email, String Telephone, String Fax,  Boolean IsActive) {
        this.FullNames = FullNames;
        this.PostalAdress = PostalAdress;
        this.PhysicalAdress = PhysicalAdress;
        this.Mobile = Mobile;
        this.Email = Email;
        this.Telephone = Telephone;
        this.Fax = Fax;
       
        this.CustCode = CustCode;
        this.IsActive = IsActive;
    }
    public boolean DeleteSupplier(){
      try {
           PreparedStatement pstmt = con.prepareStatement("{call DeleteCustomers(?,?,?)}");
   
                    pstmt.setString(1, this.getCustCode());                    
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
            sec.setUserID( _Contants.getUserId());
            sec.SaveErrors();
          return false;
      }
  }
    
  public boolean SaveCustomers(){
           try {
           PreparedStatement pstmt = con.prepareStatement("{call SaveCustomers(?,?,?,?,?,?,?,?,?,?,?)}");
  
                    pstmt.setString(1, FullNames);
                    pstmt.setString(2, PostalAdress);
                    pstmt.setString(3, PhysicalAdress);
                    pstmt.setString(4, Mobile);
                    pstmt.setString(5, Email);
                    pstmt.setString(6, Telephone);
                    pstmt.setString(7, Fax);
                    pstmt.setBoolean(8, IsActive);
                    pstmt.setString(9, _Contants.getRegSource());
                    pstmt.setString(10, _Contants.getUserId());
                     pstmt.setString(11, CustCode);
                  
                    pstmt.execute();
                    pstmt.close();
                   
              
          return true;
      } catch (Exception e) {
           Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving Customers");
            sec.setRegSource(RegSource);
            sec.setUserID(UserID);
            sec.SaveErrors();
                return false;
            }
      }   
}
