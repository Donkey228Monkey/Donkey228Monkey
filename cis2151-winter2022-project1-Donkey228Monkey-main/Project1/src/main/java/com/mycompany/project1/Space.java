/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change island license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit island template
 */
package com.mycompany.project1;

import java.util.ArrayList;

/**
 *
 * @author redyr
 */
public class Space extends Island {
    
    public ArrayList<Boolean> playerHas = new ArrayList<>();
    public ArrayList<Character> toolInventory = new ArrayList<>();
    
   
    
    
    
    public void isPickable(int[] t, ArrayList<Character> ti, int[] pc, boolean[] ps, char[][] bs){ 
        System.out.println(t[0] + " " + t[1]+ " " + t[2]);
        if(pc[0] == t[0] && pc[1] == t[0] && ps[0] != true){
                   ti.add('X');
                   ps[0] = true;
                   bs[t[0]][t[0]] = '_';
            }
        if(pc[0] == t[1] && pc[1] == t[1] && ps[1] != true){
                   ti.add('S');
                   ps[1] = true;
                   bs[t[1]][t[1]] = '_';
            }
        if(pc[0] == t[2] && pc[1] == t[2] && ps[2] != true){
                   ps[2] = true;
                   ti.add('H');
                   bs[t[2]][t[2]] = '_';
            }
    }
    
}
