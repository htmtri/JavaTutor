package example;
import java.util.Random;

public class DeckofCards {
    int size;
    int[] Deck;
    Random rand;

    DeckofCards(){
        shuffle();
        Deck = new int[size];
        for(int i = 0;i<size;i++ ){
            Deck[i] = i;
        }
        rand = new Random();
    }

    void showDeck(){
        for(int i = 0; i < size; i++){
            System.out.println("Remaining: " + getValue(Deck[i]) + " of " + getSuit(Deck[i]));
        }
    }

    int getSize(){
       return size;
    }

    String getSuit(int n){
        String suit = "";
        switch (n/13){
            case 0: suit = "Heart";
                    break;
            case 1: suit = "Spades";
                    break;
            case 2: suit = "Diamond";
                    break;
            case 3: suit = "Club";
                    break;
            default: System.exit(0);
        }
        return suit;
    }

    String getValue(int n){
        String value = "";
        switch (n%13){
            case 0: value = "Ace";
                    break;
            case 1: value = "2";
                    break;
            case 2: value = "3";
                    break;
            case 3: value = "4";
                    break;
            case 4: value = "5";
                    break;
            case 5: value = "6";
                    break;
            case 6: value = "7";
                    break;
            case 7: value = "8";
                    break;
            case 8: value = "9";
                    break;
            case 9: value = "10";
                    break;
            case 10:value = "Jack";
                    break;
            case 11:value = "Queen";
                    break;
            case 12:value = "King";
                    break;
            default: System.exit(0);
        }
        return value;
    }

    void draw(){
        int i = rand.nextInt(51);
        int card = Deck[i];
        System.out.println("Drawn " + getValue(card) + " of " + getSuit(card));
        Deck[i] = Deck[size-1];
        Deck[size-1] = card;
        size--;
    }

    void shuffle(){
        size = 52;
    }

    public static void main(String[] args) {
        DeckofCards newDeck = new DeckofCards();
        while (newDeck.getSize()>2) {
            newDeck.draw();
        }
        newDeck.showDeck();
    }
}
