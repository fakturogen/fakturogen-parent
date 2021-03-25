package pl.fakturogen.comarch.connector.services;

import org.springframework.stereotype.Service;
import pl.fakturogen.invoice.web.dto.CustomerDTO;

import java.util.Optional;

@Service
public interface ComarchCustomerService {

    Optional<CustomerDTO> read(long id);

}
