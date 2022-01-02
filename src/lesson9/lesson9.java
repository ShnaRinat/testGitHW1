package lesson9;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class lesson9 {

    interface Student {
        String getName();
        List<Course> getAllCourses();
    }
    interface Course {
        String getTitle();
    }

    static class MyStudent implements Student{
        private String name;
        private List<Course> courses;

        public MyStudent(String name, List<Course> courses){
            this.name = name;
            this.courses = courses;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public List<Course> getAllCourses() {
            return courses;
        }
    }

    static class MyCourse implements Course{
        private String title;

        public MyCourse(String title){
            this.title = title;
        }

        @Override
        public String getTitle() {
            return title;
        }
    }

    public static void main (String[] args){
        System.out.println("Приветствие");
        Course[] courses = {

        new MyCourse("Git. Базовый курс"),
        new MyCourse("Введение в тестирование"),
        new MyCourse("Java Core для тестировщиков"),
        new MyCourse("Java. Уровень 1"),
        new MyCourse("HTML/CSS для тестировщиков"),
        new MyCourse("Linux. Рабочая станция"),
        new MyCourse("Английский для IT-специалистов"),
        new MyCourse("Карьерная консультация"),
        new MyCourse("Введение в тестирование. Практикум"),
        new MyCourse("Тестирование веб-приложений")

        };

        List<Student> students = Arrays.asList(

        new MyStudent("Оля", Arrays.asList(courses[0], courses[1], courses[8])),
        new MyStudent("Сергей", Arrays.asList(courses[2], courses[3])),
        new MyStudent("Валентина", Arrays.asList(courses[4], courses[5], courses[6], courses[7])),
        new MyStudent("Олег", Arrays.asList(courses[6], courses[7], courses[6], courses[8])),
        new MyStudent("Марина", Arrays.asList(courses[8], courses[9])),
        new MyStudent("Анатолий", Arrays.asList(courses[1])),
        new MyStudent("Алексей", Arrays.asList(courses[2]))
        );

        System.out.println(uniqueCourses(students));
        System.out.println(wiseStudents(students));
        System.out.println(findStudentsByCourse(students, courses[6]));

    }

        public static List<String> uniqueCourses(List<Student> students){
        return students.stream()
                .map(Student::getAllCourses)
                .flatMap(List::stream)
                .map(Course::getTitle)
                .distinct()
                .collect(Collectors.toList());
    }

        public static List<String> wiseStudents(List<Student> students){
        return students.stream()
                .filter(student -> student.getAllCourses().size() >= 3)
                .map(Student::getName)
                .collect(Collectors.toList());
    }

        static List<String> findStudentsByCourse(List<Student> students, Course course) {
        return students.stream()
                .filter(student -> student.getAllCourses().contains(course))
                .map(Student::getName)
                .collect(Collectors.toList());
    }
}