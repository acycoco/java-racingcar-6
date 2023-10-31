package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car1;
    private final String CAR1_NAME = "pobi";
    @BeforeEach
    void setUp() {
        car1 = new Car(new CarName(CAR1_NAME));
    }

    @Test
    void RacingCar_생성시_forwardDistance가_0으로_생성() {
        assertThat(car1.getForwardDistance().getValue()).isEqualTo(0);
    }

    @Test
    void forward_메서드_사용시_forwardDistance가_1증가() {
        car1.forward();
        assertThat(car1.getForwardDistance().getValue()).isEqualTo(1);
    }

    @Test
    void toString_메서드로_name과_forwardDistance를_출력() {
        car1.forward();
        car1.forward();
        String expected = CAR1_NAME + " : --";
        assertThat(car1.toString()).isEqualTo(expected);
    }
}