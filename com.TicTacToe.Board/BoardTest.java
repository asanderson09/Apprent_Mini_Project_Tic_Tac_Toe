public class BoardTest {
    public static void main(String[] args) {
        com.TicTacToe.Board.PlayBoard board1 = new com.TicTacToe.Board.PlayBoard();
        board1.buildBoard();
        System.out.println(board1);
        board1.placeXPiece(1,1);
        board1.placeXPiece(1,2);
        board1.placeXPiece(1,3);
        board1.placeXPiece(2,1);
        board1.placeXPiece(2,2);
        board1.placeXPiece(2,3);
        board1.placeXPiece(3,1);
        board1.placeXPiece(3,2);
        board1.placeXPiece(3,3);
        System.out.println(board1);
    }
}
