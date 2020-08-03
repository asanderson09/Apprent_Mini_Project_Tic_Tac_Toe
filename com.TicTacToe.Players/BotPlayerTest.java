package com.TicTacToe.Players;

import com.TicTacToe.Players.BotPlayer;

public class BotPlayerTest {
    public static void main(String[] args) {
        com.TicTacToe.Board.PlayBoard board1 = new com.TicTacToe.Board.PlayBoard();
        BotPlayer bot = new BotPlayer();
        HumanPlayer hum = new HumanPlayer();

        board1.buildBoard();
        hum.takeTurn(5);
        System.out.println(board1);


        bot.hardAI();
        System.out.println(board1);
        hum.takeTurn(8);
        System.out.println(board1);
        bot.hardAI();
        System.out.println(board1);

        /*board1.buildBoard();
        System.out.println(board1);*/
        //Ask player, which remaining number you would like to place your piece: console read <int a>
        //you would take the argument from the player read console: and put it in board.placePiece(<int a>)
    }
}