package subway.line;

import subway.station.StationMenu;
import subway.util.InputView;
import subway.util.OutputView;

import java.util.List;

public class LineView {
    private static LineController lineController = new LineController();
    private static boolean showing = true;

    public static void run() {
        while (showing) {
            try {
                printLineMenu();
                OutputView.printWaitNum();
                String command = InputView.readCommand();

                LineMenu lineMenu = LineMenu.of(command);
                lineMenu.run();
            } catch (IllegalArgumentException e) {
                String message = e.getMessage();
                OutputView.printError(message);
            }
        }
    }

    public static void quit() {
        showing = false;
    }

    private static void printLineMenu() {
        System.out.println("## 노선 관리 화면\n" +
                "1. 노선 등록\n" +
                "2. 노선 삭제\n" +
                "3. 노선 조회\n" +
                "B. 돌아가기\n");
    }

    public static void showAddLine() {
        OutputView.printWaitCommand("등록할 노선 이름을 입력하세요.");
        String lineName = InputView.readCommand();

        OutputView.printWaitCommand("등록할 노선의 상행 종점역 이름을 입력하세요.");
        String firstStationName = InputView.readCommand();

        OutputView.printWaitCommand("등록할 노선의 하행 종점역 이름을 입력하세요.");
        String lastStationName = InputView.readCommand();

        lineController.addLine(lineName, firstStationName, lastStationName);
        OutputView.printInfo("지하철 노선이 등록되었습니다.");
    }

    public static void showDeleteLine() {
        OutputView.printWaitCommand("삭제할 노선 이름을 입력하세요.");
        String lineName = InputView.readCommand();

        lineController.deleteLine(lineName);
        OutputView.printInfo("지하철 노선이 삭제되었습니다.");
    }

    public static void showAllLineNames() {
        List<String> allLines = lineController.findAllLines();

        for(String name : allLines) {
            OutputView.printInfo(name);
        }
    }
}
