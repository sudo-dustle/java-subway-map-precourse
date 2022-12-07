package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stations;

    public Line(String name) {
        validationLength(name);
        this.name = name;
        this.stations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void initStations(Station firstStation, Station lastStation) {
        addStationByIndex(1, firstStation);
        addStationByIndex(2, lastStation);
    }

    public void addStationByIndex(int index, Station station) {
        stations.add(index - 1, station);
        station.plusLineCount();
    }

    public void deleteStation(Station station) {
        validateSize();
        stations.remove(station);
        station.minusLineCount();
    }

    public boolean hasMinimumStations() {
        return stations.size() <= 2;
    }

    private void validateSize() {
        if(stations.size() < 2) {
            throw new IllegalArgumentException("[ERROR] 2개 이하라서 삭제 안됨");
        }
    }

    public void validationLength(String name) {
        if(name.length() < 2) {
            throw new IllegalArgumentException("2글자 이상만 가능");
        }
    }
}
