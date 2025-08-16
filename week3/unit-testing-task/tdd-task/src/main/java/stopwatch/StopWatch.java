package stopwatch;

public class StopWatch {
    int minutes;
    int hours;
    int seconds;

    public void record(int seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Time cannot be negative");
        }
            this.hours = seconds / 3600;
            int remaining = seconds % 3600;
            this.seconds = remaining % 60;
            this.minutes = remaining / 60;
    }

    public int getHours() {
        return hours;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMinutes() {
        return minutes;
    }
}
