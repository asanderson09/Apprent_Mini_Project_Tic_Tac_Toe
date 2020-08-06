package com.tictactoe.board;

import com.tictactoe.players.BotPlayer;

import java.util.*;

public class PlayBoard {
    public static StringBuilder board = new StringBuilder();

    public static Map<Integer, Integer> locationMap;

    static ArrayList<Integer> playerPos = new ArrayList<>(); // ArrayList for the player positions for checking win/loss
    static ArrayList<Integer> botPos = new ArrayList<>(); // ArrayList for the bot positions for checking win/loss

    //--------------------------------------
    // Stores winning configurations in individual variables..
    // asList: This method also provides a convenient way to create a fixed-size list initialized to contain several elements
    static List topRow = Arrays.asList(1, 2, 3);
    static List middleRow = Arrays.asList(4, 5, 6);
    static List bottomRow = Arrays.asList(7, 8, 9);
    static List leftColumn = Arrays.asList(1, 4, 7);
    static List middleColumn = Arrays.asList(2, 5, 8);
    static List rightColumn = Arrays.asList(3, 6, 9);
    static List diagonalOne = Arrays.asList(1, 5, 9);
    static List diagonalSeven = Arrays.asList(7, 5, 3);

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

    //---------------------

//    enum State{Blank, X, O}
//    State[][] boardState = new State[3][3];

    public void buildBoard() {
        board.delete(0,board.length());
        board.append("-- Board --\n");
        board.append(" 1 | 2 | 3 \n");
        board.append("-----------\n");
        board.append(" 4 | 5 | 6 \n");
        board.append("-----------\n");
        board.append(" 7 | 8 | 9 \n");
        board.append("End-of-Board\n");
    }

    public static void placePiece(int a, String piece) {
        int locationValue = locationMap.get(a);
        board.setCharAt(locationValue, piece.charAt(0));
        System.out.println(board);
    }


    public static boolean checkWin() {
        for (List possibleWins : winningCombinations) {
            if (BotPlayer.playerPos.containsAll(possibleWins)) {
                System.out.println("Player Wins");
                return true;
            } else if (BotPlayer.botPos.containsAll(possibleWins)) {
                System.out.println("Bot Wins");
                return true;
            }
        }
        if (BotPlayer.playerPos.size() + BotPlayer.botPos.size() == 9) {
            System.out.println("Draw!!!");
            return true;
        }
        return false;
    }

    private static boolean tryParseInt(String num) { //java doesn't have tryParse, so we write it ourselves
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int checkMove(String a) {
        String b = a;
        Scanner scan = new Scanner(System.in);
        List<Integer> possibleMoves = BotPlayer.possibleMovesList();
        while (b.isBlank() || !tryParseInt(b) || !possibleMoves.contains(Integer.valueOf(b))) { //using the forced check or, we can avoid parsing int from invalid string exception.
            System.out.println("Illegal move, please choose a legal move from " + possibleMoves +". \n");
            b = scan.nextLine();
        }
        return Integer.parseInt(b);
    }

    @Override
    public String toString() {
        return board + "";
    }

    static {
        locationMap = Map.of(
                1, 13,
                2, 17,
                3, 21,
                4, 37,
                5, 41,
                6, 45,
                7, 61,
                8, 65,
                9, 69);
    }
}