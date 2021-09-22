package pl.fakturogen.invoice.service.exception;

/**
 * @author damian
 */

public class InvoiceTemplateDeleteException extends InvoiceTemplateException {
    public InvoiceTemplateDeleteException(String message) {
        super(message);
    }

    public InvoiceTemplateDeleteException(String message, Throwable cause) {
        super(message, cause);
    }
}
