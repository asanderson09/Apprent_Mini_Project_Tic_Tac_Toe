package TicTacToe.Board;


public class BoardTest {
    public static void main(String[] args) {
        PlayBoard board1 = new PlayBoard();
        board1.buildBoard();
        System.out.println(board1);
        board1.placeXPiece(1);
        System.out.println(board1);
        board1.placeXPiece(9);
        System.out.println(board1);

        //Ask player, which remaining number you would like to place your piece: console read <int a>
        //you would take the argument from the player read console: and put it in board.placePiece(<int a>)
    }
}



