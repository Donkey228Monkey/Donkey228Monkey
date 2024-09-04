/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project0;

import java.io.FileNotFoundException;

/**
 *
 * @author redyr
 */
public class Main {
    
    public static void main(String args[]) throws FileNotFoundException{
        
            Theater harryPotter = new Theater(10);
            Theater ecanto = new Theater(20);
            Theater matrix = new Theater(15);
        
            
            harryPotter.reserveSeat("Steve", "HarryPotter", "3");
            harryPotter.reserveSeat("Joe", "HarryPotter", "6");
            harryPotter.reserveSeat("Joe", "HarryPotter", "7");
            harryPotter.reserveSeat("Joe", "HarryPotter", "8");
            
            ecanto.reserveSeat("Joe", "Ecanto", "6");
            ecanto.reserveSeat("Steve", "Ecanto", "6");
            
            Manager manager1 = new Manager("HarryPotter");
            Manager manager2 = new Manager("Ecanto");
//            Manager manager3 = new Manager("HarryPotter");
            
            System.out.println(manager1.toString());
            System.out.println(manager2.toString());
            
    }
    
}
