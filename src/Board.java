import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<Card>> content = new ArrayList<>();
    private Card hand;

    public Board() throws Exception {
        Deck deck = new Deck();
        int rowsCounter = 0;
        while (rowsCounter < 4) {
            this.content.add(new ArrayList<>());
            int cardsCounter = 0;
            while (cardsCounter < 6) {
                this.content.get(rowsCounter).add(deck.draw());
                cardsCounter++;
            }
            rowsCounter++;
        }
        this.hand = this.content.get(3).remove(5);
        this.hand.flip();
    }

    public void replace() throws Exception {
        if (hand.compareTo(new Card(CardValue.A, Suit.SPADE)) == 0) {
            throw new Exception("Cannot replace the ace of spades from hand.");
        }
        Card newHand = this.content.get(this.hand.suitIdx()).remove(this.hand.valueIdx());
        this.content.get(this.hand.suitIdx()).add(this.hand.valueIdx(), this.hand);
        this.hand = newHand;
        this.hand.flip();
    }

    public Card getHand() {
        return this.hand;
    }

    public boolean isFaceUp() {
        return this.content.stream().allMatch(row -> row.stream().allMatch(c -> c.getFaceUp()));
    }

    public String toString() {
        String string = "";
        for (int i = 0; i < 6; i++) {
            String row = "";
            for (int j = 0; j < 4; j++) {
                if (i == 5 && j == 3) {
                    continue;
                }
                row += this.content.get(j).get(i).toString() + "\t";
            }
            row += "\n";
            string += row;
        }
        string += "hand: " + this.hand.toString() + "\n";
        return string;
    }
}
