package pl.fakturogen.invoice.service.exception;

public class InvoiceReadException extends InvoiceException {
    public InvoiceReadException(String message) {
        super(message);
    }

    public InvoiceReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
