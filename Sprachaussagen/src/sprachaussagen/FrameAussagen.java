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
    
    JTextField eingabeZugNummer;
    JTextField eingabeZeit;
    JLabel textAussage;
    JButton buttonA;

    
    public FrameAussagen(){
       setSize(800,400);
       //always write ExitOnClose (if not, than Thread will stay open and never closes)  
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       setLocation(500, 250);  
       setTitle("Aussagen");
       setResizable(false);
       setLayout(null);
       
       eingabeZugNummer = new JTextField();
       eingabeZugNummer.setBounds(10,10,500,30);
       add(eingabeZugNummer);
       
       eingabeZeit = new JTextField();
       eingabeZeit.setBounds(10,60,500,30);
       add(eingabeZeit);
       
       buttonA = new JButton("Anzeigen");
       buttonA.setBounds(10,110,100,30);
       buttonA.addActionListener(new FirstListener());
       add(buttonA);

       textAussage = new JLabel();
       //to see the Text inside we use Bounds
       textAussage.setBounds(10,120,500,250);
       Font schrift = new Font ("Serif", Font.BOLD, 22);
       textAussage.setFont(schrift);
       textAussage.setForeground(Color.white);
       add(textAussage);
       
       getContentPane().setBackground(Color.BLUE);
       setVisible(true);
    
    } 
    
    private class FirstListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String s = eingabeZugNummer.getText();
        String s1 = eingabeZeit.getText();
        Zug zug =new Zug(s,s1);
        //TODO getter-setter Methods in Zug-Klass?
        String a="Den Zug "+zug.zug+" hat eine Verspätung um "+zug.zeitVersp+" Minuten";
        textAussage.setText(a);
    }
    
    }
}  