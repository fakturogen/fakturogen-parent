package pl.fakturogen.user.exception;
/**
 * @author ewa-git
 */
public class UserExternalApiException extends Exception {

    public UserExternalApiException(String message){
        super(message);
    }

    public UserExternalApiException(String message, Throwable cause){
        super(message, cause);
    }
}
