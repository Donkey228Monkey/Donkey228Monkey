/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burger;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author redyr
 */
public class Main{
    
    public static void main(String args[]){
        
        
        File file = new File("burger.bin");
        Scanner scan = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        double costInCentsPerGram = 0.1;
        ArrayList<String> toppings = new ArrayList<>();
        double baseCost = 8.00;
        int baseWeightInGrams = 500;
        
        Burger burger = new Burger();
        
        System.out.println("1.Toppings\t2.Change burger size");
        
        int choice = scan.nextInt();
        switch(choice){
            case 1:
                String topping = scanner.nextLine();
                while(!topping.equalsIgnoreCase("STOP")){
                    burger.addToppings(topping);
                }
                break;
            case 2:
                int grams = scan.nextInt();
                baseWeightInGrams = grams;
                break;
        }
        
        burger = new Burger(costInCentsPerGram, toppings, baseCost, baseWeightInGrams);
            
        System.out.println(burger.toString());
        
        
//        try{
//        DataOutputStream dos = new DataOutputStream(
//                              new BufferedOutputStream(
//                              new FileOutputStream("burger.bin")));
//        
//        
//        dos.close();
//        }catch(IOException e){
//            System.out.println(e);
//        }
        
    }
    
}
