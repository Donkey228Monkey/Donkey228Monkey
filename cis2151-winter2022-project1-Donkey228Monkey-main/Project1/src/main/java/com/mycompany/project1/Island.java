/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author redyr
 */
public class Island {
    
    public static char[][] blocks = new char[20][20];
     
    private Random rand = new Random();
    public int[] toolCoordinates = new int[3];
    public int[] tool = new int[3];
    

    public int[] getToolCoordinates() {
        return toolCoordinates;
    }

    public void setToolCoordinates(int[] toolCoordinates) {
        this.toolCoordinates = toolCoordinates;
    }

    public int[] getTool() {
        return tool;
    }

    public void setTool(int[] tool) {
        this.tool = tool;
    }

    public static int[] getPlayerCoordinate() {
        return playerCoordinate;
    }

    public static void setPlayerCoordinate(int[] playerCoordinate) {
        Island.playerCoordinate = playerCoordinate;
    }

    public int[] getResourcesCoordinates() {
        return resourcesCoordinates;
    }

    public void setResourcesCoordinates(int[] resourcesCoordinates) {
        this.resourcesCoordinates = resourcesCoordinates;
    }

   
    public static int[] playerCoordinate = new int[2];
    private int[] resourcesCoordinates = new int[2];
    int[][] treeCoordinate; 
    public ArrayList<Integer> treesWidth = new ArrayList<>();
    public ArrayList<Integer> treesHeight = new ArrayList<>();
            
    
    
    
    public char[][] getBlocks() {
        return blocks;
    }

    public void setBlocks(char[][] blocks) {
        this.blocks = blocks;
    }
    
    public char[][] buildIsland(){
        
        this.tool[0] = rand.nextInt(this.blocks.length - 1) + 1;
        this.tool[1] = rand.nextInt(this.blocks.length - 1) + 1;
        this.tool[2] = rand.nextInt(this.blocks.length - 1) + 1;
        
        while(this.tool[0] == this.tool[1] || this.tool[1] == this.tool[2] || this.tool[0] == this.tool[2]){
        this.tool[0] = rand.nextInt(blocks.length - 1) + 1;
        this.tool[1] = rand.nextInt(blocks.length - 1) + 1;
        this.tool[2] = rand.nextInt(blocks.length - 1) + 1;            
        }
        
        for(int i = 0; i < blocks.length; i++){
            for(int j = 0; j < blocks[i].length; j++){
                blocks[i][j] = '_';
            }
        }
        
        blocks[this.tool[0]][this.tool[0]] = 'X';
        blocks[this.tool[1]][this.tool[1]] = 'S';
        blocks[this.tool[2]][this.tool[2]] = 'H';
        setTool(this.tool);
        
        for(int z = 0; z < 40; z++){
            int t = rand.nextInt(20);
            int i = rand.nextInt(20);
                if(blocks[t][i] != blocks[tool[0]][tool[0]] && blocks[t][i] != blocks[tool[1]][tool[1]] && blocks[t][i] != blocks[tool[2]][tool[2]]){
                    blocks[t][i] = 'T';
                    treesWidth.add(i);
                    treesHeight.add(t);
//                    treesCoordinates.add(z, blocks[t][i]);
                }
        }

        return blocks;
    }
    
    public String printSpace(){
        for(int i = 0; i < blocks.length; i++){
            for(int j = 0; j < blocks.length; j++){
                if(i == blocks.length){
                    System.out.println("");
                }
                System.out.print(blocks[i][j]+" ");
            }
            System.out.println();
            
        }
        return "";
    }
    
    public char[][] spawn(){
        Island.playerCoordinate[0] = 10;
        Island.playerCoordinate[1] = 10;
        Island.blocks[Island.playerCoordinate[0]][Island.playerCoordinate[1]] = '1';
        return Island.blocks;
    }
    
   
    
    
}
