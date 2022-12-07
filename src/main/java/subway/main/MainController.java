package subway.main;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

import java.util.*;
import java.util.stream.Collectors;

public class MainController {

    public Map<String, List<String>> findAll() {
        Collection<Line> lines = LineRepository.lines();

        Map<String, List<String>> all = new LinkedHashMap<>();

        for(Line line : lines) {
            String name = line.getName();
            List<String> stations = getStationNames(line);
            all.put(name, stations);
        }

        return all;
    }

    private static List<String> getStationNames(Line line) {
        return line.getStations()
                .stream()
                .map(Station::getName)
                .collect(Collectors.toList());
    }
}
