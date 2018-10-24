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
public class Inventory {
         String DocNo ,DocType ,GLAccount ,Remarks ,UOM,ItemCode ,PO;
         Date TransDate ;         
         float Quantity ;          
         Double UnitCost,VAT ;

    public Double getVAT() {
        return VAT;
    }

    public void setVAT(Double VAT) {
        this.VAT = VAT;
    }
         Double ExtendedCost ;
static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
     Constants _coConstants=new Constants();
    public Inventory() {
    }

    public String getPO() {
        return PO;
    }

    public void setPO(String PO) {
        this.PO = PO;
    }
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

    public String getGLAccount() {
        return GLAccount;
    }

    public void setGLAccount(String GLAccount) {
        this.GLAccount = GLAccount;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String Remarks) {
        this.Remarks = Remarks;
    }

    public String getUOM() {
        return UOM;
    }

    public void setUOM(String UOM) {
        this.UOM = UOM;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String ItemCode) {
        this.ItemCode = ItemCode;
    }

    public Date getTransDate() {
        return TransDate;
    }

    public void setTransDate(Date TransDate) {
        this.TransDate = TransDate;
    }

    public float getQuantity() {
        return Quantity;
    }

    public void setQuantity(float Quantity) {
        this.Quantity = Quantity;
    }

    public Double getUnitCost() {
        return UnitCost;
    }

    public void setUnitCost(Double UnitCost) {
        this.UnitCost = UnitCost;
    }

    public Double getExtendedCost() {
        return ExtendedCost;
    }

    public void setExtendedCost(Double ExtendedCost) {
        this.ExtendedCost = ExtendedCost;
    }

    public Inventory(String PO,String DocNo, String DocType, String GLAccount, String Remarks, String UOM, String ItemCode, Date TransDate, float Quantity, Double UnitCost, Double ExtendedCost,Double VAT) {
        this.PO=PO;
        this.DocNo = DocNo;
        this.DocType = DocType;
        this.GLAccount = GLAccount;
        this.Remarks = Remarks;
        this.UOM = UOM;
        this.ItemCode = ItemCode;
        this.TransDate = TransDate;
        this.Quantity = Quantity;
        this.UnitCost = UnitCost;
        this.ExtendedCost = ExtendedCost;
        this.VAT=VAT;
    }
      public boolean SaveInventoryIsuing(){
      try {
           PreparedStatement pstmt = con.prepareStatement("{call saveInventorIsuing(?,?,?,?,?,?,?)}");

                    pstmt.setString(1, getDocNo());
                    pstmt.setString(2, getDocType());
                    pstmt.setString(3, getItemCode());
                    pstmt.setFloat(4, getQuantity());
                    pstmt.setString(5, getRemarks());                
                    pstmt.setString(6, _coConstants.getUserId());
                    pstmt.setString(7, _coConstants.getRegSource());
                  
                    pstmt.execute();
                    pstmt.close();
                    con.close();
                   
          return true;
      } catch (Exception e) {
           Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving Inventory Adjustments");
            sec.setRegSource(_coConstants.getRegSource());
            sec.setUserID(_coConstants.getUserId());
            sec.SaveErrors();
          return false;
      }
  }  
    public boolean SaveInventoryAdjustments(){
      try {
           PreparedStatement pstmt = con.prepareStatement("{call saveInventorAdjustments(?,?,?,?,?,?,?)}");

                    pstmt.setString(1, getDocNo());
                    pstmt.setString(2, getDocType());
                    pstmt.setString(3, getItemCode());
                    pstmt.setFloat(4, getQuantity());
                    pstmt.setString(5, getRemarks());
                
                    pstmt.setString(6, _coConstants.getUserId());
                    pstmt.setString(7, _coConstants.getRegSource());
                  
                    pstmt.execute();
                    pstmt.close();
                    con.close();
                   
          return true;
      } catch (Exception e) {
           Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving Inventory Adjustments");
            sec.setRegSource(_coConstants.getRegSource());
            sec.setUserID(_coConstants.getUserId());
            sec.SaveErrors();
          return false;
      }
  }  
     public boolean SaveOpeningStock(){
      try {
           PreparedStatement pstmt = con.prepareStatement("{call saveInventorÓpening(?,?,?,?,?,?,?)}");

                    pstmt.setString(1, getDocNo());
                    pstmt.setString(2, getDocType());
                    pstmt.setString(3, getItemCode());
                    pstmt.setFloat(4, getQuantity());
                    pstmt.setString(5, getRemarks());
                
                    pstmt.setString(6, _coConstants.getUserId());
                    pstmt.setString(7, _coConstants.getRegSource());
                  
                    pstmt.execute();
                    pstmt.close();
                    con.close();
                   
          return true;
      } catch (Exception e) {
           Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving Opening Stock");
            sec.setRegSource(_coConstants.getRegSource());
            sec.setUserID(_coConstants.getUserId());
            sec.SaveErrors();
          return false;
      }
  }  
       public boolean SaveInventortTransactions(){
      try {
           PreparedStatement pstmt = con.prepareStatement("{call saveInventorReceipts(?,?,?,?,?,?,?,?,?,?,?,?,?)}");

           
                    pstmt.setString(1, DocNo);
                    pstmt.setString(2, DocType);
                    pstmt.setDate(3, TransDate);
                    pstmt.setString(4, ItemCode);
                    pstmt.setFloat(5, Quantity);
                  // pstmt.setString(6, UOM);
                    pstmt.setDouble(6, UnitCost);
                    pstmt.setDouble(7, ExtendedCost);
                    pstmt.setString(8, GLAccount);
                    pstmt.setString(9, Remarks);
                    pstmt.setString(10, _coConstants.getUserId());
                    pstmt.setString(11, _coConstants.getRegSource());
                   pstmt.setString(12, PO);
                    pstmt.setDouble(13, VAT);
                   
                    pstmt.execute();
                    pstmt.close();
                    con.close();
                   
          return true;
      } catch (Exception e) {
           Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving Inventory Receipts");
            sec.setRegSource(_coConstants.getRegSource());
            sec.setUserID(_coConstants.getUserId());
            sec.SaveErrors();
          return false;
      }
  }  
               
}
