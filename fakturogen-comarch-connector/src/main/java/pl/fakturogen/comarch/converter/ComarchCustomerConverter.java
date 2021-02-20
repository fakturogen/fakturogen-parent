package pl.fakturogen.comarch.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.api.customer.CustomerComarch;
import pl.fakturogen.invoice.web.dto.AddressDTO;
import pl.fakturogen.invoice.web.dto.CustomerDTO;

@Component
@Slf4j
public class ComarchCustomerConverter {
    private final ComarchAddressConverter comarchAddressConverter;

    public ComarchCustomerConverter(ComarchAddressConverter comarchAddressConverter) {
        this.comarchAddressConverter = comarchAddressConverter;
    }

    public static final int CUSTOMER_TYPE_OSOBA_FIZYCZNA = 0;
    public static final int CUSTOMER_TYPE_PODMIOT_GOSPODARCZY = 1;

    public CustomerDTO from(CustomerComarch customerComarch){
        log.info("converting from {}", customerComarch);
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setIdExternalApi(customerComarch.getId().longValue());
        customerDTO.setName(customerComarch.getName());
        customerDTO.setCustomerCode(customerComarch.getCustomerCode());
        customerDTO.setMail(customerComarch.getMail());
        customerDTO.setPhoneNumber(customerComarch.getPhoneNumber());

        AddressDTO addressDTO = comarchAddressConverter.from(customerComarch.getAddress());

        customerDTO.setAddress(addressDTO);

        Integer customerType = customerComarch.getCustomerType();

        if(customerType != null){
            if (customerType.equals(CUSTOMER_TYPE_OSOBA_FIZYCZNA)) {
                customerDTO.setPesel(customerComarch.getCustomerTaxNumber());
            } else if (customerType.equals(CUSTOMER_TYPE_PODMIOT_GOSPODARCZY)){
                customerDTO.setNip(customerComarch.getCustomerTaxNumber());
            }
        }
        log.info("mapping from {} = {}", customerComarch, customerDTO);
        return customerDTO;
    }
}
