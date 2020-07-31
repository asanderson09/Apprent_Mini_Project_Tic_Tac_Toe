package com.TicTacToe.Board;

public class PlayBoard {
    public StringBuilder board = new StringBuilder();
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

        newBoard.setCharAt(14, 'X');

        return newBoard;
    }

    @Override
    public String toString() {
        return board + "";
    }

    public StringBuilder getBoard() {
        return board;
    }
}
