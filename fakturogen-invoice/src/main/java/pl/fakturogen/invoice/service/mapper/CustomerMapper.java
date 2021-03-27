package pl.fakturogen.invoice.service.mapper;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import pl.fakturogen.invoice.dao.entity.Address;
import pl.fakturogen.invoice.dao.entity.Customer;
import pl.fakturogen.invoice.web.dto.AddressDTO;
import pl.fakturogen.invoice.web.dto.CustomerDTO;

@Component
@Slf4j
public class CustomerMapper {

    private ModelMapper modelMapper;
    private final AddressMapper addressMapper;


    public CustomerMapper(AddressMapper addressMapper){
        this.addressMapper = addressMapper;
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public CustomerDTO from(Customer customer){
        log.info("mapping from {}", customer);
        AddressDTO addressDTO = addressMapper.from(customer.getAddress());
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
        customerDTO.setAddress(addressDTO);
        log.info("mapping from {} = {}", customer, customerDTO);
        return customerDTO;
    }

    public Customer from(CustomerDTO customerDTO){
        log.info("mapping from {}", customerDTO);
        Address address = addressMapper.from(customerDTO.getAddress());
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customer.setAddress(address);
        log.info("mapping from {} = {}", customerDTO, customer);
        return customer;
    }
}