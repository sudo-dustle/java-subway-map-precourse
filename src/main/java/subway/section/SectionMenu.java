package subway.section;

import subway.util.Menu;

public enum SectionMenu implements Menu {
    ADD_SECTION("1", "구간 등록") {
        @Override
        public void run() {
            SectionView.showAddSection();
        }
    },
    DELETE_SECTION("2", "구간 삭제") {
        @Override
        public void run() {
            SectionView.showDeleteSection();
        }
    },
    QUIT("B", "돌아가기") {
        @Override
        public void run() {
            SectionView.quit();
        }
    }
    ;

    private String number;
    private String description;

    SectionMenu(String number, String description) {
        this.number = number;
        this.description = description;
    }

    @Override
    public String getNumber() {
        return number;
    }

    public static SectionMenu of(String number) {
        SectionMenu[] sectionMenus = values();

        for(SectionMenu sectionMenu : sectionMenus) {
            if(sectionMenu.getNumber().equals(number)) {
                return sectionMenu;
            }
        }

        return null;
    }
}
