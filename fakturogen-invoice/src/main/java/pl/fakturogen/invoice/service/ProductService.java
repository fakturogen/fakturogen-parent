package pl.fakturogen.invoice.service;

import org.springframework.stereotype.Service;
import pl.fakturogen.invoice.web.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    // ProductException wszystkie wyjątki tutaj dziedziczą po tym ProductException
    ProductDTO create(ProductDTO productDTO); //throws ProductCreateException
    Optional<ProductDTO> read(Long id); //throws ProductReadException jak nie będzie optionala
    List<ProductDTO> readAll(); // AllProductReadException
    void update(ProductDTO productDTO, Long id); //throws ProductDeleteException
    void delete(ProductDTO productDTO, Long id); //throws ProductDeleteException

}
