package pl.fakturogen.invoice.service.exception;

/**
 * @author damian
 */

public class InvoiceTemplateUpdateException extends InvoiceTemplateException{
    public InvoiceTemplateUpdateException(String message) {
        super(message);
    }

    public InvoiceTemplateUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
