package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
    private static final int MOVE = 1;
    private static final int NOT_MOVE = 0;

    private final String name;
    private final List<Integer> position;

    public Car(String name) {
        this.name = name;
        this.position = new ArrayList<>();
    }

    public void forward() {
        int condition = new Random().nextInt(RacingGameConstant.RANDOM_LIMIT);
        if (isForward(condition)) {
            position.add(MOVE);
            return;
        }
        position.add(NOT_MOVE);
    }

    public boolean isForward(int condition) {
        return condition >= RacingGameConstant.APPROVE_CONDITION;
    }

    public String getResult(int time) {
        StringBuilder positionMarker = new StringBuilder();
        for (int i = 0; i <= time; i++) {
            writePositionMarker(positionMarker, i);
        }
        return name + RacingGameConstant.COLON + positionMarker.toString();
    }

    private void writePositionMarker(StringBuilder positionMarker, int i) {
        if (position.get(i) > NOT_MOVE) {
            positionMarker.append(RacingGameConstant.CAR_MARKER);
        }
    }

}
