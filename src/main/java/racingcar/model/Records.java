package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Records {
    private final String carName;
    private List<Integer> records = new ArrayList<>();

    public Records(String carName) {
        this.carName = carName;
    }

    public void addRecord(int i) {
        records.add(i);
    }

    public int getTotalRecords() {
        int total = 0;

        for (int record : this.records) {
            total += record;
        }

		return total;
    }

    @Override
    public String toString() {
        int totalRecords = this.getTotalRecords();
        return new StringBuilder()
            .append(this.carName)
            .append(" : ")
            .append(printHyphen(totalRecords))
            .toString();
    }

    public String printHyphen(int totalRecords) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < totalRecords; i++) {
            result.append("-");
        }
        return result.toString();
    }
}