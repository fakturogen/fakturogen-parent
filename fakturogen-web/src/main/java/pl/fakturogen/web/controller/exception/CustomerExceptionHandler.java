package pl.fakturogen.web.controller.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.fakturogen.invoice.exception.CustomerException;

/**
 * @author ewa-git
 */
@RestControllerAdvice
@Slf4j
public class CustomerExceptionHandler {

    @ExceptionHandler(CustomerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String customerException(CustomerException e){
        return e.getMessage();
    }
}
