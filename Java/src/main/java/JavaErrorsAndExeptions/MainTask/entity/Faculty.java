package JavaErrorsAndExeptions.MainTask.entity;

import JavaErrorsAndExeptions.MainTask.exceptions.NoGroupException;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String name;
    private List<Group> groups;

    public Faculty(List<Group> groups, String name) {
        this.groups = groups;
        this.name = name;
        if (groups.size() == 0) {
            throw new NoGroupException("There are no groups on " + name + " faculty!");
        }
    }

    public String getName() {
        return name;
    }

    public Student findStudentBySurname(String surname) {
        Student foundedStudent = null;
        for (Group group : groups) {
            foundedStudent = group.findStudentBySurname(surname);
            if (foundedStudent != null) {
                break;
            }
        }
        return foundedStudent;
    }

    public List<Lesson> getLessons(String name) {
        List<Lesson> lessons = new ArrayList<>();
        for (Group group : groups) {
            lessons.addAll(group.getLesson(name));
        }
        return lessons;
    }

    public List<Lesson> getLessonFromParticularGroupAndFaculty(String name, String groupName) {
        List<Lesson> lessons = new ArrayList<>();
        for (Group group : groups) {
            if (group.getName().equals(groupName)) {
                lessons = group.getLesson(name);
                break;
            }
        }
        return lessons;
    }
}
