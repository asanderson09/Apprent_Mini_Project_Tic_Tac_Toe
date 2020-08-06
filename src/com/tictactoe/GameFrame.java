package com.tictactoe;

import java.util.Scanner;


class GameFrame {
    //STATIC VARIABLES

    //static String playerChoice;  //player must choose either [X || O]
    String defaultName = "Player";

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
        Scanner scan = new Scanner(System.in);
        do {
            isValidPiece = (playerChoice.equalsIgnoreCase("x") || playerChoice.equalsIgnoreCase("O"));
            if (isValidPiece) {
                this.playerChoice = playerChoice.toUpperCase();
                System.out.printf("\n%s chose to represent as %s \n\n", defaultName, playerChoice);
            }
            else {
                System.out.println("Please choose X or O as your chosen game piece.  \n");
                playerChoice = scan.nextLine();
            }
        } while (!isValidPiece);
    }

    //METHODS
    //default response [Player] if player declines to enter name
    //Give the user the option to choose any name and scan it in
    private void gameIntro(GameFrame game1, Scanner scan) {
        System.out.printf("\nIf you don't want to be called %s, please enter your name. \n", defaultName);
        game1.setPlayerName(scan.nextLine()); //nextLine allows a null response to default
    }

    //do you want to exit (call this after the game ends so they can choose to exit or play a new game
    //playAgain()
    private void playAgain(GameFrame game1, Scanner scan) {
        System.out.printf("\nWelcome %s, Respond exactly with No or N if you don't want to play TIC TAC TOE! \n", game1.defaultName);
        String play = scan.nextLine();
        //Ask for a new game start and exit if not interested
        if (play.equalsIgnoreCase("n") || play.equalsIgnoreCase("no")) {
            System.out.printf("\nNo hard feelings %s. Enjoy!\n", game1.defaultName);
            System.exit(0);
        } else {
            System.out.printf("\nGood luck on the game! \n\n");
        }
    }

    //Offer instructions and proceed to offer user to choose mark X or O
    private void instructions(GameFrame game1, Scanner scan) {
        System.out.printf("%s, This is important! Respond exactly with Y or Yes if you need a quick Intro on how to TIC TAC TOE! \n", game1.defaultName);
        String gameIntro = scan.nextLine();

        if (gameIntro.equalsIgnoreCase("y") || gameIntro.equalsIgnoreCase("YES")) {
            System.out.printf("1. Tic Tac Toe is played on a 3 by 3 grid. \n\n");
            System.out.printf("2. The Player can choose mark X or O. The AI bot chooses the remaining mark based on player choice for the duration of the round. \n\n");
            System.out.printf("3. The first player or bot that gets 3 marks in a row up, down, across, or diagonally is the winner. \n\n");
            System.out.printf("4. If all 9 positions on the grid fill up, then the game ends in a draw. \n\n\n");
            System.out.printf("After reviewing the instructions, its time to choose your mark as X or O ");
        } else {
            System.out.printf("\nSince you need no instruction, lets get right down to choosing your mark X or O. \n");
        }
        game1.setPlayerChoice(scan.nextLine());
    }

    public void init(GameFrame frame, Scanner scan) {
        frame.gameIntro(frame, scan);
        frame.playAgain(frame, scan);
        frame.instructions(frame, scan);
    }

}

