package com.tictactoe.players;

import com.tictactoe.board.PlayBoard;

import java.util.ArrayList;
import java.util.List;

public class HumanPlayer {
    //private final String piece = GameFrame.getPiece;
    public static String piece = "X";

    public void takeTurn(int a) {
        BotPlayer.playerPos.add(a); //logs player piece position
        BotPlayer.preferredMoves.remove(Integer.valueOf(a)); //removes the move from preferred moves, since it's taken

        List<Integer> allPositions= new ArrayList<>(); //same as bot, makes a list of all moves taken
        allPositions.addAll(BotPlayer.playerPos);
        allPositions.addAll(BotPlayer.botPos);

        List<List> winningComboCopy = new ArrayList<>(BotPlayer.winningCombinations); //same as bot, removes win combos that are not possible
        for (var possibleWins : winningComboCopy) {
            if (allPositions.containsAll(possibleWins))
                BotPlayer.winningCombinations.remove(possibleWins);//removes the possible win condition so you no longer have to worry about it.
        }

        if (HumanPlayer.piece.equals("O"))
            PlayBoard.placePiece(a , "O");
        else
            PlayBoard.placePiece(a, "X");
    }
}
