package pl.fakturogen.invoice.service.mapper;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import pl.fakturogen.invoice.dao.entity.InvoiceTemplate;
import pl.fakturogen.invoice.web.dto.InvoiceTemplateDTO;

@Component
@Slf4j
public class InvoiceTemplateMapper {
    private ModelMapper modelMapper;

    public InvoiceTemplateMapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public InvoiceTemplateDTO from(InvoiceTemplate invoiceTemplate) {
        log.info("from({})", invoiceTemplate);
        InvoiceTemplateDTO invoiceTemplateDTO = modelMapper.map(invoiceTemplate, InvoiceTemplateDTO.class);
        log.info("from({}) = {}", invoiceTemplate, invoiceTemplateDTO);
        return invoiceTemplateDTO;
    }

    public InvoiceTemplate from(InvoiceTemplateDTO invoiceTemplateDTO) {
        log.info("from({})", invoiceTemplateDTO);
        InvoiceTemplate invoiceTemplate = modelMapper.map(invoiceTemplateDTO, InvoiceTemplate.class);
        log.info("from({}) = {}", invoiceTemplateDTO, invoiceTemplate);
        return invoiceTemplate;
    }
}
