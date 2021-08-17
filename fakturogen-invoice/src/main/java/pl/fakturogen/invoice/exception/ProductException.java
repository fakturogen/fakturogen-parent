package pl.fakturogen.invoice.exception;

public class ProductException extends Exception {
    public ProductException(String message) {
        super(message);
    }
    public ProductException(String message, Throwable cause) {
        super(message, cause);
    }
}
