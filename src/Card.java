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

    public String toString() {
        if (this.isUp) {
            return this.valueString() + this.suitString();
        }
        return "XXX";
    }

    private String valueString() {
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
                throw new IllegalArgumentException("Unrecognized card value.");
        }
    }

    private String suitString() {
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
                throw new IllegalArgumentException("Unrecognized card suit.");
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
