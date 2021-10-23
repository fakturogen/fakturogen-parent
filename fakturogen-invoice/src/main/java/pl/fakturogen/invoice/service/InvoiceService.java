package pl.fakturogen.invoice.service;

import pl.fakturogen.invoice.service.exception.InvoiceTemplateException;
import pl.fakturogen.invoice.web.dto.InvoiceDTO;
import pl.fakturogen.invoice.web.dto.InvoiceTemplateDTO;

import java.util.List;
import java.util.Optional;

/**
 * @author krzysiek
 */

public interface InvoiceService {
    InvoiceDTO create(InvoiceDTO invoiceDTO);
    Optional<InvoiceDTO> read(Long id);
    List<InvoiceDTO> readAll();
    void update(InvoiceDTO invoiceDTO, Long id);
    void delete(InvoiceDTO invoiceDTO, Long id);

}
