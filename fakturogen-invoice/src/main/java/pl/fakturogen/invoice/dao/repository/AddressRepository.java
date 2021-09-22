package pl.fakturogen.invoice.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.fakturogen.invoice.dao.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
