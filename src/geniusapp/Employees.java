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
 * @author Administrator
 */
public class Employees {
    
    public    String  EmployeeId;
    public    String  Pin;
    public    String  Names;
    public    String  NSSFNo;
    public    Boolean  PayStatus;
    public   String  PostalAddress;
    public    String Gender;
    public  String IDNo;
    public   Boolean Active;
    public   String  Email1;
    public   String Telephone;
    public   Date HireDay; 
    public   Date DOB; 
    public  byte[] Person_Image;
    static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
    public Employees() {
    }

    public Employees(String EmployeeId, String Pin, String Names, String NSSFNo, Boolean PayStatus, String PostalAddress, String Gender, String IDNo, Boolean Active, String Email1, String Telephone, Date HireDay, Date DOB, byte[] Person_Image) {
        this.EmployeeId = EmployeeId;
        this.Pin = Pin;
        this.Names = Names;
        this.NSSFNo = NSSFNo;
        this.PayStatus = PayStatus;
        this.PostalAddress = PostalAddress;
        this.Gender = Gender;
        this.IDNo = IDNo;
        this.Active = Active;
        this.Email1 = Email1;
        this.Telephone = Telephone;
        this.HireDay = HireDay;
        this.DOB = DOB;
        this.Person_Image = Person_Image;
    }

    public String getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(String EmployeeId) {
        this.EmployeeId = EmployeeId;
    }

    public String getPin() {
        return Pin;
    }

    public void setPin(String Pin) {
        this.Pin = Pin;
    }

    public String getNames() {
        return Names;
    }

    public void setNames(String Names) {
        this.Names = Names;
    }

    public String getNSSFNo() {
        return NSSFNo;
    }

    public void setNSSFNo(String NSSFNo) {
        this.NSSFNo = NSSFNo;
    }

    public Boolean getPayStatus() {
        return PayStatus;
    }

    public void setPayStatus(Boolean PayStatus) {
        this.PayStatus = PayStatus;
    }

    public String getPostalAddress() {
        return PostalAddress;
    }

    public void setPostalAddress(String PostalAddress) {
        this.PostalAddress = PostalAddress;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getIDNo() {
        return IDNo;
    }

    public void setIDNo(String IDNo) {
        this.IDNo = IDNo;
    }

    public Boolean getActive() {
        return Active;
    }

    public void setActive(Boolean Active) {
        this.Active = Active;
    }

    public String getEmail1() {
        return Email1;
    }

    public void setEmail1(String Email1) {
        this.Email1 = Email1;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    public Date getHireDay() {
        return HireDay;
    }

    public void setHireDay(Date HireDay) {
        this.HireDay = HireDay;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public byte[] getPerson_Image() {
        return Person_Image;
    }

    public void setPerson_Image(byte[] Person_Image) {
        this.Person_Image = Person_Image;
    }
     public boolean SaveEmployee(){
        try {
             PreparedStatement pstmt = con.prepareStatement("{call SaveNewEmployee(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
     
                    pstmt.setString(1, EmployeeId);
                    pstmt.setString(2, Pin);
                    pstmt.setString(3, Names);
                    pstmt.setString(4, NSSFNo);
                    pstmt.setBoolean(5, PayStatus);
                    pstmt.setString(6, PostalAddress);
                    pstmt.setString(7, Gender);
                    pstmt.setString(8, IDNo);
                    pstmt.setBoolean(9, Active);
                    pstmt.setString(10, Email1);
                    pstmt.setString(11, Telephone);
                    pstmt.setDate(12, HireDay);
                    pstmt.setDate(13, DOB);
                    pstmt.setBytes(14, Person_Image);
                   pstmt.setString(15, "Genius");
                    pstmt.execute();
                    pstmt.close();
                    System.out.println( "Saved Succesffuly" );

             
    
            return true;
        } catch (Exception e) {
            System.out.println( e.getMessage() );
            return false;
        }
    }   
}
