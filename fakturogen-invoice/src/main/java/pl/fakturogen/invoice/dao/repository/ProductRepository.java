package pl.fakturogen.invoice.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.fakturogen.invoice.dao.entity.Product;

import java.util.Optional;

/**
 * @author damian
 */

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByIdExternalApi(Long id);
}
