package pl.fakturogen.invoice.service.impl;

import org.springframework.stereotype.Service;
import pl.fakturogen.invoice.dao.entity.Invoice;
import pl.fakturogen.invoice.dao.repository.InvoiceRepository;
import pl.fakturogen.invoice.service.InvoiceService;
import pl.fakturogen.invoice.service.mapper.InvoiceMapper;
import pl.fakturogen.invoice.web.dto.InvoiceDTO;
import pl.fakturogen.invoice.web.dto.InvoiceSaveDTO;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceDefault implements InvoiceService {

    private InvoiceMapper invoiceMapper;
    private InvoiceRepository invoiceRepository;

    public InvoiceServiceDefault(InvoiceMapper invoiceMapper, InvoiceRepository invoiceRepository) {
        this.invoiceMapper = invoiceMapper;
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public InvoiceDTO create(InvoiceSaveDTO invoiceSaveDTO) {
        Invoice invoiceToSave = invoiceMapper.from(invoiceSaveDTO);
        Invoice savedInvoice = invoiceRepository.save(invoiceToSave);
        InvoiceDTO invoiceDTO = invoiceMapper.from(savedInvoice);
        return invoiceDTO;
    }

    @Override
    public Optional<InvoiceDTO> read(InvoiceDTO invoiceDTO) {
        return Optional.empty();
    }

    @Override
    public List<InvoiceDTO> readAll() {
        return null;
    }

    @Override
    public InvoiceDTO update(InvoiceDTO invoiceDTO) {
        return null;
    }

    @Override
    public void delete(InvoiceDTO invoiceDTO) {

    }
}
