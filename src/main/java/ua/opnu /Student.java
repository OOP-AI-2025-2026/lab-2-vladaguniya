package ua.opnu;

import java.util.ArrayList;

public class Student {
    private String name;
    private int year;
    private ArrayList<String> courses;

    public Student(String name, int year) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Ім'я не повино бути порожнім");
        }

        if (!name.matches("[a-zA-Zа-яА-ЯёЁЇїІіЄєҐґ\\s'-]+")) {
            throw new IllegalArgumentException("Ім'я може містити лише літери, пробіли, дефіси та апострофи");
        }

        if (year < 1 || year > 4) {
            throw new IllegalArgumentException("Рік вашого навчання повинен бути 1-4");
        }

        this.name = name;
        this.year = year;
        this.courses = new ArrayList<>();
    }

    public void addCourse(String courseName) {
        if (courseName == null || courseName.isEmpty()) {
            return;
        }
        if (!courseName.matches("[a-zA-Zа-яА-ЯёЁЇїІіЄєҐґ\\s'-]+")) return;
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
}
