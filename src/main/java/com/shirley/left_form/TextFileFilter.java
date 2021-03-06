package com.shirley.left_form;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Chantal Shirley
 */
public class TextFileFilter extends FileFilter {
    @Override
    public boolean accept(File file) {
        String fileName = file.getName();
        String extension = getFileExtension(fileName);
        // return false if the extension is null or is not null
        if (extension == null || !extension.equals("html")) {
            return false;
        }
        if (file.isDirectory()) {
            return true;
        }
        return true;
    }
    
    @Override
    public String getDescription() {
        return "HTML files (*.html)";
    }
    
   public static String getFileExtension(String name) {
       int pointIndex = name.lastIndexOf(".");
       // Return null if a period character is not found or is the laster character
       if (pointIndex == -1 || pointIndex == name.length() -1) {
           return null;
       }
       // Return all character after the last pe3riod character
       return name.substring(pointIndex+1, name.length());
   }
    
}
