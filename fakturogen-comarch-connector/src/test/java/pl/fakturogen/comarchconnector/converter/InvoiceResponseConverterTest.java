package pl.fakturogen.comarchconnector.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.fakturogen.comarch.connector.model.ApiInvoice;
import pl.fakturogen.comarch.connector.model.ApiItem;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
@DisplayName("Comarch invoice converter")
class InvoiceResponseConverterTest {



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


        String json = "{\"$id\":\"1\"," +
                "\"PaymentStatus\":1," +
                "\"PurchasingPartyId\":12641710," +
                "\"ReceivingPartyId\":null," +
                "\"PaymentTypeId\":10301770," +
                "\"BankAccountId\":null," +
                "\"SalesDate\":\"2020-11-17T00:00:00+01:00\"," +
                "\"InvoiceType\":1," +
                "\"Items\":" +
                "[{\"$id\":\"2\"," +
                "\"ProductId\":null," +
                "\"Quantity\":1.0000," +
                "\"ProductCurrencyPrice\":1000.00," +
                "\"ProductDescription\":\"\"," +
                "\"Id\":27760788}, " +
                "{\"$id\":\"4\",\"ProductId\":null,\"Quantity\":3.0000,\"ProductCurrencyPrice\":500.00,\"ProductDescription\":\"\",\"Id\":788}]," +
                "\"Description\":null," +
                "\"IssueDate\":\"2020-11-17T00:00:00+01:00\"," +
                "\"Number\":\"FS/20/11/1\"," +
                "\"Status\":0," +
                "\"Id\":18369406}";

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