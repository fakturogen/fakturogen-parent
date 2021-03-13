package pl.fakturogen.web.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.fakturogen.comarch.connector.dto.ComarchProductDTO;
import pl.fakturogen.comarch.connector.services.ComarchProductService;
import pl.fakturogen.web.exception.ProductNotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    private ComarchProductService comarchProductService;

    public ProductController(ComarchProductService comarchProductService) {
        this.comarchProductService = comarchProductService;
    }


    @GetMapping("/getProductList")
    public List<ComarchProductDTO> getProductList() {
        return comarchProductService.readAll();
    }

    @GetMapping("/getProductById/{id}")
    public ComarchProductDTO getProductById(@PathVariable Long id) throws ProductNotFoundException {
        Optional<ComarchProductDTO> optionalProduct = comarchProductService.read(id);
        return optionalProduct.orElseThrow(() -> new ProductNotFoundException("Product with given id not found."));
    }
}