package racingcar.model;

import racingcar.etc.Message;

public class Laps {
    
    private final int totalLaps;

    public Laps() {
        this.totalLaps = 0;
    }

    public Laps(String input) {
        int inputLaps = Integer.parseInt(input);

        validateOneOrMore(inputLaps);

        this.totalLaps = inputLaps;
    }

    public void validateOneOrMore(int totalLaps) {
        if (totalLaps < 1) {
            throw new IllegalArgumentException(Message.LESS_THAN_1.getText());
        }
    }
}
