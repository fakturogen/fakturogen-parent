package pl.fakturogen.comarch.connector.exeption;

public class ComarchConnectorException extends Exception {
    public ComarchConnectorException(String message) {
        super(message);
    }

    public ComarchConnectorException(String message, Throwable cause) {
        super(message, cause);
    }
}
