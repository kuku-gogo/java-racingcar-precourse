package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racingcar.etc.Message;

public class Cars {
    private List<Car> carList;

    public Cars() {
        carList = new ArrayList<>();
    }

    public Cars(String input) {
        validateNoneOrEmpty(input);

        carList = new ArrayList<>();
        List<String> carNames = Arrays.asList(input.split(","));

        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    protected Cars(List<Car> carsList) {
        this.carList = carsList;
    }

    public void validateNoneOrEmpty(String input) {
        if (input == null || "".equals(input)) {
            throw new IllegalArgumentException(Message.CAR_NAME_REQUIRED.getText());
        }
    }

    public int count() {
        return carList.size();
    }

    public void run() {
        for (Car car : carList) {
            car.run();
        }
    }

	public String getRecordsText() {
        StringBuilder result = new StringBuilder();

        for (Car car : carList) {
            result.append(car.printRecords());
            result.append("\n");
        }

		return result.toString();
	}

	public List<Car> getCarList() {
        return this.carList;
	}
}
