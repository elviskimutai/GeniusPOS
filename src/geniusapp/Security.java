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
 * @author Eng.Joseph Gitahi
 */
public class Security {
    static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
    String Message,Module,RegSource,UserID;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public String getModule() {
        return Module;
    }

    public void setModule(String Module) {
        this.Module = Module;
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
    
     public void SaveErrors(){
          
          try {
           PreparedStatement pstmt = con.prepareStatement("{call spSaveErrorLogs(?,?,?,?)}");
  
                    pstmt.setString(1, Message);
                    pstmt.setString(2, "Saving Suppliers");
                    pstmt.setString(3, RegSource);
                    pstmt.setString(4, UserID);
                
                    pstmt.execute();
                    pstmt.close();
                    
         
            } catch (Exception ex) {  }
             
      }   
}
