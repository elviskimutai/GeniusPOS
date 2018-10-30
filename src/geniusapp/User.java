
package geniusapp;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Administrator
 */
public class User {
    String UserName,Password,Email,FullNames,Question,Answer,Telephone;
    Boolean IsActive;
    
    static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getFullNames() {
        return FullNames;
    }

    public void setFullNames(String FullNames) {
        this.FullNames = FullNames;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String Answer) {
        this.Answer = Answer;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    public Boolean getIsActive() {
        return IsActive;
    }

    public void setIsActive(Boolean IsActive) {
        this.IsActive = IsActive;
    }


    public User() {
        
    }

    public User(String UserName, String Password, String Email, String FullNames,   String Question, String Answer, String Telephone, Boolean IsActive) {
        this.UserName = UserName;
        this.Password = Password;
        this.Email = Email;
        this.FullNames = FullNames;
        this.Question = Question;
        this.Answer = Answer;
        this.Telephone = Telephone;
        this.IsActive = IsActive;
        
    }
      public boolean DeleteUser(String UserName){
        try {
             PreparedStatement pstmt = con.prepareStatement("{call DeleteUser(?)}");
                    pstmt.setString(1, UserName);
                    
                    pstmt.execute();
                    pstmt.close();
                   
            return true;
        } catch (Exception e) {
            System.out.println( e.getMessage() );
            return false;
        }
    }
    public boolean SaveUser(){
        try {
             PreparedStatement pstmt = con.prepareStatement("{call SaveNewUser(?,?,?,?,?,?,?,?)}");
                    pstmt.setString(1, UserName);
                    pstmt.setString(2, FullNames);                
                    pstmt.setString(3, Password);
                    pstmt.setString(4, Question);
                    pstmt.setString(5, Answer);
                    pstmt.setString(6, Email);
                    pstmt.setString(7, Telephone);
                    pstmt.setBoolean(8, IsActive);
                
                    pstmt.execute();
                    pstmt.close();
                   
            return true;
        } catch (Exception e) {
            System.out.println( e.getMessage() );
            return false;
        }
    }
    public Boolean ValidateUser(String UserName1,String Password1 ){
        // String Result;
        try {
            PreparedStatement pstmt = con.prepareStatement("{call spValidateUser(?)}");
             
                    pstmt.setString(1, UserName1);
                  
                    ResultSet rs = pstmt.executeQuery();
                    int rowcount = 0;
                    Boolean result=false;
                     while (rs.next()) {
                          rowcount =rs.getRow();
                               String pas = rs.getString("Password");                                
                               Decryption de =new Decryption();
                               String decrypted= de.decrypt(pas);
                                if (decrypted.equals(Password1)) {
                                    result= true;
                                }
      
                        }
                     return result;
             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
            
        }
         
    }
   
}
