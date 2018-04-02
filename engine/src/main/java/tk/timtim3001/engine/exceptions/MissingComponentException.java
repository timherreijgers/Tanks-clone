package tk.timtim3001.engine.exceptions;

public class MissingComponentException extends RuntimeException {

    public MissingComponentException() {
    }

    public MissingComponentException(String message) {
        super(message);
    }

    public MissingComponentException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingComponentException(Throwable cause) {
        super(cause);
    }

    public MissingComponentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
