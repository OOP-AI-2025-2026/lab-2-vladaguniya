public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        if (hours < 0) hours = 0;
        if (minutes < 0) minutes = 0;

        this.hours = hours + minutes / 60;
        this.minutes = minutes % 60;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) return;

        int total = getTotalMinutes() + hours * 60 + minutes;
        this.hours = total / 60;
        this.minutes = total % 60;
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
        int current = getTotalMinutes();
        int other = span.getTotalMinutes();

        if (other > current) return; // головна логіка тестів

        int result = current - other;
        this.hours = result / 60;
        this.minutes = result % 60;
    }

    public void scale(int factor) {
        if (factor <= 0) return;

        int total = getTotalMinutes() * factor;
        this.hours = total / 60;
        this.minutes = total % 60;
    }
}
