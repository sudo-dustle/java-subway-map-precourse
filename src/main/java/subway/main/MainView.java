package subway.main;

import subway.domain.Line;
import subway.station.StationMenu;
import subway.station.StationView;
import subway.util.InputView;
import subway.util.Menu;
import subway.util.OutputView;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainView {
    private static boolean showing = true;

    private static MainController mainController = new MainController();

    public static void run() {
        while (showing) {
            try {
                printMenu();
                OutputView.printWaitNum();
                String command = InputView.readCommand();

                Menu menu = MainMenu.of(command);
                menu.run();
            } catch (IllegalArgumentException e) {
                String message = e.getMessage();
                OutputView.printError(message);
            }
        }
    }

    public static void printAll() {
        Map<String, List<String>> all = mainController.findAll();

        Set<String> keys = all.keySet();
        for(String key : keys) {
            OutputView.printInfo(key);
            OutputView.printInfo("---");
            StationView.printAllStations(all.get(key));
            System.out.println("\n");
        }
    }

    public static void quit() {
        showing = false;
    }

    public static void printMenu() {
        System.out.println("## 메인 화면\n" +
                "1. 역 관리\n" +
                "2. 노선 관리\n" +
                "3. 구간 관리\n" +
                "4. 지하철 노선도 출력\n" +
                "Q. 종료\n");
    }
}
