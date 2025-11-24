public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Invalid time values.");
        }
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void add(int addHours, int addMinutes) {
        if (addHours < 0 || addMinutes < 0 || addMinutes > 59) {
            throw new IllegalArgumentException("Invalid time values.");
        }

        int totalMinutes = this.minutes + addMinutes;
        this.hours += addHours + totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    public void addTimeSpan(TimeSpan span) {
        add(span.getHours(), span.getMinutes());
    }

    public double getTotalHours() {
        return hours + minutes / 60.0;
    }

    public int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    public void subtract(TimeSpan span) {
        int total1 = getTotalMinutes();
        int total2 = span.getTotalMinutes();

        if (total2 > total1) {
            return;
        }

        int diff = total1 - total2;

        this.hours = diff / 60;
        this.minutes = diff % 60;
    }

    public void scale(int factor) {
        if (factor <= 0) return;

        int total = getTotalMinutes() * factor;

        this.hours = total / 60;
        this.minutes = total % 60;
    }
}
