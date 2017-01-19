/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprachaussagen;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameAussagen extends JFrame {
    
    JLabel textAussage;
    
    public FrameAussagen(String description){
       setSize(800,400);
       //always write ExitOnClose (if not, than Thread will stay open and never closes)  
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       setLocation(500, 250);  
       setTitle("Aussagen");
       setResizable(false);
       setLayout(null);
       
       textAussage = new JLabel(description);
       //to see the Text inside we use Bounds
       textAussage.setBounds(120,7,500,30);
       Font schrift = new Font ("Serif", Font.BOLD + Font.ITALIC, 22);
       textAussage.setFont(schrift);
       add(textAussage);
        
       setVisible(true);
    
    } 
}  