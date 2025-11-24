import java.util.ArrayList;

public class Student {
    private String name;
    private int year;
    private ArrayList<String> courses = new ArrayList<>();

    public Student(String name, int year) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException();
        if (year < 1 || year > 4) throw new IllegalArgumentException();

        this.name = name;
        this.year = year;
    }

    public void addCourse(String courseName) {
        if (courseName == null || courseName.isEmpty()) return;
        courses.add(courseName);
    }

    public void dropAll() {
        courses.clear();
    }

    public int getCourseCount() {
        return courses.size();
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getTuition() {
        return year * 20000;
    }

    public static void main(String[] args) {
        Student s = new Student("Vlada", 2);

        s.addCourse("Math");
        s.addCourse("Java");
        s.addCourse("Databases");

        System.out.println(s.getName() + ": кількість вивчаємих дисциплін - " + s.getCourseCount());
        System.out.println(s.getName() + ": рік навчання - " + s.getYear());
        System.out.println(s.getName() + ": заплатив за навчання - " + s.getTuition());
    }
}
