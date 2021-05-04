package racingcar.model;

import java.util.UUID;

import racingcar.etc.Message;
import racingcar.etc.Utils;

public class Car implements Comparable<Car> {
    public static final int CAR_NAME_MAX_LENGTH = 5;

    private final String name;
    private Records records;

    public Car(final String name) {
        validateNoneOrEmpty(name);
        validateLessThanFive(name);

        this.name = name;
        this.records = new Records(name);
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

    public void run() {
        int random = Utils.crateRandomIntZeroToNine();

        if (0 <= random && 3 >= random) {
            this.records.addRecord(0);
            return;
        }

        this.records.addRecord(1);
    }

	public String printRecords() {
		return this.records.toString();
	}

    public int getTotalRecord() {
        return this.records.getTotalRecords();
    }

    protected void addRecord(int record) {
        this.records.addRecord(record);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Car otherCar) {
		return this.getTotalRecord() - otherCar.getTotalRecord();
    }
}
