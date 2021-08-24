package pl.fakturogen.invoice.dao.repository;

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

    @DisplayName("Given entity when save should find equal one")
    @Test
    void test1() {
        //given
        Customer customer = new Customer();
        customer.setCustomerCode("23@$@");
        customer.setName("Jan");


        Product product = new Product();
        product.setName("Product 1");
        product.setDescription("Description of product 1");
        product.setSaleNetPrice(100.00);
        product.setSaleGrossPrice(123.00);
        product.setRate(Rate.R9);
        product.setIdExternalApi(123L);

        List<Product> items = new ArrayList<>();
        items.add(product);

        Invoice invoice = new Invoice();
        invoice.setNumber("F/1/1/2021");
        invoice.setInvoiceType(1);
        invoice.setBankAccountId(1234567890);
        invoice.setAdditionalInformation("additional information");
        invoice.setCustomer(customer);
        invoice.setItems(items);

        //when
        Invoice savedInvoice = invoiceRepository.save(invoice);
        Invoice result = invoiceRepository.findById(savedInvoice.getId()).orElseThrow(() -> new NoSuchElementException("Invoice not found"));

        //then
        assertAll(
                () -> assertNotNull(savedInvoice, "Saved invoice is null"),
                () -> assertThat(invoice.getInvoiceType()).isEqualTo(result.getInvoiceType()),
                () -> assertThat(invoice.getBankAccountId()).isEqualTo(result.getBankAccountId()),
                () -> assertThat(invoice.getAdditionalInformation()).isEqualTo(result.getAdditionalInformation()),
                () -> assertThat(invoice.getCustomer()).isEqualTo(result.getCustomer()),
                () -> assertThat(invoice.getItems()).isEqualTo(result.getItems())
        );
    }

    @DisplayName("Update should save in existing record")
    @Test
    void test2(){
        List<Invoice> invoices = invoiceRepository.findAll();
        Integer existingSize = invoices.size();


    }
}