package com.TicTacToe.Players;

import com.TicTacToe.Board.PlayBoard;

public interface Player {
    public static StringBuilder takeTurn(int a){return PlayBoard.placeXPiece(a);};
}
