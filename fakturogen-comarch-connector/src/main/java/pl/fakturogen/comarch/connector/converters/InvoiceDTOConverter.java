package pl.fakturogen.comarch.connector.converters;

import pl.fakturogen.comarch.connector.dto.InvoiceComarchDTO;
import pl.fakturogen.comarch.connector.dto.ProductComarchDTO;
import pl.fakturogen.invoice.web.dto.InvoiceDTO;

public class InvoiceDTOConverter {

    public InvoiceDTO getInvoiceFrom(InvoiceComarchDTO invoiceComarch, ProductComarchDTO productComarch) {
        return new InvoiceDTO();
    }
}
