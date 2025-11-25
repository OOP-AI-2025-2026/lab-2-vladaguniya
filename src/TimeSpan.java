public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Некоректні значення часу");
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

    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Некоректні дані для додавання");
        }

        int totalMinutes = getTotalMinutes() + hours * 60 + minutes;

        this.hours = totalMinutes / 60;
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
        int current = getTotalMinutes();
        int other = span.getTotalMinutes();

        if (other > current) {
            throw new IllegalArgumentException("Не можна відняти більший інтервал");
        }

        int result = current - other;
        this.hours = result / 60;
        this.minutes = result % 60;
    }

    public void scale(int factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Множник має бути > 0");
        }

        int newMinutes = getTotalMinutes() * factor;
        this.hours = newMinutes / 60;
        this.minutes = newMinutes % 60;
    }

    @Override
    public String toString() {
        return hours + "h " + minutes + "m";
    }
}
