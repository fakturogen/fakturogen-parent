package pl.fakturogen.invoice.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.fakturogen.invoice.dao.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
