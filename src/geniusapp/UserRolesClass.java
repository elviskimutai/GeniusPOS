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
public class UserRolesClass {
    public  String   UserGroup,  SecurityModule;
        public    Boolean View,Delete,Add,Export,Edit,Import;
static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
Constants _coConstants=new Constants();
    public UserRolesClass() {
    }

    public String getUserGroup() {
        return UserGroup;
    }

    public void setUserGroup(String UserGroup) {
        this.UserGroup = UserGroup;
    }

    public String getSecurityModule() {
        return SecurityModule;
    }

    public void setSecurityModule(String SecurityModule) {
        this.SecurityModule = SecurityModule;
    }

    public Boolean getView() {
        return View;
    }

    public void setView(Boolean View) {
        this.View = View;
    }

    public Boolean getDelete() {
        return Delete;
    }

    public void setDelete(Boolean Delete) {
        this.Delete = Delete;
    }

    public Boolean getAdd() {
        return Add;
    }

    public void setAdd(Boolean Add) {
        this.Add = Add;
    }

    public Boolean getExport() {
        return Export;
    }

    public void setExport(Boolean Export) {
        this.Export = Export;
    }

    public Boolean getEdit() {
        return Edit;
    }

    public void setEdit(Boolean Edit) {
        this.Edit = Edit;
    }

    public Boolean getImport() {
        return Import;
    }

    public void setImport(Boolean Import) {
        this.Import = Import;
    }

    public UserRolesClass(String UserGroup, String SecurityModule, Boolean View, Boolean Delete, Boolean Add, Boolean Export, Boolean Edit, Boolean Import) {
        this.UserGroup = UserGroup;
        this.SecurityModule = SecurityModule;
        this.View = View;
        this.Delete = Delete;
        this.Add = Add;
        this.Export = Export;
        this.Edit = Edit;
        this.Import = Import;
    }
       public boolean SaveUserRoles(){
      try {
           PreparedStatement pstmt = con.prepareStatement("{call spSaveUserRoles(?,?,?,?,?,?,?,?,?,?)}");
 
                    pstmt.setString(1, UserGroup);
                    pstmt.setString(2, SecurityModule);
                    pstmt.setBoolean(3, View);
                    pstmt.setBoolean(4, Add);
                    pstmt.setBoolean(5, Edit);
                    pstmt.setBoolean(6, Delete);
                    pstmt.setBoolean(7,Export );
                    pstmt.setBoolean(8,Import );
                    pstmt.setString(9, _coConstants.getRegSource());
                      pstmt.setString(10, _coConstants.getUserId());
                  
                    pstmt.execute();
                    pstmt.close();
                   
                    return true;
      } catch (Exception e) {
           Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving PUser Roles");
            sec.setRegSource(_coConstants.getRegSource());
            sec.setUserID(_coConstants.getUserId());
            sec.SaveErrors();
          return false;
      }
  } 
}
