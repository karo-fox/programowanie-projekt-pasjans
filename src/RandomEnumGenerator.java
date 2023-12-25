import java.util.Random;

public class RandomEnumGenerator<T extends Enum<T>> {
    private static final Random PRNG = new Random();
    private final T[] values;

    public RandomEnumGenerator(Class<T> e) {
        this.values = e.getEnumConstants();
    }

    public T getRandomElement() {
        return this.values[PRNG.nextInt(values.length)];
    }
}
