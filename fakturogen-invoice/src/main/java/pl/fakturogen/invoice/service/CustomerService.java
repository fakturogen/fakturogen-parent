package pl.fakturogen.invoice.service;

import org.springframework.stereotype.Service;
import pl.fakturogen.invoice.web.dto.CustomerDTO;

import java.util.Optional;

@Service
public interface CustomerService {

    CustomerDTO create(CustomerDTO customerDTO);
    Optional<CustomerDTO> read(long id);
    Optional<CustomerDTO> findByExternalId(long id);

}
