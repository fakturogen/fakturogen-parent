package pl.fakturogen.invoice.exception;

public class CustomerReadException extends CustomerException {

    public CustomerReadException(String message) {
        super(message);
    }

    public CustomerReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
