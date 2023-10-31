package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RoundTest {

    private Round round;
    private NumberGenerator numberGenerator;
    private Cars cars;
    private static final String CAR1_NAME = "pobi";
    private static final String CAR2_NAME = "woni";
    private static final String CAR3_NAME = "jun";

    @BeforeEach
    void setUp() {
        CarNames carNames = new CarNames(Arrays.asList(CAR1_NAME, CAR2_NAME, CAR3_NAME));
        cars = new Cars(carNames);
        numberGenerator = mock(NumberGenerator.class);
        round = new Round(cars, numberGenerator, new ForwardChecker());
    }

    @Test
    void run_메서드으로_각_차수마다_RacingCars의_자동차들을_자동차_전진조건을_판단해서_전진() {
        when(numberGenerator.createRandomNumber())
                .thenReturn(4)
                .thenReturn(3)
                .thenReturn(5);

        round.run();
        assertThat(cars.getCars().get(0).getForwardDistance().getValue()).isEqualTo(1);
        assertThat(cars.getCars().get(1).getForwardDistance().getValue()).isEqualTo(0);
        assertThat(cars.getCars().get(2).getForwardDistance().getValue()).isEqualTo(1);
    }
}