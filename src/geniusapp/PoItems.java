/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geniusapp;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author Eng.Joseph Gitahi
 */
public class PoItems {
    String UOM,SuppName,SuppEmail,SuppPostal,ShipToname,ShipToEmail,ShipToMobile,ItemDesc;
    float UnitPrice,LineTotal,Tax;
String ComapnyWebsite,   CompanyPhysical;
  
    Date DeliverBy;
float Qty;
    public PoItems(String SuppName, String SuppEmail, String SuppPostal, String ShipToname, String ShipToEmail, String ShipToMobile, String ItemDesc, float Qty, float UnitPrice, float LineTotal,Date DeliverBy,float Tax,String UOM,String ComapnyWebsite,  String CompanyPhysical) {
        this.SuppName = SuppName;
        this.SuppEmail = SuppEmail;
        this.SuppPostal = SuppPostal;
        this.ShipToname = ShipToname;
        this.ShipToEmail = ShipToEmail;
        this.ShipToMobile = ShipToMobile;
        this.ItemDesc = ItemDesc;
        this.Qty = Qty;
        this.UnitPrice = UnitPrice;
        
        this.LineTotal = LineTotal;
        this.DeliverBy=DeliverBy;
        this.Tax=Tax;
        this.UOM=UOM;
        this.ComapnyWebsite=ComapnyWebsite;
        this.CompanyPhysical=CompanyPhysical;
    }
  public float getTax() {
        return Tax;
    }

    public void setTax(float Tax) {
        this.Tax = Tax;
    }

    public String getComapnyWebsite() {
        return ComapnyWebsite;
    }

    public void setComapnyWebsite(String ComapnyWebsite) {
        this.ComapnyWebsite = ComapnyWebsite;
    }

    public String getCompanyPhysical() {
        return CompanyPhysical;
    }

    public void setCompanyPhysical(String CompanyPhysical) {
        this.CompanyPhysical = CompanyPhysical;
    }

    public String getUOM() {
        return UOM;
    }

    public void setUOM(String UOM) {
        this.UOM = UOM;
    }
    
    public Date getDeliverBy() {
        return DeliverBy;
    }
public void setDeliverBy(Date DeliverBy) {
        this.DeliverBy = DeliverBy;
    }

   public String getSuppEmail() {
        return SuppEmail;
    }
    public void setSuppName(String SuppName) {
        this.SuppName = SuppName;
    }

    public String getSuppName() {
        return SuppName;
    }

    public void setSuppEmail(String SuppEmail) {
        this.SuppEmail = SuppEmail;
    }

    public String getSuppPostal() {
        return SuppPostal;
    }

    public void setSuppPostal(String SuppPostal) {
        this.SuppPostal = SuppPostal;
    }

    public String getShipToname() {
        return ShipToname;
    }

    public void setShipToname(String ShipToname) {
        this.ShipToname = ShipToname;
    }

    public String getShipToEmail() {
        return ShipToEmail;
    }

    public void setShipToEmail(String ShipToEmail) {
        this.ShipToEmail = ShipToEmail;
    }

    public String getShipToMobile() {
        return ShipToMobile;
    }

    public void setShipToMobile(String ShipToMobile) {
        this.ShipToMobile = ShipToMobile;
    }

    public String getItemDesc() {
        return ItemDesc;
    }

    public void setItemDesc(String ItemDesc) {
        this.ItemDesc = ItemDesc;
    }

    public float getQty() {
        return Qty;
    }

    public void setQty(float Qty) {
        this.Qty = Qty;
    }

    public float getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(float UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

   

    public float getLineTotal() {
        return LineTotal;
    }

    public void setLineTotal(float LineTotal) {
        this.LineTotal = LineTotal;
    }
    
}
