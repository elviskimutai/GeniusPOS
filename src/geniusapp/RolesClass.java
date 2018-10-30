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
public class RolesClass {
    static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
Constants _Contants=new Constants();
   String RoleName  ,Narration ;

    public RolesClass() {
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String RoleName) {
        this.RoleName = RoleName;
    }

    public String getNarration() {
        return Narration;
    }

    public void setNarration(String Narration) {
        this.Narration = Narration;
    }

    public RolesClass(String RoleName, String Narration) {
        this.RoleName = RoleName;
        this.Narration = Narration;
    }
    public boolean SaveRole(){
      try {
           PreparedStatement pstmt = con.prepareStatement("{call SaveSecurityRoles(?,?,?,?)}");
   
                    pstmt.setString(1, RoleName);
                    pstmt.setString(2, Narration);
                    pstmt.setString(3, _Contants.getUserId());
                    pstmt.setString(4, _Contants.getRegSource());
                   
                  
                    pstmt.execute();
                    pstmt.close();
                    
          return true;
      } catch (Exception e) {
           Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving Roles");
            sec.setRegSource(_Contants.getRegSource());
            sec.setUserID(_Contants.getUserId());
            sec.SaveErrors();
          return false;
      }
  }
  public boolean DeleteRole(){
      try {
           PreparedStatement pstmt = con.prepareStatement("{call DeleteSecurityRoles(?)}");
   
                    pstmt.setString(1, this.getRoleName());
                
                  
                    pstmt.execute();
                    pstmt.close();
                   
          return true;
      } catch (Exception e) {
           Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Deleting roles");
            sec.setRegSource(_Contants.getRegSource());
            sec.setUserID(_Contants.getUserId());
            sec.SaveErrors();
          return false;
      }
  }
}
