package table_games;

public class Shuffler
{
    public static final int DEFAULT_RANDOM_MIN = 0;

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
