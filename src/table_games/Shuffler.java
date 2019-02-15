package table_games;

import java.util.Arrays;

public class Shuffler
{
    public static final int DEFAULT_RANDOM_MIN = 0;

    /**
     * The number of consecutive shuffle steps to be performed in each call to each
     * sorting procedure.
     */
    private static final int SHUFFLE_COUNT = 20;

    /**
     * The number of values to shuffle.
     */
    private static final int VALUE_COUNT = 6;

    /**
     * Tests shuffling methods.
     * 
     * @param args is not used.
     */
    public static void main(String[] args)
    {
        System.out.println("Results of " + SHUFFLE_COUNT + " consecutive perfect shuffles:");
        int[] values1 = new int[VALUE_COUNT];
        for(int i = 0; i < values1.length; i++)
        {
            values1[i] = i;
        }
        for(int j = 1; j <= SHUFFLE_COUNT; j++)
        {
            perfectShuffle(values1);
            System.out.print("  " + j + ":");
            for(int k = 0; k < values1.length; k++)
            {
                System.out.print(" " + values1[k]);
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Results of " + SHUFFLE_COUNT + " consecutive efficient selection shuffles:");
        int[] values2 = new int[VALUE_COUNT];
        for(int i = 0; i < values2.length; i++)
        {
            values2[i] = i;
        }
        for(int j = 1; j <= SHUFFLE_COUNT; j++)
        {
            selectionShuffle(values2);
            System.out.print("  " + j + ":");
            for(int k = 0; k < values2.length; k++)
            {
                System.out.print(" " + values2[k]);
            }
            System.out.println();
        }
        System.out.println();
    } // main()

    public static boolean arePermutations(int[] a, int[] b)
    {
        if(a.length != b.length)
            return false;
        sort(a);
        sort(b);

        return Arrays.equals(a, b);
    } // arePermutations()

    // Mixes int array
    public static void perfectShuffle(int[] array)
    {
        // ArrayIndexOutOfBounds exception avoidance
        if(array.length == 0)
            return;

        int start = array[0];
        for(int i = 0; i < array.length - 1; i++)
        {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = start;
    } // perfectShuffle()

    // Randomize int array
    public static void selectionShuffle(int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            int r = random(array.length - 1);
            int tmp = array[i];
            array[i] = array[r];
            array[r] = tmp;
        }
    } // selectionShuffle()

    // Selection sort for an int array
    public static void sort(int[] array)
    {
        // Select a index that will be replaced with its sorted value
        for(int select = 0; select < array.length; select++)
        {
            // low is short for index with lowest value
            int low = select;

            // Find any value that is lower than the value in the selected index
            for(int find = select; find < array.length; find++)
            {
                if(array[find] < array[low])
                {
                    low = find;
                }
            }

            // Swap the selected index with the lowest value found index
            int tmp = array[select];
            array[select] = array[low];
            array[low] = tmp;
        }
    } // sort()

    public static String flip()
    {
        int random = random(2);
        if(random == 0 || random == 1)
            return "heads";
        else
            return "tails";
    } // flip()

    public static int random(int min, int max)
    {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    } // random(int, int)

    public static int random(int max)
    {
        return random(DEFAULT_RANDOM_MIN, max);
    } // random(int)

} // Shuffler
