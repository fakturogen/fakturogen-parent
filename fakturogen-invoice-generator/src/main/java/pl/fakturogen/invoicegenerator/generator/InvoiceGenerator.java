package pl.fakturogen.invoicegenerator.generator;

import pl.fakturogen.invoice.web.dto.InvoiceDTO;
import pl.fakturogen.invoice.web.dto.InvoiceTemplateDTO;

import java.util.ArrayList;
import java.util.List;

public class InvoiceGenerator {

    public List<InvoiceDTO> generateInvoiceList (List<InvoiceTemplateDTO> invoiceTemplateDTO) {
        List<InvoiceDTO> invoiceDTOlist = new ArrayList<>();

        return invoiceDTOlist;

    }

    // Damian

    //Generuje faktury na podstawie otrzymanych Szablonów.
    // Tzn. wysyła do zewnętrznej aplikacji request z listą Szablonów i później
    // powinien otrzymać wygenerowane faktury z tej aplikacji.


    // 1. przerabia invoiceTemplate na invoice - korzysta z InvoiceTemplateGenerator
    // 2. wysyła do zewnętrznej aplikacji invoice, otrzymuje id (Long), nastawia status - korzysta z ComarchInvoiceService
    // 3. zapisuje u nas w bazie encję invoice z id zewnętrznym i statusem
}
