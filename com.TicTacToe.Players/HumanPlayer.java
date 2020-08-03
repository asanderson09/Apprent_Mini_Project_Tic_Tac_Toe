package com.TicTacToe.Players;

import com.TicTacToe.Board.PlayBoard;

public class HumanPlayer {
    //private final String piece = GameFrame.getPiece;


    public StringBuilder takeTurn(int a) {
        BotPlayer.playerPos.add(a);
        BotPlayer.preferredMoves.remove(Integer.valueOf(a));
        System.out.println(BotPlayer.playerPos);

        return PlayBoard.placeXPiece(a) ; //needs to read from console
    }
}
