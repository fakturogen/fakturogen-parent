package pl.fakturogen.comarch.connector.services;

import org.springframework.stereotype.Service;
import pl.fakturogen.comarch.connector.dto.ComarchInvoiceDTO;

import java.util.List;

@Service
public interface ComarchInvoiceService {

    ComarchInvoiceDTO read(long id);
    List<ComarchInvoiceDTO> readAll();
}
