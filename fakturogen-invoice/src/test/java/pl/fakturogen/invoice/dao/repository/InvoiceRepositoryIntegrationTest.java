package pl.fakturogen.invoice.dao.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.fakturogen.invoice.config.InvoiceTestContextConfiguration;
import pl.fakturogen.invoice.dao.entity.Customer;
import pl.fakturogen.invoice.dao.entity.Invoice;
import pl.fakturogen.invoice.dao.entity.Product;
import pl.fakturogen.invoice.dao.entity.Rate;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = {InvoiceTestContextConfiguration.class})
class InvoiceRepositoryIntegrationTest {

    @Autowired
    private InvoiceRepository invoiceRepository;

    Product productInit;
    Customer customerInit;
    Invoice invoiceInit;

    @BeforeEach
    void init(){
        customerInit = new Customer();
        customerInit.setCustomerCode("23@$@");
        customerInit.setName("Jan");


        productInit = new Product();
        productInit.setName("Product 1");
        productInit.setDescription("Description of productInit 1");
        productInit.setSaleNetPrice(100.00);
        productInit.setSaleGrossPrice(123.00);
        productInit.setRate(Rate.R9);
        productInit.setIdExternalApi(123L);

        List<Product> items = new ArrayList<>();
        items.add(productInit);

        invoiceInit = new Invoice();
        invoiceInit.setNumber("F/1/1/2021");
        invoiceInit.setInvoiceType(1);
        invoiceInit.setBankAccountId(1234567890);
        invoiceInit.setAdditionalInformation("additional information");
        invoiceInit.setCustomer(customerInit);
        invoiceInit.setItems(items);
    }

    @DisplayName("Given entity when save should find equal one")
    @Test
    void test1() {
        //given


        //when
        Invoice savedInvoice = invoiceRepository.save(invoiceInit);
        Invoice result = invoiceRepository.findById(savedInvoice.getId()).orElseThrow(() -> new NoSuchElementException("Invoice not found"));

        //then
        assertAll(
                () -> assertNotNull(savedInvoice, "Saved invoice is null"),
                () -> assertThat(invoiceInit.getInvoiceType()).isEqualTo(result.getInvoiceType()),
                () -> assertThat(invoiceInit.getBankAccountId()).isEqualTo(result.getBankAccountId()),
                () -> assertThat(invoiceInit.getAdditionalInformation()).isEqualTo(result.getAdditionalInformation()),
                () -> assertThat(invoiceInit.getCustomer()).isEqualTo(result.getCustomer())
//                () -> assertThat(invoiceInit.getItems()).isEqualTo(result.getItems())
        );
    }

    @DisplayName("Update should save in existing record")
    @Test
    void test2(){
        Invoice invoice = invoiceRepository.save(invoiceInit);
        Long invoiceId = invoice.getId();

        List<Invoice> invoices = invoiceRepository.findAll();
        Integer existingSize = invoices.size();

        Invoice updatedInvoice = new Invoice();
        updatedInvoice.setId(invoiceId);
        updatedInvoice.setNumber("23/1/2021");

        Invoice result = invoiceRepository.save(updatedInvoice);

        int sizeAfterUpdate = invoiceRepository.findAll().size();

        assertAll(
                () -> assertThat(existingSize).isEqualTo(sizeAfterUpdate)
        );


    }
}