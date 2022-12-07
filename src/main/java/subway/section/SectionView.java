package subway.section;

import subway.station.StationMenu;
import subway.util.InputView;
import subway.util.OutputView;

public class SectionView {
    private static SectionController sectionController = new SectionController();
    private static boolean showing = true;

    public static void run() {
        while (showing) {
            try {
                printSectionMenu();
                OutputView.printWaitNum();
                String command = InputView.readCommand();

                SectionMenu sectionMenu = SectionMenu.of(command);
                sectionMenu.run();
            } catch (IllegalArgumentException e) {
                String message = e.getMessage();
                OutputView.printError(message);
            }
        }
    }

    public static void quit() {
        showing = false;
    }

    public static void showAddSection() {
        printWaitLineName();
        String lineName = InputView.readCommand();

        printWaitStationName();
        String stationName = InputView.readCommand();

        printWaitSectionIndex();
        String sectionIndex = InputView.readCommand();

        sectionController.addSection(lineName, stationName, sectionIndex);
        printAddSection();
    }

    public static void showDeleteSection() {
        printWaitDeleteLine();
        String lineName = InputView.readCommand();

        printWaitDeleteStation();
        String stationName = InputView.readCommand();

        sectionController.deleteSection(lineName, stationName);
        printDeleteSection();
    }

    public static void printSectionMenu() {
        System.out.println("## 구간 관리 화면\n" +
                "1. 구간 등록\n" +
                "2. 구간 삭제\n" +
                "B. 돌아가기\n");
    }

    public static void printWaitLineName() {
        OutputView.printWaitCommand("노선을 입력하세요.");
    }

    public static void printWaitStationName() {
        OutputView.printWaitCommand("역이름을 입력하세요.");
    }

    public static void printWaitSectionIndex() {
        OutputView.printWaitCommand("순서를 입력하세요.");
    }

    private static void printAddSection() {
        OutputView.printInfo("구간이 등록되었습니다.");
    }


    public static void printWaitDeleteLine() {
        OutputView.printWaitCommand("삭제할 구간의 노선을 입력하세요.");
    }

    public static void printWaitDeleteStation() {
        OutputView.printWaitCommand("삭제할 구간의 역을 입력하세요.");
    }

    private static void printDeleteSection() {
        OutputView.printInfo("구간이 삭제되었습니다.");
    }
}
