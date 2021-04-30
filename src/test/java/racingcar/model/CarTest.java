package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.etc.Message;

class CarTest {
    
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Car 생성시 매개변수가 null or 빈값일때 exception이 발생하는지 확인.")
    void validateNoneOrEmpty(String param) {
        assertThatThrownBy(() -> {new Car(param);})
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(Message.CAR_NAME_REQUIRED.getText());
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa", "bbbbbbb"})
    @DisplayName("Car 생성시 매개변수값이 5자를 초과할 때 exception이 발생하는지 확인.")
    void validateLessThanFive(String param) {
        assertThatThrownBy(() -> {new Car(param);})
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(Message.CAR_NAME_LESS_THAN_FIVE.getText());
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaaa", "bbbbb"})
    @DisplayName("Car 생성시 매개변수가 null or 빈값일때 exception이 발생하는지 확인.")
    void validateLessThanFive_pass(String param) {
        assertThat(new Car(param))
            .hasFieldOrPropertyWithValue("name", param);
    }
}
