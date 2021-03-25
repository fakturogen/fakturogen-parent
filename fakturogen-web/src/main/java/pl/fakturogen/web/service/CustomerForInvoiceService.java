package pl.fakturogen.web.service;

import org.springframework.stereotype.Service;
import pl.fakturogen.comarch.connector.dto.ComarchCustomerDTO;
import pl.fakturogen.comarch.connector.dto.ComarchInvoiceDTO;
import pl.fakturogen.comarch.connector.mapper.FakturogenCustomerMapper;
import pl.fakturogen.comarch.connector.services.ComarchCustomerService;
import pl.fakturogen.invoice.service.CustomerService;
import pl.fakturogen.invoice.web.dto.CustomerDTO;

@Service
public class CustomerForInvoiceService {

    private ComarchCustomerService comarchCustomerService;
    private FakturogenCustomerMapper fakturogenCustomerMapper;
    private CustomerService customerService;

    public CustomerForInvoiceService(ComarchCustomerService comarchCustomerService,
                                     FakturogenCustomerMapper fakturogenCustomerMapper,
                                     CustomerService customerService) {
        this.comarchCustomerService = comarchCustomerService;
        this.fakturogenCustomerMapper = fakturogenCustomerMapper;
        this.customerService = customerService;
    }

    public CustomerDTO getCustomerToSave(ComarchInvoiceDTO comarchInvoiceDTO) {
        Long purchasingPartyId = Long.valueOf(comarchInvoiceDTO.getPurchasingPartyId());
        ComarchCustomerDTO comarchCustomerDTO = comarchCustomerService.read(purchasingPartyId).orElseThrow(() -> new RuntimeException("Customer not found in external API")); // TODO exception handler
        CustomerDTO customer = fakturogenCustomerMapper.from(comarchCustomerDTO);

        return customerService.findByExternalId(purchasingPartyId).orElse(customer);
    }
}
