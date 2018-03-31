package tk.timtim3001.engine.exceptions;

public class PhysicsEngineAlreadyInitializedException extends RuntimeException {

    public PhysicsEngineAlreadyInitializedException() {
    }

    public PhysicsEngineAlreadyInitializedException(String message) {
        super(message);
    }

    public PhysicsEngineAlreadyInitializedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PhysicsEngineAlreadyInitializedException(Throwable cause) {
        super(cause);
    }

    public PhysicsEngineAlreadyInitializedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
