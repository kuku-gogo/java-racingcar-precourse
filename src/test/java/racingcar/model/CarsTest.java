package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @Test
    void sort() {
        List<Car> list = new ArrayList<>();
        Car car01 = new Car("car01");
        Car car02 = new Car("car02");
        Car car03 = new Car("car03");
        car01.addRecord(2);
        car02.addRecord(3);
        car03.addRecord(1);
        list.add(car01);
        list.add(car02);
        list.add(car03);
        Cars cars = new Cars(list);
        cars.sort();
        List<Car> result = cars.getCars();

        assertThat(result.get(0).getName()).isEqualTo("car03");
        assertThat(result.get(1).getName()).isEqualTo("car01");
        assertThat(result.get(2).getName()).isEqualTo("car02");
    }
}
