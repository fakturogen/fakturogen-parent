package pl.fakturogen.invoice.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.fakturogen.invoice.dao.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
