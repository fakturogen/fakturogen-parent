package pl.fakturogen.web.controller.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.fakturogen.comarch.connector.dto.ComarchProductDTO;
import pl.fakturogen.comarch.connector.exception.ComarchConnectorException;
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

@Api(value = "${fakturogen.product.description}")
@RestController
@RequestMapping("/api/product")
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

    @ApiOperation(value = "${fakturogen.product.list}")
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<ComarchProductDTO> getProductList() throws ComarchConnectorException {
        return comarchProductService.readAll();
    }

    @ApiOperation(value = "${fakturogen.product.get}")
    @ApiResponse(code = 404, message = "Product not found")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ComarchProductDTO getProductById(@PathVariable Long id) throws ProductNotFoundException, ProductException, ComarchConnectorException {
        Optional<ComarchProductDTO> optionalProduct = comarchProductService.read(id);
        ComarchProductDTO comarchProductDTO = optionalProduct
                .orElseThrow(() -> new ProductNotFoundException("Product with given id not found."));

        ProductDTO productDTO = fakturogenProductMapper.from(comarchProductDTO);
        productService.create(productDTO);
        return comarchProductDTO;
    }
}