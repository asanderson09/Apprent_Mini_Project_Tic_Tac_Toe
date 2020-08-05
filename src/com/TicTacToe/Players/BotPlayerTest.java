package com.TicTacToe.Players;

import com.TicTacToe.Players.BotPlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BotPlayerTest {
    public static void main(String[] args) throws IOException {
        com.TicTacToe.Board.PlayBoard board1 = new com.TicTacToe.Board.PlayBoard();
        BotPlayer bot = new BotPlayer();
        HumanPlayer hum = new HumanPlayer();
        board1.buildBoard();
        //Scanner in = new Scanner(System.in);
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            String a = reader.readLine();
            hum.takeTurn(Integer.parseInt(a));
            System.out.println(board1);
            bot.hardAI();
            System.out.println(board1);

        }

    }
}