package pl.fakturogen.comarch.connector.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.fakturogen.comarch.connector.dto.ComarchInvoiceDTO;
import pl.fakturogen.comarch.connector.model.ComarchInvoice;
import pl.fakturogen.comarch.connector.model.ComarchItem;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("Default Comarch Invoice mapper")
class ComarchInvoiceMapperTest {

    private static final String INVOICE_$ID = "1";
    private static final Integer PAYMENT_STATUS = 1;
    private static final Integer PURCHASING_PARTY_ID = 34;
    private static final Integer RECEIVING_PARTY_ID = 0;
    private static final Integer PAYMENT_TYPE_ID = 1;
    private static final Integer BANK_ACCOUNT_ID = 3939393;
    private static final String SALES_DATE = "";
    private static final Integer INVOICE_TYPE = 2;
    private static final String DESCRIPTION = "Description";
    private static final String ISSUE_DATE = "";
    private static final String NUMBER = "FV/01/02/2000";
    private static final Integer STATUS = 0;
    private static final Integer INVOICE_ID = 123456;

    @DisplayName(" - should return all filed fields")
    @Test
    void test1(){
        ComarchInvoiceMapper comarchInvoiceMapper = new ComarchInvoiceMapper();

        ComarchItem item1 = new ComarchItem();
        item1.set$id("1");
        item1.setId(13);
        item1.setQuantity(1.000);
        item1.setProductCurrencyPrice(1000.00);
        item1.setProductDescription("Product Desc");
        item1.setId(120934);

        List<ComarchItem> itemList = new ArrayList<>();
        itemList.add(item1);

        ComarchInvoice comarchInvoice = new ComarchInvoice();
        comarchInvoice.setConsecutiveNumber(INVOICE_$ID);
        comarchInvoice.setPaymentStatus(PAYMENT_STATUS);
        comarchInvoice.setPurchasingPartyId(PURCHASING_PARTY_ID);
        comarchInvoice.setReceivingPartyId(RECEIVING_PARTY_ID);
        comarchInvoice.setPaymentTypeId(PAYMENT_TYPE_ID);
        comarchInvoice.setBankAccountId(BANK_ACCOUNT_ID);
        comarchInvoice.setSalesDate(SALES_DATE);
        comarchInvoice.setInvoiceType(INVOICE_TYPE);
        comarchInvoice.setItems(itemList);
        comarchInvoice.setDescription(DESCRIPTION);
        comarchInvoice.setIssueDate(ISSUE_DATE);
        comarchInvoice.setNumber(NUMBER);
        comarchInvoice.setStatus(STATUS);
        comarchInvoice.setId(INVOICE_ID);

        ComarchInvoiceDTO comarchInvoiceDTO = ComarchInvoiceDTO.builder()
                .consecutiveNumber(INVOICE_$ID)
                .paymentStatus(PAYMENT_STATUS)
                .purchasingPartyId(PURCHASING_PARTY_ID)
                .receivingPartyId(RECEIVING_PARTY_ID)
                .paymentTypeId(PAYMENT_TYPE_ID)
                .bankAccountId(BANK_ACCOUNT_ID)
                .salesDate(SALES_DATE)
                .invoiceType(INVOICE_TYPE)
                .items(itemList)
                .description(DESCRIPTION)
                .issueDate(ISSUE_DATE)
                .number(NUMBER)
                .status(STATUS)
                .id(INVOICE_ID).build();

        ComarchInvoiceDTO resultInvoiceDTO = comarchInvoiceMapper.from(comarchInvoice);

        assertAll(
                () -> assertThat(resultInvoiceDTO).isNotNull(),
//                () -> assertThat(resultInvoiceDTO.get$id()).isEqualTo(comarchInvoiceDTO.get$id()),
                () -> assertThat(resultInvoiceDTO.getPaymentStatus()).isEqualTo(comarchInvoiceDTO.getPaymentStatus()),
                () -> assertThat(resultInvoiceDTO.getPurchasingPartyId()).isEqualTo(comarchInvoiceDTO.getPurchasingPartyId()),
                () -> assertThat(resultInvoiceDTO.getReceivingPartyId()).isEqualTo(comarchInvoiceDTO.getReceivingPartyId()),
                () -> assertThat(resultInvoiceDTO.getPaymentTypeId()).isEqualTo(comarchInvoiceDTO.getPaymentTypeId()),
                () -> assertThat(resultInvoiceDTO.getBankAccountId()).isEqualTo(comarchInvoiceDTO.getBankAccountId()),
                () -> assertThat(resultInvoiceDTO.getSalesDate()).isEqualTo(comarchInvoiceDTO.getSalesDate()),
                () -> assertThat(resultInvoiceDTO.getInvoiceType()).isEqualTo(comarchInvoiceDTO.getInvoiceType()),
                () -> assertThat(resultInvoiceDTO.getDescription()).isEqualTo(comarchInvoiceDTO.getDescription()),
                () -> assertThat(resultInvoiceDTO.getIssueDate()).isEqualTo(comarchInvoiceDTO.getIssueDate()),
                () -> assertThat(resultInvoiceDTO.getNumber()).isEqualTo(comarchInvoiceDTO.getNumber()),
                () -> assertThat(resultInvoiceDTO.getStatus()).isEqualTo(comarchInvoiceDTO.getStatus()),
                () -> assertThat(resultInvoiceDTO.getId()).isEqualTo(comarchInvoiceDTO.getId())
        );

    }

    @DisplayName("- should map items list from Comarch invoice ")
    @Test
    void tes2(){
        ComarchInvoiceMapper comarchInvoiceMapper = new ComarchInvoiceMapper();

        ComarchItem item1 = new ComarchItem();
        item1.set$id("1");
        item1.setId(13);
        item1.setQuantity(1.000);
        item1.setProductCurrencyPrice(1000.00);
        item1.setProductDescription("Product Desc");
        item1.setId(120934);

        List<ComarchItem> itemList = new ArrayList<>();
        itemList.add(item1);

        ComarchInvoice comarchInvoice = new ComarchInvoice();
        comarchInvoice.setItems(itemList);

        ComarchInvoiceDTO comarchInvoiceDTO = ComarchInvoiceDTO.builder()
                .items(itemList).build();

        ComarchInvoiceDTO result = comarchInvoiceMapper.from(comarchInvoice);

        assertAll(
                () -> assertThat(result.getItems().size()).isEqualTo(comarchInvoiceDTO.getItems().size()),
                () -> assertThat(result).isNotNull(),
                () -> assertThat(result.getItems().get(0).get$id()).isEqualTo(comarchInvoiceDTO.getItems().get(0).get$id()),
                () -> assertThat(result.getItems().get(0).getId()).isEqualTo(comarchInvoiceDTO.getItems().get(0).getId()),
                () -> assertThat(result.getItems().get(0).getQuantity()).isEqualTo(comarchInvoiceDTO.getItems().get(0).getQuantity()),
                () -> assertThat(result.getItems().get(0).getProductCurrencyPrice()).isEqualTo(comarchInvoiceDTO.getItems().get(0).getProductCurrencyPrice()),
                () -> assertThat(result.getItems().get(0).getProductDescription()).isEqualTo(comarchInvoiceDTO.getItems().get(0).getProductDescription()),
                () -> assertThat(result.getItems().get(0).getProductId()).isEqualTo((comarchInvoiceDTO.getItems().get(0).getProductId()))

        );


    }
}