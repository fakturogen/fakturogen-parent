package pl.fakturogen.comarch.connector.converter;

import pl.fakturogen.comarch.connector.exception.converter.ComarchConverterException;

public interface ComarchConverter<O> {
    O convert(String bodyString) throws ComarchConverterException;
}
