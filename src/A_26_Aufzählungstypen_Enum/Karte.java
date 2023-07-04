package A_26_Aufzählungstypen_Enum;

import java.util.*;

public class Karte implements Comparable<Karte>{

    public enum Suit {
        DIAMONDS("Karo" ),
        HEARTS("Herz"),
        SPADES("Pik"),
        CLUBS("Kreuz");

        private final String name;

        private Suit(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public enum CardValue {
        SEVEN("7"),
        EIGHT("8"),
        NINE("9"),
        JACK("Bube"),
        QUEEN("Dame"),
        KING("König"),
        TEN("10"),
        ACE("Ass");

        private final String name;


        private CardValue(String name) {
            this.name = name;
        }


        @Override
        public String toString() {
            return name;
        }
    }


    private Suit suit;
    private CardValue cardValue;

    public Karte(int suitIndex, int cardValueIndex) {
       // System.out.println(Suit.values()[3]);                   //Gib Array von index zurück
       // System.out.println(Suit.values()[0].ordinal());       //liefert die Ordinalzahl der enum-Konstante
        Suit[] suits = Suit.values();                           //Lege liste von Enums an
        if (suitIndex >= 0 && suitIndex < suits.length) {
            this.suit = suits[suitIndex];
        } else {
            throw new IllegalArgumentException("Ungültiger Index für Suit: " + suitIndex);
        }

        CardValue[] cardValues = CardValue.values();
        if (cardValueIndex >= 0 && cardValueIndex < cardValues.length) {
            this.cardValue = cardValues[cardValueIndex];
        } else {
            throw new IllegalArgumentException("Ungültiger Index für CardValue: " + cardValueIndex);
        }
    }


    @Override
    public String toString() {
        return "{"+ suit + ", " + cardValue + '}';
    }

    @Override
    public int compareTo(Karte o) {
        int compareisonSuit = this.suit.compareTo(o.suit);

        if (compareisonSuit != 0) {
            return compareisonSuit;
        } else {
            return this.cardValue.compareTo(o.cardValue);
        }
    }
    /*@Override
    public int compareTo(Karte o) {
        if(o.cardValue.ordinal()-this.cardValue.ordinal() == 0){
            return o.cardValue.ordinal()-this.cardValue.ordinal();
        }
        else return o.cardValue.ordinal();
    }*/
}

class CardGame{

    List<Karte> cards = new LinkedList<>();

    public CardGame(int size){
        for(int i =0; i<4; i++){
            for( int j = 0; j<size/4; j++)
            {
                Karte karte = new Karte(i,j);
                cards.add(karte);

            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }
    public void sort(){
        Collections.sort(cards);
    }




    public Karte get(){
        Karte tmp = cards.get(0);
        cards.remove(0);
        return tmp;
    }
    public List<Karte> all(){
        return cards;
    }

    public static void main(String[] args) {
        CardGame cg = new CardGame(32);
        cg.shuffle();
        System.out.println(cg.cards);

        for(int i =0; i< 10; i ++) {
            if(cg.all().isEmpty()){
                System.out.println("Keine Karten mehr im Stapel.");
                break;
            }
            Karte tmp = cg.get();
            Karte heartSeven= new Karte(1,0);

            System.out.println(tmp + " Vergleich zu Herz-7:  " + tmp.compareTo(heartSeven));
        }

        cg.sort();
        System.out.println(cg.cards);

    }
}
