package JavaErrorsAndExeptions.MainTask.entity;

import JavaErrorsAndExeptions.MainTask.exceptions.NoStudentsException;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private List<Student> students;

    public Group(List<Student> students, String name) {
        this.students = students;
        this.name = name;
        if (students.size() == 0) {
            throw new NoStudentsException("There are no students in " + name + " group!");
        }
    }

    public String getName() {
        return name;
    }

    public Student findStudentBySurname(String surname) {
        Student foundedStudent = null;
        for (Student student : students) {
            if (student.getSurname().equals(surname)) {
                foundedStudent = student;
                break;
            }
        }
        return foundedStudent;
    }

    public List<Lesson> getLesson(String name) {
        List<Lesson> lessons = new ArrayList<>();
        for (Student student : students) {
            lessons.add(student.getLesson(name));
        }
        return lessons;
    }
}
