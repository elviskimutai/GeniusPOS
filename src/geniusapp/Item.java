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
public class Item {
public String ItemCode,ItemName,ItemDescription,UOM,RegSource,UserID;
public Double SellingPrice,CostPrice;
public Float VATValue;
public Boolean VATInclusive;
static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
Constants _Contants=new Constants();
    public Item() {
    }

    public String getItemCode() {
        return ItemCode;
    }
    public void setItemCode(String ItemCode) {
        this.ItemCode = ItemCode;
    }

 public Double CostPrice() {
        return SellingPrice;
    }
   
    public void setCostPrice(Double CostPrice) {
        this.CostPrice = CostPrice;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public String getItemDescription() {
        return ItemDescription;
    }

    public void setItemDescription(String ItemDescription) {
        this.ItemDescription = ItemDescription;
    }

    public String getUOM() {
        return UOM;
    }

    public void setUOM(String UOM) {
        this.UOM = UOM;
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

    public Double getSellingPrice() {
        return SellingPrice;
    }

    public void setSellingPrice(Double SellingPrice) {
        this.SellingPrice = SellingPrice;
    }

    public Float getVATValue() {
        return VATValue;
    }

    public void setVATValue(Float VATValue) {
        this.VATValue = VATValue;
    }

    public Boolean getVATInclusive() {
        return VATInclusive;
    }

    public void setVATInclusive(Boolean VATInclusive) {
        this.VATInclusive = VATInclusive;
    }

    public Item(String ItemCode, String ItemName, String ItemDescription, String UOM, String RegSource, String UserID, Double SellingPrice,Double CostPrice, Float VATValue, Boolean VATInclusive) {
        this.ItemCode = ItemCode;
        this.ItemName = ItemName;
        this.ItemDescription = ItemDescription;
        this.UOM = UOM;
        this.RegSource = RegSource;
        this.UserID = UserID;
        this.SellingPrice = SellingPrice;
        this.VATInclusive = VATInclusive;
        this.VATValue = VATValue;
        this.CostPrice = CostPrice;
    }
  public boolean SaveItem(){
      try {
           PreparedStatement pstmt = con.prepareStatement("{call SaveItems(?,?,?,?,?,?,?,?,?,?)}");
   
                    pstmt.setString(1, ItemCode);
                    pstmt.setString(2, ItemName);
                    pstmt.setString(3, ItemDescription);
                    pstmt.setDouble(4, CostPrice);
                    pstmt.setDouble(5, SellingPrice);
                    pstmt.setBoolean(6, VATInclusive);
                    pstmt.setFloat(7, VATValue);
                    pstmt.setString(8, UOM);
                    pstmt.setString(9, RegSource);
                    pstmt.setString(10, UserID);
                  
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
  public boolean DeleteItem(){
      try {
           PreparedStatement pstmt = con.prepareStatement("{call DeleteItems(?,?,?,?)}");
   
                    pstmt.setString(1, this.getItemCode());
                    pstmt.setString(2, this.getItemName());
                
                    pstmt.setString(3, _Contants.getRegSource());
                    pstmt.setString(4, _Contants.getUserId());
                  
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
