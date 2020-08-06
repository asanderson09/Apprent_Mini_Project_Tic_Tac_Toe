package com.tictactoe.players.test;

import com.tictactoe.players.BotPlayer;
import com.tictactoe.players.HumanPlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BotPlayerTest {
    public static void main(String[] args) throws IOException {
        com.tictactoe.board.PlayBoard board1 = new com.tictactoe.board.PlayBoard();
        BotPlayer bot = new BotPlayer();
        HumanPlayer hum = new HumanPlayer();
        board1.buildBoard();
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