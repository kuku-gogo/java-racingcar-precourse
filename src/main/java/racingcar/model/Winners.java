package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winners {
    private List<Car> winnerList = new ArrayList<>();

    public Winners(List<Car> carList) {
        Car winnerCar = Collections.max(carList);

        for (Car car : carList) {
            addWinnerList(car, winnerCar);
        }
    }

    private void addWinnerList(Car car, Car winnerCar) {
        if (car.compareTo(winnerCar) == 0) {
            this.winnerList.add(car);
        }
    }

    protected List<Car> getWinnerList() {
        return this.winnerList;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        if (!this.winnerList.isEmpty()) {
            result.append(this.winnerList.get(0).getName());
        }

        for (int i = 1; i < this.winnerList.size(); i++) {
            result.append(", ");
            result.append(this.winnerList.get(i).getName());
        }

        return result.toString();
    }
}
