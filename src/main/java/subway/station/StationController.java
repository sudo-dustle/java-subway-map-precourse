package subway.station;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;
import java.util.stream.Collectors;

public class StationController {
    public void addStation(String name) {
        Station station = new Station(name);
        validateExistStation(name);

        StationRepository.addStation(station);
    }


    public void deleteStation(String name) {
        validateNotExistStation(name);
        validateStationInLine(name);

        StationRepository.deleteStation(name);
    }

    private void validateStationInLine(String name) {
        Station station = StationRepository.findStationByName(name);
        if(station.hasLines()) {
           throw new IllegalArgumentException("이미 노선에 있는거라서 삭제 안됨");
        }
    }


    public List<String> findAllStationNames() {
        return StationRepository.stations()
                .stream()
                .map(Station::getName)
                .collect(Collectors.toList());
    }

    private void validateExistStation(String name) {
        if(StationRepository.isExistStation(name)) {
            throw new IllegalArgumentException("[ERROR] 이미 있음");
        }
    }

    private void validateNotExistStation(String name) {
        if(!StationRepository.isExistStation(name)) {
            throw new IllegalArgumentException("[ERROR] 없음");
        }
    }


}
