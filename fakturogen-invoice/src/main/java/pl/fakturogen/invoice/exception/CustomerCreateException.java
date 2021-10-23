package pl.fakturogen.invoice.exception;

public class CustomerCreateException extends CustomerException {

    public CustomerCreateException(String message) {
        super(message);
    }

    public CustomerCreateException(String message, Throwable cause) {
        super(message, cause);
    }
}
