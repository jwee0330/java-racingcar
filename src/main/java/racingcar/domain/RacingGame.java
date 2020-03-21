package racingcar.domain;

public class RacingGame {

    private final int time;
    private final Cars cars;

    public RacingGame(int time, Cars cars) {
        this.time = time;
        this.cars = cars;
    }

    public void game() {
        for (int i = 0; i < time; i++) {
            cars.move();
        }
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < time; i++) {
            sb.append(cars.getResult(i));
        }
        return sb.toString();
    }
}
