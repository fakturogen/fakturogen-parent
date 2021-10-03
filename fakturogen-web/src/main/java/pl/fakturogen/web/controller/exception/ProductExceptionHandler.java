package pl.fakturogen.web.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.fakturogen.invoice.exception.CreateProductException;
import pl.fakturogen.invoice.exception.ReadProductException;
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

    @ExceptionHandler(ReadProductException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public WebErrorResponse readProductException(ReadProductException ex) {
        return getDedicatedResponse(HttpStatus.BAD_REQUEST.toString(), ex.getMessage());
    }

    @ExceptionHandler(CreateProductException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public WebErrorResponse createProductException(CreateProductException ex) {
        return getDedicatedResponse(HttpStatus.BAD_REQUEST.toString(), ex.getMessage());
    }

    private WebErrorResponse getDedicatedResponse (String httpStatus, String message) {
        return WebErrorResponse.builder()
                .errorStatus(httpStatus)
                .errorMessage(message)
                .build();
    }

}
