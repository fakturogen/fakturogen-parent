package pl.fakturogen.invoice.service.exception;

public class InvoiceUpdateException extends InvoiceException {
    public InvoiceUpdateException(String message) {
        super(message);
    }

    public InvoiceUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
