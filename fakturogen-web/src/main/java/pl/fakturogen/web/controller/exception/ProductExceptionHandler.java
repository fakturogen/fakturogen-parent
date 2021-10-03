package pl.fakturogen.web.controller.exception;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ProductExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public WebErrorResponse notFoundProductException(ProductNotFoundException ex) {
        return WebErrorResponse.builder()
                .errorCode(HttpStatus.NOT_FOUND.toString())
                .errorMessage(ex.getMessage())
                .build();
    }

    @ExceptionHandler(ReadProductException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String readProductException(ReadProductException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(CreateProductException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String createProductException(CreateProductException ex) {
        return ex.getMessage();
    }




}
