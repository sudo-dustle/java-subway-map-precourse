package subway.line;

import subway.util.Menu;

public enum LineMenu implements Menu {
    ADD_LINE("1", "노선 등록") {
        @Override
        public void run() {
            LineView.showAddLine();
        }
    },
    DELETE_LINE("2", "노선 삭제") {
        @Override
        public void run() {
            LineView.showDeleteLine();
        }
    },
    FIND_LINE("3", "노선 조회") {
        @Override
        public void run() {
            LineView.showAllLineNames();
        }
    },
    QUIT("B", "돌아가기") {
        @Override
        public void run() {
            LineView.quit();
        }
    }
    ;

    private String number;
    private String description;

    LineMenu(String number, String description) {
        this.number = number;
        this.description = description;
    }

    @Override
    public String getNumber() {
        return number;
    }

    public static LineMenu of(String command) {
        LineMenu[] lineMenus = values();

        for(LineMenu lineMenu : lineMenus) {
            if(lineMenu.getNumber().equals(command)) {
                return lineMenu;
            }
        }

        return null;
    }
}
