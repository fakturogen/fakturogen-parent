package pl.fakturogen.invoice.service;

import org.springframework.stereotype.Service;
import pl.fakturogen.invoice.web.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    ProductDTO create(ProductDTO productDTO);
    Optional<ProductDTO> read(long id);
    List<ProductDTO> readAll();
    void update(ProductDTO productDTO, long id);
    void delete(ProductDTO productDTO, long id);

}
