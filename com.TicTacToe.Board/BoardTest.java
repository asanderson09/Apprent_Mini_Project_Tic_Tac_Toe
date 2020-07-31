package com.TicTacToe.Board;

public class BoardTest {
    public static void main(String[] args) {
        PlayBoard board1 = new PlayBoard();
        board1.buildBoard();
        System.out.println(board1);
        board1.placeXPiece(1,1);
        System.out.println(board1);

    }
}
