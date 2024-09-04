/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis2151.project1;

/**
 *
 * @author redyr
 */
public class Plane {
    
    private int inititalAltitudeInFeet = 950;
    private int currentAltitudeInFeet;
    private int maxAltitudeInFeet;
    private boolean gearEnabled;
    private String model;
    private int setCurrentAltitudeInFeet;
    
    public Plane(String model, int currentAltitudeInFeet, int maxAltitudeInFeet){
        this.currentAltitudeInFeet = currentAltitudeInFeet;
        this.gearEnabled = gearEnabled;
        this.maxAltitudeInFeet = maxAltitudeInFeet;
        this.model = model;
        this.inititalAltitudeInFeet = inititalAltitudeInFeet;
    }

    /**
     * @return the currentAltitudeInFeet
     */
    
    public int getInititalAltitudeInFeet() {
        return inititalAltitudeInFeet;
    }

    public void setInititalAltitudeInFeet(int inititalAltitudeInFeet) {
        this.inititalAltitudeInFeet = inititalAltitudeInFeet;
    }


    public void setSetCurrentAltitudeInFeet(int setCurrentAltitudeInFeet) {
        this.setCurrentAltitudeInFeet = setCurrentAltitudeInFeet;
    }

    /**
     * @param currentAltitudeInFeet the currentAltitudeInFeet to set
     * @param setCurrentAltitudeInFeet
     * @return 
     */
    public void changeCurrentAltitudeInFeet(int setCurrentAltitudeInFeet) {
        
           this.currentAltitudeInFeet = getCurrentAltitudeInFeet();
           int asd = this.currentAltitudeInFeet;           
           this.currentAltitudeInFeet = currentAltitudeInFeet + setCurrentAltitudeInFeet;
           
         if(this.currentAltitudeInFeet > this.maxAltitudeInFeet){
               setCurrentAltitudeInFeet(asd);
           }else{
           setCurrentAltitudeInFeet(this.currentAltitudeInFeet);}
}

    
    public int getCurrentAltitudeInFeet() {
        
        return currentAltitudeInFeet;
    }
     public void setCurrentAltitudeInFeet(int currentAltitudeInFeet) {
        
        this.currentAltitudeInFeet = currentAltitudeInFeet;
    }
    /**
     * @return the maxAltitudeInFeet
     */
    public int getMaxAltitudeInFeet() {
        return maxAltitudeInFeet;
    }

    /**
     * @param maxAltitudeInFeet the maxAltitudeInFeet to set
     */
    public void setMaxAltitudeInFeet(int maxAltitudeInFeet) {
        this.maxAltitudeInFeet = maxAltitudeInFeet;
    }

    /**
     * @return the gearEnabled
     */
   public boolean isGearEnabled() {
        if(currentAltitudeInFeet < 1000){
            gearEnabled = true;
        }
        else{
            gearEnabled = false;

        }
        return gearEnabled;
    }
    /**
     * @param gearEnabled the gearEnabled to set
     */
    public void setGearEnabled(boolean gearEnabled) {
        if(isGearEnabled() == true){
        this.gearEnabled = true;         
        System.out.println("Gear is enabled");
        }
        else{
            System.out.println("Too high ");
            this.gearEnabled = gearEnabled;
        }
    }

    
    public void setGearDisabled(boolean gearEnabled) {
        if(isGearEnabled() == false){
        this.gearEnabled = false;      
        System.out.println("Gear is disabled");            

        }
        else{
            System.out.println("Too low");
            this.gearEnabled = gearEnabled;
        }
    }
    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }
    
        
}
