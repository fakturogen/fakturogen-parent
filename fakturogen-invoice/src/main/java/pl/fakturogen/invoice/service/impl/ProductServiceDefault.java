package pl.fakturogen.invoice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.fakturogen.invoice.dao.entity.Product;
import pl.fakturogen.invoice.dao.repository.ProductRepository;
import pl.fakturogen.invoice.exception.ProductCreateException;
import pl.fakturogen.invoice.exception.ProductException;
import pl.fakturogen.invoice.exception.ProductReadException;
import pl.fakturogen.invoice.service.ProductService;
import pl.fakturogen.invoice.service.mapper.ProductMapper;
import pl.fakturogen.invoice.web.dto.ProductDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author damian
 */

@Slf4j
@Service
public class ProductServiceDefault implements ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public ProductServiceDefault(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDTO create(ProductDTO productDTO) throws ProductException {
        try {
            Product product = productMapper.from(productDTO);
            Product savedProduct = productRepository.save(product);
            return productMapper.from(savedProduct);
        } catch (Exception ex) {
            log.warn(ex.getMessage(), ex);
            throw new ProductCreateException("Error during creating product entity in database");
        }
    }

    @Override
    public Optional<ProductDTO> read(Long id) throws ProductException {
        try {
            Optional<Product> optionalProduct = productRepository.findById(id);
            ProductDTO returnProductDTO = null;

            if (optionalProduct.isPresent()) {
                Product product = optionalProduct.get();
                returnProductDTO = productMapper.from(product);
            }
            return Optional.ofNullable(returnProductDTO);
        } catch (Exception ex) {
            log.warn(ex.getMessage(), ex);
            throw new ProductReadException("Error during reading product from database");
        }

    }

    @Override
    public List<ProductDTO> readAll() throws ProductException {
        try {
            List<Product> allProductList = productRepository.findAll();
            return allProductList.stream()
                    .map(product -> productMapper.from(product))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            log.warn(ex.getMessage(), ex);
            throw new ProductReadException("Error during reading all products from database");
        }
    }

    @Override
    public Optional<ProductDTO> findByExternalId(Long id) throws ProductException {
        try {
            productRepository.findByIdExternalApi(id);
        } catch (Exception ex) {
            log.warn(ex.getMessage(), ex);
            throw new ProductReadException("Error during reading product from database");
        }
        return Optional.empty();
    }

}
