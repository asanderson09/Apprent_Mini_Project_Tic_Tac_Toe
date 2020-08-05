package TicTacToe.Players;

public class IllegalDifficultyException extends RuntimeException {
    public IllegalDifficultyException() {
        super();
    }

    public IllegalDifficultyException(String message) {
        System.out.println("Invalid Difficulty! Difficulty of the bot can be 'Easy' or 'Hard'");
    }

    public IllegalDifficultyException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalDifficultyException(Throwable cause) {
        super(cause);
    }
}
