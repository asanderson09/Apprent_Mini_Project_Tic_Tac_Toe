package com.TicTacToe.Players;

import com.TicTacToe.Board.PlayBoard;
import java.util.*;

public class BotPlayer {
    //private final String piece = GameFrame.getPiece; // opposite of other piece
    private final String difficulty = "Easy"; // read difficulty from console
    static List<Integer> preferredMoves = new ArrayList<>(); //taking the 4 corners as perferred moves
    static List<Integer> block19 = new ArrayList<Integer>(Arrays.asList(1, 9)); //opposite corners for countering tictactoe strategy
    static List<Integer> block37 = new ArrayList<Integer>(Arrays.asList(3, 7));

    //--------------------------------
    static List<Integer> playerPos = new ArrayList<>(); // ArrayList for the player positions for checking win/loss
    static List<Integer> botPos = new ArrayList<>(); // ArrayList for the bot positions for checking win/loss

    static List<Integer> topRow = new ArrayList<Integer>(Arrays.asList(1, 2, 3)); //the winning conditions
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
        preferredMoves.addAll(Arrays.asList(1, 3, 7, 9));
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

    public void initBot() {
        playerPos.clear();
        botPos.clear();
        preferredMoves.clear();
        preferredMoves.addAll(Arrays.asList(1, 3, 7, 9));
        winningCombinations.clear();
        winningCombinations.add(topRow);
        winningCombinations.add(middleRow);
        winningCombinations.add(bottomRow);
        winningCombinations.add(leftColumn);
        winningCombinations.add(middleColumn);
        winningCombinations.add(rightColumn);
        winningCombinations.add(diagonalOne);
        winningCombinations.add(diagonalSeven);
    }


    public static void difficultyAITurn(String difficulty) throws IllegalDifficultyException { //would call this from run game to take AI turn
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

    public static void easyAI() {  //randomly places a piece in a space that still has a number (not filled with "X" or "O")
        List<Integer> possibleMoves = possibleMovesList(); //generates a list of possible moves from the board, method below
        randomMove(possibleMoves); //bot takes the turn randomly from possible moves!
    }

    public static void hardAI() {
        List<Integer> possibleMoves = possibleMovesList();
        List<List> winningComboCopy = new ArrayList<>(winningCombinations); //creates a copy of the winning combinations list
        if (possibleMoves.size() == 8) {  //first bot move                  // of list to prevent concurrent modification error
            firstMove();                                                    // (we delete winning combinations as they become unavailable)
        } else if (possibleMoves.size() == 6 && (playerPos.containsAll(block19) || playerPos.containsAll(block37))) {
            randomTurnBetweenFour(); //second bot move, to prevent always winning strategy of first moving piece
        } else { //all other moves
            for (List possibleWins : winningComboCopy) { //checkes every remaining win condition
                int botMatch = matchCounter(possibleWins,botPos); //counting the number of matches between bot positions, and win condition
                int humMatch = matchCounter(possibleWins,playerPos); //same, but for humans
                if (botMatch >= 2) { //if there are 2 matches in an AVAILABLE win condition, do the rest of to see if bot can take it
                    winConditionMove(possibleWins, botPos);
                    return;
                } else if (humMatch >= 2) { //if the bot isn't able to win in the turn, check if the human player might be able to win
                    winConditionMove(possibleWins, playerPos);
                    return;
                }
            }
            randomMove(possibleMoves); //if there are no win conditions to met or block, take a possible move
            System.out.println("random move");
        }
    }

    private static int matchCounter(List<Integer> combo, List<Integer> positions){ //counter for the matches between player
        int matches = 0;                                                       //or bot positions, and the winning conditions
        for (var comboPos : combo){
            for (var positionsPos : positions) {
                if (positionsPos.equals(comboPos))
                    matches++;
            }
        }
        return matches;
    }

    private static void winConditionMove(List<Integer> possibleWins, List<Integer> positions) { //takes winCondition list, and human/bot positions
        List<Integer> possibleMoves = possibleMovesList();
        List<Integer> difference = new ArrayList<>(possibleWins); //create new list of the 3 numbers for a win condition
        difference.removeAll(positions); //removes all other numbers from the win condition, remaining number is the space needed to win
        if (possibleMoves.contains(difference.get(0))) { //check if the move is still available to be taken
            takeTurn(difference.get(0));
        }
    }


    private static void firstMove() { //if the player picks a corner, take the middle to block. take a preferred move otherwise
        List<Integer> possibleMoves = possibleMovesList();
        if (!possibleMoves.contains(1) || !possibleMoves.contains(3) || !possibleMoves.contains(7) || !possibleMoves.contains(9))
            takeTurn(5);
        else
            randomMove(preferredMoves);
    }

    private static void randomTurnBetweenFour() { //for the second move, picks randomly from 4 moves to block opposite corner strategy
        Random random = new Random();
        if (random.nextBoolean()) {
            if (random.nextBoolean())
                takeTurn(2);
            else
                takeTurn(4);
        } else {
            if (random.nextBoolean())
                takeTurn(6);
            else
                takeTurn(8);
        }
    }

    private static void randomMove(List<Integer> moveList) { //randomizer for the movelist fed into the method
        Random randomMove = new Random(); //create new random object to determine move
        takeTurn(moveList.get(randomMove.nextInt(moveList.size()))); //takes a turn from the random provided moveList
    }

    private static List<Integer> possibleMovesList() { //constructing the possible moves on the board
        List<Integer> possibleMoves = new ArrayList<>(); //initialize array of possible moves for the AI to choose
        PlayBoard.locationMap.forEach((key, value) -> {  //iterates over every burrito of the map, if the
            Character positionValue = PlayBoard.board.charAt(value); //casts the char at each of 9 positions into modifiable Character type
            if (!positionValue.toString().equals("X") && !positionValue.toString().equals("O")) {  // cast Character to String and check if it equals any DIGITs (0-9)
                possibleMoves.add(key);  //if it DOES equal a digit, meaning it's not an "X" or "O" yet, then add it to possible moves
            }
        });
        return possibleMoves;
    }

    public static StringBuilder takeTurn(int a) {
        botPos.add(a); //logs the position that the bot placed the piece
        preferredMoves.remove(Integer.valueOf(a)); //removes the position from list of preferred positions

        List<Integer> allPositions = new ArrayList<>(); //construct new mutable list of all positions that have been taken
        allPositions.addAll(playerPos);
        allPositions.addAll(botPos);

        List<List> winningComboCopy = new ArrayList<>(winningCombinations); //makes copy of winning combos to avoid concurrent mod error
        for (var possibleWins : winningComboCopy) {
            if (allPositions.containsAll(possibleWins)) //if possible win combo has been used up from positions, then ->
                winningCombinations.remove(possibleWins);//removes the possible win condition so you no longer have to worry about it.
        }

        return PlayBoard.placeOPiece(a);
    }

}

