package pl.fakturogen.comarch.connector.services;

import org.springframework.stereotype.Service;
import pl.fakturogen.comarch.connector.dto.ComarchCustomerDTO;

import java.util.Optional;

@Service
public interface ComarchCustomerService {
    //Krzysiek
    Optional<ComarchCustomerDTO> read(Long id);

}
