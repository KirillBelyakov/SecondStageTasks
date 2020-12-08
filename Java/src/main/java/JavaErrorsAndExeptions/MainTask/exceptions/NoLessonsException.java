package JavaErrorsAndExeptions.MainTask.exceptions;

import java.util.NoSuchElementException;

public class NoLessonsException extends NoSuchElementException {

    String exceptionHeader;

    public NoLessonsException() {
    }

    public NoLessonsException(String exceptionHeader) {
        super();
        this.exceptionHeader = exceptionHeader;
    }

    @Override
    public String toString() {
        return "NoLessonsException " + exceptionHeader;
    }
}
