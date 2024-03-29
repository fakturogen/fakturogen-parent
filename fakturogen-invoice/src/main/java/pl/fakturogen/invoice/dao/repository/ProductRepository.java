package pl.fakturogen.invoice.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.fakturogen.invoice.dao.entity.Product;

import java.util.Optional;

/**
 * @author damian
 */

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByIdExternalApi(Long id);
}
