package pl.fakturogen.web.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fakturogen.comarch.connector.connector.ComarchApiCustomerConnector;
import pl.fakturogen.comarch.connector.dto.ComarchCustomerDTO;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/api/get/customer")
public class CustomerController {
    private final ComarchApiCustomerConnector comarchApiCustomerConnector;

    public CustomerController(ComarchApiCustomerConnector comarchApiCustomerConnector) {
        this.comarchApiCustomerConnector = comarchApiCustomerConnector;
    }

    @GetMapping
    public List<ComarchCustomerDTO> list() throws IOException {
        return comarchApiCustomerConnector.readAll();
    }

    @GetMapping("/{id}")
    public ComarchCustomerDTO read(@PathVariable long id) throws Exception {
        Optional<ComarchCustomerDTO> optionalCustomer = comarchApiCustomerConnector.read(id);
        //ComarchCustomerDTO comarchCustomerDTO = optionalCustomer.orElseThrow(() -> new Exception("Customer with id " + id + " was not found"));
        // dorobic wyjatek  i zwrocic or else throw
        ComarchCustomerDTO comarchCustomerDTO = optionalCustomer.get();
        return comarchCustomerDTO;
    }

    @PostMapping
    public Long create() throws IOException {
        ComarchCustomerDTO customerComarchDTO = new ComarchCustomerDTO();
        customerComarchDTO.setName("NAME");
        Random random = new Random();
        customerComarchDTO.setCustomerCode(String.valueOf(random.nextInt(100)));
        customerComarchDTO.setMail("MAIL");
        customerComarchDTO.setPhoneNumber("PHONE_NUMBER");

        Long externalId = comarchApiCustomerConnector.create(customerComarchDTO);
        return externalId;
    }

}
