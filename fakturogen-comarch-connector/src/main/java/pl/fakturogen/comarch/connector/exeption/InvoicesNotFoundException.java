package pl.fakturogen.comarch.connector.exeption;

public class InvoicesNotFoundException extends RuntimeException {

    public InvoicesNotFoundException(){
        super("Could not find invoices");
    }
}
