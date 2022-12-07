package subway.util;

import java.util.List;

public class OutputView {
    private static final String prefix = "[INFO] ";

    public static void printWaitNum() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    public static void printError(String error) {
        System.out.println(error + "\n");
    }

    public static void printInfo(String message) {
        System.out.println(prefix + message);
    }

    public static void printWaitCommand(String message) {
        System.out.println("## " + message);
    }
}
