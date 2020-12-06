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
        if (file.isDirectory()) {
            return true;
        }
        String fileName = file.getName();
        String extension = getFileExtension(fileName);
        // return false if the extension is null or is not null
        if (extension == null || !extension.equals("txt")) {
            return false;
        }
        return true;
    }
    
    @Override
    public String getDescription() {
        return "TXT files (*.txt)";
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
