package pl.fakturogen.invoice.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.fakturogen.invoice.dao.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
