/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geniusapp;

/**
 *
 * @author Administrator
 */
import java.sql.Connection;
import java.sql.DriverManager;

public  class SqlConnection {
   
 public static Connection connect(){
     try{
            String userName = "Guest";
            String password = "Citimax123";
          //  String Driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String Url="jdbc:sqlserver://CITIMAX;databaseName=GeniusPOS";        
                      
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          // Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
          //  Class.forName(Driver);
            Connection con=DriverManager.getConnection(Url, userName, password);
          
               if(con!=null) System.out.println("Connection Successful!");
            return con;
     }catch(Exception e)
		{
			  e.printStackTrace();
               System.out.println("Error Trace in getConnection() : " + e.getMessage());
                       
                        return null;
		}
 }   
}

	