package com.anthonyMiniSolo;

import java.util.Scanner;

public class TicTacToe {
    // game board
   private static char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};
    public static void main(String[] args) {
        printGameBoard(gameBoard);

        Scanner scan = new Scanner(System.in);

        System.out.println("Place your next piece:  input # from 1-9 and press enter/return :"); // prompts player for input

        int playersMoveChoice = scan.nextInt(); // Takes input from player

        System.out.println(playersMoveChoice); // prints out where the player is placing piece

        placePiece(gameBoard,playersMoveChoice, "player");

        printGameBoard(gameBoard); // prints gameboard

    }

    private static void printGameBoard(char[][] gameboard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static void placePiece(char [][] gameBoard, int playersMoveChoice, String user)
    {
        char symbol = ' ';
        char cross = 'X';
        char nought = 'O';

        if(user.equals("player")) {
            symbol = cross;

        }
        else if(user.equals("bot"))
        {
            symbol = nought;
        }
        // places players piece at correct position of the array
        switch (playersMoveChoice)
        {
            case 1 -> gameBoard[0][0] = symbol;
            case 2 -> gameBoard[0][2] = symbol;
            case 3 -> gameBoard[0][4] = symbol;
            case 4 -> gameBoard[2][0] = symbol;
            case 5 -> gameBoard[2][2] = symbol;
            case 6 -> gameBoard[2][4] = symbol;
            case 7 -> gameBoard[4][0] = symbol;
            case 8 -> gameBoard[4][2] = symbol;
            case 9 -> gameBoard[4][4] = symbol;
            default -> {
            }
        }


    }
}