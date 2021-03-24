package pl.fakturogen.invoice.service;

import pl.fakturogen.invoice.web.dto.InvoiceDTO;
import pl.fakturogen.invoice.web.dto.InvoiceSaveDTO;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {

    InvoiceDTO create(InvoiceSaveDTO invoiceSaveDTO);
    Optional<InvoiceDTO> read(InvoiceDTO invoiceDTO);
    List<InvoiceDTO> readAll();
    InvoiceDTO update(InvoiceDTO invoiceDTO);
    void delete(InvoiceDTO invoiceDTO);
}
