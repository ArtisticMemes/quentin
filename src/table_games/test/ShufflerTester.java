package table_games.test;

import table_games.Shuffler;

public class ShufflerTester
{

    public static void main(String[] args)
    {
        // Testing sorting
        int[] a = {
                9, 9, 1, 3, 2, 5, 6, 8
        };
        System.out.println("Sort 1 ---- \n");
        Shuffler.sort(a);
        for(int i = 0; i < a.length; i++)
            System.out.println(a[i]);

        // Testing shuffling
        int[] b = {
                1, 2, 3, 4, 5, 6
        };
        System.out.println("Shuffle 1 ---- \n");
        Shuffler.selectionShuffle(b);
        for(int integer : b)
            System.out.println(integer);
        System.out.println("Shuffle 2 ---- \n");
        Shuffler.selectionShuffle(b);
        for(int integer : b)
            System.out.println(integer);
    } // main()

} // ShufflerTester
