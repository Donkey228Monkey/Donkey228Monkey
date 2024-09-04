
import java.util.ArrayList;
import java.util.Collections;


public class Hand {

    private boolean isFullHouse() {
        return isThreeOfaKind() && isPair();
    }

    private boolean isThreeOfaKind() {
        return countPairs() == 6;
    }

    
    private boolean isTwoPair() {
        return countPairs() == 4;
    }

    private boolean isPair() {
        return countPairs() == 2;
    }

    private boolean isRoyalFlush() {
        return false;
    }
    
    
    enum Result{
        Win, Lose, Draw;
    }    
     enum Rank{
        HIGH_CARD, ONE_PAIR, TWO_PAIR, THREE_OF_A_KIND, STRAIGHT, FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH;
    }
        private int index = 0;
        private boolean returnVal = false;
        private static Cards card = new Cards();
        public ArrayList<Cards> cards;
        private static Cards.Card[] cardy = Cards.Card.values();
        private static Cards.Suit[] suit = Cards.Suit.values();

    public Hand(){
        cards = new ArrayList<Cards>(5);
        Collections.sort(cards);
    }
    public void add(Cards card){
        cards.add(card);
    }
    
    
    
    public String report(){
        String report = "";
        for(int i = 0; i < cards.size(); i++){
            card = cards.get(i);
            report += card.toString() + "\n";
        }
        return report;
    }
    
    /*
    for(int i = 0; i < card.
    
    */
    
    public void giveCard(Cards card, Hand hand){
         cards.remove(card);
         hand.add(card);
    }
    
    
    public Result call(Hand hand){
        if(checkRank().ordinal() > hand.checkRank().ordinal()){
            return Result.Win;
        }
        if(checkRank().ordinal() < hand.checkRank().ordinal()){
            return Result.Lose;
        }
            if(checkRank() == Rank.ONE_PAIR && hand.checkRank() == Rank.ONE_PAIR){
                if(hand.cards.get(index).getCard().ordinal() > cards.get(index).getCard().ordinal()){
                    return Result.Win;
                }if(hand.cards.get(index).getCard().ordinal() < cards.get(index).getCard().ordinal()){
                    return Result.Lose;
                }
            }
            if(checkRank() == Rank.TWO_PAIR && hand.checkRank() == Rank.TWO_PAIR){
                if(hand.cards.get(index).getCard().ordinal() > cards.get(index).getCard().ordinal()){
                    return Result.Win;
                }if(hand.cards.get(index).getCard().ordinal() < cards.get(index).getCard().ordinal()){
                    return Result.Lose;
                }
            }
            if(checkRank() == Rank.THREE_OF_A_KIND && hand.checkRank() == Rank.THREE_OF_A_KIND){
                if(hand.cards.get(index).getCard().ordinal() > cards.get(index).getCard().ordinal()){
                    return Result.Win;
                }if(hand.cards.get(index).getCard().ordinal() < cards.get(index).getCard().ordinal()){
                    return Result.Lose;
                }
            }
            if(checkRank() == Rank.STRAIGHT && hand.checkRank() == Rank.STRAIGHT){
                if(hand.cards.get(0).getCard().ordinal() > cards.get(0).getCard().ordinal()){
                    return Result.Win;
                }if(hand.cards.get(0).getCard().ordinal() < cards.get(0).getCard().ordinal()){
                    return Result.Lose;
                }
            }
            if(checkRank() == Rank.FLUSH && hand.checkRank() == Rank.FLUSH){
                if(hand.cards.get(0).getCard().ordinal() > cards.get(0).getCard().ordinal()){
                    return Result.Win;
                }if(hand.cards.get(0).getCard().ordinal() < cards.get(0).getCard().ordinal()){
                    return Result.Lose;
                }
            }
            
        return Result.Draw;
    }
    
    public int getIndex(int index){
        return index;
    }
    
    
    
     public Rank checkRank(){
        if(isStraightFlush()){
            return Rank.STRAIGHT_FLUSH;
        }
        if(isFourOfaKind()){
            return Rank.FOUR_OF_A_KIND;
        }
        if(isFullHouse()){
            return Rank.FULL_HOUSE;
        }
        if(isFlush()){
            return Rank.FLUSH;
        }
        if(isStraight()){
            return Rank.STRAIGHT;
        }
        if(isThreeOfaKind()){
            return Rank.THREE_OF_A_KIND;
        }
        if(isTwoPair()){
            return Rank.TWO_PAIR;
        }
        if(isPair()){
            return Rank.ONE_PAIR;
        }
       
        return Rank.HIGH_CARD;
    }
    
      public boolean isStraight(){
          int counter = 0;
          for(int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){      
                if(i == j) continue;
                
                if(cards.get(i).getCard().ordinal() == cards.get(j).getCard().ordinal() - 1)
                {
//                    return returnVal = true;
                    counter++;
                }
//                else returnVal = false;
            }
            
        }
            return counter == 3;
      }
    
      public boolean isFlush(){
          return countSuits() == 12;
      }
      
      public boolean isStraightFlush(){
          return isFlush() && isStraight();
      }

      public boolean isFourOfaKind(){
          return countPairs() == 12;
      }      
      
      
//the method counts amount of the cards with the same suit in the hand
    public int countSuits(){
        int counter = 0;
        for(int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){                   if(i == j) continue;        
                       
                if(cards.get(i).getSuit() == cards.get(j).getSuit()) counter++;
            }
        }    
        return counter;
    }
    
    //the function is meant to count pairs of cards with the same rank
    public int countPairs() {
        index = -1;
        int counter = 0;
        for(int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){        if(i == j) continue;  
                
                if(cards.get(i).getCard() == cards.get(j).getCard())
                {
                    counter++;
                    index++;
                }
            }
            
        }   
        
        return counter;
    }

    public void clear(Hand hand){
        for(int i = 0; i < 4; i++){
            hand.cards.remove(i);
        }
    }
}
