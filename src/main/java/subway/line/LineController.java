package subway.line;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;
import java.util.stream.Collectors;

public class LineController {

    public void addLine(String name, String firstStationName, String lastStationName) {
        validateLine(name, firstStationName, lastStationName);

        Station firstStation = StationRepository.findStationByName(firstStationName);
        Station lastStation = StationRepository.findStationByName(lastStationName);

        Line line = makeLine(name, firstStation, lastStation);
        LineRepository.addLine(line);
    }

    private void validateLine(String name, String firstStationName, String lastStationName) {
        validateExistLine(name);
        validateExistStation(firstStationName);
        validateExistStation(lastStationName);
    }

    private static Line makeLine(String name, Station firstStation, Station lastStation) {
        Line line = new Line(name);
        line.initStations(firstStation, lastStation);
        return line;
    }

    private static void validateExistStation(String name) {
        if(!StationRepository.isExistStation(name)) {
            throw new IllegalArgumentException("[ERROR] 없으면 생성 불가띠");
        }
    }

    public void deleteLine(String name) {
        validateNotExistLine(name);
        LineRepository.deleteLineByName(name);
    }

    public List<String> findAllLines() {
        return LineRepository.lines()
                .stream()
                .map(Line::getName)
                .collect(Collectors.toList());
    }

    private void validateExistLine(String name) {
        if(LineRepository.isExistLine(name)) {
            throw new IllegalArgumentException("[ERROR] 이미 있음");
        }
    }

    private void validateNotExistLine(String name) {
        if(!LineRepository.isExistLine(name)) {
            throw new IllegalArgumentException("[ERROR] 없음");
        }
    }
}
