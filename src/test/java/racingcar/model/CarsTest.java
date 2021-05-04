package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import racingcar.etc.Message;

class CarsTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Cars 생성시 매개변수가 null or 빈값일때 exception이 발생하는지 확인.")
    void validateNoneOrEmpty(String param) {
        assertThatThrownBy(() -> {new Cars(param);})
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(Message.CAR_NAME_REQUIRED.getText());
    }

    @ParameterizedTest
    @CsvSource(value = {"aaa,bbb,ccc:3", "aa,bb,cc,dd:4"}, delimiter = ':')
    @DisplayName("Cars 생성시 매개변수가 null or 빈값일때 exception이 발생하는지 확인.")
    void getCount(String param, int count) {
        Cars cars = new Cars(param);

        assertThat(cars.count()).isEqualTo(count);
    }
}
