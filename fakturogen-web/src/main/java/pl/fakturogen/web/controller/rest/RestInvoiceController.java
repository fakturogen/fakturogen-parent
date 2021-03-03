package pl.fakturogen.web.controller.rest;

import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fakturogen.comarch.connector.connectors.ComarchApiInvoiceConnector;
import pl.fakturogen.comarch.connector.model.ApiInvoice;

import java.io.IOException;

@RestController
public class RestInvoiceController {

    private ApplicationArguments applicationArguments;
    private ComarchApiInvoiceConnector apiInvoiceConnector;

    public RestInvoiceController(ApplicationArguments applicationArguments, ComarchApiInvoiceConnector apiInvoiceConnector) {
        this.applicationArguments = applicationArguments;
        this.apiInvoiceConnector = apiInvoiceConnector;
    }

    @RequestMapping("/getInvoices")
    public String getInvoices() throws IOException {
        String[] args = applicationArguments.getSourceArgs();
        apiInvoiceConnector.setClientId(args[0]);
        apiInvoiceConnector.setSecret(args[1]);
        return apiInvoiceConnector.getInvoices();
    }

    @RequestMapping("/getInvoices/{id}")
    public ApiInvoice getInvoice(@PathVariable long id) throws IOException {
        String[] args = applicationArguments.getSourceArgs();
        apiInvoiceConnector.setClientId(args[0]);
        apiInvoiceConnector.setSecret(args[1]);
        return apiInvoiceConnector.getInvoiceById(id);
    }
}
