package pl.fakturogen.invoicegenerator.generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pl.fakturogen.comarch.connector.exception.ComarchConnectorException;
import pl.fakturogen.comarch.connector.services.ComarchInvoiceService;
import pl.fakturogen.invoice.service.InvoiceService;
import pl.fakturogen.invoice.web.dto.InvoiceDTO;
import pl.fakturogen.invoice.web.dto.InvoiceTemplateDTO;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author damian
 */

class InvoiceGeneratorTest {

    @Mock
    private ComarchInvoiceService comarchInvoiceService;
    @Mock
    private InvoiceService invoiceService;
    @Mock
    private InvoiceTemplateConventer invoiceTemplateConventer;

    @InjectMocks
    private InvoiceGenerator invoiceGenerator;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenTwoInvoiceTemplateDTOListShouldReturnTwoInvoiceDTOList() throws ComarchConnectorException {
        InvoiceTemplateDTO invoiceTemplateDTO_1 = new InvoiceTemplateDTO();
        invoiceTemplateDTO_1.setId(1L);

        InvoiceTemplateDTO invoiceTemplateDTO_2 = new InvoiceTemplateDTO();
        invoiceTemplateDTO_2.setId(2L);

        List<InvoiceTemplateDTO> invoiceTemplateDTOList = List.of(invoiceTemplateDTO_1, invoiceTemplateDTO_2);

        InvoiceDTO invoiceDTO_1 = new InvoiceDTO();
        invoiceDTO_1.setId(1L);

        InvoiceDTO invoiceDTO_2 = new InvoiceDTO();
        invoiceDTO_2.setId(2L);

        List<InvoiceDTO> expectedDTOList = List.of(invoiceDTO_1, invoiceDTO_2);

        Mockito.when(comarchInvoiceService.create(invoiceDTO_1)).thenReturn(1L);
        Mockito.when(comarchInvoiceService.create(invoiceDTO_2)).thenReturn(2L);
        Mockito.when(invoiceService.create(invoiceDTO_1)).thenReturn(invoiceDTO_1);
        Mockito.when(invoiceService.create(invoiceDTO_2)).thenReturn(invoiceDTO_2);
        Mockito.when(invoiceTemplateConventer.from(invoiceTemplateDTO_1)).thenReturn(invoiceDTO_1);
        Mockito.when(invoiceTemplateConventer.from(invoiceTemplateDTO_2)).thenReturn(invoiceDTO_2);

        List<InvoiceDTO> invoiceDTOS = invoiceGenerator.generateInvoiceList(invoiceTemplateDTOList);

        assertThat(invoiceDTOS).isEqualTo(expectedDTOList);
    }

    @Test
    void givenEmptyInvoiceTemplateDTOListShouldReturnEmptyInvoiceDTOList() throws ComarchConnectorException {
        List<InvoiceTemplateDTO> emptyTemplateList = List.of();
        List<InvoiceDTO> returnedList = invoiceGenerator.generateInvoiceList(emptyTemplateList);
        assertThat(returnedList).isEmpty();
    }

}