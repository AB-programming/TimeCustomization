package top.abstyle;

/**
 * @author AB-style
 * @date 2023/09/10
 */
public class TimeResult {
    private long time;
    private TimeUnit unit;

    public TimeResult() {
    }

    public TimeResult(long time, TimeUnit unit) {
        this.time = time;
        this.unit = unit;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public TimeUnit getUnit() {
        return unit;
    }

    public void setUnit(TimeUnit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "TimeResult{" +
                "time=" + time +
                ", unit=" + unit +
                '}';
    }
}
