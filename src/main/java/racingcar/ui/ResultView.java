package racingcar.ui;

public class ResultView {

    private final String winner;
    private final String renderingView;

    public ResultView(String winner, String renderingView) {
        this.winner = winner;
        this.renderingView = renderingView;
    }

    public void print() {
        System.out.printf("실행 결과\n%s \n%s가 최종 우승했습니다.", renderingView, winner);

    }
}
