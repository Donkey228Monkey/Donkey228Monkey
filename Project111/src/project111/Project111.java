/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project111;

import cis2151.project1.Plane;
import java.util.Scanner;

/**
 *
 * @PROJECT[1]
 * @author Raad Al Tayi
 * @class CIS2151
 * @tutor Eric Charnesky
 */
public class Project111 {

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       
            
        System.out.print("Hello! So we can start what is the plane model?");

        System.out.println("\nWhat is the model?");
        Scanner scan = new Scanner(System.in);
        String model = scan.nextLine();
        
        System.out.println("Welcome on w" + model + " how high are we flying today?");

        String max = scan.nextLine();
        int maximum = getInteger(max);

        Plane plane = new Plane(model, 0, maximum);
        int assister;
//        int initial = plane.getInititalAltitudeInFeet();
//        plane = new Plane(model, initial);
        int altitude = 0;
        
        do{
            
        
        
          
            
            altitude = plane.getCurrentAltitudeInFeet();
            plane = new Plane(model, altitude, maximum);

            menu();
            assister = scan.nextInt();


            int changeAltitude = 0;
            
            if(assister == 1){
                System.out.print("Altitude: ");
                changeAltitude = scan.nextInt();
                plane.changeCurrentAltitudeInFeet(changeAltitude);
            }
            
        choice(assister, altitude, changeAltitude, maximum);

        for(int i = 0; i < 10; i++){ System.out.print("-"); }
        
        
        altitude = plane.getCurrentAltitudeInFeet();
        plane.setCurrentAltitudeInFeet(altitude);

        plane = new Plane(model, altitude, maximum);
       
        
        }while(assister != 0);
        
        System.out.print("Till next time, captain!");
        System.exit(0);
              
      
           
             
    }
    
    private static void menu(){
        System.out.println("\n1.Change altitude\t2.Enable Gear\n3.Disable gear\t4.Status\n0.Exit");
    }
    
    
    private static void choice(int assister, int altitude, int changeAltitude, int maxAltitude){
            Plane plane = new Plane("", altitude, maxAltitude);
            
           switch(assister){
                case 1 :
                    plane.changeCurrentAltitudeInFeet(changeAltitude);
                    System.out.println("\nCurrent altitude is: " + plane.getCurrentAltitudeInFeet());
                    plane.setCurrentAltitudeInFeet(plane.getCurrentAltitudeInFeet());
                    break;
                case 2:
                    plane.setGearEnabled(plane.isGearEnabled());
                    break;
                case 3:
                    plane.setGearDisabled(plane.isGearEnabled());
                    break;
                case 4:
                    System.out.println("\nCurrent altitude is: " + plane.getCurrentAltitudeInFeet() + "\t Gear enabled: " + plane.isGearEnabled() + "\n");
                    break;
                default:
                    System.exit(0);
            }
    }
    
  private static int getInteger(String integer){
      try{
          Scanner scanner = new Scanner(System.in);
          integer = scanner.next();
      }catch(NumberFormatException e){
          System.out.println("Enter a number: ");
          e.toString();

      }
      int toInt = Integer.parseInt(integer);

      return toInt;
    }
  
  private String integerPlease(){

      return "Enter a number, please: ";
  }
    
}
