package pl.fakturogen.invoice.exception;

/**
 * @author damian
 */

public class ProductCreateException extends ProductException{
    public ProductCreateException(String message) {
        super(message);
    }

    public ProductCreateException(String message, Throwable cause) {
        super(message, cause);
    }
}
