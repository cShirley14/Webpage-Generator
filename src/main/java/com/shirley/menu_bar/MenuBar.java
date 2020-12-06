/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shirley.menu_bar;

import com.shirley.Languages;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Chantal Shirley
 */
public class MenuBar extends JMenuBar implements ActionListener {
    private JMenu file_menu;
    private JMenu window_menu;
    private MenuItemListener listener;
    private JMenuItem export_data_item;
    private JMenuItem quit_item;
    private ResourceBundle messages = Languages.getResourceBundle();
    
    public MenuBar() {
        // Create File Menu
        file_menu = new JMenu(messages.getString("file-title"));
        
        export_data_item = new JMenuItem(messages.getString("export-title"));
        file_menu.add(export_data_item);
        export_data_item.addActionListener(this);
        
        file_menu.addSeparator();
        quit_item = new JMenuItem(messages.getString("quit-title"));
        file_menu.add(quit_item);
        quit_item.addActionListener(this);
        
        this.add(file_menu);
        
        // Create Window Menu
        window_menu = new JMenu(messages.getString("window-title"));
        this.add(window_menu);
    }
    
    public void setMenuItemListener(MenuItemListener listener) {
        this.listener = listener;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem clicked = (JMenuItem) e.getSource();
        if (listener != null) {
            listener.getMenuItem(clicked);
        }
    }
}
