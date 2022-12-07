package subway.station;

import subway.util.Menu;

public enum StationMenu implements Menu {
    ADD_STATION("1", "역 등록") {
        @Override
        public void run() {
            StationView.showAddStation();
        }
    },
    DELETE_STATION("2", "역 삭제") {
        @Override
        public void run() {
            StationView.showDeleteStation();
        }
    },
    FIND_STATION("3", "역 조회") {
        @Override
        public void run() {
            StationView.showAllStations();
        }
    },
    QUIT("B", "돌아가기") {
        @Override
        public void run() {
            StationView.quit();
        }
    }
    ;

    private String number;
    private String description;

    StationMenu(String number, String description) {
        this.number = number;
        this.description = description;
    }

    @Override
    public String getNumber() {
        return number;
    }

    public static StationMenu of(String number) {
        StationMenu[] stationMenus = values();

        for(StationMenu stationMenu : stationMenus) {
            if(stationMenu.getNumber().equals(number)) {
                return stationMenu;
            }
        }

        return null;
    }
}
