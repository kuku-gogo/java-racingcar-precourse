package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Records {
    private final String carName;
    private List<Integer> recordList = new ArrayList<>();

    public Records(String carName) {
        this.carName = carName;
    }

    public void addRecord(int i) {
        recordList.add(i);
    }

    public int getTotalRecords() {
        int total = 0;

        for (int record : this.recordList) {
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