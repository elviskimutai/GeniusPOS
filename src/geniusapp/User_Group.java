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
public class User_Group {
     String   UserGroup,  UserName;
static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
Constants _Contants=new Constants();
    public User_Group(String UserGroup, String UserName) {
        this.UserGroup = UserGroup;
        this.UserName = UserName;
    }

    public String getUserGroup() {
        return UserGroup;
    }

    public void setUserGroup(String UserGroup) {
        this.UserGroup = UserGroup;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
      public boolean SaveUserGroups(){
      try {
           PreparedStatement pstmt = con.prepareStatement("{call saveUserGroups(?,?,?,?,?)}");
   
                    pstmt.setString(1, UserGroup);
                    pstmt.setString(2, UserName);
                                
                    pstmt.setString(3, _Contants.getRegSource());
                    pstmt.setString(4, _Contants.getUserId());                  
                  
                    pstmt.execute();
                    pstmt.close();
                    
          return true;
      } catch (Exception e) {
           Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving Users groups");
            sec.setRegSource(_Contants.getRegSource());
            sec.setUserID(_Contants.getUserId());
            sec.SaveErrors();
          return false;
      }
  }
  public boolean DeleteUserGroups(){
      try {
           PreparedStatement pstmt = con.prepareStatement("{call DeleteSecurityGroups(?)}");
   
                     pstmt.setString(1, UserGroup);
                    pstmt.setString(2, UserName);
                                
                   
                
                  
                    pstmt.execute();
                    pstmt.close();
                   
          return true;
      } catch (Exception e) {
           Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Deleting Security Group");
            sec.setRegSource(_Contants.getRegSource());
            sec.setUserID(_Contants.getUserId());
            sec.SaveErrors();
          return false;
      }
  }
}
