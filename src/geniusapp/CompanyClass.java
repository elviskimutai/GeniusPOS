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
public class CompanyClass {
    public String CompayName ,Email ,Telephone,Mobile,Fax ,PostalAdress,PhysicaAdress,WebUrl;
static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
Constants _Contants=new Constants();
    public CompanyClass() {
    }

    public String getWebUrl() {
        return WebUrl;
    }

    public void setWebUrl(String WebUrl) {
        this.WebUrl = WebUrl;
    }

    public String getCompayName() {
        return CompayName;
    }

    public void setCompayName(String CompayName) {
        this.CompayName = CompayName;
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

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }

    public String getPostalAdress() {
        return PostalAdress;
    }

    public void setPostalAdress(String PostalAdress) {
        this.PostalAdress = PostalAdress;
    }

    public String getPhysicaAdress() {
        return PhysicaAdress;
    }

    public void setPhysicaAdress(String PhysicaAdress) {
        this.PhysicaAdress = PhysicaAdress;
    }

    public CompanyClass(String CompayName, String Email, String Telephone, String Mobile, String Fax, String PostalAdress, String PhysicaAdress,String WebUrl) {
        this.CompayName = CompayName;
        this.Email = Email;
        this.Telephone = Telephone;
        this.Mobile = Mobile;
        this.Fax = Fax;
        this.PostalAdress = PostalAdress;
        this.PhysicaAdress = PhysicaAdress;
        this.WebUrl=WebUrl;
    }
    public boolean SaveCompany(){
      try {
           PreparedStatement pstmt = con.prepareStatement("{call SaveCompany(?,?,?,?,?,?,?,?)}");
   
                    pstmt.setString(1, CompayName);
                    pstmt.setString(2, Email);
                    pstmt.setString(3, Telephone);
                    pstmt.setString(4, Mobile);
                    pstmt.setString(5, Fax);
                    pstmt.setString(6, PostalAdress);
                    pstmt.setString(7, PhysicaAdress);
                    pstmt.setString(8, WebUrl);
                  
                  
                    pstmt.execute();
                    pstmt.close();
                    
          return true;
      } catch (Exception e) {
           Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving Comapy");
            sec.setRegSource(_Contants.getRegSource());
            sec.setUserID(_Contants.getUserId());
            sec.SaveErrors();
          return false;
      }
  }
  public boolean DeleteCompany(){
      try {
           PreparedStatement pstmt = con.prepareStatement("{call DeleteCompany(?)}");
   
                    pstmt.setString(1, this.getCompayName());
        
                
                  
                    pstmt.execute();
                    pstmt.close();
                   
          return true;
      } catch (Exception e) {
           Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Deleting Company");
         sec.setRegSource(_Contants.getRegSource());
            sec.setUserID(_Contants.getUserId());
            sec.SaveErrors();
          return false;
      }
  }
}
