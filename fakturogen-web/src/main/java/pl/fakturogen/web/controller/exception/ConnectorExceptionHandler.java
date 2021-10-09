package pl.fakturogen.web.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.fakturogen.comarch.connector.exeption.ComarchConnectorException;
import pl.fakturogen.web.exception.WebErrorResponse;

/**
 * @author damian
 */

@RestControllerAdvice
public class ConnectorExceptionHandler {

    @ExceptionHandler(ComarchConnectorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public WebErrorResponse connectionException(ComarchConnectorException ex) {
        return WebErrorResponse.builder()
                .errorStatus(HttpStatus.BAD_REQUEST.toString())
                .errorMessage(ex.getMessage())
                .build();
    }
}
