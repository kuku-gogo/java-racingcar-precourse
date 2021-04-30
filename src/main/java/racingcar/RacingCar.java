package racingcar;

import java.util.Scanner;

import racingcar.business.RacingCarUi;
import racingcar.model.Cars;

public class RacingCar {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RacingCarUi ui = new RacingCarUi(scanner);

        Cars cars = createCars(ui);
    }

    public static Cars createCars(RacingCarUi ui) {
        Cars cars = null;

        do {
            cars = askCarNames(ui);
        } while (cars.count() == 0);

        return cars;
    }

    public static Cars askCarNames(RacingCarUi ui) {
        Cars cars = null;

        try {
            cars = new Cars(ui.askCarNames());
        } catch (IllegalArgumentException e) {
            cars = new Cars();
            ui.showMessage(e.getMessage());
        }

        return cars;
    } 
}
