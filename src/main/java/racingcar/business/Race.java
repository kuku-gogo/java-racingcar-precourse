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
        StringBuilder result = new StringBuilder("실행 결과\n");
        for (int i = 0; i < laps.getCount(); i++) {
            cars.run();
            result.append(getRecordsTextByLap());
            result.append("\n");
        }

        return result.toString();
	}

    public String getRecordsTextByLap() {
        return cars.getRecordsText();
    }
}
