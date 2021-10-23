package pl.fakturogen.comarch.connector.mapper;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.dto.ComarchInvoiceDTO;
import pl.fakturogen.comarch.connector.model.ComarchInvoice;
import pl.fakturogen.invoice.web.dto.InvoiceDTO;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<ComarchInvoiceDTO> from(List<ComarchInvoice> comarchInvoice) {
        logger.info("from {{}}", comarchInvoice);
        ModelMapper modelMapper = new ModelMapper();
        List<ComarchInvoiceDTO> comarchInvoiceDTOList = comarchInvoice.stream()
                .map(invoice -> modelMapper.map(invoice, ComarchInvoiceDTO.class))
                .collect(Collectors.toList());
        logger.info("to {{}}", comarchInvoiceDTOList);
        return comarchInvoiceDTOList;
    }

    public ComarchInvoice from(ComarchInvoiceDTO comarchInvoiceDTO){
        logger.info("comarchInvoiceDTO {}", comarchInvoiceDTO);
        ModelMapper modelMapper = new ModelMapper();
        ComarchInvoice comarchInvoice = modelMapper.map(comarchInvoiceDTO, ComarchInvoice.class);
        logger.info("to comarchInvoice: {}", comarchInvoice);
        return comarchInvoice;
    }

    public ComarchInvoiceDTO fromInvoiceDTO(InvoiceDTO invoiceDTO) {
        return null;
    }
}
