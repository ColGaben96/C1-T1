package co.edu.unbosque.model.exception;

public class AlreadyExistsException extends Exception {
    public AlreadyExistsException() {
        super("ya existe.");
    }
}
