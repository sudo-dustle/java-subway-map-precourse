package subway.section;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SectionController {

    public void addSection(String lineName, String stationName, String index) {
        Line line = findLine(lineName);
        Station station = findStation(stationName);

        line.addStationByIndex(Integer.parseInt(index), station);
    }

    public void deleteSection(String lineName, String stationName) {
        Line line = findLine(lineName);
        validateLineSize(line);

        Station station = findStation(stationName);
        line.deleteStation(station);
    }

    private static void validateLineSize(Line line) {
        if(line.hasMinimumStations()) {
            throw new IllegalArgumentException("2개 이하일 때 삭제 불가");
        }
    }

    private Station findStation(String stationName) {
        return StationRepository.findStationByName(stationName);
    }

    private Line findLine(String lineName) {
        return LineRepository.findLineByName(lineName);
    }
}
