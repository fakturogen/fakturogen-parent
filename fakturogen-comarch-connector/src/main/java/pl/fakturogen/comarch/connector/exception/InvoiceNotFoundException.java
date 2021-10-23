package pl.fakturogen.comarch.connector.exception;

public class InvoiceNotFoundException extends RuntimeException {
    public InvoiceNotFoundException(long id) {
        super("Invoice with id:" + id + " not found!");
    }
}
