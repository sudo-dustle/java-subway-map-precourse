package subway.station;

import subway.util.InputView;
import subway.util.OutputView;

import java.util.List;

public class StationView {
    private static StationController stationController = new StationController();
    private static boolean showing = true;

    public static void run() {
        while (showing) {
            try {
                printStationMenu();
                OutputView.printWaitNum();
                String command = InputView.readCommand();

                StationMenu stationMenu = StationMenu.of(command);
                stationMenu.run();
            } catch (IllegalArgumentException e) {
                String message = e.getMessage();
                OutputView.printError(message);
            }
        }
    }

    public static void quit() {
        showing = false;
    }

    public static void showAddStation() {
        printWaitStationName();
        String name = InputView.readCommand();
        stationController.addStation(name);
        printAddStation();
    }

    public static void showDeleteStation() {
        printWaitDeleteStation();
        String name = InputView.readCommand();
        stationController.deleteStation(name);
        printDeleteStation();
    }

    public static void showAllStations() {
        List<String> allStationNames = stationController.findAllStationNames();
        printAllStations(allStationNames);
    }

    public static void printWaitStationName() {
        OutputView.printWaitCommand("등록할 역 이름을 입력하세요.");
    }

    public static void printWaitDeleteStation() {
        OutputView.printWaitCommand("삭제할 역 이름을 입력하세요.");
    }

    public static void printStationMenu() {
        System.out.println("## 역 관리 화면\n" +
                "1. 역 등록\n" +
                "2. 역 삭제\n" +
                "3. 역 조회\n" +
                "B. 돌아가기\n");
    }

    public static void printAddStation() {
        OutputView.printInfo("자하철 역이 등록되었습니다");
    }

    public static void printDeleteStation() {
        OutputView.printInfo("지하철 역이 삭제되었습니다.");
    }

    public static void printAllStations(List<String> stationNames) {
        for (String name : stationNames) {
            OutputView.printInfo(name);
        }
    }
}
