/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1;

import java.util.ArrayList;

/**
 *
 * @author redyr
 */
public class Tool implements Toolinterface{

    @Override
    public boolean isBuildable(int steps, char[][] bs, int[] coordinates, int d) {
        for(int ss = 0; ss < steps; ss++ ){
            if(bs[coordinates[0]][coordinates[1]] == ' '){
                return true;
            }else System.out.println("Next " + steps + " steps are not diggable");return false;
        }
        return false;
    }

    @Override
    public boolean isChopable() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isDigable() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
        
}
