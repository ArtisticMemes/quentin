package table_games.test;

import table_games.Shuffler;

public class ShufflerTester
{

    public static void main(String[] args)
    {
        int[] a = {
                9, 9, 1, 3, 2, 5, 6, 8
        };
        Shuffler.sort(a);
        for(int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    } // main()

} // ShufflerTester
