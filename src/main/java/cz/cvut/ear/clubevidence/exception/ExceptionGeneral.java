package cz.cvut.ear.clubevidence.exception;

public class ExceptionGeneral extends RuntimeException{
    public ExceptionGeneral() {
    }

    public ExceptionGeneral(String message) {
        super(message);
    }

    public ExceptionGeneral(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionGeneral(Throwable cause) {
        super(cause);
    }
}

