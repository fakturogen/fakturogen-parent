package pl.fakturogen.web.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.fakturogen.comarch.connector.dto.ComarchInvoiceDTO;
import pl.fakturogen.comarch.connector.services.ComarchInvoiceService;

import java.io.IOException;
import java.util.List;

@RestController
public class InvoiceController {

    private ComarchInvoiceService comarchInvoiceService;

    public InvoiceController(ComarchInvoiceService comarchInvoiceService) {
        this.comarchInvoiceService = comarchInvoiceService;
    }

    @GetMapping("/getInvoices")
    public List<ComarchInvoiceDTO> getInvoices() throws IOException {
        return comarchInvoiceService.readAll();
    }

    @GetMapping("/getInvoices/{id}")
    public ComarchInvoiceDTO getInvoice(@PathVariable long id) throws Exception {
        return comarchInvoiceService.read(id);
    }
}
