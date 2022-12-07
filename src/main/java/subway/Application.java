package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.line.LineView;
import subway.main.MainView;

public class Application {
    public static void main(String[] args) {
        //final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        Station station1 = new Station("교대역");
        StationRepository.addStation(station1);
        Station station2 = new Station("강남역");
        StationRepository.addStation(station2);
        Station station3 = new Station("역삼역");
        StationRepository.addStation(station3);
        Station station4 = new Station("남부터미널역");
        StationRepository.addStation(station4);
        Station station5 = new Station("양재역");
        StationRepository.addStation(station5);
        Station station6 = new Station("매봉역");
        StationRepository.addStation(station6);
        Station station7 = new Station("양재시민의숲역");
        StationRepository.addStation(station7);

        Line line1 = new Line("2호선");
        line1.addStationByIndex(1, station1);
        line1.addStationByIndex(2, station2);
        line1.addStationByIndex(3, station3);
        LineRepository.addLine(line1);

        Line line2 = new Line("3호선");
        line2.addStationByIndex(1, station1);
        line2.addStationByIndex(2, station4);
        line2.addStationByIndex(3, station5);
        line2.addStationByIndex(4, station6);
        LineRepository.addLine(line2);

        Line line3 = new Line("신분당선");
        line3.addStationByIndex(1, station2);
        line3.addStationByIndex(2, station5);
        line3.addStationByIndex(3, station7);
        LineRepository.addLine(line3);

        MainView.run();
    }
}
