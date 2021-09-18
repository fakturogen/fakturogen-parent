package pl.fakturogen.invoice.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.fakturogen.invoice.dao.entity.CustomerType;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, Long> {
}
