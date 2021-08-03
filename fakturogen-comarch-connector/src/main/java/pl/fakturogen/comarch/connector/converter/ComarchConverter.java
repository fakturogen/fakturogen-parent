package pl.fakturogen.comarch.connector.converter;

public interface ComarchConverter<O> {
    O convert(String bodyString) throws Exception;
}
