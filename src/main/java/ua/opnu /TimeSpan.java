package ua.opnu;


public class TimeSpan {
    private int hours;
    private int minutes;

    TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    int getHours() {
        return this.hours;
    }

    int getMinutes() {
        return this.minutes;
    }

    void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            return;
        }
        int totalMinutes = this.hours * 60 + hours * 60 + this.minutes + minutes;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    void addTimeSpan(TimeSpan timespan) {
        int h = timespan.getHours();
        int m = timespan.getMinutes();
        add(h, m);
    }

    double getTotalHours() {
        return (hours + minutes / 60.0);
    }

    int getTotalMinutes() {
        return (minutes + hours * 60);
    }

    void subtract(TimeSpan span) {
        int totalMinutesCurrent = this.hours * 60 + this.minutes;
        int totalMinutesSpan = span.getHours() * 60 + span.getMinutes();

        if (totalMinutesSpan > totalMinutesCurrent) {
            return;
        }

        int remainingMinutes = totalMinutesCurrent - totalMinutesSpan;
        this.hours = remainingMinutes / 60;
        this.minutes = remainingMinutes % 60;
    }

    void scale(int factor) {
        int totalMinutesCurrent = this.hours * 60 + this.minutes;

        if (factor <= 0) {
            return;
        }

        totalMinutesCurrent *= factor;

        this.hours = totalMinutesCurrent / 60;
        this.minutes = totalMinutesCurrent % 60;
    }
}
