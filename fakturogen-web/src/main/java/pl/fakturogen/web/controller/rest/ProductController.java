package pl.fakturogen.web.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.fakturogen.comarch.connector.connector.ComarchApiProductConnector;
import pl.fakturogen.comarch.connector.dto.ComarchProductDTO;
import pl.fakturogen.web.exception.ProductNotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    private ComarchApiProductConnector comarchApiProductConnector;

    public ProductController(ComarchApiProductConnector comarchApiProductConnector) {
        this.comarchApiProductConnector = comarchApiProductConnector;
    }

    @GetMapping("/getProductList")
    public List<ComarchProductDTO> getProductList() {
        return comarchApiProductConnector.readAll();
    }

    @GetMapping("/getProductById/{id}")
    public ComarchProductDTO getProductById(@PathVariable Long id) throws ProductNotFoundException {
        Optional<ComarchProductDTO> optionalProduct = comarchApiProductConnector.read(id);
        return optionalProduct.orElseThrow(() -> new ProductNotFoundException("Product with given id not found."));
    }
}