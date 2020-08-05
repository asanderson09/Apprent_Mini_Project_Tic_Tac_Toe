package com.TicTacToe;

import java.util.Scanner;


class GameFrame {
    //STATIC VARIABLES

    //static String playerChoice;  //player must choose either [X || O]
    String defaultName = "Player";


    public static void main(String[] args) {//POSSIBLY TEMP MAIN FOR DEMO RUNS
        GameFrame game1 = new GameFrame();
        Scanner scan = new Scanner(System.in);


        //Give the user the option to choose any name and scan it in
        game1.gameIntro(game1,scan);

        //do you want to exit (call this after the game ends so they can choose to exit or play a new game
        //playAgain()
        game1.playAgain(game1,scan);
        /*System.out.printf("\nWelcome %s, Respond exactly with No or N if you don't want to play TIC TAC TOE! ", game1.defaultName);
        String play = scan.next();

        //Ask for a new game start and exit if not interested
        if (play.equalsIgnoreCase("n") || play.equalsIgnoreCase("no")) {
            System.out.printf("\nNo hard feelings %s. Enjoy!\n", game1.defaultName);
            System.exit(0);
        } else {
            System.out.printf("\nWelcome to the next game! \n\n");
        }*/


        //Offer instructions and proceed to offer user to choose mark X or O
        //instructions() (returns x or o for player choice)

        game1.instructions(game1,scan);
        /*System.out.printf("%s, This is important! Respond exactly with Y or Yes if you need a quick Intro on how to TIC TAC TOE! ", game1.defaultName);
        String gameIntro = scan.next();

        if (gameIntro.equalsIgnoreCase("y") || gameIntro.equalsIgnoreCase("YES")) {
            System.out.printf("1. Tic Tac Toe is played on a 3 by 3 grid. \n\n");
            System.out.printf("2. The Player can choose mark X or O. The AI bot chooses the remaining mark based on player choice for the duration of the round. \n\n");
            System.out.printf("3.The first player or bot that gets 3 marks in a row up, down, across, or diagonally is the winner. \n\n");
            System.out.printf("4. If all 9 positions on the grid fill up, then the game ends in a draw. \n\n\n");
            System.out.printf("After reviewing the instructions, its time to choose your mark as X or O ");
        } else {
            System.out.printf("\nSince you need no instruction, lets get right down to choosing your mark X or O. ");
        }
        game1.setPlayerChoice(scan.next());*/

        //TODO GameStart() passed to board AI

        //TODO Ask the player if they wish to play again or quit Strecth goal
    }

    //INSTANCE VARIABLES
    private static String playerName;
    private static String playerChoice;


    //CTORS
    public GameFrame() {
        setPlayerName(defaultName);
    }

    public GameFrame(String playerName) {
        setPlayerName(playerName);
    }

    public GameFrame(String playerName, String playerChoice) {
        this();
        setPlayerName(playerChoice);
    }

    //ASSESSORS
    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String name) {
        if (!name.isBlank()) {
            this.defaultName = name;
        }
        else {
            this.defaultName = "Player";
        }
    }

    public String getPlayerChoice() {
        return playerChoice;
    }

    // validate choice of X or O ignoring Case with player feedback
    public void setPlayerChoice(String playerChoice) {
        boolean isValidPiece;

        do {
            isValidPiece = (playerChoice.equalsIgnoreCase("x") || playerChoice.equalsIgnoreCase("O"));
            if (isValidPiece) {
                playerChoice = playerChoice.toUpperCase();
                System.out.printf("\n%s chose to represent as %s ", defaultName, playerChoice);
            }
            else System.out.println("Please choose X or O as your chosen game piece.  \n");
        } while (!isValidPiece);
    }

    //METHODS
    //default response [Player] if player declines to enter name
    private void gameIntro(GameFrame game1, Scanner scan) {
        System.out.printf("\nIf you don't want to be called %s, please enter your name. ", defaultName);
        game1.setPlayerName(scan.nextLine()); //nextLine allows a null response to default
    }

    private void playAgain(GameFrame game1, Scanner scan) {
        System.out.printf("\nWelcome %s, Respond exactly with No or N if you don't want to play TIC TAC TOE! ", game1.defaultName);
        String play = scan.nextLine();

        if (play.equalsIgnoreCase("n") || play.equalsIgnoreCase("no")) {
            System.out.printf("\nNo hard feelings %s. Enjoy!\n", game1.defaultName);
            System.exit(0);
        } else {
            System.out.printf("\nWelcome to the next game! \n\n");
        }
    }

    private void instructions(GameFrame game1, Scanner scan) {
        System.out.printf("%s, This is important! Respond exactly with Y or Yes if you need a quick Intro on how to TIC TAC TOE! ", game1.defaultName);
        String gameIntro = scan.nextLine();

        if (gameIntro.equalsIgnoreCase("y") || gameIntro.equalsIgnoreCase("YES")) {
            System.out.printf("1. Tic Tac Toe is played on a 3 by 3 grid. \n\n");
            System.out.printf("2. The Player can choose mark X or O. The AI bot chooses the remaining mark based on player choice for the duration of the round. \n\n");
            System.out.printf("3.The first player or bot that gets 3 marks in a row up, down, across, or diagonally is the winner. \n\n");
            System.out.printf("4. If all 9 positions on the grid fill up, then the game ends in a draw. \n\n\n");
            System.out.printf("After reviewing the instructions, its time to choose your mark as X or O ");
        } else {
            System.out.printf("\nSince you need no instruction, lets get right down to choosing your mark X or O. ");
        }
        game1.setPlayerChoice(scan.nextLine());
    }

}
