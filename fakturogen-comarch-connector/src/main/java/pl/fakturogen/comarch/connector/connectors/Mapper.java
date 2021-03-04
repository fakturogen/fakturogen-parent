package pl.fakturogen.comarch.connector.connectors;

public interface Mapper <I,O>{
    O from(I input);
    I to(O output);

}
