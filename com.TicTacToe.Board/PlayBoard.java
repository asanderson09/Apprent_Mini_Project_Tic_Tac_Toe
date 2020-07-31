package com.TicTacToe.Board;

import java.util.HashMap;
import java.util.Map;

public class PlayBoard {
    public StringBuilder board = new StringBuilder();
    private static Map<Integer, Integer> locationMap = new HashMap<>();

    static {locationMap = Map.of(11,14,
            12,18,
            13,22,
            21, 33,
            22,37,
            23,41,
            31,54,
            32,58,
            33,62);

    }


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
