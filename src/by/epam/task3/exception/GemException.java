package by.epam.task3.exception;

public class GemException extends Exception{
    public GemException() {
        super();
    }

    public GemException(String message) {
        super(message);
    }

    public GemException(String message, Throwable cause) {
        super(message, cause);
    }

    public GemException(Throwable cause) {
        super(cause);
    }
}
