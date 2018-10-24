/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geniusapp;

/**
 *
 * @author Eng.Joseph Gitahi
 */
public class ItemCombo {
    String ItemCode,itemName;

    public ItemCombo() {
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String ItemCode) {
        this.ItemCode = ItemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ItemCombo(String ItemCode, String itemName) {
        this.ItemCode = ItemCode;
        this.itemName = itemName;
    }
}
