package subway.domain;

import java.util.*;

public class LineRepository {
    private static final Map<String, Line> lines = new LinkedHashMap<>();

    public static Collection<Line> lines() {
        return Collections.unmodifiableCollection(lines.values());
    }

    public static void addLine(Line line) {
        lines.putIfAbsent(line.getName(), line);
    }

    public static void deleteLineByName(String name) {
        lines.remove(name);
    }

    public static Line findLineByName(String name) {
        return lines.get(name);
    }

    public static boolean isExistLine(String name) {
        return lines.containsKey(name);
    }
}
