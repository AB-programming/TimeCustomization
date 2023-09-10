package top.abstyle;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimeCustomization {
    private final HashMap<TimeUnit, List<Integer>> container = new HashMap<>();

    private SimpleDateFormat timeFormat;

    public TimeCustomization() {
    }

    public TimeCustomization(String timeFormat) {
        this.timeFormat = new SimpleDateFormat(timeFormat);
    }

    public void setFormat(String timeFormat) {
        this.timeFormat = new SimpleDateFormat(timeFormat);
    }

    public TimeResult getTime(String time) throws ParseException {
        Date initTime = timeFormat.parse(time);
        Date nowDate = new Date();
        if (this.container.containsKey(TimeUnit.MILLISECOND)) {
            List<Integer> values = this.container.get(TimeUnit.MILLISECOND);
            values.sort(Comparator.comparingInt(v -> v));
            for (Integer value : values) {
                if (nowDate.getTime() - initTime.getTime() <= value * TimeUnit.MILLISECOND.getValue()) {
                    return new TimeResult(value, TimeUnit.MILLISECOND);
                }
            }
        }
        if (this.container.containsKey(TimeUnit.SECOND)) {
            List<Integer> values = this.container.get(TimeUnit.SECOND);
            values.sort(Comparator.comparingInt(v -> v));
            for (Integer value : values) {
                if (nowDate.getTime() - initTime.getTime() <= value * TimeUnit.SECOND.getValue()) {
                    return new TimeResult(value, TimeUnit.SECOND);
                }
            }
        }
        if (this.container.containsKey(TimeUnit.MINUTE)) {
            List<Integer> values = this.container.get(TimeUnit.MINUTE);
            values.sort(Comparator.comparingInt(v -> v));
            for (Integer value : values) {
                if (nowDate.getTime() - initTime.getTime() <= value * TimeUnit.MINUTE.getValue()) {
                    return new TimeResult(value, TimeUnit.MINUTE);
                }
            }
        }
        if (this.container.containsKey(TimeUnit.HOUR)) {
            List<Integer> values = this.container.get(TimeUnit.HOUR);
            values.sort(Comparator.comparingInt(v -> v));
            for (Integer value : values) {
                if (nowDate.getTime() - initTime.getTime() <= value * TimeUnit.HOUR.getValue()) {
                    return new TimeResult(value, TimeUnit.HOUR);
                }
            }
        }
        if (this.container.containsKey(TimeUnit.DAY)) {
            List<Integer> values = this.container.get(TimeUnit.DAY);
            values.sort(Comparator.comparingInt(v -> v));
            for (Integer value : values) {
                if (nowDate.getTime() - initTime.getTime() <= value * TimeUnit.DAY.getValue()) {
                    return new TimeResult(value, TimeUnit.DAY);
                }
            }
        }
        return new TimeResult(0, TimeUnit.NULL);
    }

    public void putTimePoint(TimeUnit unit, Integer... values) {
        if (this.container.containsKey(unit)) {
            this.container.get(unit).addAll(Arrays.asList(values));
        } else {
            this.container.put(unit, new ArrayList<>(Arrays.asList(values)));
        }
    }

    public static void main(String[] args) {
        TimeCustomization t = new TimeCustomization();
        t.setFormat("yyyy-MM-dd HH:mm:ss");
        t.putTimePoint(TimeUnit.MINUTE, 3, 6, 7, 2, 1);
//        t.putTimePoint(TimeUnit.DAY, 1);
        t.putTimePoint(TimeUnit.HOUR, 1);
        try {
            TimeResult time = t.getTime("2023-09-10 21:05:00");
            System.out.println(time);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
