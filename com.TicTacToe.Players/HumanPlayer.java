package com.TicTacToe.Players;

import com.TicTacToe.Board.PlayBoard;

public class HumanPlayer implements Player {
    //private final String piece = GameFrame.getPiece;


    public StringBuilder takeTurn(int a) {
        return PlayBoard.placeXPiece(a) ; //needs to read from console
    }
}
