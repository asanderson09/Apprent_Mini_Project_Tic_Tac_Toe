import java.util.HashMap;
import java.util.Map;

public class PlayBoard {
    public static StringBuilder board = new StringBuilder();
    public static Map<Integer, Integer> locationMap = new HashMap<>();

//    enum State{Blank, X, O}
//    State[][] boardState = new State[3][3];



    public static StringBuilder buildBoard() {
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

    public static StringBuilder placeOPiece(int a) {
        //StringBuilder newBoard = board; //getting the current state of the board, BEFORE you place new piece... and then returning the next state at the end
        //testing puting x at top left
        //a + b have to convert into the character space
        int locationValue = locationMap.get(a);
        board.setCharAt(locationValue, 'O'); // playerPieceChoice for "X"

        // boardState[a][b] = State.X;
        // checkWinX();

        //should check winner for every move?
        return board;
    }

//    public boolean checkWinX(){
//        int xSum = 0;
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++){
//                if (boardState[i][j])
//            }
//
//        }
//
//        return false;
//    }

    public StringBuilder getBoard() {
        return board;
    }


    @Override
    public String toString() {
        return board + "";
    }

    static {locationMap = Map.of(
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