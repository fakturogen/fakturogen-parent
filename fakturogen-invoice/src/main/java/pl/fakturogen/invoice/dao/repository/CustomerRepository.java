package pl.fakturogen.invoice.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.fakturogen.invoice.dao.entity.Customer;

import java.util.Optional;


/**
 * @author ewa-git
 */

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByIdExternalApi(Long id);

}
