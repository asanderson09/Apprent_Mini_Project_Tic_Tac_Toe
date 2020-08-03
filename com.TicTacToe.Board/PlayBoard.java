import java.lang.reflect.Array;
import java.util.*;

public class PlayBoard {
    public static StringBuilder board = new StringBuilder();
    private static Map<Integer, Integer> locationMap;

    static ArrayList<Integer> playerPos = new ArrayList<>(); // ArrayList for the player positions for checking win/loss
    static ArrayList<Integer> botPos = new ArrayList<>(); // ArrayList for the bot positions for checking win/loss


//    enum State{Blank, X, O}
//    State[][] boardState = new State[3][3];

    public StringBuilder buildBoard()
        {
            board.append("-- Board --\n\n");
            board.append(" 1 | 2 | 3 \n");
            board.append("-----------\n");
            board.append(" 4 | 5 | 6 \n");
            board.append("-----------\n");
            board.append(" 7 | 8 | 9 \n\n");
            board.append("End-of-Board\n");

            return board;
        }

    public static StringBuilder placeXPiece(int a) {
        //StringBuilder newBoard = board; //getting the current state of the board, BEFORE you place new piece... and then returning the next state at the end
        //testing puting x at top left
        //a + b have to convert into the character space
        int locationValue = locationMap.get(a);
        board.setCharAt(locationValue, 'X'); // playerPieceChoice for "X"

       // boardState[a][b] = State.X;
       // checkWinX();

        //should check winner for every move?
        return board;
    }

    private static String checkWin()
    {
        // Stores winning configurations in individual variables..
        // asList: This method also provides a convenient way to create a fixed-size list initialized to contain several elements
        List topRow = Arrays.asList(1, 2, 3);
        List middleRow = Arrays.asList(4, 5, 6);
        List bottomRow = Arrays.asList(7, 8, 9);
        List leftColumn = Arrays.asList(1, 4, 7);
        List middleColumn = Arrays.asList(2, 5, 8);
        List rightColumn = Arrays.asList(3, 6, 9);
        List diagonalOne = Arrays.asList(1, 5, 9);
        List diagonalSeven = Arrays.asList(7, 5, 3);

        //Uses ArrayList to store a Collection of all winning configurations in one Map, for an easy way to iterate
        List<List> winningCombinations = new ArrayList<>();
        winningCombinations.add(topRow);
        winningCombinations.add(middleRow);
        winningCombinations.add(bottomRow);
        winningCombinations.add(leftColumn);
        winningCombinations.add(middleColumn);
        winningCombinations.add(rightColumn);
        winningCombinations.add(diagonalOne);
        winningCombinations.add(diagonalSeven);

        for(List possibleWins : winningCombinations)
            {
                if(playerPos.containsAll(possibleWins))
                    {
                        return "Player Wins";
                    }
                else if (botPos.containsAll(possibleWins))
                    {
                        return "Bot Wins";
                    }
            }
        if(playerPos.size() + botPos.size() == 9)
            {

            }

        return "";
    }

    public StringBuilder getBoard()
        {
            return board;
        }


    @Override
    public String toString()
        {
            return board + "";
        }

    static
        {locationMap = Map.of(
                1,14,
                2,18,
                3,22,
                4,38,
                5,42,
                6,46,
                7,62,
                8,66,
                9,70);
        }
}