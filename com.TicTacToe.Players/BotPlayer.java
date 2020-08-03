package com.TicTacToe.Players;

import com.TicTacToe.Board.PlayBoard;
import com.TicTacToe.Players.Player;

import java.lang.reflect.Array;
import java.util.*;

public class BotPlayer {
    //private final String piece = GameFrame.getPiece; // opposite of other piece
    private final String difficulty = "Easy"; // read difficulty from console
    static List<Integer> preferredMoves = new ArrayList<>();
    static {
        preferredMoves.add(1);
        preferredMoves.add(3);
        preferredMoves.add(7);
        preferredMoves.add(9);
    }

    //--------------------------------
    static ArrayList<Integer> playerPos = new ArrayList<>(); // ArrayList for the player positions for checking win/loss
    static ArrayList<Integer> botPos = new ArrayList<>(); // ArrayList for the bot positions for checking win/loss
    static List<Integer> topRow = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
    static List<Integer> middleRow = new ArrayList<Integer>(Arrays.asList(4, 5, 6));
    static List<Integer> bottomRow = new ArrayList<Integer>(Arrays.asList(7, 8, 9));
    static List<Integer> leftColumn = new ArrayList<Integer>(Arrays.asList(1, 4, 7));
    static List<Integer> middleColumn = new ArrayList<Integer>(Arrays.asList(2, 5, 8));
    static List<Integer> rightColumn = new ArrayList<Integer>(Arrays.asList(3, 6, 9));
    static List<Integer> diagonalOne = new ArrayList<Integer>(Arrays.asList(1, 5, 9));
    static List<Integer> diagonalSeven = new ArrayList<Integer>(Arrays.asList(7, 5, 3));

    //Uses ArrayList to store a Collection of all winning configurations in one Map, for an easy way to iterate
    static List<List> winningCombinations = new ArrayList<>();

    static {
        winningCombinations.add(topRow);
        winningCombinations.add(middleRow);
        winningCombinations.add(bottomRow);
        winningCombinations.add(leftColumn);
        winningCombinations.add(middleColumn);
        winningCombinations.add(rightColumn);
        winningCombinations.add(diagonalOne);
        winningCombinations.add(diagonalSeven);
    }
//--------------------------------


    public static void difficultyAITurn(String difficulty) throws IllegalDifficultyException {
        switch (difficulty) {
            case "Easy":
                easyAI();
                break;
            case "Hard":
                hardAI();
                break;
            default:
                throw new IllegalDifficultyException();
        }

    }

    public static void easyAI() {  //randomly places a piece in a space that still has a number (not filled with "X" or "O"
        int a; //initialize int value of the move the bot WILL take
        List<Integer> possibleMoves = possibleMovesList();
        Random randomMove = new Random(); //create new random object to determine move
        a = possibleMoves.get(randomMove.nextInt(possibleMoves.size())); //sets value of move to a random value of the List of random moves
        takeTurn(a); //bot takes the turn!
    }

    public static void hardAI() {
        int a;
        List<Integer> possibleMoves = possibleMovesList();
        Random randomMove = new Random();
        if (possibleMoves.size() == 8) {
            if (!possibleMoves.contains(1))
                takeTurn(9);
            else if (!possibleMoves.contains(3))
                takeTurn(7);
            else if (!possibleMoves.contains(7))
                takeTurn(3);
            else if (!possibleMoves.contains(9))
                takeTurn(1);
            else
                takeTurn(preferredMoves.get(randomMove.nextInt(preferredMoves.size())));
            return; //breaks out of method if it takes the turn
        } else { //concurrentModification danger here! ...
            for (List possibleWins : winningCombinations) {
                if (possibleWins.containsAll(playerPos)) {
                    List<Integer> difference = possibleWins;
                    System.out.println(difference + "x");
                    difference.removeAll(playerPos);//removes the other two values from the winning condition (so the remaining number is the one that completes the win)
                    //winningCombinations.remove(possibleWins); //removes the possible win condition so you no longer have to worry about it.
                    if (possibleMoves.containsAll(difference)) {
                        takeTurn(difference.get(0)); //takes the first legitimate move possible to prevent player from winning
                        return;
                        //breaks out of the whooooole thing AFTER a legitimate move
                    }
                }
            }
        }

        if (botPos.size() == 1) { //if player is not going to win, and the AI only had one move, take another prefered move that hasn't been removed yet.
            takeTurn(preferredMoves.get(randomMove.nextInt(preferredMoves.size())));
            return; //bad form but exits if it does a move
        } else { //if the player isn't going to win, and the bot has a possible win, take the winning move
            for (List possibleWinsBot : winningCombinations) {
                if (possibleWinsBot.containsAll(botPos)) {
                    List<Integer> differenceBot = possibleWinsBot;
                    botPos.removeAll(differenceBot);
                    //winningCombinations.remove(possibleWinsBot); //not needed cuz you woooooooooooon
                    takeTurn(differenceBot.get(0));
                    return; //breaks out of the whole turn, cuz you won
                }
            }
            takeTurn(possibleMoves.get(randomMove.nextInt(possibleMoves.size()))); //if NOOOOTHING else is true, then take a random move cuz it'll prob be a draw
            return; //bad form but exits if it does a move
        }
    }

    private static List<Integer> possibleMovesList() {
        List<Integer> possibleMoves = new ArrayList<>(); //array of possible moves for the AI to choose
        PlayBoard.locationMap.forEach((key, value) -> {  //iterates over every burrito of the map, if the
            Character positionValue = PlayBoard.board.charAt(value); //casts the char at each of 9 positions into modifiable Character type
            if (!positionValue.toString().equals("X") && !positionValue.toString().equals("O")) {  // cast Character to String and check if it equals any DIGITs (0-9)
                possibleMoves.add(key);  //if it DOES equal a digit, meaning it's not an "X" or "O" yet, then add it to possible moves
            }
        });
        return possibleMoves;
    }

    public static StringBuilder takeTurn(int a) {
        botPos.add(a);
        preferredMoves.remove(Integer.valueOf(a));
        return PlayBoard.placeOPiece(a); //needs to read from console
    }

}

