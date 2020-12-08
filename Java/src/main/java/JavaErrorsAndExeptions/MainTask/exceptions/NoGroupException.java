package JavaErrorsAndExeptions.MainTask.exceptions;

import java.util.NoSuchElementException;

public class NoGroupException extends NoSuchElementException {

    String exceptionHeader;

    public NoGroupException() {
    }

    public NoGroupException(String exceptionHeader) {
        super();
        this.exceptionHeader = exceptionHeader;
    }

    @Override
    public String toString() {
        return "NoGroupException " + exceptionHeader;
    }
}
