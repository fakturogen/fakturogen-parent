package pl.fakturogen.invoicegenerator.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.fakturogen.comarch.connector.exception.ComarchConnectorException;
import pl.fakturogen.comarch.connector.services.ComarchInvoiceService;
import pl.fakturogen.invoice.service.InvoiceService;
import pl.fakturogen.invoice.web.dto.InvoiceDTO;
import pl.fakturogen.invoice.web.dto.InvoiceTemplateDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author damian
 */

@Service
public class InvoiceGenerator {

    private ComarchInvoiceService comarchInvoiceService;
    private InvoiceService invoiceService;
    private InvoiceTemplateConventer invoiceTemplateConventer;

    @Autowired
    public InvoiceGenerator(ComarchInvoiceService comarchInvoiceService, InvoiceService invoiceService,
                            InvoiceTemplateConventer invoiceTemplateConventer) {
        this.comarchInvoiceService = comarchInvoiceService;
        this.invoiceService = invoiceService;
        this.invoiceTemplateConventer = invoiceTemplateConventer;
    }

    public List<InvoiceDTO> generateInvoiceList (List<InvoiceTemplateDTO> invoiceTemplateDTOList) throws ComarchConnectorException {

        List<InvoiceDTO> invoiceDTOlist = new ArrayList<>();

        for (InvoiceTemplateDTO invoiceTemplateDTO : invoiceTemplateDTOList) {
            InvoiceDTO invoiceDTO = invoiceTemplateConventer.from(invoiceTemplateDTO);

            Long invoiceId = comarchInvoiceService.create(invoiceDTO);
            invoiceDTO.setId(invoiceId);
            invoiceService.create(invoiceDTO);
            invoiceDTOlist.add(invoiceDTO);
        }

        return invoiceDTOlist;
    }
}
