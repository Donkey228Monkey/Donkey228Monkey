/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1;

import java.util.Random;

/**
 *
 * @author redyr
 */
public class AnimalCraft {
    
    public static void main(String args[]){
        
        Player p = new Player();
        Island i = new Island();
        Random random = new Random();
      
//        p.spawn();
        boolean game = true;
        while(game){
            p.move();
        }
        
    }
    
}
