


public class Cards implements Comparable<Cards>{


    public Cards(){
        
    }

    @Override
    public int compareTo(Cards o) {
        return card.ordinal() - o.card.ordinal();
    }

     public enum Suit {
        Hearts, Spades, Diamonds, Clubs;
        
        private static final Suit[] suit = Suit.values();
        public static Suit getSuit(int i){
            return Suit.suit[i];
            }
        }
        
   
     
    
    public enum Card{
        Ace, 
        King, Queen, Jack,
        Ten, Nine, Eight, 
        Seven, Six, Five, 
        Four, Three, Two;
        
        private static final Card[] card = Card.values();
        public static Card getCard(int i){
            return Card.card[i];
        }
    }
    
   
    
    private Suit suit;
    private Card card;

    public Card getCard() {
        return this.card;
    }

    
    public Cards(final Card card, final Suit suit){
        
        this.card = card;
        this.suit = suit;
        
    }



    public Suit getSuit() {
        return this.suit;
    }


    @Override
    public String toString(){
        return card + " of " + suit;
    }
    
   
    
}
