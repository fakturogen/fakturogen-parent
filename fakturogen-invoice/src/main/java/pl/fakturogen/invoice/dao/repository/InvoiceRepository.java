package pl.fakturogen.invoice.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.fakturogen.invoice.dao.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
