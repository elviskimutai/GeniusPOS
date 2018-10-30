/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geniusapp;

import java.io.InputStream;
import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class SalesQuotation {
      public  String SOCode ;
	public String Item ;
	public String Customer,InvoiceCode ;
	public Float Qty ;
	public Float UnitPrice,VAT;
	public Float LineTotal,CostOfGoods ;        
       public  String CustomerNames,CustomerEmail,CustomerPostal;            
       public String Comapny; 
     public   String ComapnyEmail,ComapnyWebsite,CompanyPhysical;

    public String getCompanyPhysical() {
        return CompanyPhysical;
    }

    public void setCompanyPhysical(String CompanyPhysical) {
        this.CompanyPhysical = CompanyPhysical;
    }
     public   String ComapnyMobile;
     public   String ItemDesc;
     public   String UOM; 
     public    InputStream image;
     public Date InvoiceDueDate;

    public String getInvoiceCode() {
        return InvoiceCode;
    }

    public void setInvoiceCode(String InvoiceCode) {
        this.InvoiceCode = InvoiceCode;
    }

    public String getComapnyWebsite() {
        return ComapnyWebsite;
    }

    public void setComapnyWebsite(String ComapnyWebsite) {
        this.ComapnyWebsite = ComapnyWebsite;
    }

    public Date getInvoiceDueDate() {
        return InvoiceDueDate;
    }

    public void setInvoiceDueDate(Date InvoiceDueDate) {
        this.InvoiceDueDate = InvoiceDueDate;
    }
     
    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }
         

    public String getSOCode() {
        return SOCode;
    }

    public void setSOCode(String SOCode) {
        this.SOCode = SOCode;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String Item) {
        this.Item = Item;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String Customer) {
        this.Customer = Customer;
    }

    public Float getQty() {
        return Qty;
    }

    public void setQty(Float Qty) {
        this.Qty = Qty;
    }

    public Float getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(Float UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public Float getVAT() {
        return VAT;
    }

    public void setVAT(Float VAT) {
        this.VAT = VAT;
    }

    public Float getLineTotal() {
        return LineTotal;
    }

    public void setLineTotal(Float LineTotal) {
        this.LineTotal = LineTotal;
    }

    public Float getCostOfGoods() {
        return CostOfGoods;
    }

    public void setCostOfGoods(Float CostOfGoods) {
        this.CostOfGoods = CostOfGoods;
    }

    public String getCustomerNames() {
        return CustomerNames;
    }

    public void setCustomerNames(String CustomerNames) {
        this.CustomerNames = CustomerNames;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String CustomerEmail) {
        this.CustomerEmail = CustomerEmail;
    }

    public String getCustomerPostal() {
        return CustomerPostal;
    }

    public void setCustomerPostal(String CustomerPostal) {
        this.CustomerPostal = CustomerPostal;
    }

    public String getComapny() {
        return Comapny;
    }

    public void setComapny(String Comapny) {
        this.Comapny = Comapny;
    }

    public String getComapnyEmail() {
        return ComapnyEmail;
    }

    public void setComapnyEmail(String ComapnyEmail) {
        this.ComapnyEmail = ComapnyEmail;
    }

    public String getComapnyMobile() {
        return ComapnyMobile;
    }

    public void setComapnyMobile(String ComapnyMobile) {
        this.ComapnyMobile = ComapnyMobile;
    }

    public String getItemDesc() {
        return ItemDesc;
    }

    public void setItemDesc(String ItemDesc) {
        this.ItemDesc = ItemDesc;
    }

    public String getUOM() {
        return UOM;
    }

    public void setUOM(String UOM) {
        this.UOM = UOM;
    }

    public SalesQuotation(String SOCode, String Item, String Customer, String InvoiceCode, Float Qty, Float UnitPrice, Float VAT, Float LineTotal, Float CostOfGoods, String CustomerNames, String CustomerEmail, String CustomerPostal, String Comapny, String ComapnyEmail, String ComapnyWebsite, String ComapnyMobile, String ItemDesc, String UOM, Date InvoiceDueDate,String CompanyPhysical) {
        this.SOCode = SOCode;
        this.Item = Item;
        this.Customer = Customer;
        this.InvoiceCode = InvoiceCode;
        this.Qty = Qty;
        this.UnitPrice = UnitPrice;
        this.VAT = VAT;
        this.LineTotal = LineTotal;
        this.CostOfGoods = CostOfGoods;
        this.CustomerNames = CustomerNames;
        this.CustomerEmail = CustomerEmail;
        this.CustomerPostal = CustomerPostal;
        this.Comapny = Comapny;
        this.ComapnyEmail = ComapnyEmail;
        this.ComapnyWebsite = ComapnyWebsite;
        this.ComapnyMobile = ComapnyMobile;
        this.ItemDesc = ItemDesc;
        this.UOM = UOM;
        //this.image = image;
        this.InvoiceDueDate = InvoiceDueDate;
        this.CompanyPhysical=CompanyPhysical;
    }

//    public SalesQuotation(String SOCode, String Item, String Customer, Float Qty, Float UnitPrice, Float VAT, Float LineTotal, Float CostOfGoods, String CustomerNames, String CustomerEmail, String CustomerPostal, String Comapny, String ComapnyEmail, String ComapnyMobile, String ItemDesc, String UOM, InputStream image) {
//        this.SOCode = SOCode;
//        this.Item = Item;
//        this.Customer = Customer;
//        this.Qty = Qty;
//        this.UnitPrice = UnitPrice;
//        this.VAT = VAT;
//        this.LineTotal = LineTotal;
//        this.CostOfGoods = CostOfGoods;
//        this.CustomerNames = CustomerNames;
//        this.CustomerEmail = CustomerEmail;
//        this.CustomerPostal = CustomerPostal;
//        this.Comapny = Comapny;
//        this.ComapnyEmail = ComapnyEmail;
//        this.ComapnyMobile = ComapnyMobile;
//        this.ItemDesc = ItemDesc;
//        this.UOM = UOM;
//        this.image = image;
//    }
//        
//
//    public SalesQuotation(String SOCode, String Item, String Customer, Float Qty, Float UnitPrice, Float VAT, Float LineTotal, Float CostOfGoods, String CustomerNames, String CustomerEmail, String CustomerPostal, String Comapny, String ComapnyEmail, String ComapnyMobile, String ItemDesc, String UOM) {
//        this.SOCode = SOCode;
//        this.Item = Item;
//        this.Customer = Customer;
//        this.Qty = Qty;
//        this.UnitPrice = UnitPrice;
//        this.VAT = VAT;
//        this.LineTotal = LineTotal;
//        this.CostOfGoods = CostOfGoods;
//        this.CustomerNames = CustomerNames;
//        this.CustomerEmail = CustomerEmail;
//        this.CustomerPostal = CustomerPostal;
//        this.Comapny = Comapny;
//        this.ComapnyEmail = ComapnyEmail;
//        this.ComapnyMobile = ComapnyMobile;
//        this.ItemDesc = ItemDesc;
//        this.UOM = UOM;
//    }
//        
//        
}
