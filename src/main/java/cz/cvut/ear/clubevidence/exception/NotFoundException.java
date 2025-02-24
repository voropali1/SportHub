package cz.cvut.ear.clubevidence.exception;

/**
 * Indicates that a resource was not found.
 */
public class NotFoundException extends ExceptionGeneral {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public static NotFoundException create(String resourceName, Object identifier) {
        return new NotFoundException(resourceName + " identified by " + identifier + " not found.");
    }
}
