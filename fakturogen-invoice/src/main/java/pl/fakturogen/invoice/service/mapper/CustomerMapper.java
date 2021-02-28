package pl.fakturogen.invoice.service.mapper;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import pl.fakturogen.invoice.dao.entity.Customer;
import pl.fakturogen.invoice.web.dto.CustomerDTO;

@Component
@Slf4j
public class CustomerMapper {

    private ModelMapper modelMapper;

    public CustomerMapper(){
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public CustomerDTO from(Customer customer){
        log.info("mapping from {}", customer);
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
        log.info("mapping from {} = {}", customer, customerDTO);
        return customerDTO;
    }

    public Customer from(CustomerDTO customerDTO){
        log.info("mapping from {}", customerDTO);
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        log.info("mapping from {} = {}", customerDTO, customer);
        return customer;
    }
}