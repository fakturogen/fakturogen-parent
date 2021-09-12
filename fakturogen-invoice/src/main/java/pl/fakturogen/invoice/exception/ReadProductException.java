package pl.fakturogen.invoice.exception;

/**
 * @author damian
 */

public class ReadProductException extends ProductException{
    public ReadProductException(String message) {
        super(message);
    }

    public ReadProductException(String message, Throwable cause) {
        super(message, cause);
    }
}
