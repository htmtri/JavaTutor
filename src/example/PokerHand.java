package example;

/**
 * Deck Of Cards
 *
 * A program to model typical operations on a deck of cards.
 * Uses simple integer-based data structure for storage.
 *
 * @author jtk
 *
 * @date 2/8/13
 */

import java.util.Random;

public class PokerHand {
    int[] cards;  // storage for the deck of cards
    int size;  // the current number of available cards
    Random r;  // a random number generator for dealing

    /**
     * Constructs and initializes the deck of cards.
     */
    PokerHand() {
        cards = new int[52];
        for (int i = 0; i < cards.length; i++)
            cards[i] = i;
        shuffle();
        r = new Random();
    }

    /**
     * Shuffles the deck (by resetting the available card count).
     */
    void shuffle() {
        size = 52;
    }

    /**
     * Draws a card from the deck.
     *
     * @return An integer representing the card number.
     */
    int draw() {
        int i = r.nextInt(size);
        int card = cards[i];

        // swap the card drawn with the last available card...
        cards[i] = cards[size-1];
        cards[size-1] = card;
        size--;  // decrement: one less card available to draw

        return card;
    }

    /**
     * Draws a hand of cards from the deck.
     *
     * @param size the number of cards to draw.
     * @return an integer array of the cards drawn.
     */
    int[] drawHand(int size) {
        int[] hand = new int[size];
        for (int i = 0; i < size; i++)
            hand[i] = draw();
        return hand;
    }

    /**
     * Computes the suit of an integer card number.
     *
     * @param card the card number (0-51).
     * @return the suit of the card from "HSDC".
     */
    static String cardToSuit(int card) {
        return Character.toString("HSDC".charAt(card / 13));
    }

    /**
     * Computes the value (A-K) of an integer card number.
     *
     * @param card the card number (0-51).
     * @return the value of the card from "A23456789TJQK".
     */
    static String cardToValue(int card) {
        return Character.toString("A23456789TJQK".charAt(card % 13));
    }

    /**
     * Computes the 2-character name of a card.
     *
     * @param card the card number (0-51).
     * @return the string name of the card (e.g., "AH").
     */
    static String cardToName(int card) {
        return cardToValue(card) + cardToSuit(card);
    }

    /**
     * Computes a string representation of a hand of cards.
     *
     * @param hand an int array of card numbers (0-51).
     * @return the space-separated string names of the cards (e.g., "AH KC 3D").
     */
    static String handToString(int[] hand) {
        String result = "";
        for (int i = 0; i < hand.length; i++)
            result += cardToName(hand[i]) + " ";
        return result.substring(0, result.length()-1);
    }

    /**
     * Checks if a hand is a flush (all same suit).
     *
     * @param hand an int array of card numbers (0-51).
     * @return true if all cards in the hand are the same suit
     */
    static boolean isFlush(int[] hand) {
        for (int i = 1; i < hand.length; i++)
            if (!cardToSuit(hand[0]).equals(cardToSuit(hand[i])))
                return false;
        return true;
    }

    /**
     * main method used for testing and experiments.
     */
    public static void main(String[] args) {
        // Create a deck and print it out...
        PokerHand deck = new PokerHand();
        for (int i = 0; i < 52; i++)
            System.out.printf("%3s", cardToName(deck.draw()));
        System.out.printf("\n");

        // Shuffle the deck (reset to full deck)...
        deck.shuffle();

        // Print a set of four bridge hands identified by compass directions...
        String[] players = { "north", "south", "east", "west" };
        for (String player : players) {
            int[] hand = deck.drawHand(13);
            System.out.printf("%6s: %s\n", player, handToString(hand));
        }

        // Generate a set of 5-card poker hands and count the number of flushes...
        final int TRIALS = 100000;
        int count = 0;
        for (int i = 0; i < TRIALS; i++) {
            deck.shuffle();  // shuffle after each trial
            int[] hand = deck.drawHand(5);
            if (isFlush(hand)) {
                System.out.printf("flush: %s\n", handToString(hand));
                count++;
            }
        }
        System.out.printf("%d of %d hands were flushes: %.2f%%\n", count, TRIALS, (double) count/TRIALS*100);
    }
}