package pl.fakturogen.comarch.connector;

public interface ExternalApiDataProvider {

    //lista standardowych metod zawierająca requesty i response do api zewnętrznego np.:
    // te metody będą wywoływane przez serwisy z modułu invoice
    // tutaj robimy tylko interfejs, a implementacja zależy od typu zewnętrznego api i jest osobną klasą, jak np.
    // ComarchApiProvider - to implementacja dla tej klasy

    //przykładowe metody:
    //(trzeba zrobić ich więcej tzn. takie jakie będą nam potrzebne w serwisach w CRUDZie)

    //public CustomerDTO getCustomerById(long id);
    //public InvoiceDTO getInvoiceById(long id);
    //public ProductDTO getProductById(long id);

}
