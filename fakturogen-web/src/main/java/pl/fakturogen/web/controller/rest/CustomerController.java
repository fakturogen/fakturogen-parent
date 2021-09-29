package pl.fakturogen.web.controller.rest;

import org.springframework.web.bind.annotation.*;
import pl.fakturogen.comarch.connector.connector.ComarchApiCustomerConnector;
import pl.fakturogen.comarch.connector.dto.ComarchAddressDTO;
import pl.fakturogen.comarch.connector.dto.ComarchCustomerDTO;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;
/**
 * @author ewa-git
 */

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
        ComarchCustomerDTO comarchCustomerDTO = optionalCustomer.orElseThrow(() -> new Exception("Customer with id " + id + " was not found"));
//        ComarchCustomerDTO comarchCustomerDTO = optionalCustomer.get();
        return comarchCustomerDTO;
    }

    @PostMapping
    public Long create() throws IOException {
        ComarchCustomerDTO customerComarchDTO = new ComarchCustomerDTO();
        ComarchAddressDTO comarchAddressDTO = new ComarchAddressDTO();
        customerComarchDTO.setName("NAME");
        Random random = new Random();
        customerComarchDTO.setCustomerTaxNumber("K/001");
        customerComarchDTO.setCustomerType(0);
        customerComarchDTO.setCustomerCode(String.valueOf(random.nextInt(100)));
        customerComarchDTO.setMail("MAIL");
        customerComarchDTO.setPhoneNumber("PHONE_NUMBER");
        customerComarchDTO.setAddress(comarchAddressDTO);

        Long externalId = comarchApiCustomerConnector.create(customerComarchDTO);
        return externalId;
    }

}
