package cz.cvut.ear.clubevidence.exception;

/**
 * Signifies that invalid data have been provided to the application.
 */
public class ValidationException extends ExceptionGeneral{
    public ValidationException(String message) {
        super(message);
    }
}
