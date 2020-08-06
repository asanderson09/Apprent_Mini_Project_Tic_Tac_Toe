package com.tictataoe.client;

import com.tictactoe.GameFrame;
import com.tictactoe.board.PlayBoard;
import com.tictactoe.players.BotPlayer;
import com.tictactoe.players.HumanPlayer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String banner = Files.readString(Path.of("data", "banner.txt"));
        System.out.println(banner);

        while (true) { //only way to exit game is by replying no to play a game
            PlayBoard board = new PlayBoard();  //initalizations
            BotPlayer bot = new BotPlayer();
            HumanPlayer hum = new HumanPlayer();
            GameFrame frame = new GameFrame();
            Scanner scan = new Scanner(System.in);
            board.buildBoard(); //deletes and recreates board for new iterations
            frame.init(frame, scan); //initializations
            bot.initBot(); //same
            if (frame.getPlayerChoice().equals("O")) { //static sets for the pieces
                HumanPlayer.piece = "O";
                BotPlayer.piece = "X";
            }
            System.out.println(board); //shows board for human's first move
            while (!PlayBoard.checkWin()) { //while the game hasn't ended, alternate turns
                System.out.println("Please choose a position to place your piece, your piece is: " + frame.getPlayerChoice() + ".");
                hum.takeTurn(PlayBoard.checkMove(Integer.parseInt(scan.nextLine())));
                BotPlayer.difficultyAITurn(BotPlayer.difficulty);
            }
        }
    }
}


