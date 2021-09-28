package pl.fakturogen.comarch.connector.services.impl;

import org.springframework.stereotype.Service;
import pl.fakturogen.comarch.connector.connector.ComarchApiInvoiceConnector;
import pl.fakturogen.comarch.connector.dto.ComarchInvoiceDTO;
import pl.fakturogen.comarch.connector.exeption.ComarchHttpConnectorException;
import pl.fakturogen.comarch.connector.exeption.InvoiceNotFoundException;
import pl.fakturogen.comarch.connector.exeption.InvoicesNotFoundException;
import pl.fakturogen.comarch.connector.mapper.ComarchInvoiceMapper;
import pl.fakturogen.comarch.connector.model.ComarchInvoice;
import pl.fakturogen.comarch.connector.services.ComarchInvoiceService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@Service
public class ComarchInvoiceServiceDefault implements ComarchInvoiceService {
    private ComarchApiInvoiceConnector connector;
    private ComarchInvoiceMapper comarchInvoiceMapper;

    public ComarchInvoiceServiceDefault(ComarchApiInvoiceConnector connector, ComarchInvoiceMapper comarchInvoiceMapper) {
        this.connector = connector;
        this.comarchInvoiceMapper = comarchInvoiceMapper;
    }

    @Override
    public ComarchInvoiceDTO read(long id) {
        Optional<ComarchInvoiceDTO> comarchInvoiceDTO = Optional.empty();
        try {
            ComarchInvoice invoiceById = connector.getInvoiceById(id);
            comarchInvoiceDTO = Optional.of(comarchInvoiceMapper.from(invoiceById));
        } catch (IOException | ComarchHttpConnectorException e) {
            e.printStackTrace();
        }
        return comarchInvoiceDTO.orElseThrow(() -> new InvoiceNotFoundException(id));
    }

    @Override
    public List<ComarchInvoiceDTO> readAll() {
        Optional<List<ComarchInvoiceDTO>> comarchInvoiceDTOList = Optional.empty();
        try {
            List<ComarchInvoice> invoices = connector.getInvoices();
            comarchInvoiceDTOList = Optional.of(comarchInvoiceMapper.from(invoices));

        } catch (IOException | ComarchHttpConnectorException ex) {
            ex.printStackTrace();
        }

        return comarchInvoiceDTOList.orElseThrow(() -> new InvoicesNotFoundException());
    }

}
