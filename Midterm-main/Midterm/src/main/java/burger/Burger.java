/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burger;

import java.util.ArrayList;

/**
 *
 * @author redyr
 */
public class Burger {

    private double costInCentsPerGram;
    private ArrayList<String> toppings = new ArrayList<>();
    private double baseCost;
    private int baseWeightInGrams;
    
    public Burger(double costInCentsPerGram, ArrayList<String> toppings,
                 double baseCost, int baseWeightInGrams){
        
        this.baseCost = baseCost;
        this.baseWeightInGrams = baseWeightInGrams;
        this.toppings = toppings;
        this.costInCentsPerGram = costInCentsPerGram;
    }
    
    public Burger(){    }

    public void addToppings(String topping) {
        this.toppings.add(topping);
    }

    //toppings are free? 
    public double getTotal(){
        return (this.costInCentsPerGram * this.baseWeightInGrams)+ this.baseCost;
    }
   
    public ArrayList<String> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
    }
    
    @Override
    public String toString(){
        for(int i = 0; i < getToppings().size(); i++){
            System.out.print(toppings.get(i) + " ");
        }
        return "\nBase cost is " + this.baseCost + "\tWeight in grams " + this.baseWeightInGrams + "\tCost per gram " +this.costInCentsPerGram + "\n\t\n\t\t\t\tTotal:" + getTotal();
    }
    
}
