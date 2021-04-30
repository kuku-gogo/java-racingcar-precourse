package racingcar.business;

import java.util.Scanner;

public class RacingCarUi {

    private final Scanner scanner;

    public RacingCarUi(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String askCarNames() {
        showMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return scanner.next();
    }

    public String askLaps() {
        showMessage("시도할 회수는 몇회인가요?");
        return scanner.next();
    }
}
