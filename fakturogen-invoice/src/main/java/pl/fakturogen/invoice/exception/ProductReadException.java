package pl.fakturogen.invoice.exception;

/**
 * @author damian
 */

public class ProductReadException extends ProductException{
    public ProductReadException(String message) {
        super(message);
    }

    public ProductReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
