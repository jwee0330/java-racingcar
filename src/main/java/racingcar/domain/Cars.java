package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        this.cars = cars;
    }

    public int getCarsSize() {
        return cars.size();
    }

    public void move() {
        for (int carNumber = 0; carNumber < cars.size(); carNumber++) {
            cars.get(carNumber).forward();
        }
    }

    public String getResult(int time) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getResult(time).concat(RacingGameConstant.CARRIAGE_RETURN));
        }
        sb.append(RacingGameConstant.CARRIAGE_RETURN);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cars)) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
