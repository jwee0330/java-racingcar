package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    public void test() {
        //given
        String[] carNames = new String[]{"정원", "자바", "레이서"};

        Cars cars = new Cars(carNames);
        //when
        //then
        assertThat(cars.getCarsSize()).isEqualTo(3);

    }

}
