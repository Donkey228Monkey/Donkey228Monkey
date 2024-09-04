///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package com.mycompany.project0;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author redyr
 */
public class Manager{
    
    private String movie;
    private String list;
    
    public Manager(){
        
    }
    
    public Manager(String movie){
        this.movie = movie;
    }
    
    public String toString(){
        File file = new File(this.movie+".txt");
        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                this.list += scan.nextLine() + "\n";
            }
        } catch (FileNotFoundException ex) {
            
        }
        return list;
    }
    
}
