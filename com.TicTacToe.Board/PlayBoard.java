import java.util.HashMap;
import java.util.Map;

public class PlayBoard {
    public StringBuilder board = new StringBuilder();
    private static Map<Integer, Integer> locationMap = new HashMap<>();

//    enum State{Blank, X, O}
//    State[][] boardState = new State[3][3];



    public StringBuilder buildBoard() {
        board.append("-- Board --\n\n");
        board.append("   |   |   \n");
        board.append("-----------\n");
        board.append("   |   |   \n");
        board.append("-----------\n");
        board.append("   |   |   \n\n");
        board.append("End-of-Board\n");

        return board;
    }

    public StringBuilder placeXPiece(int a, int b) {
        StringBuilder newBoard = board;
        //testing puting x at top left
        //a + b have to convert into the character space
        int locationValue = locationMap.get(a*10 + b);
        newBoard.setCharAt(locationValue, 'X'); // playerPieceChoice for "X"

       // boardState[a][b] = State.X;
       // checkWinX();

        //should check winner for every move?
        return newBoard;
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
            11,14,
            12,18,
            13,22,
            21,38,
            22,42,
            23,46,
            31,62,
            32,66,
            33,70);
    }
}