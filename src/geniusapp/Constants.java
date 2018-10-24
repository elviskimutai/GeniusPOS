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
public class Constants {
    public static  String UserId,RegSource,POCODE;

    public Constants() {
    }

    public static String getPOCODE() {
        return POCODE;
    }

    public static void setPOCODE(String POCODE) {
        Constants.POCODE = POCODE;
    }

    public  String getUserId() {
        return UserId;
    }

    public static void setUserId(String UserId) {
        Constants.UserId = UserId;
    }

    public  String getRegSource() {
        return RegSource;
    }

    public static void setRegSource(String RegSource) {
        Constants.RegSource = RegSource;
    }
    
}
