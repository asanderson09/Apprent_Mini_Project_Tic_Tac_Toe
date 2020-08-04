import javax.imageio.stream.ImageInputStream;

import java.io.Console;

public class GameFrame {
    //STATIC VARIABLES
    static String playerName = "Player";  // default response [Player] if player declines to enter name
    static String playerChoice;  //player must choose either [X || O]
    static boolean isChoiceValid;

    //statics so no need to instantiate an object to gather user input

    //INSTANCE FIELDS
    //TODO Do we need to stretch create a GameFrame instance to code an [array or an enum] of 1 player vs 1 bot?



    //CTORS
    public GameFrame() {
        //no-op
    }

    public GameFrame(String playerName, String playerChoice ) {

    }

    //ASSESSOR METHODS

    public static String getPlayerName() {
        return playerName;
    }

    public static void setPlayerName(String playerName) {
        GameFrame.playerName = playerName;
    }

    public static String getPlayerChoice() {
        return playerChoice;
    }

    public static void setPlayerChoice(String playerChoice) {
        // validate choice of X or O ignoring Case with player feedback
        do {
            System.out.println("Please choose X or O as your chosen game piece.  \n");
            isChoiceValid = (playerChoice.equalsIgnoreCase("x") || playerChoice.equalsIgnoreCase("O"));
            if (isChoiceValid) {
                GameFrame.playerChoice = playerChoice;
                System.out.println("You chose to play as " + playerChoice.toUpperCase());
            }
        } while (!isChoiceValid);

    }
    //METHODS

    /*
     *TODO QUICK MAIN DEMO TO ADD PLAYER RESPONSE TO PLAY, REPLAY, WHAT PIECE, AND MAYBE DIFFICULTY
     * & INCLUDES INSTRUCT/TUTORIAL
     *
     */

    public static void main(String[] args) {//POSSIBLY TEMP MAIN FOR DEMO RUNS
        Console console = System.console();

        Console console = new Console();

        //TODO Ask Player name get response
        playerName = console.readLine("If you mind being reffered to as Player, please enter your name ");

        //TODO Ask Do you Want to play Tic Tac Toe?
        console.readLine(playerName + "Respond Yes(Y) or No(N) if you want to play TIC TAC TOE!");


        //TODO Do you Need Instructions

        /*
         *  1. Tic Tac Toe is played on a 3 by 3 grid.
         *
         *  2. The Player can choose mark X or O. The AI bot chooses the remaining mark based on player choice for the duration of the round.
         *
         *  3.The first player or bot that gets 3 marks in a row up, down, across, or diagonally is the winner.
         *
         *  4. If all 9 positions on the grid fill up, then the game ends in a draw.
         */






        //console.readLine("Please choose X or O as your designation. \n");
        //GameFrame.setPlayerChoice();


        setPlayerChoice("o");
       // System.out.println("Please choose X or O as your designation. ");

        //TODO Ask the player if they wish to play again or quit
    }

}
