package ua.opnu;

public class Main {

    public static void main(String[] args) {
        Student student = new Student("Олег", 1);
        student.addCourse("Схемотехніка");
        student.addCourse("Англійська мова");
        student.addCourse("Прикладна фізика");
        student.addCourse("Алгоритмізація та програмування");
        student.addCourse("Дискретна математика");

        System.out.println(student.getName() + ": кількість вивчаємих дисциплін - " + student.getCourseCount());
        System.out.println(student.getName() + ": рік навчання - " + student.getYear());
        System.out.println(student.getName() + ": заплатив за навчання - " + student.getTuition());
    }
}
