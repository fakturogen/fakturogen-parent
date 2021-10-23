package pl.fakturogen.invoicegenerator.generator;

import org.springframework.beans.factory.annotation.Autowired;
import pl.fakturogen.comarch.connector.exeption.ComarchConnectorException;
import pl.fakturogen.comarch.connector.services.ComarchInvoiceService;
import pl.fakturogen.invoice.service.InvoiceService;
import pl.fakturogen.invoice.web.dto.InvoiceDTO;
import pl.fakturogen.invoice.web.dto.InvoiceTemplateDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author damian
 */

public class InvoiceGenerator {

    private ComarchInvoiceService comarchInvoiceService;
    private InvoiceService invoiceService;

    @Autowired
    public InvoiceGenerator(ComarchInvoiceService comarchInvoiceService, InvoiceService invoiceService) {
        this.comarchInvoiceService = comarchInvoiceService;
        this.invoiceService = invoiceService;
    }

    public List<InvoiceDTO> generateInvoiceList (List<InvoiceTemplateDTO> invoiceTemplateDTOList) throws ComarchConnectorException {
        InvoiceTemplateConventer invoiceTemplateConventer = new InvoiceTemplateConventer();

        List<InvoiceDTO> invoiceDTOlist = new ArrayList<>();

        for (InvoiceTemplateDTO invoiceTemplateDTO : invoiceTemplateDTOList) {
            InvoiceDTO invoiceDTO = invoiceTemplateConventer.from(invoiceTemplateDTO);

            Long invoiceId = comarchInvoiceService.create(invoiceDTO);
            invoiceDTO.setId(invoiceId);
            invoiceService.create(invoiceDTO);
            invoiceDTOlist.add(invoiceDTO);
        }

        return invoiceDTOlist;

    }

    // Damian

    //Generuje faktury na podstawie otrzymanych Szablonów.
    // Tzn. wysyła do zewnętrznej aplikacji request z listą Szablonów i później
    // powinien otrzymać wygenerowane faktury z tej aplikacji.


    // 1. przerabia invoiceTemplate na invoice - korzysta z InvoiceTemplateConverter
    // 2. wysyła do zewnętrznej aplikacji invoice, otrzymuje id (Long)
    // 3. zapisuje u nas w bazie encję invoice z id zewnętrznym i statusem
}
