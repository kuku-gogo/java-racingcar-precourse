package racingcar.etc;

import java.util.Random;

public class Utils {

    private static Random random = new Random();

    private Utils() {}

    public static int crateRandomIntZeroToNine() {
        return random.nextInt(9);
    }
}
