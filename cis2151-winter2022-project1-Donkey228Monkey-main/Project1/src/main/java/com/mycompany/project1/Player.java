/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit template
 */
package com.mycompany.project1;

import static com.mycompany.project1.Island.blocks;
import static com.mycompany.project1.Island.playerCoordinate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author redyr
 */
public final class Player extends Island{
    
    public ArrayList<Character> toolInventory = new ArrayList<>();
    public boolean[] playerHas = {false, false, false};
    Scanner scan = new Scanner(System.in);
    int dirtInStock = 0;
    int woodInStock = 0;
    char dirt = '_';
    char woodH = '|';
    char woodV = '=';
    private static char[][] blocks1 = new char[20][20];
    private boolean[] directionBool = new boolean[4];
    

    public boolean[] getDirectionBool() {
        return directionBool;
    }

    public void setDirectionBool(boolean[] directionBool) {
        for(int i = 0; i < 4; i++){
            directionBool[i] = false;
        }
        this.directionBool = directionBool;
    }

    public void resetDirectionBool(boolean[] directionBool) {
        for(int i = 0; i < 4; i++){
            directionBool[i] = false;
        }
        this.directionBool = directionBool;
    }
    
    Space space = new Space();
    
    Player(){
        
        
        buildIsland();
        spawn();
        copy();
        getTool();
        printSpace();
        
//        space.isPickable();
    }
    
    void copy(){
        for(int i = 0; i < blocks.length; i++){
            for(int j = 0; j < blocks[i].length; j++){
                if(blocks[i][j] != '1'){
                    blocks1[i][j] = blocks[i][j];
                }else blocks1[i][j] = '_';
            }
        }
    }
    
     public void move(){
        space.isPickable(this.tool, this.toolInventory, Player.playerCoordinate, this.playerHas, blocks1);
        int choice, steps;
        
        System.out.println("What would like to do Adventurer?\n1.up\n2.left\n3.right\n4.down\n5.Inventory\n6.Use");
        choice = scan.nextInt();
        
        
        
        if(choice < 5){
            System.out.println("How many steps?");
            steps = scan.nextInt();
        }else steps = 0;
        switch(choice){
            case 1:
               directionBool[0] = true; 
               moveUp(steps);
               break;
            case 2:
               directionBool[1] = true; 
               moveLeft(steps);
               break;
            case 3:
               directionBool[2] = true; 
               moveRight(steps);
               break;
            case 4:
               directionBool[3] = true; 
               moveDown(steps);
               break;
            case 5:
                System.out.println(toolInventory);   
                break;
                
            case 6:
                use();
                break;
        }
        resetDirectionBool(directionBool);
        printSpace();
    }
     
     private void moveUp(int steps){
        blocks[playerCoordinate[0]][playerCoordinate[1]] = blocks1[playerCoordinate[0]][playerCoordinate[1]];
        blocks[playerCoordinate[0]-steps][playerCoordinate[1]] = '1';
        playerCoordinate[0] -= steps;
        System.out.println(playerCoordinate[0] + " " + playerCoordinate[1]);
     }
     
     private void moveLeft(int steps){
        blocks[playerCoordinate[0]][playerCoordinate[1]] = blocks1[playerCoordinate[0]][playerCoordinate[1]];
        blocks[playerCoordinate[0]][playerCoordinate[1]-steps] = '1';
        playerCoordinate[1] -= steps;
        System.out.println(playerCoordinate[0] + " " + playerCoordinate[1]);
     }
     
     private void moveRight(int steps){
        blocks[playerCoordinate[0]][playerCoordinate[1]] = blocks1[playerCoordinate[0]][playerCoordinate[1]];
        blocks[playerCoordinate[0]][playerCoordinate[1]+steps] = '1';
        playerCoordinate[1] += steps;
        System.out.println(playerCoordinate[0] + " " + playerCoordinate[1]);
     }
     
     private void moveDown(int steps){
        blocks[playerCoordinate[0]][playerCoordinate[1]] = blocks1[playerCoordinate[0]][playerCoordinate[1]];
        blocks[playerCoordinate[0]+steps][playerCoordinate[1]] = '1';
        playerCoordinate[0] += steps;
        System.out.println(playerCoordinate[0] + " " + playerCoordinate[1]);
     }

