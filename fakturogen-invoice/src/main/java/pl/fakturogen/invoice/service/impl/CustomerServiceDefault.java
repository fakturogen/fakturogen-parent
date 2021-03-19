package pl.fakturogen.invoice.service.impl;

import org.springframework.stereotype.Service;
import pl.fakturogen.invoice.dao.repository.CustomerRepository;
import pl.fakturogen.invoice.service.CustomerService;
import pl.fakturogen.invoice.service.mapper.CustomerMapper;
import pl.fakturogen.invoice.web.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceDefault implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceDefault(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public Optional<CustomerDTO> read(Long id) {
        return Optional.empty();
    }

    @Override
    public List<CustomerDTO> readAll() {
        return null;
    }

    @Override
    public void update(CustomerDTO customerDTO, Long id) {

    }

    @Override
    public void delete(CustomerDTO customerDTO, Long id) {

    }
}
