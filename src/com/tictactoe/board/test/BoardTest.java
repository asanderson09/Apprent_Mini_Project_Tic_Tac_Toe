package com.tictactoe.board.test;


import com.tictactoe.board.PlayBoard;

public class BoardTest {
    public static void main(String[] args) {
        PlayBoard board1 = new PlayBoard();
        board1.buildBoard();
        System.out.println(board1);
        board1.placePiece(1, "O");
        System.out.println(board1);
        board1.placePiece(9, "X");
        System.out.println(board1);
    }
}



