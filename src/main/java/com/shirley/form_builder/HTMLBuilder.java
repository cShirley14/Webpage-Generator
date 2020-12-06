/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shirley.form_builder;

/**
 *
 * @author Chantal Shirley
 */
public class HTMLBuilder {
    
    public static class HTMLGenerator {
        public String buildWebPage(String title, String redForeground,
                String greenForeground, String blueForeground, String 
                redBackground, String greenBackground, String blueBackground,
                String content){
            StringBuilder sb = new StringBuilder();
            
            sb.append("<!DOCTYPE html>\n");
            sb.append("<html>\n");
            sb.append("\t<head>\n");
            sb.append("\t\t<title>");
            sb.append(title).append("<\title>\n");
            sb.append("\t\t<style type='text/css'>\n");
            sb.append("\t\t\tbody {\n");
            sb.append("\t\t\t\tcolor: rgb(").append(
                    redForeground).append(",").append(
                    greenForeground).append(",").append(
                    blueForeground).append(");\n");
            sb.append("\t\t\t\tbackground: rgb(").append(
                    redBackground).append(",").append(
                    greenBackground).append(",").append(
                    blueBackground).append(");\n");
            sb.append("\t\t\t}\n");
            sb.append("\t\t</style>");
            sb.append("\t</head>\n");
            sb.append("\t<body>\n");
            sb.append("\t\t<section>\n");
            sb.append("\t\t\t<header>\n");
            sb.append("<h1>");
            
            
            return sb.toString();
        }
            
    }
}
