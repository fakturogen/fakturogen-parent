package pl.fakturogen.invoice.generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pl.fakturogen.comarch.connector.exception.ComarchConnectorException;
import pl.fakturogen.invoice.web.dto.InvoiceDTO;
import pl.fakturogen.invoice.web.dto.InvoiceTemplateDTO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

/**
 * @author damian
 */

class InvoiceProviderServiceTest {

    @Mock
    private InvoiceAnalyzer invoiceAnalyzer;

    @Mock
    private InvoiceGenerator invoiceGenerator;

    @Mock
    private InvoiceStatusAnalyzer invoiceStatusAnalyzer;

    @InjectMocks
    private InvoiceProviderService invoiceProviderService;

    private List<InvoiceDTO> invoiceDTOList;
    private List<InvoiceTemplateDTO> invoiceTemplateDTOList;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        InvoiceDTO invoiceDTO1 = InvoiceDTO.builder()
                .id(1L)
                .build();
        InvoiceDTO invoiceDTO2 = InvoiceDTO.builder()
                .id(2L)
                .build();

        invoiceDTOList = List.of(invoiceDTO1, invoiceDTO2);

        InvoiceTemplateDTO invoiceTemplateDTO1 = InvoiceTemplateDTO.builder()
                .id(1L)
                .build();

        InvoiceTemplateDTO invoiceTemplateDTO2 =InvoiceTemplateDTO.builder()
                .id(2L)
                .build();

        invoiceTemplateDTOList = List.of(invoiceTemplateDTO1, invoiceTemplateDTO2);
    }

    @Test
    void generateTemplateListShouldOnceInvokeUpdateStatus() {
        List<InvoiceDTO> emptyInvoiceDTO_list = new ArrayList<>();
        invoiceProviderService.generateTemplateList(emptyInvoiceDTO_list);
        verify(invoiceStatusAnalyzer, Mockito.times(1)).updateStatus();
    }

    @Test
    void givenInvoiceDTOListShouldReturnInvoiceTemplateDTOList() {
        Mockito.when(invoiceAnalyzer.generateInvoiceTemplateList(invoiceDTOList)).thenReturn(invoiceTemplateDTOList);
        List<InvoiceTemplateDTO> returnedList = invoiceProviderService.generateTemplateList(invoiceDTOList);
        assertEquals(invoiceTemplateDTOList, returnedList);
    }

    @Test
    void givenInvoiceTemplateListShouldReturnInvoiceList() throws ComarchConnectorException {
        Mockito.when(invoiceGenerator.createInvoiceList(invoiceTemplateDTOList)).thenReturn(invoiceDTOList);
        List<InvoiceDTO> returnedList = invoiceProviderService.createExternalInvoice(invoiceTemplateDTOList);
        assertEquals(invoiceDTOList, returnedList);
    }
}