package JavaErrorsAndExeptions.MainTask.exceptions;

import java.util.NoSuchElementException;

public class NoFacultyException extends NoSuchElementException {

    String exceptionHeader;

    public NoFacultyException() {
    }

    public NoFacultyException(String exceptionHeader) {
        super();
        this.exceptionHeader = exceptionHeader;
    }

    @Override
    public String toString() {
        return "NoFacultyException " + exceptionHeader;
    }
}
