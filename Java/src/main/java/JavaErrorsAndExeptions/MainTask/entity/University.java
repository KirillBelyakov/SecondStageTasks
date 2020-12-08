package JavaErrorsAndExeptions.MainTask.entity;

import JavaErrorsAndExeptions.MainTask.exceptions.NoFacultyException;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Faculty> faculties;

    public University(List<Faculty> faculties) {
        this.faculties = faculties;
        if (faculties.size() == 0) {
            throw new NoFacultyException("There are no faculties in university!");
        }
    }

    public Student findStudentBySurname(String surname) {
        Student foundedStudent = null;
        for (Faculty faculty : faculties) {
            foundedStudent = faculty.findStudentBySurname(surname);
            if (foundedStudent != null) {
                break;
            }
        }
        return foundedStudent;
    }

    public double getStudentAverageMark(String surname) {
        System.out.println("Student " + surname + " average mark is :");
        return findStudentBySurname(surname).getStudentAverageMark();
    }

    public List<Lesson> getLessons(String name) {
        List<Lesson> lessons = new ArrayList<>();
        for (Faculty faculty : faculties) {
            lessons.addAll(faculty.getLessons(name));
        }
        return lessons;
    }

    public double getLessonsAverageMark(String name) {
        List<Lesson> lessons;
        lessons = getLessons(name);
        double averageLessonMark = 0;
        for (Lesson lesson : lessons) {
            averageLessonMark += lesson.getMark();
        }
        System.out.println("Average " + name + " lesson mark for whole university is :");
        return averageLessonMark / lessons.size();
    }

    public List<Lesson> getLessonFromParticularGroupAndFaculty(String name, String facultyName, String groupName) {
        List<Lesson> lessons = new ArrayList<>();
        for (Faculty faculty : faculties) {
            if (faculty.getName().equals(facultyName)) {
                lessons = faculty.getLessonFromParticularGroupAndFaculty(name, groupName);
                break;
            }
        }
        return lessons;
    }

    public double getMarksFromParticularGroupAndFaculty(String name, String faculty, String group) {
        List<Lesson> lessons;
        lessons = getLessonFromParticularGroupAndFaculty(name, faculty, group);
        double averageMark = 0;
        for (Lesson lesson : lessons) {
            averageMark += lesson.getMark();
        }
        System.out.println("For " + faculty + " faculty " + group + " group average mark is :");
        return averageMark / lessons.size();
    }

}
