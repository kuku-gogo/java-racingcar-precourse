package racingcar.business;

import racingcar.model.Cars;
import racingcar.model.Laps;
import racingcar.model.Winners;

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
            result.append(cars.getRecordsText());
            result.append("\n");
        }

        return result.toString();
	}

	public String announceWinners() {
        StringBuilder result = new StringBuilder();
        Winners winners = new Winners(cars.getCarList());

        result.append(winners.toString());
        result.append("가 최종 우승했습니다.");

		return result.toString();
	}
}
