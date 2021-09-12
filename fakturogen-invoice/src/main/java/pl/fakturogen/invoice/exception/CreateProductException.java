package pl.fakturogen.invoice.exception;

/**
 * @author damian
 */

public class CreateProductException extends ProductException{
    public CreateProductException(String message) {
        super(message);
    }

    public CreateProductException(String message, Throwable cause) {
        super(message, cause);
    }
}
