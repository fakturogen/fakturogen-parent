package pl.fakturogen.comarch.connector.converter;

import pl.fakturogen.comarch.connector.exeption.ComarchConverterException;

public interface ComarchConverter<O> {

    O convert(String bodyString) throws ComarchConverterException;
}
