package pl.fakturogen.comarch.connector.services.impl;

import org.springframework.stereotype.Service;
import pl.fakturogen.comarch.connector.connector.ComarchApiCustomerConnector;
import pl.fakturogen.comarch.connector.dto.ComarchCustomerDTO;
import pl.fakturogen.comarch.connector.exception.ComarchConnectorException;
import pl.fakturogen.comarch.connector.services.ComarchCustomerService;

import java.util.List;
import java.util.Optional;

@Service
public class ComarchCustomerServiceDefault implements ComarchCustomerService {
    private ComarchApiCustomerConnector comarchApiCustomerConnector;

    public ComarchCustomerServiceDefault(ComarchApiCustomerConnector comarchApiCustomerConnector) {
        this.comarchApiCustomerConnector = comarchApiCustomerConnector;
    }

    @Override
    public Optional<ComarchCustomerDTO> read(Long id) throws ComarchConnectorException {
        return comarchApiCustomerConnector.read(id);
    }

    @Override
    public List<ComarchCustomerDTO> readAll() throws ComarchConnectorException {
        return comarchApiCustomerConnector.readAll();
    }
}
