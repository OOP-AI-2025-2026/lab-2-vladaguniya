import java.util.ArrayList;

public class Student {
    private String name;
    private int year;
    private ArrayList<String> courses;

    public Student(String name, int year) {
        if (year < 1 || year > 4) {
            throw new IllegalArgumentException("Рік має бути від 1 до 4");
        }
        this.name = name;
        this.year = year;
        this.courses = new ArrayList<>();
    }

    public void addCourse(String courseName) {
        if (courseName == null || courseName.isEmpty()) {
            throw new IllegalArgumentException("Назва дисципліни порожня");
        }
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


    // MAIN — що треба в завданні
    public static void main(String[] args) {

        Student st = new Student("Влада", 2);

        st.addCourse("Алгоритми");
        st.addCourse("Бази даних");
        st.addCourse("Java");

        System.out.println(st.getName() + ": кількість вивчаємих дисциплін - " + st.getCourseCount());
        System.out.println(st.getName() + ": рік навчання - " + st.getYear());
        System.out.println(st.getName() + ": заплатив за навчання - " + st.getTuition());
    }
}
