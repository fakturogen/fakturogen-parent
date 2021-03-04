package pl.fakturogen.comarchconnector.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.fakturogen.comarch.connector.model.ApiInvoice;
import pl.fakturogen.comarch.connector.model.ApiItem;

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

        ApiItem apiItem1 = new ApiItem();
        apiItem1.set$id("2");
        apiItem1.setProductCurrencyPrice(1000.00);
        apiItem1.setId(27760788);

        ApiItem apiItem2 = new ApiItem();
        apiItem2.set$id("4");
        apiItem2.setProductCurrencyPrice(500.00);
        apiItem2.setId(788);

        List<ApiItem> apiItems = new ArrayList<>();
        apiItems.add(apiItem1);
        apiItems.add(apiItem2);

        ApiInvoice apiInvoice = new ApiInvoice();
        apiInvoice.set$id("1");
        apiInvoice.setPaymentStatus(1);
        apiInvoice.setPurchasingPartyId(12641710);
        apiInvoice.setItems(apiItems);
        apiInvoice.setId(18369406);

        ApiInvoice apiInvoiceJson = new ApiInvoice();
        apiInvoiceJson.set$id(FOLLOWING_NUMBER);
        apiInvoiceJson.setPaymentStatus(PAYMENT_STATUS);
        apiInvoiceJson.setPurchasingPartyId(PURCHASING_PARTY_ID);
        apiInvoiceJson.setReceivingPartyId(RECEIVING_PARTY_ID);
        apiInvoiceJson.setPaymentTypeId(PAYMENT_TYPE_ID);
        apiInvoiceJson.setBankAccountId(BANK_ACCOUNT_ID);
        apiInvoiceJson.setSalesDate(SALES_DATE);
        apiInvoiceJson.setInvoiceType(INVOICE_TYPE);
        apiInvoiceJson.setItems(apiItems);
        apiInvoiceJson.setDescription(DESCRIPTION);
        apiInvoiceJson.setIssueDate(ISSUE_DATE);
        apiInvoiceJson.setNumber(NUMBER);
        apiInvoiceJson.setStatus(STATUS);
        apiInvoiceJson.setId(ID);

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(apiInvoiceJson);

        ApiInvoice result = invoiceResponseConverter.from(json);

        Assertions.assertAll(
                () -> assertThat(result.get$id()).isNotNull(),
                () -> assertThat(result.getPaymentStatus()).isEqualTo(apiInvoice.getPaymentStatus()),
                () -> assertThat(result.getPurchasingPartyId()).isEqualTo(apiInvoice.getPurchasingPartyId()),
                () -> assertThat(result.getItems()).isNotNull(),
                () -> assertThat(result.getItems().size()).isEqualTo(apiItems.size()),
                () -> assertThat(result.getItems().get(0).get$id()).isEqualTo(apiItems.get(0).get$id()), // czy tak porównywać z listą?
                () -> assertThat(result.getItems().get(0).getProductCurrencyPrice()).isEqualTo(apiItem1.getProductCurrencyPrice()),
                () -> assertThat(result.getItems().get(0).getId()).isEqualTo(apiItem1.getId())
        );


    }
}