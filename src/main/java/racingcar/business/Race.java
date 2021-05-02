package racingcar.business;

import racingcar.model.Cars;
import racingcar.model.Laps;

public class Race {
    private final Cars cars;
    private final Laps laps;

	public Race(Cars cars, Laps laps) {
        this.cars = cars;
        this.laps = laps;
    }

	public String start() {
        cars.run();

        return createAllRecords();
	}

    public String createAllRecords() {
        StringBuilder result = new StringBuilder("실행 결과\n");
        result.append(cars.getRecords());

        return result.toString();
    }
}
