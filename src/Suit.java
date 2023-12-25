public enum Suit {
    HEART(0), DIAMOND(1), CLUB(2), SPADE(3);

    private final int value;
    private Suit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
