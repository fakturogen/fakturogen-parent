package pl.fakturogen.comarch.connector.services;

import pl.fakturogen.comarch.connector.dto.ComarchProductDTO;

import java.util.List;
import java.util.Optional;

public interface ComarchProductService {

    Optional<ComarchProductDTO> read(Long id);
    List<ComarchProductDTO> readAll();

}
