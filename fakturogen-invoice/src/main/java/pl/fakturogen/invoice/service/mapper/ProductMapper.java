package pl.fakturogen.invoice.service.mapper;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.fakturogen.invoice.dao.entity.Product;
import pl.fakturogen.invoice.web.dto.ProductDTO;

@Component
@Slf4j
public class ProductMapper {

    private ModelMapper modelMapper;

    public ProductMapper() {
        modelMapper = new ModelMapper();
    }

    public ProductDTO from(Product product) {
        log.info("from({})", product);
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        log.info("from({}) = {}", product, productDTO);
        return productDTO;
    }

    public Product from(ProductDTO productDTO) {
        log.info("from({})", productDTO);
        Product product = modelMapper.map(productDTO, Product.class);
        log.info("from({}) = {}", productDTO, product);
        return product;
    }
}
