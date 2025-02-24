package cz.cvut.ear.clubevidence.exception;

public class PersistenceException extends ExceptionGeneral{
    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistenceException(Throwable cause) {
        super(cause);
    }
}
