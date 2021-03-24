package pl.fakturogen.invoice.service;

import org.springframework.stereotype.Service;

@Service
public class InvoiceManagerService {
    /*private InvoiceMapper invoiceMapper;
    private ComarchInvoiceService comarchInvoiceService;
    private ComarchCustomerService comarchCustomerService;
    private CustomerService customerService;
    private InvoiceService invoiceService;

    public InvoiceManagerService(InvoiceMapper invoiceMapper, ComarchInvoiceService comarchInvoiceService, ComarchCustomerService comarchCustomerService, CustomerService customerService, InvoiceService invoiceService) {
        this.invoiceMapper = invoiceMapper;
        this.comarchInvoiceService = comarchInvoiceService;
        this.comarchCustomerService = comarchCustomerService;
        this.customerService = customerService;
        this.invoiceService = invoiceService;
    }

    public InvoiceDTO create(long id) {
        ComarchInvoiceDTO comarchInvoiceDTO = comarchInvoiceService.read(id);
        InvoiceSaveDTO invoiceToSave = invoiceMapper.from(comarchInvoiceDTO);

        Integer purchasingPartyId = comarchInvoiceDTO.getPurchasingPartyId();
        Optional<CustomerDTO> customerDTO = customerService.findByExternalId(purchasingPartyId);

        if(customerDTO.isPresent()){
            invoiceToSave.setCustomer(customerDTO.get());
            return invoiceService.create(invoiceToSave);
        }
        Optional<CustomerDTO> comarchCustomer = comarchCustomerService.read(purchasingPartyId);
        comarchCustomer.ifPresent(invoiceToSave::setCustomer);
        return invoiceService.create(invoiceToSave);
    }*/
}
