package co.edu.unbosque.model.exception;

public class NotFoundException extends Exception {
    public NotFoundException() {
        super("no existe en el sistema.");
    }
}
