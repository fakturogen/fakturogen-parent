package pl.fakturogen.comarch.connector.services;

import org.springframework.stereotype.Service;
import pl.fakturogen.comarch.connector.dto.ComarchInvoiceDTO;
import pl.fakturogen.comarch.connector.exeption.ComarchConnectorException;

import java.util.List;

@Service
public interface ComarchInvoiceService {
    ComarchInvoiceDTO read(Long id) throws ComarchConnectorException;
    List<ComarchInvoiceDTO> readAll() throws ComarchConnectorException;
}
