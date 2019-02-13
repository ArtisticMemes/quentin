package table_games.test;

import table_games.Deck;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester
{
    public static void main(String[] args)
    {
        // variables
        String[] ranks = {
                "yike", "oof", "darn"
        };
        String[] suit = {
                "hart", "dimon", "clud", "shovel"
        };
        int[] values = {
                1, 2, 3
        };

        // creating the deck
        Deck deck = new Deck(ranks, suit, values);

        // the testing part
        System.out.println("the deck  \n" + deck);
        System.out.println("size of the deck " + deck.size());
        deck.deal();
        System.out.println("size of the deck afer one \"deal\" " + deck.size());
        deck.deal();
        deck.deal();

        System.out.println("\n\nthe deck after dealing  \n" + deck);
    } // main()
} // DeckTester
