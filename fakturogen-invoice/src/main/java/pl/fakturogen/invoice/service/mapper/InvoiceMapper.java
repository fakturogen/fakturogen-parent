package pl.fakturogen.invoice.service.mapper;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import pl.fakturogen.invoice.dao.entity.Invoice;
import pl.fakturogen.invoice.web.dto.InvoiceSaveDTO;

@Component
@Slf4j
public class InvoiceMapper {
    public Invoice from (InvoiceSaveDTO invoiceSaveDTO){
        log.info("from {}", invoiceSaveDTO);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Invoice invoice = modelMapper.map(invoiceSaveDTO, Invoice.class);
        log.info("to {}", invoice);
        return invoice;
    }
}
