package pl.fakturogen.comarch.connector.exception;

public class InvoicesNotFoundException extends RuntimeException {

    public InvoicesNotFoundException(){
        super("Could not find invoices");
    }
}
