package pl.fakturogen.comarch.connector.exception;

public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(String message){
        super(message);
    }
}
