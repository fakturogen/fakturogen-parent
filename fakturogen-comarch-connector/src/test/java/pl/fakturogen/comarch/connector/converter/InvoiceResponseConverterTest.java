package pl.fakturogen.comarch.connector.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.fakturogen.comarch.connector.model.ComarchInvoice;
import pl.fakturogen.comarch.connector.model.ComarchItem;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Comarch invoice converter")
class InvoiceResponseConverterTest {
    private static final String FOLLOWING_NUMBER = "1";
    private static final Integer PAYMENT_STATUS = 1;
    private static final Integer PURCHASING_PARTY_ID = 12641710;
    private static final Integer RECEIVING_PARTY_ID = null;
    private static final int PAYMENT_TYPE_ID = 10301770;
    private static final Integer BANK_ACCOUNT_ID = null;
    private static final String SALES_DATE = "2020-11-17T00:00:00+01:00";
    private static final int INVOICE_TYPE = 1;
    private static final String DESCRIPTION = null;
    private static final String ISSUE_DATE = "2020-11-17T00:00:00+01:00";
    private static final String NUMBER = "FS/20/11/1";
    private static final int STATUS = 0;
    private static final Integer ID = 18369406;

    @DisplayName(" - should convert all fields from json to an ApiInvoice object")
    @Test
    void test1() throws JsonProcessingException {
        InvoiceResponseConverter invoiceResponseConverter = new InvoiceResponseConverter();

        ComarchItem comarchItem1 = new ComarchItem();
        comarchItem1.set$id("2");
        comarchItem1.setProductCurrencyPrice(1000.00);
        comarchItem1.setId(27760788);

        ComarchItem comarchItem2 = new ComarchItem();
        comarchItem2.set$id("4");
        comarchItem2.setProductCurrencyPrice(500.00);
        comarchItem2.setId(788);

        List<ComarchItem> comarchItems = new ArrayList<>();
        comarchItems.add(comarchItem1);
        comarchItems.add(comarchItem2);

        ComarchInvoice comarchInvoice = new ComarchInvoice();
        comarchInvoice.set$id("1");
        comarchInvoice.setPaymentStatus(1);
        comarchInvoice.setPurchasingPartyId(12641710);
        comarchInvoice.setItems(comarchItems);
        comarchInvoice.setId(18369406);

        ComarchInvoice comarchInvoiceJson = new ComarchInvoice();
        comarchInvoiceJson.set$id(FOLLOWING_NUMBER);
        comarchInvoiceJson.setPaymentStatus(PAYMENT_STATUS);
        comarchInvoiceJson.setPurchasingPartyId(PURCHASING_PARTY_ID);
        comarchInvoiceJson.setReceivingPartyId(RECEIVING_PARTY_ID);
        comarchInvoiceJson.setPaymentTypeId(PAYMENT_TYPE_ID);
        comarchInvoiceJson.setBankAccountId(BANK_ACCOUNT_ID);
        comarchInvoiceJson.setSalesDate(SALES_DATE);
        comarchInvoiceJson.setInvoiceType(INVOICE_TYPE);
        comarchInvoiceJson.setItems(comarchItems);
        comarchInvoiceJson.setDescription(DESCRIPTION);
        comarchInvoiceJson.setIssueDate(ISSUE_DATE);
        comarchInvoiceJson.setNumber(NUMBER);
        comarchInvoiceJson.setStatus(STATUS);
        comarchInvoiceJson.setId(ID);

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(comarchInvoiceJson);

        ComarchInvoice result = invoiceResponseConverter.from(json);

        Assertions.assertAll(
                () -> assertThat(result.get$id()).isNotNull(),
                () -> assertThat(result.getPaymentStatus()).isEqualTo(comarchInvoice.getPaymentStatus()),
                () -> assertThat(result.getPurchasingPartyId()).isEqualTo(comarchInvoice.getPurchasingPartyId()),
                () -> assertThat(result.getItems()).isNotNull(),
                () -> assertThat(result.getItems().size()).isEqualTo(comarchItems.size()),
                () -> assertThat(result.getItems().get(0).get$id()).isEqualTo(comarchItems.get(0).get$id()), // czy tak porównywać z listą?
                () -> assertThat(result.getItems().get(0).getProductCurrencyPrice()).isEqualTo(comarchItem1.getProductCurrencyPrice()),
                () -> assertThat(result.getItems().get(0).getId()).isEqualTo(comarchItem1.getId())
        );


    }
}