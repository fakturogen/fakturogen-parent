package pl.fakturogen.invoice.service;

import org.springframework.stereotype.Service;
import pl.fakturogen.invoice.exception.CreateProductException;
import pl.fakturogen.invoice.exception.ReadProductException;
import pl.fakturogen.invoice.web.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

/**
 * @author damian
 */

@Service
public interface ProductService {
    ProductDTO create(ProductDTO productDTO) throws CreateProductException;
    Optional<ProductDTO> read(Long id) throws ReadProductException;
    List<ProductDTO> readAll() throws ReadProductException;
}
