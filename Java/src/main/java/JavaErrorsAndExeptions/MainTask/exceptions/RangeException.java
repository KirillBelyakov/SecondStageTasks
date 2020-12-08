package JavaErrorsAndExeptions.MainTask.exceptions;

public class RangeException extends IllegalArgumentException {

    String exceptionHeader;

    public RangeException() {
    }

    public RangeException(String exceptionHeader) {
        super();
        this.exceptionHeader = exceptionHeader;
    }

    @Override
    public String toString() {
        return "RangeException " + exceptionHeader;
    }
}

