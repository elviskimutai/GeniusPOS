
package geniusapp;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class UserGroup {
       static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
Constants _Contants=new Constants();
   String GroupName ,GroupCode ,Narration ;

    public String getGroupCode() {
        return GroupCode;
    }

    public void setGroupCode(String GroupCode) {
        this.GroupCode = GroupCode;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String GroupName) {
        this.GroupName = GroupName;
    }

    public String getNarration() {
        return Narration;
    }

    public void setNarration(String Narration) {
        this.Narration = Narration;
    }

    public UserGroup() {
    }

    public UserGroup(String GroupName, String GroupCode, String Narration) {
        this.GroupName = GroupName;
        this.GroupCode = GroupCode;
        this.Narration = Narration;
    }

  
    public boolean SaveSecurityGroup(){
      try {
           PreparedStatement pstmt = con.prepareStatement("{call saveSecurityGroups(?,?,?,?,?)}");
   
                    pstmt.setString(1, GroupCode);
                    pstmt.setString(2, GroupName);
                     pstmt.setString(3, Narration);                    
                    pstmt.setString(4, _Contants.getRegSource());
                    pstmt.setString(5, _Contants.getUserId());                  
                  
                    pstmt.execute();
                    pstmt.close();
                    
          return true;
      } catch (Exception e) {
           Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving Security groups");
            sec.setRegSource(_Contants.getRegSource());
            sec.setUserID(_Contants.getUserId());
            sec.SaveErrors();
          return false;
      }
  }
  public boolean DeleteSecurityGroup(){
      try {
           PreparedStatement pstmt = con.prepareStatement("{call DeleteSecurityGroups(?)}");
   
                    pstmt.setString(1, this.getGroupCode());
                
                  
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
