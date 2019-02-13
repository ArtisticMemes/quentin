package table_games.test;

import java.util.Arrays;

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
                2, 3, 4, 1
        };
        System.out.println("Shuffle 1 ---- \n");
        Shuffler.selectionShuffle(b);
        for(int integer : b)
            System.out.println(integer);
        System.out.println("Shuffle 2 ---- \n");
        Shuffler.selectionShuffle(b);
        for(int integer : b)
            System.out.println(integer);

        // Target sequence
        int[] c = new int[]{
                4, 3, 2, 1
        };
        int i = 0;
        while(i < 400 && !Arrays.equals(b, c)) // max of 400 randomizations
        {
            i++;
            System.out.print("\n" + i + " --> ");
            Shuffler.selectionShuffle(b);
            for(int integer : b)
                System.out.print(integer);
        }
        System.out.println("\nShuffle Until Desired Output ---- \n");
        for(int integer : b)
            System.out.println(integer);
    } // main()

} // ShufflerTester
