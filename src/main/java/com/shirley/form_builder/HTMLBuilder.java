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
        public static String buildWebPage(String title, String redForeground,
                String greenForeground, String blueForeground, String 
                redBackground, String greenBackground, String blueBackground,
                String content){
            StringBuilder sb = new StringBuilder();
            
            sb.append("<!DOCTYPE html>\n");
            sb.append("<html>\n");
            sb.append("\t<head>\n");
            sb.append("\t\t<title>").append(title).append("<\title>\n");
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
            sb.append("\t\t</style>\n");
            sb.append("\t</head>\n");
            sb.append("\t<body>\n");
            sb.append("\t\t<section>\n");
            sb.append("\t\t\t<header>\n");
            sb.append("\t\t\t\t<h1>").append(title).append("</h1>\n");
            sb.append("\t\t\t</header>\n");
            sb.append("\t\t\t<p>").append(content).append("</p>\n");
            sb.append("\t\t</section>\n");
            sb.append("\t</body>\n");
            sb.append("</html>");
            return sb.toString();
        }
            
    }
}
