/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shirley;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Chantal Shirley
 */
public class Languages {
    public enum LanguageOptions { USA, SPANISH, CATALAN, BELARUSIAN };
    private static ResourceBundle messages = ResourceBundle.getBundle(
            "messages", Locale.getDefault());
    
    public static ResourceBundle getResourceBundle() {
        return messages;
    }
    
    public static void setResourceBundle(LanguageOptions language) {
        Locale locale = Locale.getDefault();
        
        switch (language) {
            case USA:
                locale = Locale.US;
                break;
            case SPANISH:
                locale = new Locale("ES", "MX");
                break;
            case CATALAN:
                locale = new Locale("CA");
                break;
            case BELARUSIAN:
                locale = new Locale("BE");
        }
        messages = ResourceBundle.getBundle("messages", locale);
    }
}
