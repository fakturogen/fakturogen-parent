package pl.fakturogen.invoice.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.fakturogen.invoice.dao.entity.InvoiceTemplate;

public interface InvoiceTemplateRepository extends JpaRepository<InvoiceTemplate, Long> {
}
