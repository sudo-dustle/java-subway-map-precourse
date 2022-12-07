package subway.main;

import subway.line.LineView;
import subway.section.SectionView;
import subway.station.StationView;
import subway.util.Menu;

public enum MainMenu implements Menu {
    STATION("1", "역 관리", StationView::run),
    LINE("2", "노선 관리", LineView::run),
    SECTION("3", "구간 관리", SectionView::run),
    PRINT("4", "지하철 노선도 출력", MainView::printAll),
    QUIT("Q", "종료", MainView::quit);

    private final String number;
    private final String description;

    private final Runnable runnable;

    MainMenu(String number, String description, Runnable runnable) {
        this.number = number;
        this.description = description;
        this.runnable = runnable;
    }

    public static Menu of(String command) {
        for(Menu menu : values()) {
            if(menu.getNumber().equals(command)) {
                return menu;
            }
        }

        return null;
    }

    @Override
    public void run() {
        runnable.run();
    }

    @Override
    public String getNumber() {
        return this.number;
    }
}
