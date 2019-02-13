package table_games;

public class Shuffler
{
    public static final int DEFAULT_RANDOM_MIN = 0;

    public static boolean arePermutations(int[] a, int[] b)
    {
        if(a.length != b.length)
            return false;
        sort(a);
        sort(b);

        return a.equals(b);
    } // arePermutations()

    // Mixes int array
    public static void perfectShuffle(int[] array)
    {
        // ArrayIndexOutOfBounds exception avoidance
        if(array.length == 0)
            return;

        int end = array[array.length - 1];
        for(int i = 0; i < array.length - 1; i++)
        {
            array[i] = array[i + 1];
        }
        array[0] = end;
    } // perfectShuffle()

    // Randomize int array
    public static void selectionShuffle(int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            int r = random(0, array.length - 1);
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
