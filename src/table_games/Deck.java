package table_games;

import java.util.ArrayList;
import java.util.List;

/**
 * The Deck class represents a shuffled deck of cards. It provides several
 * operations including initialize, shuffle, deal, and check if empty.
 */
public class Deck
{

    /**
     * cards contains all the cards in the deck.
     */
    private List<Card> cards;

    /**
     * size is the number of not-yet-dealt cards. Cards are dealt from the top
     * (highest index) down. The next card to be dealt is at size - 1.
     */
    private int size;

    /**
     * Creates a new <code>Deck</code> instance.<BR>
     * It pairs each element of ranks with each element of suits, and produces one
     * of the corresponding card.
     * 
     * @param ranks is an array containing all of the card ranks.
     * @param suits is an array containing all of the card suits.
     * @param values is an array containing all of the card point values.
     */
    public Deck(String[] ranks, String[] suits, int[] values)
    {
        cards = new ArrayList<Card>(ranks.length);
        for(int a = 0; a < suits.length; a++)
        {
            for(int b = 0; b < ranks.length; b++)
                cards.add(new Card(ranks[b], suits[a], values[b]));
        }
        size = cards.size();
        shuffle();
    } // Deck()

    /**
     * Determines if this deck is empty (no undealt cards).
     * 
     * @return true if this deck is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return size == 0;
    } // isEmpty()

    /**
     * Accesses the number of undealt cards in this deck.
     * 
     * @return the number of undealt cards in this deck.
     */
    public int size()
    {
        return size;
    } // size()

    /**
     * Randomly permute the given collection of cards and reset the size to
     * represent the entire deck.
     */
    public void shuffle()
    {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
    } // shuffle()

    /**
     * Deals a card from this deck.
     * 
     * @return the card just dealt, or null if all the cards have been previously
     *         dealt.
     */
    public Card deal()
    {
        size--;
        if(size < 0)
            return null;
        else
            return cards.get(size);
    } // deal()

    /**
     * Generates and returns a string representation of this deck.
     * 
     * @return a string representation of this deck.
     */
    @Override
    public String toString()
    {
        String output = "size = " + size + "\nUndealt cards: \n";

        for(int k = size - 1; k >= 0; k--)
        {
            output = output + cards.get(k);
            // Insert carriage returns so entire deck is visible on console.
            output = output + "\n";
        }

        output = output + "\nDealt cards: \n";
        for(int k = cards.size() - 1; k >= size; k--)
        {
            output = output + cards.get(k);
            // Insert carriage returns so entire deck is visible on console.
            output = output + "\n";
        }

        output = output + "\n";
        return output;
    } // toString()

} // Deck
