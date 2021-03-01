package pl.fakturogen.web.controller.rest;

import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fakturogen.comarch.connector.connectors.HttpConnectorUtils;
import pl.fakturogen.invoice.dao.entity.Customer;

import java.io.IOException;

@RestController
@RequestMapping("/api/get/customer")
public class ConnectorUtilsController {
    public final static String BASE_URL = "https://app.erpxt.pl/api2/public/customers";
    private final HttpConnectorUtils httpConnectorUtils;

    public ConnectorUtilsController(HttpConnectorUtils httpConnectorUtils) {
        this.httpConnectorUtils = httpConnectorUtils;
    }

    @GetMapping
    public String list() throws IOException {
        Response response = httpConnectorUtils.httpGetAll(BASE_URL);
        return response.body().string();
    }

    @GetMapping("/{id}")
    public String read(@PathVariable long id) throws IOException {
        Response response = httpConnectorUtils.httpGetById(BASE_URL, id);
        return response.body().string();
    }

    @PostMapping
    public String create() throws IOException {
        Customer customer = new Customer();
        customer.setName("NAME");
        customer.setNip("NIP");
        customer.setCustomerCode("CUSTOMER_CODE");
        customer.setMail("MAIL");
        customer.setPhoneNumber("PHONE_NUMBER");



        Response response = httpConnectorUtils.httpPost(BASE_URL, customer);
        return response.body().string();
    }

}
