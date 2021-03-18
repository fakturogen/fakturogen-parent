package pl.fakturogen.comarch.connector.services.impl;

import org.springframework.stereotype.Service;
import pl.fakturogen.comarch.connector.connector.ComarchApiInvoiceConnector;
import pl.fakturogen.comarch.connector.dto.ComarchInvoiceDTO;
import pl.fakturogen.comarch.connector.mapper.ComarchInvoiceMapper;
import pl.fakturogen.comarch.connector.model.ComarchInvoice;
import pl.fakturogen.comarch.connector.services.ComarchInvoiceService;

import java.io.IOException;

@Service
public class ComarchInvoiceServiceDefault implements ComarchInvoiceService {

    private ComarchApiInvoiceConnector connector;
    private ComarchInvoiceMapper comarchInvoiceMapper;

    public ComarchInvoiceServiceDefault(ComarchApiInvoiceConnector connector, ComarchInvoiceMapper comarchInvoiceMapper) {
        this.connector = connector;
        this.comarchInvoiceMapper = comarchInvoiceMapper;
    }

    @Override
    public ComarchInvoiceDTO read(long id) throws IOException {
        ComarchInvoice invoiceById = connector.getInvoiceById(id);
        ComarchInvoiceDTO comarchInvoiceDTO = comarchInvoiceMapper.from(invoiceById);
        return comarchInvoiceDTO;
    }
}
