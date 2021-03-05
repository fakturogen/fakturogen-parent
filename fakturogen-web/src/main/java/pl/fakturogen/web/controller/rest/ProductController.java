package pl.fakturogen.web.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fakturogen.comarch.connector.connectors.ComarchApiProductConnector;
import pl.fakturogen.comarch.connector.dto.ComarchProductDTO;

import java.io.IOException;
import java.util.List;

@RestController
public class ProductController {
    private ComarchApiProductConnector comarchApiProductConnector;

    public ProductController(ComarchApiProductConnector comarchApiProductConnector) {
        this.comarchApiProductConnector = comarchApiProductConnector;
    }

    @RequestMapping("/getProductList")
    public List<ComarchProductDTO> getProductList() throws IOException {
        return comarchApiProductConnector.getAllProductList();
    }
}