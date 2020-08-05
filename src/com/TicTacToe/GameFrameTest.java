package com.TicTacToe;

import com.TicTacToe.Board.PlayBoard;
import com.TicTacToe.Players.BotPlayer;
import com.TicTacToe.Players.HumanPlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameFrameTest {


    public static void main(String[] args) throws IOException {
        com.TicTacToe.Board.PlayBoard board1 = new com.TicTacToe.Board.PlayBoard();
        BotPlayer bot = new BotPlayer();
        HumanPlayer hum = new HumanPlayer();
        board1.buildBoard();

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));


        while (!PlayBoard.checkWin()) {  //instead of putting all this in main, you'd wrap this all into a method called "play game"
            String a = reader.readLine();
            while (!PlayBoard.checkMove(Integer.parseInt(a))){
                a = reader.readLine();
            }
            hum.takeTurn(Integer.parseInt(a));
            System.out.println(board1);
            bot.hardAI();
            System.out.println(board1);


        }
    }
}


