/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprachaussagen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author Aksana
 */
public class FirstListener implements ActionListener {
    //um JLabel von Klasse UnserFrame zu greifen, ändern
    //wir definieren Variable und mit Konstruktor 
    //weisen in diese Variable JLabel von UnserFrame
    JLabel lbl;
    FirstListener (JLabel lbl){
        this.lbl=lbl;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        lbl.setText("Hallo");
    }
    
}
