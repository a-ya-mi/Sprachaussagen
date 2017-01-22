/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprachaussagen;

/**
 *
 * @author Aksana
 */
public class Zug {
    //TODO protected ist not the best idea here
        protected static String zug;
        protected static Integer zeitVersp;
        
        Zug(String zug, String zeit){
            this.zug=zug;
            this.zeitVersp=Integer.parseInt(zeit);
        }
        //TODO getter-setter Methods?
}

