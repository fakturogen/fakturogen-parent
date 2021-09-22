package pl.fakturogen.invoice.service;

import org.springframework.stereotype.Service;
import pl.fakturogen.invoice.service.exception.InvoiceTemplateException;
import pl.fakturogen.invoice.web.dto.InvoiceTemplateDTO;

import java.util.List;
import java.util.Optional;

/**
 * @author damian
 */

@Service
public interface InvoiceTemplateService {

    InvoiceTemplateDTO create(InvoiceTemplateDTO invoiceTemplateDTO) throws InvoiceTemplateException;
    Optional<InvoiceTemplateDTO> read(Long id) throws InvoiceTemplateException;
    List<InvoiceTemplateDTO> readAll() throws InvoiceTemplateException;
    void update(InvoiceTemplateDTO invoiceTemplateDTO, Long id) throws InvoiceTemplateException;
    void delete(InvoiceTemplateDTO invoiceTemplateDTO, Long id) throws InvoiceTemplateException;

}
