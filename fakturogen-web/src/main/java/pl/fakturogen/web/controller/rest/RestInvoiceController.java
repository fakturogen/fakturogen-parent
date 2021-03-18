package pl.fakturogen.web.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.fakturogen.comarch.connector.dto.ComarchInvoiceDTO;
import pl.fakturogen.comarch.connector.services.ComarchInvoiceService;

@RestController
public class RestInvoiceController {

    private ComarchInvoiceService comarchInvoiceService;

    public RestInvoiceController(ComarchInvoiceService comarchInvoiceService) {
        this.comarchInvoiceService = comarchInvoiceService;
    }

/*    @GetMapping("/getInvoices")
    public List<ComarchInvoice> getInvoices() throws IOException {
        return comarchApiInvoiceConnector.getInvoices();
    }*/

    @GetMapping("/getInvoices/{id}")
    public ComarchInvoiceDTO getInvoice(@PathVariable long id) throws Exception {
        return comarchInvoiceService.read(id);
    }
}
