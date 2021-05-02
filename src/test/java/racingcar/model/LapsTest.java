package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.etc.Message;

public class LapsTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    @DisplayName("Laps 생성시 1미만의 파라메터 입력시 exception 발생하는지 확인.")
    void validateOneOrMore(String param) {
        assertThatThrownBy(() -> {new Laps(param);})
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(Message.LESS_THAN_1.getText());
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "aaa", "t"})
    @DisplayName("숫자 타입이 아닌값을 입력시 exception 발생하는지 확인.")
    void valideteNumber(String param) {
        assertThatThrownBy(() -> {new Laps(param);})
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(Message.ONLY_NUMBER.getText());
    }
}
