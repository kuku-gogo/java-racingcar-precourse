package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RecordsTest {

    @Test
    @DisplayName("레코드 기록후 전체 레코드 조회시 기록된 총합이 나오는지 확인.")
    void getTotalRecords() {
        Records records = new Records("test");

        records.addRecord(1);
        records.addRecord(0);
        records.addRecord(1);

        assertThat(records.getTotalRecords()).isEqualTo(2);
    }

    @Test
    @DisplayName("레코드의 toString 테스트.")
    void toString_test() {
        Records records = new Records("test");

        records.addRecord(1);
        records.addRecord(1);

        assertThat(records).hasToString("test : --");
    }
}