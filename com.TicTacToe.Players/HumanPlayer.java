package com.TicTacToe.Players;

import com.TicTacToe.Board.PlayBoard;

import java.util.ArrayList;
import java.util.List;

public class HumanPlayer {
    //private final String piece = GameFrame.getPiece;


    public StringBuilder takeTurn(int a) {
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

        return PlayBoard.placeXPiece(a) ; //needs to read from console
    }
}
