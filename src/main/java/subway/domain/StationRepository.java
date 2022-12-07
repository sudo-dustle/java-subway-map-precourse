package subway.domain;

import java.util.*;

public class StationRepository {
    private static final Map<String, Station> stations = new LinkedHashMap<>();

    public static Collection<Station> stations() {
        return Collections.unmodifiableCollection(stations.values());
    }

    public static void addStation(Station station) {
        stations.putIfAbsent(station.getName(), station);
    }

    public static void deleteStation(String name) {
        stations.remove(name);
    }

    public static Station findStationByName(String name) {
        return stations.get(name);
    }

    public static boolean isExistStation(String name) {
        return stations.containsKey(name);
    }
}
