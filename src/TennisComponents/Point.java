package TennisComponents;

public enum Point {

    LOVE("Love"),
    FIFTEEN("15"),
    THIRTY("30"),
    FORTY("40");

    private final String displayValue;

    Point(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public Point next() {
        return switch (this) {
            case LOVE -> FIFTEEN;
            case FIFTEEN -> THIRTY;
            case THIRTY -> FORTY;
            case FORTY -> FORTY; // stays at 40 (deuce logic handled separately)
        };
    }
}
