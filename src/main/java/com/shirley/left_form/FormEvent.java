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
    private String redColor;
    private String greenColor;
    private String blueColor;
    private String content;

    public FormEvent(Object source, String title, String content) {
        super(source);
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
