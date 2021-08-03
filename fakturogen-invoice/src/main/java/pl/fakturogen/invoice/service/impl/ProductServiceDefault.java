package pl.fakturogen.invoice.service.impl;

import org.springframework.stereotype.Service;
import pl.fakturogen.invoice.dao.entity.Product;
import pl.fakturogen.invoice.dao.repository.ProductRepository;
import pl.fakturogen.invoice.service.ProductService;
import pl.fakturogen.invoice.service.mapper.ProductMapper;
import pl.fakturogen.invoice.web.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

/**
 * @author damian
 */

@Service
public class ProductServiceDefault implements ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public ProductServiceDefault(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        Product product = productMapper.from(productDTO);
        Product savedProduct = productRepository.save(product);
        return productMapper.from(savedProduct);
    }

    @Override
    public Optional<ProductDTO> read(Long id) {
        return Optional.empty();
    }

    @Override
    public List<ProductDTO> readAll() {
        return null;
    }

    @Override
    public void update(ProductDTO productDTO, Long id) {

    }

    @Override
    public void delete(ProductDTO productDTO, Long id) {

    }
}
