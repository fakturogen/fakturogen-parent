package pl.fakturogen.comarch.connector.services;

import pl.fakturogen.comarch.connector.dto.ComarchCustomerDTO;
import pl.fakturogen.comarch.connector.exception.ComarchConnectorException;

import java.util.List;
import java.util.Optional;

public interface ComarchCustomerService {

    Optional<ComarchCustomerDTO> read(Long id) throws ComarchConnectorException;
    List<ComarchCustomerDTO> readAll() throws ComarchConnectorException;
}
