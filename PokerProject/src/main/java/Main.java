
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DonkeyMonkey
 */
public class Main extends Cards {
    
    public static void main(String[] args){
        
        int balance1 = 100;
        int balance2 = 100;
        
        Hand hand1 = new Hand();
        Hand hand2 = new Hand();

        
        Random rand = new Random();
        
        
  
        
        
        
        
        
//        hand1.add(new Cards(Cards.Card.Seven, Cards.Suit.Hearts));
//        hand1.add(new Cards(Cards.Card.Six, Cards.Suit.Spades));
//        hand1.add(new Cards(Cards.Card.Five, Cards.Suit.Hearts));
//        hand1.add(new Cards(Cards.Card.Four, Cards.Suit.Hearts));
//        hand1.add(new Cards(Cards.Card.Three, Cards.Suit.Hearts));
//        System.out.println(hand1.countPairs());
        
        
        
       

        while(balance1 != 0 || balance2 != 0){
        Deck d1 = new Deck();
        Hand h1 = new Hand();
        Hand h2 = new Hand();             
        d1.getDeck();
        d1.shuffleDeck();        
        
        
        d1.deal(h1);
        d1.deal(h2);
        
        Collections.sort(h1.cards);
        Collections.sort(h2.cards);
        
        System.out.println(h1.report());
        System.out.println(h1.checkRank());

        
        System.out.println("Stick or twist?(1 or 2)");

        
        Scanner scan = new Scanner(System.in);
        
        int choice = scan.nextInt();
        
//            if(choice == 2){
//
//
//                int sda = scan.nextInt();
//
//                d1.redrad(h1, sda);
//                Collections.sort(h1.cards);
//
//                System.out.println(h1.report() + "\n" + h1.checkRank());
//            }
        
        
        
        balance2--;
        balance1--;
        
        System.out.println("\nYour balance is: " + balance1);
        
        System.out.println(h1.report() + "\n" + h1.call(h2)); 
        
        System.out.println(h2.report());
        
       
        
        if(h1.call(hand2) == Hand.Result.Win){
            balance1 += 2;
        }
        else if(h1.call(hand2) == Hand.Result.Lose)balance2 +=2;
        
        }
        
        

        
        
    }
    
}
