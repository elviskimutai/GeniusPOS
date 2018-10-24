/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geniusapp;

import Forms.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class GeniusApp {

    /**
     * @param args the command line arguments
     */
     static  void run(){
         
         SqlConnection al=new SqlConnection();
        al.connect();
    }
   
    public static void main(String[] args) {
         //TODO code application logic here
        run();
       Login _Login = new Login();
      _Login.show();
//Mailer.send("elviskimcheruiyot@gmail.com","KIMkim100%","elviskcheruiyot@gmail.com","hello javatpoint","How r u?");
       
       
                      
        
    }
    
}
