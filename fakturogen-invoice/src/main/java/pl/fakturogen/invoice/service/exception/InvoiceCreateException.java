package pl.fakturogen.invoice.service.exception;

public class InvoiceCreateException extends InvoiceException {
    public InvoiceCreateException(String message) {
        super(message);
    }
    public InvoiceCreateException(String message, Throwable cause){
        super(message, cause);
    }
}
