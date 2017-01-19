/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprachaussagen;

import java.io.*;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;


/**
 *
 * @author Aksana
 */
public class Sprachaussagen extends JFrame{

    public static void main(String[] args) {
        String zugName="";
        String zugZeitVersp="";
        BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
        try{
            zugName=br.readLine();
            zugZeitVersp=br.readLine();
            br.close();
        }
        catch(Exception e){
            System.out.println("Geben Sie bitte Zugnummer und Verspätungszeit!");
        }

        Zug zug =new Zug(zugName,zugZeitVersp);
        String a="Den Zug "+zug.zug+" hat eine Verspätung um "+zug.zeitVersp+" Minuten";
        JFrame jf = new FrameAussagen(a);
        
        ArrayList<String> aussagen = new ArrayList<String>();
        aussagenListfuellen(aussagen);
        
        spielen(aussagen.get(0));
        spielen(aussagen.get(1));
        spielen(aussagen.get(2));
        spielen(aussagen.get(3));
        spielen(aussagen.get(4));
        
        
    }    
    

    public  static void spielen(String name){
        try {
            String adresse="Audio/"+name+".wav";
            File soundFile = new File(adresse); //Звуковой файл
	
            //Получаем AudioInputStream
            //Вот тут могут полететь IOException и UnsupportedAudioFileException
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
	
            //Получаем реализацию интерфейса Clip
            //Может выкинуть LineUnavailableException
            Clip clip = AudioSystem.getClip();
	
            //Загружаем наш звуковой поток в Clip
            //Может выкинуть IOException и LineUnavailableException
            clip.open(ais);
	
            clip.setFramePosition(0); //устанавливаем указатель на старт
            clip.start(); //Поехали!!!

            //Если не запущено других потоков, то стоит подождать, пока клип не закончится
            //В GUI-приложениях следующие 3 строчки не понадобятся
            Thread.sleep(clip.getMicrosecondLength()/1000);
            clip.stop(); //Останавливаем
            clip.close(); //Закрываем
        } catch (Exception e) {
            System.out.println("Fehler bei der Soundausgabe!");
        }
    
    }
    
    
    static void aussagenListfuellen(ArrayList<String> aussagen){
        aussagen.add(0,"DenZug");
        aussagen.add(1,"hatVerspaetungUm");
        aussagen.add(2,"Minuten");
        aussagen.add(3,"NummerDesZuges");
        aussagen.add(4,"Zeit");
    }
    
    
   private static class Zug{
        private static String zug;
        private static String zeitVersp;
        
        Zug(String zug, String zeit){
            this.zug=zug;
            this.zeitVersp=zeit;
        }
   }
   
}