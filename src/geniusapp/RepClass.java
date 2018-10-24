/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geniusapp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eng.Joseph Gitahi
 */
public class RepClass {
    
   public List<ItemCombo>  FindAll(){
       List<ItemCombo> Items=new ArrayList<ItemCombo>();
      
       Items.add(new ItemCombo("ITEM-01","OMO") );
        Items.add(new ItemCombo("ITEM-02","SOAP") );
         Items.add(new ItemCombo("ITEM-03","MILK") );
          Items.add(new ItemCombo("ITEM-04","OMO") );
           Items.add(new ItemCombo("ITEM-05","OMO") );
            Items.add(new ItemCombo("ITEM-01","OMO") );
            return Items;
   }
}
