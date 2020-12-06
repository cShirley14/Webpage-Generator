package com.shirley.left_form;

import com.shirley.Languages;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Chantal Shirley
 */
public class FormPanel extends JPanel {
    private JLabel title_label;
    private JLabel content_label;
    private JLabel colorChooser_label;
    private JTextField title_field;
    private JTextArea content_field;
    private JTextField colorChooser_field;
    private JButton submit_button;
    private JButton choose_button;
    private FormListener formListener;
    private ResourceBundle messages = Languages.getResourceBundle();
    private String red;
    private String blue;
    private String green;
    
    public FormPanel() {
        Dimension size = getPreferredSize();
        size.width = 500;
        setPreferredSize(size);
        
        Border inner_border = BorderFactory.createTitledBorder(
                messages.getString("title"));
        Border outer_border = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outer_border, 
                inner_border));
        
        title_label = new JLabel(messages.getString("request-title"));
        content_label = new JLabel(messages.getString("request-content"));
        colorChooser_label = new JLabel(messages.getString("choose-color"));
        submit_button = new JButton(messages.getString("submit-button"));
        choose_button = new JButton(messages.getString("pick-button"));
        
        title_field = new JTextField(10);
        colorChooser_field = new JTextField(10);
        content_field = new JTextArea(20,20);
        
        choose_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Execute JColorChooser
                Color color = Color.RED;
                Color actualColor = JColorChooser.showDialog(choose_button,"Select a Color", color);
                System.out.println(actualColor.getRed());
                colorChooser_field.setText(actualColor.toString());
                colorChooser_field.enableInputMethods(false);
            }
        });
        
        submit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = title_field.getText();
                String content = content_field.getText();
                
                FormEvent event = new FormEvent(this, title, red, green,  
                        blue, content);
                if (formListener != null) {
                    formListener.formSubmit(event);
                }
            }
        });
     
        layoutComponents();
    }
    
    public void setListener(FormListener formListener) {
        this.formListener = formListener;
    }
    
    public void layoutComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        /******** First row ********/
        gc.weightx = 1;
        gc.weighty = 1;
        
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        add(title_label, gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(title_field, gc);
        
        /******** second row ********/
        gc.weightx = 1;
        gc.weighty = 1;
        
        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_END;
        add(content_label, gc);
        
        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        add(content_field, gc);
        
        /******** third row ********/
        gc.weightx = 1;
        gc.weighty = 1;
        
        gc.gridx = 0;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_END;
        add(colorChooser_label, gc);
        
        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        add(choose_button, gc);
        
        /******** fourth row ********/
        gc.weightx = 1;
        gc.weighty = 20;
        
        gc.gridx = 1;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(submit_button, gc);
    }
}
