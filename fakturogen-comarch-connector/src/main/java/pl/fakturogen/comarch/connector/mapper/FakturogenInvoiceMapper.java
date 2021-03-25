package pl.fakturogen.comarch.connector.mapper;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.dto.ComarchInvoiceDTO;
import pl.fakturogen.invoice.web.dto.InvoiceSaveDTO;

@Component
@Slf4j
public class FakturogenInvoiceMapper {

    public InvoiceSaveDTO from (ComarchInvoiceDTO comarchInvoiceDTO) {
        log.info("From: {{}}", comarchInvoiceDTO);
//        InvoiceSaveDTO invoiceSaveDTO = new InvoiceSaveDTO();
//        invoiceSaveDTO.setNumber(comarchInvoiceDTO.getNumber());
//        invoiceSaveDTO.setIssueDate(comarchInvoiceDTO.getIssueDate());
//        invoiceSaveDTO.setSaleDate(comarchInvoiceDTO.getSalesDate());
//        invoiceSaveDTO.setPaymentMethod(comarchInvoiceDTO.getPaymentTypeId());
//        invoiceSaveDTO.setStatus(comarchInvoiceDTO.getStatus());
//        invoiceSaveDTO.setBankAccountId(comarchInvoiceDTO.getBankAccountId());
//        invoiceSaveDTO.setInvoiceType(comarchInvoiceDTO.getInvoiceType());
//        invoiceSaveDTO.setOriginalId(comarchInvoiceDTO.getId());
        ModelMapper modelMapper = new ModelMapper();
        InvoiceSaveDTO invoiceSaveDTO = modelMapper.map(comarchInvoiceDTO, InvoiceSaveDTO.class);
        log.info("To: {{}}", invoiceSaveDTO);

        return invoiceSaveDTO;

    }

}
