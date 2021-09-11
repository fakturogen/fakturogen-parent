package pl.fakturogen.invoice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.fakturogen.invoice.dao.entity.Customer;
import pl.fakturogen.invoice.dao.repository.CustomerRepository;
import pl.fakturogen.invoice.exception.CustomerException;
import pl.fakturogen.invoice.service.CustomerService;
import pl.fakturogen.invoice.service.mapper.CustomerMapper;
import pl.fakturogen.invoice.web.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author ewa-git
 */

@Slf4j
@Service
public class CustomerServiceDefault implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceDefault(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) throws CustomerException {
        try {
            Customer customer = customerMapper.from(customerDTO);
            Customer customerSaved = customerRepository.save(customer);
            return customerMapper.from(customerSaved);
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
            throw new CustomerException("There was an unexpected error during saving customer in database");
        }
    }

    @Override
    public Optional<CustomerDTO> read(Long id) throws CustomerException {
        try {
            Optional<Customer> optionalCustomer = customerRepository.findById(id);
            CustomerDTO customerDTO = null;
            if (optionalCustomer.isPresent()) {
                customerDTO = customerMapper.from(optionalCustomer.get());
            }
            return Optional.ofNullable(customerDTO);
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
            throw new CustomerException("There was an unexpected error during finding customer in database");
        }

    }

    @Override
    public List<CustomerDTO> readAll() throws CustomerException {
        try {
            List<Customer> customerList = customerRepository.findAll();
            List<CustomerDTO> customerDTOList = customerList.stream()
                    .map(customer -> customerMapper.from(customer))
                    .collect(Collectors.toList());
            return customerDTOList;

        } catch (Exception e) {
            log.warn(e.getMessage(), e);
            throw new CustomerException("There was an unexpected error during finding all customers in database");
        }
    }
}