     private void use(){
         Random random = new Random();
         System.out.println("1.Shovel\n2.Hammer\n3.Axe");
         
         int useItem = scan.nextInt();
         
         switch(useItem){
            case 1:
                if(playerHas[1]){
                    blocks1[playerCoordinate[0]][playerCoordinate[1]] = ' ';
                    dirtInStock += random.nextInt(5-1) + 1;
                    System.out.println("You have " + dirtInStock + " dirt available");
                    break;
                }else{
                    System.out.println("Find a shovel first");
                    break;
                }
            case 2:
                if(playerHas[2]){
                System.out.println("1.Break\n2.Build");
                int useHammer = scan.nextInt();
                System.out.println("1.Up\n2.Left\n3.Right\n4.Down");
                int direction = scan.nextInt();
                
                    switch(useHammer){
                        case 1:
                            
                            
                            if(direction == 1 || direction == 4){
                                    breakVertical(direction, playerCoordinate, blocks1);
                            }
                            if(direction == 2 || direction == 3){
                                    breakHorizontal(direction, playerCoordinate, blocks1);
                            }
                            break;
                            
                        case 2:
                            if(direction == 1 || direction == 4){
                                    buildVertical(direction, playerCoordinate, blocks1);
                            }else buildHorizontal(direction, playerCoordinate, blocks1);
                            break;
                            
                    }
                }else System.out.println("Find a hammer");
            
            
            break; 
            case 3:
                if(playerHas[0]){
                    int i = 0;
                    int rand = 0;
                    while(i < treesHeight.size()){
                        if(playerCoordinate[0] == treesHeight.get(i) && playerCoordinate[1] == treesWidth.get(i)){
                            blocks1[playerCoordinate[0]][playerCoordinate[1]] = '_';
                            rand = random.nextInt(6-4)+4;
                            woodInStock += rand;
                            System.out.println("You have "+ woodInStock +" wood available");
                            break;
                        }else i++;
                    }
                    if(rand == 0)System.out.println("Nothing to chop");
                    break;
                }else System.out.println("Find an Axe");break;
            }
         }
     
     
     private char[][] buildVertical(int direction, int p[], char[][] b){
         
        System.out.println("How many blocks?");
        int bs = scan.nextInt();
        int x = p[0];
        int y = p[1];
        int i = 0;
         
         switch(direction){
            case 1:
                 while(i < bs){
                    blocks[x-i][y] = '|';
                    blocks1[x-i][y] = blocks[x-i][y];
                    System.out.println("did it " + (x-i) + " " + y + " " + blocks1[x-i][y]);
                    i++;
                 }
                break;
            case 4: 
                while(i < bs){
                    blocks[x+i][y] = '|';
                    blocks1[x+i][y] = blocks[x-i][y];
//                    System.out.println("did it " + (x-i) + " " + y + " " + blocks1[x-i][y]);
                    i++;
                 }
                 
         }
         
         return blocks1;
     }
     
      private char[][] buildHorizontal(int direction, int p[], char[][] b){
         
        System.out.println("How many blocks?");
        int bs = scan.nextInt();
        int x = p[0];
        int y = p[1];
        int i = 0;
         
         switch(direction){
            case 2:
                if(woodInStock >= bs){
                 while(i < bs){
                    woodInStock -= bs; 
                    blocks[x][y-i] = '=';
                    blocks1[x][y-i] = blocks[x][y-i];
                    System.out.println("did it " + (y-i) + " " + y + " " + blocks1[x-i][y]);
                    i++;
                 }
                } else System.out.println("Not enough of wood");
                 
                break;
            case 3: 
                if(woodInStock >= bs){
                    woodInStock -= bs; 
                    while(i < bs){
                        blocks[x][y+i] = '=';
                        blocks1[x][y+i] = blocks[x-i][y];
                        i++;
                     }
                } else System.out.println("Not enough of wood");
                 
         }
         
         return blocks1;
     }
     private char[][] breakVertical(int direction, int p[], char[][] bs){
         
        char[][] b = bs; 
        System.out.println("How many blocks?");
        int ss = scan.nextInt();
        int x = p[0];
        int y = p[1];
        int i = 0;
         
         switch(direction){
             case 1:
                 while(i < ss){
                     if(blocks[x-i][y] == '|' || blocks[x-i][y] == '='){
                        blocks[x-i][y] = '_';
                        blocks1[x-i][y] = blocks[x-i][y];
                        i++;
                         continue;
                     }else System.out.println("Next " + ss + " steps are not breakable");
                     i++;
                 }
                 break;
             case 4:
                while(i < ss){
                     if(blocks[x+i][y] == '|' || blocks[x-i][y] == '='){
                        blocks[x+i][y] = '_';
                        blocks1[x+i][y] = blocks[x-i][y];
                        i++;
                         continue;
                     }else System.out.println("Next " + ss + " steps are not breakable");
                     i++;
                 }
                 break;
                      
                 
         }
         
         return blocks1;
     }
     
      private char[][] breakHorizontal(int direction, int p[], char[][] bs){
         
        char[][] b = bs; 
        System.out.println("How many blocks?");
        int ss = scan.nextInt();
        int x = p[0];
        int y = p[1];
        int i = 0;
         
         switch(direction){
            case 3:
                 while(i < ss){
                     if(blocks[x][y+i] == '|'){
                        blocks[x+i][y+i] = '_';
                        blocks1[x+i][y+i] = blocks[x-i][y];
                        i++;
                         continue;
                     }else System.out.println("Next " + ss + " steps are not breakable");
                     i++;
                 }
                 break;
            case 2:
                while(i < ss){
                    if(blocks[x][y-i] == '|'){
                        blocks[x][y-i] = '_';
                        blocks1[x][y-i] = blocks[x-i][y];
                        i++;
                         continue;
                    }else System.out.println("Next " + ss + " steps are not breakable");
                    i++;
                }
                 break;     
                 
         }
         
         return blocks1;
        }
 
     }

