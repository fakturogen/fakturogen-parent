package pl.fakturogen.comarch.connector.exeption.converter;

import pl.fakturogen.comarch.connector.exeption.ComarchConnectorException;

public class ComarchConverterException extends ComarchConnectorException {
    public ComarchConverterException(String message) {
        super(message);
    }

    public ComarchConverterException(String message, Throwable cause) {
        super(message, cause);
    }
}
