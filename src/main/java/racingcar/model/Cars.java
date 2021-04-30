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

    public void validateNoneOrEmpty(String input) {
        if (input == null || "".equals(input)) {
            throw new IllegalArgumentException(Message.CAR_NAME_REQUIRED.getText());
        }
    }

    public int count() {
        return carList.size();
    }
}
