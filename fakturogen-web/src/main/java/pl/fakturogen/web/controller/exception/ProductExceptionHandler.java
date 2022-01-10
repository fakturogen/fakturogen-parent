package pl.fakturogen.web.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.fakturogen.invoice.exception.ProductCreateException;
import pl.fakturogen.invoice.exception.ProductReadException;
import pl.fakturogen.web.exception.ProductNotFoundException;
import pl.fakturogen.web.exception.WebErrorResponse;

/**
 * @author damian
 */

@RestControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public WebErrorResponse notFoundProductException(ProductNotFoundException ex) {
        return getDedicatedResponse(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
    }

    @ExceptionHandler(ProductReadException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public WebErrorResponse readProductException(ProductReadException ex) {
        return getDedicatedResponse(HttpStatus.BAD_REQUEST.toString(), ex.getMessage());
    }

    @ExceptionHandler(ProductCreateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public WebErrorResponse createProductException(ProductCreateException ex) {
        return getDedicatedResponse(HttpStatus.BAD_REQUEST.toString(), ex.getMessage());
    }

    private WebErrorResponse getDedicatedResponse (String httpStatus, String message) {
        return WebErrorResponse.builder()
                .errorStatus(httpStatus)
                .errorMessage(message)
                .build();
    }

}
