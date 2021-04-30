package racingcar;

import java.util.Optional;
import java.util.Scanner;

import racingcar.business.RacingCarUi;
import racingcar.model.Cars;
import racingcar.model.Laps;

public class RacingCar {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RacingCarUi ui = new RacingCarUi(scanner);

        Cars cars = createCars(ui);
        Laps laps = createLaps(ui);
    }

    private static Laps createLaps(RacingCarUi ui) {
        Optional<Laps> laps;

        do {
            laps = askLaps(ui);
        } while (!laps.isPresent());

        return laps.get();
    }

    private static Optional<Laps> askLaps(RacingCarUi ui) {
        Optional<Laps> laps;

        try {
            laps = Optional.of(new Laps(ui.askLaps()));
        } catch (IllegalArgumentException e) {
            laps = Optional.empty();
            ui.showMessage(e.getMessage());
        }

        return laps;
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
