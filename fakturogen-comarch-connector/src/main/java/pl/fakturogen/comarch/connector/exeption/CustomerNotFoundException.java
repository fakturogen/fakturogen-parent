package pl.fakturogen.comarch.connector.exeption;

public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(String message){
        super(message);
    }
}
