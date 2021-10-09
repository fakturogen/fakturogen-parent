package pl.fakturogen.comarch.connector.services.impl;

import org.springframework.stereotype.Service;
import pl.fakturogen.comarch.connector.connector.ComarchApiInvoiceConnector;
import pl.fakturogen.comarch.connector.dto.ComarchInvoiceDTO;
import pl.fakturogen.comarch.connector.exeption.ComarchConnectorException;
import pl.fakturogen.comarch.connector.exeption.InvoiceNotFoundException;
import pl.fakturogen.comarch.connector.exeption.InvoicesNotFoundException;
import pl.fakturogen.comarch.connector.mapper.ComarchInvoiceMapper;
import pl.fakturogen.comarch.connector.model.ComarchInvoice;
import pl.fakturogen.comarch.connector.services.ComarchInvoiceService;

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
    public ComarchInvoiceDTO read(Long id) throws ComarchConnectorException, ComarchConnectorException {
        // FIXME: refactor Exception handling!
        Optional<ComarchInvoiceDTO> comarchInvoiceDTO = Optional.empty();
//        try {
            ComarchInvoice invoiceById = connector.getInvoiceById(id);
            comarchInvoiceDTO = Optional.of(comarchInvoiceMapper.from(invoiceById));
            return comarchInvoiceDTO.orElseThrow(() -> new InvoiceNotFoundException(id));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public List<ComarchInvoiceDTO> readAll() throws ComarchConnectorException {
        // FIXME: refactor Exception handling!
        Optional<List<ComarchInvoiceDTO>> comarchInvoiceDTOList = Optional.empty();
//        try {
            List<ComarchInvoice> invoices = connector.getInvoices();
            comarchInvoiceDTOList = Optional.of(comarchInvoiceMapper.from(invoices));
            return comarchInvoiceDTOList.orElseThrow(() -> new InvoicesNotFoundException());
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

    }

}
