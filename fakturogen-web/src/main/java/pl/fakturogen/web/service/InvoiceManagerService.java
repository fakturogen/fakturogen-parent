package pl.fakturogen.web.service;

import org.springframework.stereotype.Service;
import pl.fakturogen.comarch.connector.dto.ComarchInvoiceDTO;
import pl.fakturogen.comarch.connector.mapper.FakturogenInvoiceMapper;
import pl.fakturogen.comarch.connector.services.ComarchInvoiceService;
import pl.fakturogen.invoice.service.InvoiceService;
import pl.fakturogen.invoice.service.exception.InvoiceException;
import pl.fakturogen.invoice.web.dto.CustomerDTO;
import pl.fakturogen.invoice.web.dto.InvoiceDTO;
import pl.fakturogen.invoice.web.dto.InvoiceSaveDTO;
import pl.fakturogen.invoice.web.dto.ProductDTO;

import java.util.List;

@Service
public class InvoiceManagerService {


    private ComarchInvoiceService comarchInvoiceService;
    private FakturogenInvoiceMapper fakturogenInvoiceMapper;
    private CustomerForInvoiceService customerForInvoiceService;
    private ProductForInvoiceService productForInvoiceService;
    private InvoiceService invoiceService;

    public InvoiceManagerService(ComarchInvoiceService comarchInvoiceService, FakturogenInvoiceMapper fakturogenInvoiceMapper, CustomerForInvoiceService customerForInvoiceService, ProductForInvoiceService productForInvoiceService) {
        this.comarchInvoiceService = comarchInvoiceService;
        this.fakturogenInvoiceMapper = fakturogenInvoiceMapper;
        this.customerForInvoiceService = customerForInvoiceService;
        this.productForInvoiceService = productForInvoiceService;
    }

    public InvoiceDTO saveInvoice(long id) throws InvoiceException {
        ComarchInvoiceDTO comarchInvoiceDTO = comarchInvoiceService.read(id);
        InvoiceSaveDTO invoiceToSave = fakturogenInvoiceMapper.from(comarchInvoiceDTO);

        CustomerDTO customerToSave = customerForInvoiceService.getCustomerToSave(comarchInvoiceDTO);
        List<ProductDTO> items = productForInvoiceService.getProduct(comarchInvoiceDTO);

        invoiceToSave.setCustomer(customerToSave);
        invoiceToSave.setItems(items);

        return invoiceService.create(invoiceToSave);
    }


}
