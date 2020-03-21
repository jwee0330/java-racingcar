package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @DisplayName("몇 대의 자동차로 몇 번의 이동을 할 것인지 입력할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"3 : 1", "3 : 3", "5 : 1", "5 : 3", "5 : 5", "5 : 10"}, delimiter = ':')
    public void init(int totalCarCount, int time) throws NoSuchFieldException, IllegalAccessException {
        Cars cars = new Cars(new String[]{"정원", "자바", "레이서"});
        RacingGame racingCarGame = new RacingGame(time, cars); // time: 몇 번, totalCarCount: 몇 대

        Field filedTime = RacingGame.class.getDeclaredField("time");
        Field fieldCars = RacingGame.class.getDeclaredField("cars");

        filedTime.setAccessible(true);
        fieldCars.setAccessible(true);

        int existingTime = (int) filedTime.get(racingCarGame);
        Cars existingCars = (Cars) fieldCars.get(racingCarGame);

        assertThat(existingTime).isEqualTo(time);
        assertThat(existingCars).isEqualTo(cars);
    }

    @DisplayName("자동차는 조건이 4 이상일 때만 전진한다.")
    @ParameterizedTest
    @CsvSource(value = {"1 : false", "2 : false", "3 : false", "4 : true"}, delimiter = ':')
    void RacingCarForwardOnConditionGraterThanOrEqualForTest(int condition, boolean expected) {

        Car car = new Car("정원");
        boolean forwardCondition = car.isForward(condition);

        assertThat(forwardCondition).isEqualTo(expected);
    }
}
