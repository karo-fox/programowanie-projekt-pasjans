import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<Card>> content = new ArrayList<>();
    private Card hand;

    public Board() {
        Deck deck = new Deck();
        int rowsCounter = 0;
        while (rowsCounter < 4) {
            this.content.add(new ArrayList<>());
            int cardsCounter = 0;
            while (cardsCounter < 6) {
                try {
                    this.content.get(rowsCounter).add(deck.draw());
                    cardsCounter++;
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            rowsCounter++;
        }
        this.hand = this.content.get(3).remove(5);
        this.hand.flip();
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
