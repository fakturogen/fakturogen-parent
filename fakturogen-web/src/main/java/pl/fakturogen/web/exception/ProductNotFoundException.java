package pl.fakturogen.web.exception;

/**
 * @author damian
 */

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message){
        super(message);
    }
}
