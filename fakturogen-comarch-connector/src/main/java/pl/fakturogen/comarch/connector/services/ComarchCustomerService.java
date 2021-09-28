package pl.fakturogen.comarch.connector.services;

import pl.fakturogen.comarch.connector.dto.ComarchCustomerDTO;

import java.util.List;
import java.util.Optional;

public interface ComarchCustomerService {

    Optional<ComarchCustomerDTO> read(Long id);
    List<ComarchCustomerDTO> readAll();
}
