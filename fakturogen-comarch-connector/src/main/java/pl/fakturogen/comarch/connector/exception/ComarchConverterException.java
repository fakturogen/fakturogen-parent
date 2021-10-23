package pl.fakturogen.comarch.connector.exception;

public class ComarchConverterException extends ComarchConnectorException {

    public ComarchConverterException(String message) {
        super(message);
    }

    public ComarchConverterException(String message, Throwable cause) {
        super(message, cause);
    }
}
