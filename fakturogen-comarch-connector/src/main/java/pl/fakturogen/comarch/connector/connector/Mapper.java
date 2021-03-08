package pl.fakturogen.comarch.connector.connector;

public interface Mapper <I,O>{
    O from(I input);
    I to(O output);

}
