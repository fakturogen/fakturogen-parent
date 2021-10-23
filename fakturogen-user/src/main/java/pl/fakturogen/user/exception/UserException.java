package pl.fakturogen.user.exception;
/**
 * @author ewa-git
 */

public class UserException extends Exception {
    public UserException(String message){
        super(message);
    }

    public UserException(String message, Throwable cause){
        super(message, cause);
    }
}
