package pl.fakturogen.comarch.connector.services;

import org.springframework.stereotype.Service;
import pl.fakturogen.comarch.connector.dto.ComarchProductDTO;
import pl.fakturogen.comarch.connector.exeption.ComarchConnectorException;

import java.util.List;
import java.util.Optional;

@Service
public interface ComarchProductService {

    Optional<ComarchProductDTO> read(Long id) throws ComarchConnectorException;
    List<ComarchProductDTO> readAll() throws ComarchConnectorException;

}
