package root.neuralnet.math;

import java.util.Random;

public class RandomNumberGenerator {
    private static Random random = new Random();
    public static double generateNext() {
        return random.nextDouble();
    }
}
