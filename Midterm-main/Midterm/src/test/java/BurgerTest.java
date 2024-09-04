/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import burger.Burger;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author redyr
 */
public class BurgerTest {
    
    public BurgerTest() {
    }
    
   @Test
   public void testTotal(){
       Burger burger = new Burger();
       
       ArrayList<String> toppings = new ArrayList<>();
       burger.addToppings("Cheese");
       burger.addToppings("Bacon");
       burger.addToppings("Onions");
       burger.addToppings("Spaghetti");
       
       
       
       burger = new Burger(0.01, toppings, 2.00, 600);
       double actualResult = burger.getTotal();
       double expectedResult = 8.00;
       
       assertEquals(expectedResult, actualResult);
   }
   
}
