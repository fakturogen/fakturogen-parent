package pl.fakturogen.comarch.connector.mapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.model.ComarchCustomer;
import pl.fakturogen.comarch.connector.dto.AddressComarchDTO;
import pl.fakturogen.comarch.connector.dto.CustomerComarchDTO;
import pl.fakturogen.comarch.connector.dto.CustomerTypeComarchDTO;

@Component
@Slf4j
public class ComarchCustomerMapper {
    private final ComarchAddressMapper comarchAddressMapper;
    private final ComarchCustomerTypeMapper comarchCustomerTypeMapper;

    public ComarchCustomerMapper(ComarchAddressMapper comarchAddressMapper, ComarchCustomerTypeMapper comarchCustomerTypeMapper) {
        this.comarchAddressMapper = comarchAddressMapper;
        this.comarchCustomerTypeMapper = comarchCustomerTypeMapper;
    }

    public static final int CUSTOMER_TYPE_OSOBA_FIZYCZNA = 0;
    public static final int CUSTOMER_TYPE_PODMIOT_GOSPODARCZY = 1;

    public CustomerComarchDTO from(ComarchCustomer comarchCustomer) {
        log.info("converting from {}", comarchCustomer);
        CustomerComarchDTO customerComarchDTO = new CustomerComarchDTO();
        customerComarchDTO.setIdExternalApi(comarchCustomer.getId().longValue());
        customerComarchDTO.setName(comarchCustomer.getName());
        customerComarchDTO.setCustomerCode(comarchCustomer.getCustomerCode());
        customerComarchDTO.setMail(comarchCustomer.getMail());
        customerComarchDTO.setPhoneNumber(comarchCustomer.getPhoneNumber());

        AddressComarchDTO addressComarchDTO = comarchAddressMapper.from(comarchCustomer.getAddress());

        customerComarchDTO.setAddress(addressComarchDTO);

        Integer customerType = comarchCustomer.getCustomerType();

        if (customerType != null) {
            CustomerTypeComarchDTO customerTypeDTO = comarchCustomerTypeMapper.from(comarchCustomer);
            customerComarchDTO.setCustomerType(customerTypeDTO);
            if (customerType.equals(CUSTOMER_TYPE_OSOBA_FIZYCZNA)) {
                customerComarchDTO.setPesel(comarchCustomer.getCustomerTaxNumber());
            } else if (customerType.equals(CUSTOMER_TYPE_PODMIOT_GOSPODARCZY)) {
                customerComarchDTO.setNip(comarchCustomer.getCustomerTaxNumber());
            }
        }
        log.info("mapping from {} = {}", comarchCustomer, customerComarchDTO);
        return customerComarchDTO;
    }

    public ComarchCustomer from(CustomerComarchDTO customerComarchDTO) {
        log.info("converting from {}", customerComarchDTO);
        ComarchCustomer comarchCustomer = new ComarchCustomer();
        if (customerComarchDTO.getId() != null) {
            comarchCustomer.setId(customerComarchDTO.getId().intValue());
        }
        if (customerComarchDTO.getName() != null) {
            comarchCustomer.setName(customerComarchDTO.getName());
        }
        if (customerComarchDTO.getCustomerCode() != null) {
            comarchCustomer.setCustomerCode(customerComarchDTO.getCustomerCode());
        }
        if (customerComarchDTO.getMail() != null) {
            comarchCustomer.setMail(customerComarchDTO.getMail());
        }
        if (customerComarchDTO.getPhoneNumber() != null) {
            comarchCustomer.setPhoneNumber(customerComarchDTO.getPhoneNumber());
        }

        if (customerComarchDTO.getCustomerType() != null) {
            if (customerComarchDTO.getCustomerType().getId().equals(CUSTOMER_TYPE_OSOBA_FIZYCZNA)) {
                comarchCustomer.setCustomerType(0);
                if (customerComarchDTO.getPesel() != null) {
                    comarchCustomer.setCustomerTaxNumber(customerComarchDTO.getPesel());
                }
            } else {
                comarchCustomer.setCustomerType(1);
                if (customerComarchDTO.getNip() != null) {
                    comarchCustomer.setCustomerTaxNumber(customerComarchDTO.getNip());
                }
            }
        } else {
            comarchCustomer.setCustomerType(1);
            if (customerComarchDTO.getNip() != null) {
                comarchCustomer.setCustomerTaxNumber(customerComarchDTO.getNip());
            }
        }

        log.info("mapping from {} = {}", customerComarchDTO, comarchCustomer);
        return comarchCustomer;
    }
}

