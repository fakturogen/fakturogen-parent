package pl.fakturogen.comarch.connector.exception.converter;

import pl.fakturogen.comarch.connector.exception.ComarchConnectorException;

public class ComarchConverterException extends ComarchConnectorException {
    public ComarchConverterException(String message) {
        super(message);
    }

    public ComarchConverterException(String message, Throwable cause) {
        super(message, cause);
    }
}
