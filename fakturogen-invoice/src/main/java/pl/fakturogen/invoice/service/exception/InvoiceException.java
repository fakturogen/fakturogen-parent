package pl.fakturogen.invoice.service.exception;

public class InvoiceException extends Exception {

    public InvoiceException(String message) {
        super(message);
    }

    public InvoiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
