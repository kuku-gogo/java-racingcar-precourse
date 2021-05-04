package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnersTest {

    List<Car> list;
    Car car01;
    Car car02;
    Car car03;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
        car01 = new Car("car01");
        car02 = new Car("car02");
        car03 = new Car("car03");
    }

    @Test
    @DisplayName("우승자 조회 로직 검증.")    
    void getWinnerList() {
        car01.addRecord(2);
        car02.addRecord(3);
        car03.addRecord(1);
        list.add(car01);
        list.add(car02);
        list.add(car03);
        Cars cars = new Cars(list);
        List<Car> result = cars.getCarList();
        Winners winners = new Winners(result);

        assertThat(winners.getWinnerList()).containsOnly(car02);
        assertThat(winners.getWinnerList()).doesNotContain(car01, car03);
    }

    @Test
    @DisplayName("우승자가 복수일때 정상적으로 조회되는지 검증")
    void getWinnerList_joint() {
        car01.addRecord(3);
        car02.addRecord(3);
        car03.addRecord(1);
        list.add(car01);
        list.add(car02);
        list.add(car03);
        Cars cars = new Cars(list);
        List<Car> result = cars.getCarList();
        Winners winners = new Winners(result);

        assertThat(winners.getWinnerList()).containsOnly(car01, car02);
        assertThat(winners.getWinnerList()).doesNotContain(car03);
    }
}