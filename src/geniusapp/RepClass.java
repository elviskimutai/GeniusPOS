/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geniusapp;

import java.io.InputStream;

/**
 *
 * @author Eng.Joseph Gitahi
 */
public class RepClass {
    String no,name;
    InputStream image;
    
//   public List<ItemCombo>  FindAll(){
//       List<ItemCombo> Items=new ArrayList<ItemCombo>();
//      
//       Items.add(new ItemCombo("ITEM-01","OMO") );
//        Items.add(new ItemCombo("ITEM-02","SOAP") );
//         Items.add(new ItemCombo("ITEM-03","MILK") );
//          Items.add(new ItemCombo("ITEM-04","OMO") );
//           Items.add(new ItemCombo("ITEM-05","OMO") );
//            Items.add(new ItemCombo("ITEM-01","OMO") );
//            return Items;
//   }

    public RepClass(String no, String name, InputStream image) {
        this.no = no;
        this.name = name;
        this.image = image;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }
}
