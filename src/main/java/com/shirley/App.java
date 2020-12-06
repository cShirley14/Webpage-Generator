package com.shirley;

import javax.swing.SwingUtilities;

/**
 *
 * @author Chantal Shirley
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Languages.setResourceBundle(Languages.LanguageOptions.SPANISH);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }
}
