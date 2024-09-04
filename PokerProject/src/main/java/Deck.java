
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Deck extends Hand{
    Random rand = new Random();
    
    private static Cards.Card[] card = Cards.Card.values();
    private static Cards.Suit[] suit = Cards.Suit.values();

    
    
//    getDeck() method  building deck based on suit and card rank
    public void getDeck(){
        for(int i = 0; i < suit.length; i++){
            for(int j = 0; j < card.length; j++){
                Cards cardsInDeck = new Cards(card[j], suit[i]);
                this.add(cardsInDeck);
            }
        }  
    }
    
    
  
//    this method shuffles deck 
    
    public void shuffleDeck(){ 
        for(int i = cards.size() - 1; i > 0; i--){
            int randCard = rand.nextInt(i);
            Cards randomCard = cards.get(randCard);
            Cards lastCard = cards.get(i);
            
            cards.set(i, randomCard);
            cards.set(randCard, lastCard);
            
        }
    }
    
//    this method deals cards to the players
    public void deal(Hand hand){
        
        for(int i = 0; i < 5; i++){
            this.giveCard(cards.get(0), hand);
        }

            
    }
    
    public void redrad(Hand hand, int card1){
       
       hand.cards.remove(card1);   
       this.giveCard(cards.get(0), hand);
    }
    
    
    
}
