package tk.timtim3001.engine.exceptions;

public class WorldNotInitializedException extends RuntimeException {

    public WorldNotInitializedException() {
    }

    public WorldNotInitializedException(String message) {
        super(message);
    }

    public WorldNotInitializedException(String message, Throwable cause) {
        super(message, cause);
    }

    public WorldNotInitializedException(Throwable cause) {
        super(cause);
    }

    public WorldNotInitializedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
