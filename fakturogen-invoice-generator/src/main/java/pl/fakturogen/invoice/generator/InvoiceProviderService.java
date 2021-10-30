package pl.fakturogen.invoice.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.fakturogen.comarch.connector.exception.ComarchConnectorException;
import pl.fakturogen.invoice.web.dto.InvoiceDTO;
import pl.fakturogen.invoice.web.dto.InvoiceTemplateDTO;

import java.util.List;

/**
 * @author damian
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

    //    public
    // zewnętrzne serwisy Controller z komunikują się z tym serwisem, który udostępnia metody InoviceAnalyzer

    public List<InvoiceTemplateDTO> generateTemplateList(List<InvoiceDTO> invoiceList) {
        invoiceStatusAnalyzer.updateStatus();
        return invoiceAnalyzer.generateInvoiceTemplateList(invoiceList);
    }

    public List<InvoiceDTO> createExternalInvoice(List<InvoiceTemplateDTO> invoiceTemplateDTOList) throws ComarchConnectorException {
        return  invoiceGenerator.createInvoiceList(invoiceTemplateDTOList);
    }

}
