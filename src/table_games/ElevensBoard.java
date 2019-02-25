package table_games;

import java.util.ArrayList;
import java.util.List;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board
{
    private static final String SPADE   = "spades";
    private static final String HEART   = "hearts";
    private static final String DIAMOND = "diamonds";
    private static final String CLUBS   = "clubs";

    /**
     * The size (number of cards) on the board.
     */
    private static final int BOARD_SIZE = 9;

    /**
     * The ranks of the cards for this game to be sent to the deck.
     */
    private static final String[] RANKS = {
            "ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"
    };

    /**
     * The suits of the cards for this game to be sent to the deck.
     */
    private static final String[] SUITS = {
            SPADE, HEART, DIAMOND, CLUBS
    };

    /**
     * The values of the cards for this game to be sent to the deck.
     */
    private static final int[] POINT_VALUES = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
    };

    /**
     * Flag used to control debugging print statements.
     */
    private static final boolean TESTING = false;

    /**
     * Creates a new <code>ElevensBoard</code> instance.
     */
    public ElevensBoard()
    {
        super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
    } // ElevensBoard()

    /**
     * Determines if the selected cards form a valid group for removal. In Elevens,
     * the legal groups are (1) a pair of non-face cards whose values add to 11, and
     * (2) a group of three cards consisting of a jack, a queen, and a king in some
     * order.
     * 
     * @param selectedCards the list of the indices of the selected cards.
     * @return true if the selected cards form a valid group for removal; false
     *         otherwise.
     */
    @Override
    public boolean isLegal(List<Integer> selectedCards)
    {
        ArrayList<Integer> values = new ArrayList<Integer>();
        // Convert from indices to point values
        for(int i = 0; i < selectedCards.size(); i++)
            values.add(cardAt(selectedCards.get(i)).pointValue());
        return containsPairSum11(values) || containsJQK(values);
    } // isLegal()

    /**
     * Determine if there are any legal plays left on the board. In Elevens, there
     * is a legal play if the board contains (1) a pair of non-face cards whose
     * values add to 11, or (2) a group of three cards consisting of a jack, a
     * queen, and a king in some order.
     * 
     * @return true if there is a legal play left on the board; false otherwise.
     */
    @Override
    public boolean anotherPlayIsPossible()
    {
        for(int a = 0; a < BOARD_SIZE; a++)
        {
            for(int b = 0; b < BOARD_SIZE; b++)
            {
                List<Integer> selectedCards = new ArrayList<Integer>();
                selectedCards.add(cardAt(a).pointValue());
                selectedCards.add(cardAt(b).pointValue());
                if(containsPairSum11(selectedCards))
                    return true;
            }
        }
        List<Integer> cards = new ArrayList<Integer>();
        for(int i = 0; i < size(); i++)
            cards.add(cardAt(i).pointValue());
        return cards.contains(11) && cards.contains(12) && cards.contains(13);
    } // anotherPlayIsPossible()

    /**
     * Check for an 11-pair in the selected cards.
     * 
     * @param values selects a subset of this board. It is list of indexes into this
     *        board that are searched to find an 11-pair.
     * @return true if the board entries in selectedCards contain an 11-pair; false
     *         otherwise.
     */
    private boolean containsPairSum11(List<Integer> values)
    {
        if(values.size() == 2)
        {
            return values.get(0) + values.get(1) == 11;
        }
        else
            return false;
    } // containsPairSum11()

    /**
     * Check for a JQK in the selected cards.
     * 
     * @param values selects a subset of this board. It is list of indexes into this
     *        board that are searched to find a JQK group.
     * @return true if the board entries in selectedCards include a jack, a queen,
     *         and a king; false otherwise.
     */
    private boolean containsJQK(List<Integer> values)
    {
        boolean j = false;
        boolean q = false;
        boolean k = false;
        for(Integer value : values)
        {
            if(value == 11)
                j = true;
            if(value == 12)
                q = true;
            if(value == 13)
                k = true;
        }
        return j && q && k;
    } // containsJQK()

} // ElevensBoard
