package com.shirley;

import com.shirley.top_toolbar.Toolbar;
import java.awt.BorderLayout;
import java.awt.Dimension;

import java.util.ResourceBundle;
import javax.swing.JFrame;

/**
 *
 * @author Chantal Shirley
 */
public class MainFrame extends JFrame {
    private ResourceBundle messages = Languages.getResourceBundle();
    private Toolbar toolbar;
    
    public MainFrame() {
        super();
        setTitle(messages.getString("title"));
        setMinimumSize(new Dimension(500, 400));
        setSize(600,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        toolbar = new Toolbar();
        add(toolbar, BorderLayout.NORTH);
        toolbar.setVisible(false);
        
    }

}
