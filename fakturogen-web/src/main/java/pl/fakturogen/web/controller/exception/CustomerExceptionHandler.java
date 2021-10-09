package pl.fakturogen.web.controller.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.fakturogen.invoice.exception.CustomerCreateException;
import pl.fakturogen.invoice.exception.CustomerReadException;
import pl.fakturogen.web.exception.CustomerNotFoundException;
import pl.fakturogen.web.exception.WebErrorResponse;

/**
 * @author ewa-git
 */
@RestControllerAdvice
public class CustomerExceptionHandler {

    private WebErrorResponse getError (String httpStatus, String message) {
        return WebErrorResponse.builder()
                .errorStatus(httpStatus)
                .errorMessage(message)
                .build();
    }

    @ExceptionHandler(CustomerReadException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public WebErrorResponse customerReadException(CustomerReadException e){
        return getError(HttpStatus.BAD_REQUEST.toString(), e.getMessage());
    }

    @ExceptionHandler(CustomerCreateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public WebErrorResponse customerCreateException(CustomerCreateException e){
        return getError(HttpStatus.BAD_REQUEST.toString(), e.getMessage());
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public WebErrorResponse customerNotFoundException(CustomerNotFoundException e){
        return getError(HttpStatus.NOT_FOUND.toString(), e.getMessage());
    }
}
