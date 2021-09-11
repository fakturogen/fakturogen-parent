package pl.fakturogen.invoice.service;

import org.springframework.stereotype.Service;
import pl.fakturogen.invoice.exception.CustomerException;
import pl.fakturogen.invoice.web.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;
/**
 * @author ewa-git
 */

@Service
public interface CustomerService {
    CustomerDTO create(CustomerDTO customerDTO) throws CustomerException;
    Optional<CustomerDTO> read(Long id) throws CustomerException;
    List<CustomerDTO> readAll() throws CustomerException;
}
