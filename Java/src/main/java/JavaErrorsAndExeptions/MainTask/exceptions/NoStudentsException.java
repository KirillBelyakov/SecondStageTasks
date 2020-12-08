package JavaErrorsAndExeptions.MainTask.exceptions;

import java.util.NoSuchElementException;

public class NoStudentsException extends NoSuchElementException {

    String exceptionHeader;

    public NoStudentsException() {
    }

    public NoStudentsException(String exceptionHeader) {
        super();
        this.exceptionHeader = exceptionHeader;
    }

    @Override
    public String toString() {
        return "NoStudentsException " + exceptionHeader;
    }
}
