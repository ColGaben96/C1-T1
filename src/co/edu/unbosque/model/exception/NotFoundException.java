package co.edu.unbosque.model.exception;

public class NotFoundException extends Exception {
    public NotFoundException() {
        super("No puede ser encontrado.");
    }
}
