package pl.fakturogen.comarch.connector.services.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import pl.fakturogen.comarch.connector.connector.ComarchApiInvoiceConnector;
import pl.fakturogen.comarch.connector.dto.ComarchInvoiceDTO;
import pl.fakturogen.comarch.connector.mapper.ComarchInvoiceMapper;
import pl.fakturogen.comarch.connector.model.ComarchInvoice;
import pl.fakturogen.comarch.connector.services.ComarchInvoiceService;

import java.io.IOException;

import static org.mockito.Mockito.doReturn;


class ComarchInvoiceServiceDefaultTest {

        private static final Integer PAYMENT_STATUS = 1;
    private static final Integer PURCHASING_PARTY_ID = 34;
    private static final Integer RECEIVING_PARTY_ID = 0;
    private static final Integer PAYMENT_TYPE_ID = 1;
    private static final Integer BANK_ACCOUNT_ID = 3939393;
    private static final String SALES_DATE = "11/12/2021";
    private static final Integer INVOICE_TYPE = 2;
    private static final String DESCRIPTION = "Description";
    private static final String ISSUE_DATE = "11/12/2021";
    private static final String NUMBER = "FV/01/02/2000";
    private static final Integer STATUS = 0;
    private static final Long INVOICE_ID = 123456L;

    ComarchInvoice comarchInvoice = new ComarchInvoice();
    ComarchInvoiceDTO comarchInvoiceDTO;
    @Mock
    private ComarchApiInvoiceConnector connector;
    @Mock
    private ComarchInvoiceMapper comarchInvoiceMapper;
    @InjectMocks
    private ComarchInvoiceServiceDefault comarchInvoiceService;

    @BeforeEach
    void setUp() throws IOException {
        //given
        comarchInvoice.setPaymentStatus(PAYMENT_STATUS);
        comarchInvoice.setPurchasingPartyId(PURCHASING_PARTY_ID);
        comarchInvoice.setReceivingPartyId(RECEIVING_PARTY_ID);
        comarchInvoice.setPaymentTypeId(PAYMENT_TYPE_ID);
        comarchInvoice.setBankAccountId(BANK_ACCOUNT_ID);
        comarchInvoice.setSalesDate(SALES_DATE);
        comarchInvoice.setInvoiceType(INVOICE_TYPE);
        comarchInvoice.setDescription(DESCRIPTION);
        comarchInvoice.setIssueDate(ISSUE_DATE);
        comarchInvoice.setNumber(NUMBER);
        comarchInvoice.setStatus(STATUS);
        comarchInvoice.setId(INVOICE_ID);
        doReturn(comarchInvoice).when(connector.getInvoiceById(INVOICE_ID));

        comarchInvoiceDTO = ComarchInvoiceDTO.builder()
                .paymentStatus(PAYMENT_STATUS)
                .purchasingPartyId(PURCHASING_PARTY_ID)
                .receivingPartyId(RECEIVING_PARTY_ID)
                .paymentTypeId(PAYMENT_TYPE_ID)
                .bankAccountId(BANK_ACCOUNT_ID)
                .salesDate(SALES_DATE)
                .invoiceType(INVOICE_TYPE)
                .description(DESCRIPTION)
                .issueDate(ISSUE_DATE)
                .number(NUMBER)
                .status(STATUS)
                .id(INVOICE_ID).build();
        doReturn(comarchInvoiceDTO).when(comarchInvoiceMapper.from(comarchInvoice));



    }

    @DisplayName("Should return given id")
    @Test
    public void test() {
        //when
        ComarchInvoiceDTO actual = comarchInvoiceService.read(INVOICE_ID);
        //then

        Assertions.assertEquals(comarchInvoiceDTO, actual);
    }
}