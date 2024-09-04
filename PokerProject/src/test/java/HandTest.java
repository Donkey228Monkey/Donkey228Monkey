/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author redyr
 */
public class HandTest {
    
    
    public HandTest() {
    }

//    @org.junit.Test
//    public void testAdd() {
//        System.out.println("add");
//        Cards card = null;
//        Hand instance = new Hand();
//        instance.add(card);
//        fail("The test case is a prototype.");
//    }

    @org.junit.Test
    public void testAPair() {
        
        Hand hand1 = new Hand();
        

        hand1.add(new Cards(Cards.Card.Ace, Cards.Suit.Diamonds));
        hand1.add(new Cards(Cards.Card.Four, Cards.Suit.Clubs));
        hand1.add(new Cards(Cards.Card.Four, Cards.Suit.Spades));
        hand1.add(new Cards(Cards.Card.Three, Cards.Suit.Hearts));
        hand1.add(new Cards(Cards.Card.Two, Cards.Suit.Diamonds));
        

        Hand.Rank expectedResult = Hand.Rank.ONE_PAIR;
        Hand.Rank actualResult = hand1.checkRank();
        int expectedIndex = 1;
        int expectedIndex1 = 2;
        
        
        
        assertEquals(expectedResult, actualResult);
        
    }
    
    
    
    @org.junit.Test
    public void testTwoPairs() {
        
        Hand hand1 = new Hand();
        Hand hand2 = new Hand();
        

        hand1.add(new Cards(Cards.Card.Six, Cards.Suit.Diamonds));
        hand1.add(new Cards(Cards.Card.Six, Cards.Suit.Clubs));
        hand1.add(new Cards(Cards.Card.Three, Cards.Suit.Spades));
        hand1.add(new Cards(Cards.Card.Three, Cards.Suit.Spades));
        hand1.add(new Cards(Cards.Card.Four, Cards.Suit.Hearts));
        

        
        
        Hand.Rank expectedResult = Hand.Rank.TWO_PAIR;
        Hand.Rank actualResult = hand1.checkRank();
        
        assertEquals(expectedResult, actualResult);
    }
     @org.junit.Test
     public void testFlush() {
        
        Hand hand1 = new Hand();
        

        hand1.add(new Cards(Cards.Card.Three, Cards.Suit.Hearts));
        hand1.add(new Cards(Cards.Card.Six, Cards.Suit.Hearts));
        hand1.add(new Cards(Cards.Card.Two, Cards.Suit.Hearts));
        hand1.add(new Cards(Cards.Card.Five, Cards.Suit.Hearts));
        hand1.add(new Cards(Cards.Card.Four, Cards.Suit.Hearts));
        

        
        
        Hand.Rank expectedResult = Hand.Rank.FLUSH;
        Hand.Rank actualResult = hand1.checkRank();
        
        assertEquals(expectedResult, actualResult);
    }
     
    @org.junit.Test
    public void testThreeOfaKind() {
        
        Hand hand1 = new Hand();
        Hand hand2 = new Hand();
        

        hand1.add(new Cards(Cards.Card.Seven, Cards.Suit.Diamonds));
        hand1.add(new Cards(Cards.Card.Seven, Cards.Suit.Clubs));
        hand1.add(new Cards(Cards.Card.Seven, Cards.Suit.Spades));
        hand1.add(new Cards(Cards.Card.Four, Cards.Suit.Spades));
        hand1.add(new Cards(Cards.Card.Five, Cards.Suit.Hearts));
        

        Hand.Rank expectedResult = Hand.Rank.THREE_OF_A_KIND;
        Hand.Rank actualResult = hand1.checkRank();
        
        assertEquals(expectedResult, actualResult);
    }
    @org.junit.Test
    public void testStraigt() {
        
        Hand hand1 = new Hand();
        

        hand1.add(new Cards(Cards.Card.Seven, Cards.Suit.Hearts));
        hand1.add(new Cards(Cards.Card.Six, Cards.Suit.Spades));
        hand1.add(new Cards(Cards.Card.Five, Cards.Suit.Hearts));
        hand1.add(new Cards(Cards.Card.Four, Cards.Suit.Hearts));
        hand1.add(new Cards(Cards.Card.Three, Cards.Suit.Hearts));
        

        
        
        Hand.Rank expectedResult = Hand.Rank.STRAIGHT;
        Hand.Rank actualResult = hand1.checkRank();
        
        assertEquals(expectedResult, actualResult);
    }
    @org.junit.Test
    public void testFourOfaKind() {
        
        Hand hand1 = new Hand();
        

        hand1.add(new Cards(Cards.Card.Seven, Cards.Suit.Hearts));
        hand1.add(new Cards(Cards.Card.Seven, Cards.Suit.Spades));
        hand1.add(new Cards(Cards.Card.Seven, Cards.Suit.Hearts));
        hand1.add(new Cards(Cards.Card.Seven, Cards.Suit.Hearts));
        hand1.add(new Cards(Cards.Card.Three, Cards.Suit.Hearts));
        

        
        
        Hand.Rank expectedResult = Hand.Rank.FOUR_OF_A_KIND;
        Hand.Rank actualResult = hand1.checkRank();
        
        assertEquals(expectedResult, actualResult);
    }
    @org.junit.Test
    public void testStraigtFlush() {
        
        Hand hand1 = new Hand();
        

        hand1.add(new Cards(Cards.Card.Seven, Cards.Suit.Hearts));
        hand1.add(new Cards(Cards.Card.Six, Cards.Suit.Hearts));
        hand1.add(new Cards(Cards.Card.Five, Cards.Suit.Hearts));
        hand1.add(new Cards(Cards.Card.Four, Cards.Suit.Hearts));
        hand1.add(new Cards(Cards.Card.Three, Cards.Suit.Hearts));
        

        
        
        Hand.Rank expectedResult = Hand.Rank.STRAIGHT_FLUSH;
        Hand.Rank actualResult = hand1.checkRank();
        
        assertEquals(expectedResult, actualResult);
    }
//    public void testGiveCard() {
//        System.out.println("giveCard");
//        Cards card = null;
//        Hand hand = null;
//        Hand instance = new Hand();
//        instance.giveCard(card, hand);
//        fail("The test case is a prototype.");
//    }

//    @org.junit.Test
//    public void testCheckHand() {
//        System.out.println("checkHand");
//        Hand instance = new Hand();
//        String expResult = "";
//        String result = instance.checkHand();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
    
}
