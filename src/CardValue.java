public enum CardValue {
    N9(0), N10(1), J(2), Q(3), K(4), A(5);

    private final int value;
    private CardValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
