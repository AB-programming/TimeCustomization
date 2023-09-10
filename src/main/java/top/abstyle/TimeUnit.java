package top.abstyle;

public enum TimeUnit {
    NULL(0),
    MILLISECOND(1),
    SECOND(1000),
    MINUTE(60000),
    HOUR(3600000),
    DAY(86400000);
    private final long value;

    TimeUnit(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
