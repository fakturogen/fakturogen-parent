package pl.fakturogen.web.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fakturogen.comarch.connector.dto.ComarchCustomerDTO;
import pl.fakturogen.web.exception.CustomerNotFoundException;
import pl.fakturogen.comarch.connector.mapper.FakturogenCustomerMapper;
import pl.fakturogen.comarch.connector.services.ComarchCustomerService;
import pl.fakturogen.invoice.service.CustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/getCustomer")
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
    public List<ComarchCustomerDTO> getCustomerList(){
        return  comarchCustomerService.readAll();
    }

    @GetMapping("/{id}")
    public ComarchCustomerDTO getCustomerById(@PathVariable Long id) throws CustomerNotFoundException {
        Optional<ComarchCustomerDTO> optionalCustomer = comarchCustomerService.read(id);
        ComarchCustomerDTO comarchCustomerDTO = optionalCustomer.orElseThrow(() -> new CustomerNotFoundException("Couldn't find customer with id " + id));

        return comarchCustomerDTO;
    }
}
