import java.util.ArrayList;

public class Game {
    private final Card STOP_CARD = new Card(CardValue.A, Suit.SPADE);
    private Board board;
    private ArrayList<String> visualization;
    private boolean isWon;

    public Game() {
        this.board = new Board();
        this.visualization = new ArrayList<>();
        this.isWon = false;
    }

    public void run() {
        this.visualization.add(this.board.toString());
        while (this.board.getHand().compareTo(this.STOP_CARD) != 0) {
            this.board.replace();
            this.visualization.add(this.board.toString());
        }
        this.checkResult();
    }

    public boolean getResult() {
        return this.isWon;
    }

    private void checkResult() {
        if (this.board.isFaceUp()) {
            this.isWon = true;
        }
    }

    public String toString() {
        return String.join("\n", this.visualization);
    }
}
