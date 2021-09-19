package pl.fakturogen.web.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.fakturogen.comarch.connector.dto.ComarchProductDTO;
import pl.fakturogen.comarch.connector.mapper.FakturogenProductMapper;
import pl.fakturogen.comarch.connector.services.ComarchProductService;
import pl.fakturogen.invoice.exception.ProductException;
import pl.fakturogen.invoice.service.ProductService;
import pl.fakturogen.invoice.web.dto.ProductDTO;
import pl.fakturogen.web.exception.ProductNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * @author damian
 */

@RestController
public class ProductController {
    private ComarchProductService comarchProductService;
    private ProductService productService;
    private FakturogenProductMapper fakturogenProductMapper;

    public ProductController(ComarchProductService comarchProductService, ProductService productService,
                             FakturogenProductMapper fakturogenProductMapper) {
        this.comarchProductService = comarchProductService;
        this.productService = productService;
        this.fakturogenProductMapper = fakturogenProductMapper;
    }


    @GetMapping("/getProductList")
    @ResponseStatus(HttpStatus.OK)
    public List<ComarchProductDTO> getProductList() {
        return comarchProductService.readAll();
    }

    @GetMapping("/getProductById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ComarchProductDTO getProductById(@PathVariable Long id) throws ProductNotFoundException, ProductException {
        Optional<ComarchProductDTO> optionalProduct = comarchProductService.read(id);
        ComarchProductDTO comarchProductDTO = optionalProduct
                .orElseThrow(() -> new ProductNotFoundException("Product with given id not found."));

        ProductDTO productDTO = fakturogenProductMapper.from(comarchProductDTO);
        productService.create(productDTO);
        return comarchProductDTO;
    }
}