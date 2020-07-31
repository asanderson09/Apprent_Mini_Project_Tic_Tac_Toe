package com.TicTacToe.Board;

import java.util.Arrays;

public class PlayBoard {
    private String[] board = new String[9];


    public void clearBoard(){
        Arrays.fill(board, " ");
    }

    public void displayBoard() {
        System.out.println("--- Board ---\n");
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " \n");
        System.out.println("End-Of-Board");
    }
}
