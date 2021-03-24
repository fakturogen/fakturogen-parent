package pl.fakturogen.invoice.service.mapper;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.dto.ComarchInvoiceDTO;
import pl.fakturogen.invoice.dao.entity.Invoice;
import pl.fakturogen.invoice.web.dto.InvoiceDTO;
import pl.fakturogen.invoice.web.dto.InvoiceSaveDTO;

@Component
@Slf4j
public class InvoiceMapper {

    public Invoice from (InvoiceSaveDTO invoiceSaveDTO){
        log.info("from {{}}", invoiceSaveDTO);
        ModelMapper modelMapper = new ModelMapper();
        Invoice invoice = modelMapper.map(invoiceSaveDTO, Invoice.class);
        log.info("to {{}}", invoice);
        return invoice;
    }

    public InvoiceDTO from (Invoice invoice) {
        log.info("From: {{}}", invoice);
        ModelMapper modelMapper = new ModelMapper();
        InvoiceDTO invoiceDTO = modelMapper.map(invoice, InvoiceDTO.class);
        log.info("To: {{}}", invoiceDTO);
        return invoiceDTO;
    }

    public InvoiceSaveDTO from(ComarchInvoiceDTO comarchInvoiceDTO){
        log.info("From: {{}}", comarchInvoiceDTO);
        ModelMapper modelMapper = new ModelMapper();
        InvoiceSaveDTO invoiceSaveDTO = modelMapper.map(comarchInvoiceDTO, InvoiceSaveDTO.class);
        log.info("To: {{}}", invoiceSaveDTO);
        return invoiceSaveDTO;
    }
}
