package pl.fakturogen.comarch.connector.exeption;

public class ComarchHttpConnectorException extends ComarchConnectorException {
    public ComarchHttpConnectorException(String message) {
        super(message);
    }

    public ComarchHttpConnectorException(String message, Throwable cause) {
        super(message, cause);
    }
}
