public class Card implements Comparable<Card> {
    private CardValue value;
    private Suit suit;
    private boolean isUp;

    public Card(CardValue value, Suit suit) {
        this.value = value;
        this.suit = suit;
        this.isUp = false;
    }

    public void flip() {
        this.isUp = !this.isUp;
    }

    public int suitIdx() {
        return this.suit.getValue();
    }

    public int valueIdx() {
        return this.value.getValue();
    }

    public boolean getFaceUp() {
        return this.isUp;
    }

    public String toString() {
        try {
            if (this.isUp) {
                return this.valueString() + this.suitString();
            }
        } catch (Exception e) {
            return "XXX";
        }
        return "XXX";
    }

    private String valueString() throws Exception {
        switch (value) {
            case A:
                return "A";
            case K:
                return "K";
            case Q:
                return "Q";
            case J:
                return "J";
            case N10:
                return "10";
            case N9:
                return "9";
            default:
                throw new Exception("Unrecognized card value.");
        }
    }

    private String suitString() throws Exception {
        switch (suit) {
            case HEART:
                return "♥";
            case DIAMOND:
                return "♦";
            case CLUB:
                return "♣";
            case SPADE:
                return "♠";
            default:
                throw new Exception("Unrecognized card suit.");
        }
    }

    @Override
    public int compareTo(Card other) {
        if (this.suit == other.suit) {
            return Integer.compare(this.value.getValue(), other.value.getValue());
        }
        return Integer.compare(this.suit.getValue(), other.suit.getValue());
    }
}
