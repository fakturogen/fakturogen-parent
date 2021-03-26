package pl.fakturogen.comarch.connector.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.fakturogen.comarch.connector.dto.ComarchInvoiceDTO;
import pl.fakturogen.invoice.web.dto.CustomerDTO;
import pl.fakturogen.invoice.web.dto.InvoiceSaveDTO;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Given ")
class FakturogenInvoiceMapperTest {
    private static final Integer PAYMENT_STATUS = 1;
    private static final Integer PURCHASING_PARTY_ID = 345;
    private static final Integer RECEIVING_PARTY_ID = 324;
    private static final Integer PAYMENT_TYPE_ID = 2;
    private static final Integer BANK_ACCOUNT_ID = 1234567890;
    private static final String SALES_DATE = "03-04-2021";
    private static final Integer INVOICE_TYPE = 0;
    private static final String DESCRIPTION = "Description";
    private static final String ISSUE_DATE = "03-04-2021";
    private static final String NUMBER = "F2/2/2212";
    private static final Integer STATUS = 0;
    private static final Long ID = 4380L;
    private static final Long ORIGINAL_ID = 243L;

    private static final Long CUSTOMER_ID = 1L;
    private static final Long CUSTOMER_EXT_API_ID = 234L;
    private static final String CUSTOMER_NAME = "Jan Kowalski";
    private static final String CUSTOMER_NIP = "123124142";
    private static final String CUSTOMER_PESEL = "47921929129";
    private static final String CUSTOMER_CODE = "312312";
    private static final String CUSTOMER_MAIL = "mail@test.com";
    private static final String CUSTOMER_PHONE_NUMBER = "123342421";

    @DisplayName("- should be equal")
    @Test
    void test1(){
        FakturogenInvoiceMapper fakturogenInvoiceMapper = new FakturogenInvoiceMapper();
        CustomerDTO customerDTO = CustomerDTO.builder()
                .id(CUSTOMER_ID)
                .idExternalApi(CUSTOMER_EXT_API_ID)
                .name(CUSTOMER_NAME)
                .nip(CUSTOMER_NIP)
                .pesel(CUSTOMER_PESEL)
                .customerCode(CUSTOMER_CODE)
                .mail(CUSTOMER_MAIL)
                .phoneNumber(CUSTOMER_PHONE_NUMBER).build();


        ComarchInvoiceDTO comarchInvoice = ComarchInvoiceDTO.builder()
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
                .id(ID).build();

        InvoiceSaveDTO expected = InvoiceSaveDTO.builder()
                .status(STATUS)
                .customer(customerDTO)
                .originalId(ORIGINAL_ID)
                .paymentMethod(PAYMENT_TYPE_ID)
                .bankAccountId(BANK_ACCOUNT_ID)
                .saleDate(SALES_DATE)
                .invoiceType(INVOICE_TYPE)
                .additionalInformation(DESCRIPTION)
                .issueDate(ISSUE_DATE)
                .number(NUMBER)
                .build();
        InvoiceSaveDTO actual = fakturogenInvoiceMapper.from(comarchInvoice);

        Assertions.assertAll(
                () -> assertThat(actual.getPaymentMethod()).isEqualTo(expected.getPaymentMethod())
        );

    }


}