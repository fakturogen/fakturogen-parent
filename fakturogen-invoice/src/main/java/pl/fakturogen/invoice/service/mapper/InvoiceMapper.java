package pl.fakturogen.invoice.service.mapper;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.fakturogen.invoice.dao.entity.Invoice;
import pl.fakturogen.invoice.web.dto.InvoiceDTO;

@Component
@Slf4j
public class InvoiceMapper {

    public InvoiceDTO from (Invoice invoice) {
        log.info("from {}", invoice);
        ModelMapper modelMapper = new ModelMapper();
        InvoiceDTO invoiceDTO = modelMapper.map(invoice,InvoiceDTO.class);
        log.info("to {}", invoiceDTO);
        return  invoiceDTO;
    }

    public Invoice to (InvoiceDTO invoiceDTO){
        log.info("from {}", invoiceDTO);
        ModelMapper modelMapper = new ModelMapper();
        Invoice invoice = modelMapper.map(invoiceDTO, Invoice.class);
        log.info("to {}", invoice);
        return invoice;
    }
}
