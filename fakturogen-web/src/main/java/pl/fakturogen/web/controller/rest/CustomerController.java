package pl.fakturogen.web.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fakturogen.comarch.connector.dto.ComarchCustomerDTO;
import pl.fakturogen.comarch.connector.exeption.ComarchConnectorException;
import pl.fakturogen.comarch.connector.mapper.FakturogenCustomerMapper;
import pl.fakturogen.comarch.connector.services.ComarchCustomerService;
import pl.fakturogen.invoice.exception.CustomerException;
import pl.fakturogen.invoice.service.CustomerService;
import pl.fakturogen.invoice.web.dto.CustomerDTO;
import pl.fakturogen.web.exception.CustomerNotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private ComarchCustomerService comarchCustomerService;
    private CustomerService customerService;
    private FakturogenCustomerMapper fakturogenCustomerMapper;

    public CustomerController(ComarchCustomerService comarchCustomerService,
                              CustomerService customerService,
                              FakturogenCustomerMapper fakturogenCustomerMapper) {
        this.comarchCustomerService = comarchCustomerService;
        this.customerService = customerService;
        this.fakturogenCustomerMapper = fakturogenCustomerMapper;
    }

    @GetMapping
    public List<ComarchCustomerDTO> getCustomerList() throws ComarchConnectorException {
        return  comarchCustomerService.readAll();
    }

    @GetMapping("/get/{id}")
    public ComarchCustomerDTO getCustomerById(@PathVariable Long id) throws CustomerNotFoundException, CustomerException, ComarchConnectorException {
        Optional<ComarchCustomerDTO> optionalCustomer = comarchCustomerService.read(id);
        ComarchCustomerDTO comarchCustomerDTO = optionalCustomer.orElseThrow(() -> new CustomerNotFoundException("Couldn't find customer with id " + id));

        CustomerDTO customerDTO = fakturogenCustomerMapper.from(comarchCustomerDTO);
        customerService.create(customerDTO);
        return comarchCustomerDTO;
    }

    @PostMapping
    public Long create(@RequestBody ComarchCustomerDTO comarchCustomerDTO) throws CustomerException {
        CustomerDTO customerDTO = fakturogenCustomerMapper.from(comarchCustomerDTO);
        CustomerDTO customerSavedInDatabase = customerService.create(customerDTO);
        return customerSavedInDatabase.getId();
    }

}
