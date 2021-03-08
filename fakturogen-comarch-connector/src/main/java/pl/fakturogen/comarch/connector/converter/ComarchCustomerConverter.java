package pl.fakturogen.comarch.connector.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.api.customer.CustomerComarch;
import pl.fakturogen.comarch.connector.dto.AddressComarchDTO;
import pl.fakturogen.comarch.connector.dto.CustomerComarchDTO;
import pl.fakturogen.comarch.connector.dto.CustomerTypeComarchDTO;

@Component
@Slf4j
public class ComarchCustomerConverter {
    private final ComarchAddressConverter comarchAddressConverter;
    private final ComarchCustomerTypeConventer comarchCustomerTypeConventer;

    public ComarchCustomerConverter(ComarchAddressConverter comarchAddressConverter, ComarchCustomerTypeConventer comarchCustomerTypeConventer) {
        this.comarchAddressConverter = comarchAddressConverter;
        this.comarchCustomerTypeConventer = comarchCustomerTypeConventer;
    }

    public static final int CUSTOMER_TYPE_OSOBA_FIZYCZNA = 0;
    public static final int CUSTOMER_TYPE_PODMIOT_GOSPODARCZY = 1;

    public CustomerComarchDTO from(CustomerComarch customerComarch) {
        log.info("converting from {}", customerComarch);
        CustomerComarchDTO customerComarchDTO = new CustomerComarchDTO();
        customerComarchDTO.setIdExternalApi(customerComarch.getId().longValue());
        customerComarchDTO.setName(customerComarch.getName());
        customerComarchDTO.setCustomerCode(customerComarch.getCustomerCode());
        customerComarchDTO.setMail(customerComarch.getMail());
        customerComarchDTO.setPhoneNumber(customerComarch.getPhoneNumber());

        AddressComarchDTO addressComarchDTO = comarchAddressConverter.from(customerComarch.getAddress());

        customerComarchDTO.setAddress(addressComarchDTO);

        Integer customerType = customerComarch.getCustomerType();

        if (customerType != null) {
            CustomerTypeComarchDTO customerTypeDTO = comarchCustomerTypeConventer.from(customerComarch);
            customerComarchDTO.setCustomerType(customerTypeDTO);
            if (customerType.equals(CUSTOMER_TYPE_OSOBA_FIZYCZNA)) {
                customerComarchDTO.setPesel(customerComarch.getCustomerTaxNumber());
            } else if (customerType.equals(CUSTOMER_TYPE_PODMIOT_GOSPODARCZY)) {
                customerComarchDTO.setNip(customerComarch.getCustomerTaxNumber());
            }
        }
        log.info("mapping from {} = {}", customerComarch, customerComarchDTO);
        return customerComarchDTO;
    }

    public CustomerComarch from(CustomerComarchDTO customerComarchDTO) {
        log.info("converting from {}", customerComarchDTO);
        CustomerComarch customerComarch = new CustomerComarch();
        if (customerComarchDTO.getId() != null) {
            customerComarch.setId(customerComarchDTO.getId().intValue());
        }
        if (customerComarchDTO.getName() != null) {
            customerComarch.setName(customerComarchDTO.getName());
        }
        if (customerComarchDTO.getCustomerCode() != null) {
            customerComarch.setCustomerCode(customerComarchDTO.getCustomerCode());
        }
        if (customerComarchDTO.getMail() != null) {
            customerComarch.setMail(customerComarchDTO.getMail());
        }
        if (customerComarchDTO.getPhoneNumber() != null) {
            customerComarch.setPhoneNumber(customerComarchDTO.getPhoneNumber());
        }

        if (customerComarchDTO.getCustomerType() != null) {
            if (customerComarchDTO.getCustomerType().getId().equals(CUSTOMER_TYPE_OSOBA_FIZYCZNA)) {
                customerComarch.setCustomerType(0);
                if (customerComarchDTO.getPesel() != null) {
                    customerComarch.setCustomerTaxNumber(customerComarchDTO.getPesel());
                }
            } else {
                customerComarch.setCustomerType(1);
                if (customerComarchDTO.getNip() != null) {
                    customerComarch.setCustomerTaxNumber(customerComarchDTO.getNip());
                }
            }
        } else {
            customerComarch.setCustomerType(1);
            if (customerComarchDTO.getNip() != null) {
                customerComarch.setCustomerTaxNumber(customerComarchDTO.getNip());
            }
        }

        log.info("mapping from {} = {}", customerComarchDTO, customerComarch);
        return customerComarch;
    }
}
