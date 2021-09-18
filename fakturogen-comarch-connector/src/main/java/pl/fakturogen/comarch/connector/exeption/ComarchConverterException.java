package pl.fakturogen.comarch.connector.exeption;

public class ComarchConverterException extends ComarchConnectorException {

    public ComarchConverterException(String message) {
        super(message);
    }

    public ComarchConverterException(String message, Throwable cause) {
        super(message, cause);
    }
}
