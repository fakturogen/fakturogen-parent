package pl.fakturogen.web.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.fakturogen.comarch.connector.connector.ComarchApiProductConnector;
import pl.fakturogen.comarch.connector.dto.ComarchProductDTO;

import java.io.IOException;
import java.util.List;

@RestController
public class ProductController {
    private ComarchApiProductConnector comarchApiProductConnector;

    public ProductController(ComarchApiProductConnector comarchApiProductConnector) {
        this.comarchApiProductConnector = comarchApiProductConnector;
    }

    @GetMapping("/getProductList")
    public List<ComarchProductDTO> getProductList() throws IOException {
        return comarchApiProductConnector.readAll();
    }

    @GetMapping("/getProductById/{id}")
    public ComarchProductDTO getProductById(@PathVariable Long id) throws IOException {
        return comarchApiProductConnector.read(id);
    }
}