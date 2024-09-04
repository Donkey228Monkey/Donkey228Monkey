/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.project1;

/**
 *
 * @author redyr
 */
public interface Toolinterface {
    
    public boolean isBuildable(int steps, char[][] bs, int[] coordinates, int direction);
    public boolean isDigable();
    public boolean isChopable();
    
}
