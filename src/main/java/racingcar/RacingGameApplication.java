package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Cars cars = new Cars(inputView.getCarNames());

        RacingGame racingGame = new RacingGame(inputView.getTime(), cars);
        racingGame.game();

        ResultView resultView = new ResultView(racingGame.getResult());
        resultView.print();
    }

}
