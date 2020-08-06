package com.tictactoe;

import com.tictactoe.board.PlayBoard;
import com.tictactoe.players.BotPlayer;
import com.tictactoe.players.HumanPlayer;
import java.io.IOException;
import java.util.Scanner;

public class GameFrameClient {
    public static void main(String[] args) throws IOException {
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


