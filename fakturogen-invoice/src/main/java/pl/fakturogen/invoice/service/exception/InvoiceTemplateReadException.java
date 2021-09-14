package pl.fakturogen.invoice.service.exception;

/**
 * @author damian
 */

public class InvoiceTemplateReadException extends InvoiceTemplateException{
    public InvoiceTemplateReadException(String message) {
        super(message);
    }

    public InvoiceTemplateReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
