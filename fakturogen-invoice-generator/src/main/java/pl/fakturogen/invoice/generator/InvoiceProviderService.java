package pl.fakturogen.invoice.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.fakturogen.comarch.connector.exception.ComarchConnectorException;
import pl.fakturogen.invoice.web.dto.InvoiceDTO;
import pl.fakturogen.invoice.web.dto.InvoiceTemplateDTO;

import java.util.List;

/**
 * @author damian
 *
 * Services from other modules communicate with this service to use methods to analyze historical invoices and generate
 * InvoiceTemplates which are invoices propositions for next month. It also allows creating new invoices in external
 * system and update invoices' status in internal system.
 */

@Service
public class InvoiceProviderService {

    private InvoiceAnalyzer invoiceAnalyzer;
    private InvoiceGenerator invoiceGenerator;
    private InvoiceStatusAnalyzer invoiceStatusAnalyzer;

    @Autowired
    public InvoiceProviderService(InvoiceAnalyzer invoiceAnalyzer, InvoiceGenerator invoiceGenerator,
                                  InvoiceStatusAnalyzer invoiceStatusAnalyzer) {
        this.invoiceAnalyzer = invoiceAnalyzer;
        this.invoiceGenerator = invoiceGenerator;
        this.invoiceStatusAnalyzer = invoiceStatusAnalyzer;
    }

    public List<InvoiceTemplateDTO> generateTemplateList(List<InvoiceDTO> invoiceList) {
        invoiceStatusAnalyzer.updateStatus();
        return invoiceAnalyzer.generateInvoiceTemplateList(invoiceList);
    }

    public List<InvoiceDTO> createExternalInvoice(List<InvoiceTemplateDTO> invoiceTemplateDTOList) throws ComarchConnectorException {
        return invoiceGenerator.createInvoiceList(invoiceTemplateDTOList);
    }

}
