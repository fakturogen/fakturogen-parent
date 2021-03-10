package pl.fakturogen.comarch.connector.mapper;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.dto.ComarchInvoiceDTO;
import pl.fakturogen.comarch.connector.model.ComarchInvoice;

@Component
public class ComarchInvoiceMapper {

    private static Logger logger = LoggerFactory.getLogger(ComarchInvoiceMapper.class);

    public ComarchInvoiceDTO from(ComarchInvoice comarchInvoice) {
        logger.info("from {{}}", comarchInvoice);
        ModelMapper modelMapper = new ModelMapper();
        ComarchInvoiceDTO comarchInvoiceDTO = modelMapper.map(comarchInvoice, ComarchInvoiceDTO.class);
        logger.info("to {{}}", comarchInvoiceDTO);
        return comarchInvoiceDTO;
    }

    public ComarchInvoice from( ComarchInvoiceDTO comarchInvoiceDTO){
        return null;
    }

}
