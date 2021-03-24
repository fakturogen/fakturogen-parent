package pl.fakturogen.invoice.dao.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.fakturogen.invoice.config.InvoiceTestContextConfiguration;
import pl.fakturogen.invoice.dao.entity.Invoice;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = {InvoiceTestContextConfiguration.class})
class InvoiceRepositoryIntegrationTest {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @DisplayName("Given entity when save should find equal one")
    @Test
    void test1() {
        //given
        Invoice invoice = new Invoice();
        invoice.setId(123L);
        invoice.setNumber("F/1/1/2021");

        //when
        Invoice savedInvoice = invoiceRepository.save(invoice);
        Optional<Invoice> byId = invoiceRepository.findById(invoice.getId());

        //then
        assertAll(
                () -> assertNotNull(savedInvoice, "Saved invoice is null")
        );
    }
}