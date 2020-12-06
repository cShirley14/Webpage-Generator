package com.shirley;

import com.shirley.left_form.FormEvent;
import com.shirley.left_form.FormListener;
import com.shirley.left_form.FormPanel;
import com.shirley.left_form.TextFileFilter;
import com.shirley.menu_bar.MenuBar;
import com.shirley.menu_bar.MenuItemListener;
import com.shirley.top_toolbar.Toolbar;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Chantal Shirley
 */
public class MainFrame extends JFrame {
    private ResourceBundle messages = Languages.getResourceBundle();
    private Toolbar toolbar;
    private MenuBar menuBar;
    private TextPanel textPanel;
    private FormPanel formPanel;
    private JFileChooser fileChooser;
    
    public MainFrame() {
        super();
        setTitle(messages.getString("title"));
        setMinimumSize(new Dimension(800, 400));
        setSize(1000,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e) {
               closeWindow();
           }
        });
        
        setLayout(new BorderLayout());
        
        menuBar = new MenuBar();
        setJMenuBar(menuBar);
        fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter((new TextFileFilter()));
        menuBar.setMenuItemListener(new MenuItemListener() {
            @Override
            public void getMenuItem(JMenuItem menuItem) {
                String menuItemText = menuItem.getText();
                if (menuItemText.equals(messages.getString("export-title"))) {
                    int action = fileChooser.showSaveDialog(MainFrame.this);
                    if(action == JFileChooser.APPROVE_OPTION) {
                        try (PrintWriter writer = new PrintWriter (    
                                new File(
                                    fileChooser.getSelectedFile().getPath()))) {
                            writer.print(textPanel.getText());
                            JOptionPane.showMessageDialog(MainFrame.this,
                                    messages.getString("saved-message"),
                                    messages.getString("save-message"),
                                    JOptionPane.INFORMATION_MESSAGE);
                        } catch (FileNotFoundException ex) {
                            JOptionPane.showMessageDialog(MainFrame.this, 
                                    messages.getString("fail-export") +
                                    ex.getMessage(),
                                    messages.getString("file-not-found"),
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                else if (menuItemText.equals(messages.getString(
                        "quit-title"))) {
                        closeWindow();
                }
            } 
        });

        
        
        toolbar = new Toolbar();
        add(toolbar, BorderLayout.NORTH);
        toolbar.setVisible(false);
        
        formPanel = new FormPanel();
        add(formPanel, BorderLayout.WEST);
        formPanel.setListener(new FormListener() {
            @Override
            public void formSubmit(FormEvent formEvent) {
                String title = formEvent.getTitle();
                String content = formEvent.getContent();
                
                textPanel.appendText("Test Success");
        }
    });
        
    textPanel = new TextPanel();
    add(textPanel, BorderLayout.CENTER);
    
    setVisible(true);
        
    }
    
    private void closeWindow() {
        int action = JOptionPane.showConfirmDialog(MainFrame.this, 
            "Do you really want to quit?",
            "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
        if(action == JOptionPane.OK_OPTION){
            System.exit(0); // or e.getWindow().dispose();
        }
        else if (action == JOptionPane.CANCEL_OPTION) {
            // Return back to Main Frame
            JOptionPane.getFrameForComponent(MainFrame.this);
        }
    }

}
