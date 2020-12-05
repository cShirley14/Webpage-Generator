package com.shirley.left_form;

import com.shirley.Languages;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Chantal Shirley
 */
public class FormPanel extends JPanel {
    private JLabel title_label;
    private JLabel red_label;
    private JLabel green_label;
    private JLabel blue_label;
    private JLabel content_label;
    private JTextField title_field;
    private JTextField red_field;
    private JTextField blue_field;
    private JTextField green_field;
    private JTextField content_field;
    private JButton submit_button;
    private FormListener formListener;
    private ResourceBundle messages = Languages.getResourceBundle();
    
    public FormPanel() {
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);
        
        Border inner_border = BorderFactory.createTitledBorder(
                messages.getString("title"));
        Border outer_border = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outer_border, 
                inner_border));
        
        title_label = new JLabel(messages.getString("request-title"), 
                JLabel.LEFT);
        red_label = new JLabel(messages.getString("request-red"),
                JLabel.LEFT);
        blue_label = new JLabel(messages.getString("request-blue"),
                JLabel.LEFT);
        green_label = new JLabel(messages.getString("request-green"),
                JLabel.LEFT);
        content_label = new JLabel(messages.getString("request-content"),
                JLabel.LEFT);
        submit_button = new JButton(messages.getString("submit-button"));
        
        title_field = new JTextField(10);
        red_field = new JTextField(10);
        blue_field = new JTextField(10);
        green_field = new JTextField(10);
        content_field = new JTextField(10);
        submit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = title_field.getText();
                String red = red_field.getText();
                String blue = blue_field.getText();
                String green = green_field.getText();
                String content = content_field.getText();
                
                FormEvent event = new FormEvent(this, title, red, blue,
                    green, content);
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
        
        /******** Second row ********/
        gc.weightx = 1;
        gc.weighty = 1;
        
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        add(red_label, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(red_field, gc);
        
        /******** third row ********/
        gc.weightx = 1;
        gc.weighty = 1;
        
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        add(green_label, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(green_field, gc);
        
        /******** fourth row ********/
        gc.weightx = 1;
        gc.weighty = 1;
        
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        add(blue_label, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(blue_field, gc);
        
        /******** fifth row ********/
        gc.weightx = 1;
        gc.weighty = 1;
        
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        add(content_label, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(content_field, gc);
        
        /******** sixth row ********/
        gc.weightx = 1;
        gc.weighty = 20;
        
        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(submit_button, gc);
    }
}
