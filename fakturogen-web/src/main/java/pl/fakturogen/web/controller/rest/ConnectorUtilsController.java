package pl.fakturogen.web.controller.rest;

import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fakturogen.comarch.connector.model.ComarchCustomer;
import pl.fakturogen.comarch.connector.connector.HttpConnectorUtils;
import pl.fakturogen.comarch.connector.dto.CustomerComarchDTO;
import pl.fakturogen.comarch.connector.mapper.ComarchProductMapper;

import java.io.IOException;
import java.util.Random;

@RestController
@RequestMapping("/api/get/customer")
public class ConnectorUtilsController {
    public final static String BASE_URL = "https://app.erpxt.pl/api2/public/customers";
    private final HttpConnectorUtils httpConnectorUtils;
    private final ComarchProductMapper.ComarchCustomerMapper comarchCustomerMapper;

    public ConnectorUtilsController(HttpConnectorUtils httpConnectorUtils, ComarchProductMapper.ComarchCustomerMapper comarchCustomerMapper) {
        this.httpConnectorUtils = httpConnectorUtils;
        this.comarchCustomerMapper = comarchCustomerMapper;
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
        CustomerComarchDTO customerComarchDTO = new CustomerComarchDTO();
        customerComarchDTO.setName("NAME");
        customerComarchDTO.setNip("NIP");
        Random random = new Random();
        customerComarchDTO.setCustomerCode(String.valueOf(random.nextInt(100)));
        customerComarchDTO.setMail("MAIL");
        customerComarchDTO.setPhoneNumber("PHONE_NUMBER");

        ComarchCustomer comarchCustomer = comarchCustomerMapper.from(customerComarchDTO);

        Response response = httpConnectorUtils.httpPost(BASE_URL, comarchCustomer);
        return response.body().string();
    }

}
