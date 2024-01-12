import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> content;
    private RandomEnumGenerator<CardValue> valueGenerator;
    private RandomEnumGenerator<Suit> suitGenerator;


    public Deck() throws Exception {
        this.valueGenerator = new RandomEnumGenerator<>(CardValue.class);
        this.suitGenerator = new RandomEnumGenerator<>(Suit.class);
        this.shuffle();
    }

    public void shuffle() throws Exception {
        this.content = new ArrayList<>();
        while (this.content.size() != 24) {
            Card card = new Card(valueGenerator.getRandomElement(), suitGenerator.getRandomElement());
            if (!this.content.stream().anyMatch(c -> c.compareTo(card) == 0)) {
                this.content.add(card);
            }
        }
    }

    public void sort() {
        this.content.sort((Card c1, Card c2) -> c1.compareTo(c2));
    }

    public Card draw() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Cannot draw from the empty deck.");
        }
        return this.content.remove(this.content.size() - 1);
    }

    public boolean isEmpty() {
        return this.content.size() == 0;
    }

    public String toString() {
        return this.content.toString();
    }
}
