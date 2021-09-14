package pl.fakturogen.invoice.service;

import pl.fakturogen.invoice.service.exception.InvoiceCreateException;
import pl.fakturogen.invoice.service.exception.InvoiceException;
import pl.fakturogen.invoice.web.dto.InvoiceDTO;
import pl.fakturogen.invoice.web.dto.InvoiceSaveDTO;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {

    InvoiceDTO create(InvoiceSaveDTO invoiceSaveDTO) throws InvoiceException;
    InvoiceDTO read(Long id) throws InvoiceException;
    List<InvoiceDTO> readAll() throws InvoiceException;
    InvoiceDTO update(InvoiceDTO invoiceDTO) throws InvoiceException;
    void delete(InvoiceDTO invoiceDTO) throws InvoiceException;
}
