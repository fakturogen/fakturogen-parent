package pl.fakturogen.invoice.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.fakturogen.invoice.dao.entity.Product;

/**
 * @author damian
 */

public interface ProductRepository extends JpaRepository<Product, Long> {
}
