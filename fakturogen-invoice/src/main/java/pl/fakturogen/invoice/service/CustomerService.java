package pl.fakturogen.invoice.service;

import org.springframework.stereotype.Service;
import pl.fakturogen.invoice.web.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {

    CustomerDTO create(CustomerDTO customerDTO);
    Optional<CustomerDTO> read(Long id);
    List<CustomerDTO> readAll();
    void update(CustomerDTO customerDTO, Long id);
    void delete(CustomerDTO customerDTO, Long id);
}
