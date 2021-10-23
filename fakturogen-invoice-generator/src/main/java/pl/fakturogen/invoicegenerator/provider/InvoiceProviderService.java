package pl.fakturogen.invoicegenerator.provider;

public class InvoiceProviderService {
    // zewnętrzne serwisy Controller z komunikują się z tym serwisem, który udostępnia metody InoviceAnalyer

    // 1) metoda, która sprawdza aktualną listę faktur w bazie naszej, czy zgadza się z listą faktur w Comarchu
    // m.in. sprawdza czy faktury, które mamy jaki mają status w Comarchu (zatwierdzony, czy w buforze)
    // sprawdza po id dokumentu Comarchowym i statusie

    // 2) metoda, która generuje templatki na podstawie faktur Invoice (z naszej bazy) -- korzysta z metody w InvoiceAnalyzer
    // 3) metoda, która przyjmuje templatki InvoiceTemplate i wysyła do Comarchu w celu stworzenia Invoice
    // (korzysta z InvoiceGenerator)
    // można przy okazji zapisywać te Invoice u nas w bazie

}
