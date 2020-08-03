package com.TicTacToe.Players;

import com.TicTacToe.Board.PlayBoard;
import com.TicTacToe.Players.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BotPlayer{
    //private final String piece = GameFrame.getPiece; // opposite of other piece
    private final String difficulty = "Easy"; // read difficulty from console


    public static void difficultyAITurn(String difficulty) throws IllegalDifficultyException {
        switch (difficulty) {
            case "Easy":
                easyAI();
                break;
            case "Hard":
               /* hardAI();*/
                break;
            default:
                throw new IllegalDifficultyException();
        }

    }

    public static void easyAI(){  //randomly places a piece in a space that still has a number (not filled with "X" or "O"
        int a; //initialize int value of the move the bot WILL take
        List<Integer> possibleMoves = new ArrayList<>(); //array of possible moves for the AI to choose
        PlayBoard.locationMap.forEach((key,value) -> {  //iterates over every burrito of the map, if the
            Character positionValue = PlayBoard.board.charAt(value); //casts the char at each of 9 positions into modifiable Character type
            if (!positionValue.toString().equals("X") && !positionValue.toString().equals("O")) {  // cast Character to String and check if it equals any DIGITs (0-9)
                possibleMoves.add(key);  //if it DOES equal a digit, meaning it's not an "X" or "O" yet, then add it to possible moves
            }
        });
        Random randomMove = new Random(); //create new random object to determine move
        a = possibleMoves.get(randomMove.nextInt(possibleMoves.size())); //sets value of move to a random value of the List of random moves
        takeTurn(a); //bot takes the turn!
    }

  /*  public void hardAI(){
        int a;

        takeTurn(a);
    }*/


    public static StringBuilder takeTurn(int a) {
        return PlayBoard.placeXPiece(a) ; //needs to read from console
    }

}

