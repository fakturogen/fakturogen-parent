package pl.fakturogen.invoice.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.fakturogen.invoice.dao.entity.Customer;
import pl.fakturogen.invoice.dao.entity.Invoice;
import pl.fakturogen.invoice.dao.entity.Product;
import pl.fakturogen.invoice.dao.entity.Rate;
import pl.fakturogen.invoice.web.dto.CustomerDTO;
import pl.fakturogen.invoice.web.dto.InvoiceSaveDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Invoice ModelMapper ")
class InvoiceMapperTest {
    InvoiceMapper invoiceMapper;
    List<Product> items;
    CustomerDTO customer;

    @BeforeEach
    void init() {
        invoiceMapper = new InvoiceMapper();
        customer = new CustomerDTO();
        items = new ArrayList<>();
    }

    @DisplayName(" - should map InvoiceSaveDTO to entity")
    @Test
    public void test1() {
        Product product1 = new Product();
        product1.setId(1L);
        product1.setRate(Rate.R9);
        product1.setSaleNetPrice(100.00);
        product1.setName("Apartment no. 1");

        Product product2 = new Product();
        product2.setId(12L);
        product2.setRate(Rate.R9);
        product2.setSaleNetPrice(100.00);
        product2.setName("Apartment no. 2");

        items.add(product1);
        items.add(product2);

        customer.setName("Jan");
        customer.setId(4L);
        customer.setNip("123");

        InvoiceSaveDTO receivedDTO = InvoiceSaveDTO.builder()
                .number("1/1/2021")
                .status(0)
                .issueDate(LocalDate.of(2021, 1, 19))
                .paymentMethod(1)
                .total(246.00)
                .tax(0.23)
                .net(200.00)
                .discount(00.0)
                .status(1)
                .customerDTO(customer)
                .items(items)
                .bankAccountId(1234)
                .invoiceType(0)
                .additionalInformation("brak")
                .originalId(23L)
                .build();

        Invoice result = invoiceMapper.from(receivedDTO);


        Assertions.assertAll(
                () -> assertThat(result).isNotNull(),
                () -> assertThat(result.getNumber()).isEqualTo(receivedDTO.getNumber()),
                () -> assertThat(result.getStatus()).isEqualTo(receivedDTO.getStatus()),
                () -> assertThat(result.getIssueDate()).isEqualTo(receivedDTO.getIssueDate()),
                () -> assertThat(result.getPaymentMethod()).isEqualTo(receivedDTO.getPaymentMethod()),
                () -> assertThat(result.getTotal()).isEqualTo(receivedDTO.getTotal()),
                () -> assertThat(result.getTax()).isEqualTo(receivedDTO.getTax()),
                () -> assertThat(result.getNet()).isEqualTo(receivedDTO.getNet()),
                () -> assertThat(result.getDiscount()).isEqualTo(receivedDTO.getDiscount()),
                () -> assertThat(result.getStatus()).isEqualTo(receivedDTO.getStatus()),
                () -> assertThat(result.getCustomer()).isNotNull(),
                () -> assertThat(result.getCustomer().getNip()).isEqualTo(receivedDTO.getCustomerDTO().getNip()),
                () -> assertThat(result.getBankAccountId()).isEqualTo(receivedDTO.getBankAccountId()),
                () -> assertThat(result.getInvoiceType()).isEqualTo(receivedDTO.getInvoiceType()),
                () -> assertThat(result.getAdditionalInformation()).isEqualTo(receivedDTO.getAdditionalInformation()),
                () -> assertThat(result.getOriginalId()).isEqualTo(receivedDTO.getOriginalId())
        );

    }

    @DisplayName(" - should map empty object ")
    @Test
    public void test2(){
        InvoiceSaveDTO invoiceSaveDTO = new InvoiceSaveDTO();

        Invoice invoice = new Invoice();
        invoice.setItems(invoiceSaveDTO.getItems());
//        invoice.setCustomer(invoiceSaveDTO.);

        Invoice result = invoiceMapper.from(invoiceSaveDTO);

       assertThat(result).hasAllNullFieldsOrProperties();

    }


}