package racingcar.model;

import java.util.UUID;

import racingcar.etc.Message;

public class Car {
    public static final int CAR_NAME_MAX_LENGTH = 5;

    private final String id;
    private final String name;

    public Car(final String name) {
        validateNoneOrEmpty(name);
        validateLessThanFive(name);

        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public void validateNoneOrEmpty(String name) {
        if (name == null || "".equals(name)) {
            throw new IllegalArgumentException(Message.CAR_NAME_REQUIRED.getText());
        }
    }

    public void validateLessThanFive(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(Message.CAR_NAME_LESS_THAN_FIVE.getText());
        }
    }
}
