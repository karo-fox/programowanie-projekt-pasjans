import java.util.ArrayList;

public class Game {
    private Board board = new Board();
    private final Card STOP_CARD = new Card(CardValue.A, Suit.SPADE);
    private ArrayList<String> visualization = new ArrayList<>();
    private boolean isWon = false;

    public Game() {}

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
