package table_games.test;

import table_games.Card;

/**
 * This is a class that tests the Card class.
 */
public class CardTester
{
    /**
     * The main method in this class checks the Card operations for consistency.
     * 
     * @param args is not used.
     */
    public static void main(String[] args)
    {
        System.out.println(new Card("test", "test", -5).matches(new Card("test", "test", -5))); // nonsensical values
        System.out.println(new Card("king", "hearts", 13).matches(new Card("king", "hearts", 13))); // real values
        System.out.println(new Card("king", "hearts", 13).matches(new Card("queen", "hearts", 12))); // nonmatching
    } // main()

} // CardTester
