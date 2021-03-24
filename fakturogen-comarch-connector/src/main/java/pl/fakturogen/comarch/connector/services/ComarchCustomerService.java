package pl.fakturogen.comarch.connector.services;

import pl.fakturogen.invoice.web.dto.CustomerDTO;

import java.util.Optional;

public interface ComarchCustomerService {

    Optional<CustomerDTO> read(long id);

}
