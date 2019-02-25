package table_games;

import java.util.ArrayList;
import java.util.List;

public class ThirteensBoard extends Board
{
    private static final String SPADE   = "spades";
    private static final String HEART   = "hearts";
    private static final String DIAMOND = "diamonds";
    private static final String CLUBS   = "clubs";

    /**
     * The size (number of cards) on the board.
     */
    private static final int BOARD_SIZE = 10;

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

    public ThirteensBoard()
    {
        super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
    } // ThirteensBoard()

    @Override
    public boolean isLegal(List<Integer> selectedCards)
    {
        ArrayList<Integer> values = new ArrayList<Integer>();
        // Convert from indices to point values
        for(int i = 0; i < selectedCards.size(); i++)
            values.add(cardAt(selectedCards.get(i)).pointValue());

        return isKing(values) || containsPairSum13(values);
    } // isLegal()

    @Override
    public boolean anotherPlayIsPossible()
    {
        for(int a = 0; a < BOARD_SIZE; a++)
        {
            if(cardAt(a).pointValue() == 13)
                return true;
            for(int b = 0; b < BOARD_SIZE; b++)
            {
                List<Integer> values = new ArrayList<Integer>();
                values.add(cardAt(a).pointValue());
                values.add(cardAt(b).pointValue());
                if(containsPairSum13(values))
                    return true;
            }
        }
        return false;
    } // anotherPlayIsPossible()

    private boolean isKing(List<Integer> values)
    {
        return values.size() == 1 && values.get(0) == 13;
    } // isKing()

    private boolean containsPairSum13(List<Integer> values)
    {
        if(values.size() == 2)
        {
            return values.get(0) + values.get(1) == 13;
        }
        else
            return false;
    } // containsPairSum11()

} // ThirteensBoard
