package pl.fakturogen.invoice.service;

import org.springframework.stereotype.Service;
import pl.fakturogen.invoice.exception.CreateProductException;
import pl.fakturogen.invoice.exception.ProductException;
import pl.fakturogen.invoice.exception.ReadProductException;
import pl.fakturogen.invoice.web.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

/**
 * @author damian
 */

@Service
public interface ProductService {
    ProductDTO create(ProductDTO productDTO) throws ProductException;
    Optional<ProductDTO> read(Long id) throws ProductException;
    List<ProductDTO> readAll() throws ProductException;
    Optional<ProductDTO> findByExternalId(Long id) throws ProductException;
}
