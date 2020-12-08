package JavaErrorsAndExeptions.MainTask.entity;

import JavaErrorsAndExeptions.MainTask.exceptions.RangeException;

public class Lesson {
    private String name;
    private int mark;

    public Lesson(String name, int mark) {
        this.name = name;
        this.mark = mark;
        if (mark > 10 || mark < 0) {
            throw new RangeException("Students mark must be from 0 to 10");
        }
    }

    public String getName() {
        return name;
    }

    public int getMark() {
        return mark;
    }
}
