package subway.domain;


public class Station {
    private String name;
    private Integer lineCount;

    public Station(String name) {
        validationLength(name);
        this.name = name;
        this.lineCount = 0;
    }

    public String getName() {
        return name;
    }

    public void plusLineCount() {
        this.lineCount += 1;
    }

    public void minusLineCount() {
        this.lineCount -= 1;
    }

    public boolean hasLines() {
        return lineCount > 0;
    }

    public void validationLength(String name) {
        if(name.length() < 2) {
            throw new IllegalArgumentException("2글자 이상만 가능");
        }
    }
}
