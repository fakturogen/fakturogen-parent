package pl.fakturogen.comarch.connector.services.impl;

import org.springframework.stereotype.Service;
import pl.fakturogen.comarch.connector.connector.ComarchApiInvoiceConnector;
import pl.fakturogen.comarch.connector.dto.ComarchInvoiceDTO;
import pl.fakturogen.comarch.connector.services.ComarchInvoiceService;

import java.util.List;

@Service
public class ComarchInvoiceServiceDefault implements ComarchInvoiceService{
    private ComarchApiInvoiceConnector comarchApiInvoiceConnector;

    public ComarchInvoiceServiceDefault(ComarchApiInvoiceConnector comarchApiInvoiceConnector) {
    this.comarchApiInvoiceConnector = comarchApiInvoiceConnector;
    }

    @Override
    public ComarchInvoiceDTO read(long id) {
        return null;
    }

    @Override
    public List<ComarchInvoiceDTO> readAll() {
        return null;
    }
}