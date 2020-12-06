/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shirley.left_form;

import java.util.EventObject;

/**
 *
 * @author Chantal Shirley
 */
public class FormEvent extends EventObject {

    private String title;
    private String redForeground;
    private String greenForeground;
    private String blueForeground;
    private String redBackground;
    private String greenBackground;
    private String blueBackground;
    private String content;

    public FormEvent(Object source, String title, String redForeground, 
            String greenForeground, String blueForeground, 
            String redBackground, String greenBackground,
            String blueBackground, String content) {
        super(source);
        this.title = title;
        this.redForeground = redForeground;
        this.greenForeground = greenForeground;
        this.blueForeground = blueForeground;
        this.redBackground = redBackground;
        this.blueBackground = blueBackground;
        this.greenBackground = greenBackground;
        this.content = content;
    }

    
    public String getRedBackground() {
        return redBackground;
    }

    public void setRedBackground(String redBackground) {
        this.redBackground = redBackground;
    }

    public String getGreenBackground() {
        return greenBackground;
    }

    public void setGreenBackground(String greenBackground) {
        this.greenBackground = greenBackground;
    }

    public String getBlueBackground() {
        return blueBackground;
    }

    public void setBlueBackground(String blueBackground) {
        this.blueBackground = blueBackground;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRedForeground() {
        return redForeground;
    }

    public void setRedForeground(String redForeground) {
        this.redForeground = redForeground;
    }

    public String getGreenForeground() {
        return greenForeground;
    }

    public void setGreenForeground(String greenForeground) {
        this.greenForeground = greenForeground;
    }

    public String getBlueForeground() {
        return blueForeground;
    }

    public void setBlueForeground(String blueForeground) {
        this.blueForeground = blueForeground;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
