package pl.fakturogen.invoice.service.exception;

/**
 * @author damian
 */

public class InvoiceTemplateCreateException extends InvoiceTemplateException{
    public InvoiceTemplateCreateException(String message) {
        super(message);
    }

    public InvoiceTemplateCreateException(String message, Throwable cause) {
        super(message, cause);
    }
}
