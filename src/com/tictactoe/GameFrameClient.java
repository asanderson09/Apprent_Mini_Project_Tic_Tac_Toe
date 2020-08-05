package com.tictactoe;

import com.tictactoe.board.PlayBoard;
import com.tictactoe.players.BotPlayer;
import com.tictactoe.players.HumanPlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GameFrameClient {


    public static void main(String[] args) throws IOException {
        PlayBoard board = new PlayBoard();
        BotPlayer bot = new BotPlayer();
        HumanPlayer hum = new HumanPlayer();
        GameFrame frame = new GameFrame();
        Scanner scan = new Scanner(System.in);
        board.buildBoard();
        bot.initBot();
        frame.init(frame, scan);
        BotPlayer.getDifficulty();
        if (frame.getPlayerChoice().equals("O")) {
            HumanPlayer.piece = "O";
            BotPlayer.piece = "X";
        }
        System.out.println(board);
        while (!PlayBoard.checkWin()) {
            System.out.println("Please choose a position to place your piece, your piece is: " + frame.getPlayerChoice() + ".");
            hum.takeTurn(Integer.parseInt(scan.nextLine()));
            BotPlayer.difficultyAITurn(BotPlayer.difficulty);
        }
    }
}


