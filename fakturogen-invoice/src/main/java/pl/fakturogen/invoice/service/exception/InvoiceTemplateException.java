package pl.fakturogen.invoice.service.exception;

/**
 * @author damian
 */

public class InvoiceTemplateException extends Exception {
    public InvoiceTemplateException(String message) {
        super(message);
    }

    public InvoiceTemplateException(String message, Throwable cause) {
        super(message, cause);
    }
}
