package pl.fakturogen.invoice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.fakturogen.invoice.dao.entity.Invoice;
import pl.fakturogen.invoice.dao.repository.InvoiceRepository;
import pl.fakturogen.invoice.service.InvoiceService;
import pl.fakturogen.invoice.service.exception.InvoiceCreateException;
import pl.fakturogen.invoice.service.exception.InvoiceException;
import pl.fakturogen.invoice.service.exception.InvoiceReadException;
import pl.fakturogen.invoice.service.exception.InvoiceUpdateException;
import pl.fakturogen.invoice.service.mapper.InvoiceMapper;
import pl.fakturogen.invoice.web.dto.InvoiceDTO;
import pl.fakturogen.invoice.web.dto.InvoiceSaveDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class InvoiceServiceDefault implements InvoiceService {

    private InvoiceMapper invoiceMapper;
    private InvoiceRepository invoiceRepository;

    public InvoiceServiceDefault(InvoiceMapper invoiceMapper, InvoiceRepository invoiceRepository) {
        this.invoiceMapper = invoiceMapper;
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public InvoiceDTO create(InvoiceSaveDTO invoiceSaveDTO) throws InvoiceException {
        try {
            Invoice invoiceToSave = invoiceMapper.from(invoiceSaveDTO);
            Invoice savedInvoice = invoiceRepository.save(invoiceToSave);
            InvoiceDTO invoiceDTO = invoiceMapper.from(savedInvoice);
            return invoiceDTO;
        } catch (IllegalArgumentException iae) {
            log.warn(iae.getMessage(), iae);
            throw new InvoiceCreateException("Error during saving invoice with original id: " + invoiceSaveDTO.getOriginalId());
        }
    }

    @Override
    public InvoiceDTO read(Long id) throws InvoiceException {
        try {
            Invoice invoice = invoiceRepository.findById(id)
                    .orElseThrow(() -> new InvoiceReadException("Not found"));
            InvoiceDTO invoiceDTO = invoiceMapper.from(invoice);
            return invoiceDTO;
        } catch (IllegalArgumentException ex) {
            log.warn(ex.getMessage(), ex);
            throw new InvoiceReadException("Error during read invoice with given id: " + id);
        }

    }

    @Override
    public List<InvoiceDTO> readAll() throws InvoiceException {
        try {
            List<Invoice> invoices = invoiceRepository.findAll();
            return invoices.stream()
                    .map(invoice -> invoiceMapper.from(invoice))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            log.warn(ex.getMessage(), ex);
            throw new InvoiceReadException("Error during reading invoice list");
        }
    }

    @Override
    public InvoiceDTO update(InvoiceDTO invoiceDTO) throws InvoiceException {
        Long id = invoiceDTO.getId();
        try {
            Invoice invoice = invoiceRepository.findById(id)
                    .orElseThrow(() -> new InvoiceReadException("Invoice not found"));
            Invoice saved = invoiceRepository.save(invoice);
            return invoiceMapper.from(saved);
        } catch (IllegalArgumentException ex) {
            log.warn(ex.getMessage(), ex);
            throw new InvoiceUpdateException("Error during invoice update - id: : " + id);
        }
    }

    @Override
    public void delete(InvoiceDTO invoiceDTO) throws InvoiceException {
        Long id = invoiceDTO.getId();
        try {
            Invoice invoice = invoiceRepository.findById(id)
                    .orElseThrow(() -> new InvoiceUpdateException("Invoice with given id not found. Id:" + id));
            invoiceRepository.delete(invoice);

        } catch (IllegalArgumentException ex) {
            log.warn(ex.getMessage(), ex);
            throw new InvoiceUpdateException("Error during invoice delete");
        }
    }

}
