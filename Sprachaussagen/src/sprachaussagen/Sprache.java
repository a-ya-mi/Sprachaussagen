/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprachaussagen;

import javax.sound.sampled.AudioInputStream;
import marytts.LocalMaryInterface;
import marytts.MaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.util.data.audio.AudioPlayer;
/**
 *
 * @author Aksana
 */

//MaryTTS oder OpenMary fuer Lesen von Text

public class Sprache {

    private MaryInterface marytts;
    private AudioPlayer ap;
            
    public Voice(String voiceName)
    {
        try
        {
            marytts = new LocalMaryInterface();
            marytts.setVoice(voiceName);
            ap = new AudioPlayer();
        }
        catch (MaryConfigurationException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void say(String input)
    {
        try
        {
            AudioInputStream audio = marytts.generateAudio(input);
            
            ap.setAudio(audio);
            ap.start();
        }
        catch (SynthesisException ex)
        {
            System.err.println("Error saying phrase.");
        }
    }
}  
