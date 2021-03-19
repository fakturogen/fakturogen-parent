package pl.fakturogen.comarch.connector.services.impl;

import org.springframework.stereotype.Service;
import pl.fakturogen.comarch.connector.connector.ComarchApiProductConnector;
import pl.fakturogen.comarch.connector.dto.ComarchProductDTO;
import pl.fakturogen.comarch.connector.services.ComarchProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ComarchProductServiceDefault implements ComarchProductService {
    private ComarchApiProductConnector connector;

    public ComarchProductServiceDefault(ComarchApiProductConnector connector) {
        this.connector = connector;
    }

    @Override
    public Optional<ComarchProductDTO> read(Long id) {
        return connector.read(id);
    }

    @Override
    public List<ComarchProductDTO> readAll() {
        return connector.readAll();
    }
}
