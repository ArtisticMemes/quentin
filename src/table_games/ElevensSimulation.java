package table_games;

/**
 * This is a class that plays noninteractive games of Elevens. See accompanying
 * documents for a description of how Elevens is played.
 */
public class ElevensSimulation
{

    /**
     * The number of games of Elevens to play.
     */
    private static final int GAMES_TO_PLAY = 100000;

    /**
     * Flag used to control debugging print statements.
     */
    public static final boolean DEBUG = false;

    /**
     * @param args is not used.
     */
    public static void main(String[] args)
    {
        ElevensBoardAuto board = new ElevensBoardAuto();
        int wins = 0;

        System.out.print("Working");
        for(int k = 0; k < GAMES_TO_PLAY; k++)
        {
            if(!DEBUG)
            {
                if(k % (GAMES_TO_PLAY / 10) == 0)
                    System.out.print(".");
            }
            if(DEBUG)
            {
                System.out.println(board);
            }
            while(board.playIfPossible())
            {
                if(DEBUG)
                {
                    System.out.println(board);
                }
            }
            if(board.gameIsWon())

                wins++;
            if(DEBUG)
            {
                if(board.gameIsWon())
                    System.out.println("Game Won\n");
                else
                    System.out.println("Game Lost\n");
            }
            board.newGame();
        }

        double percentWon = (int) (1000.0 * wins / GAMES_TO_PLAY + 0.5) / 10.0;
        System.out.println();
        System.out.println("Games won:    " + wins);
        System.out.println("Games played: " + GAMES_TO_PLAY);
        System.out.println("Percent won:  " + percentWon + "%");
    }
}
