package pl.fakturogen.comarch.connector.mapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.dto.ComarchCustomerDTO;
import pl.fakturogen.invoice.web.dto.AddressDTO;
import pl.fakturogen.invoice.web.dto.CustomerDTO;
import pl.fakturogen.invoice.web.dto.CustomerTypeDTO;
/**
 * @author ewa-git
 */

@Component
@Slf4j
public class FakturogenCustomerMapper {
    private final FakturogenAddressMapper fakturogenAddressMapper;
    private final FakturogenCustomerTypeMapper fakturogenCustomerTypeMapper;

    public FakturogenCustomerMapper(FakturogenAddressMapper comarchAddressToEntityDTOMapper, FakturogenCustomerTypeMapper comarchCustomerTypeToEntityDTOMapper) {
        this.fakturogenAddressMapper = comarchAddressToEntityDTOMapper;
        this.fakturogenCustomerTypeMapper = comarchCustomerTypeToEntityDTOMapper;
    }

    public static final int CUSTOMER_TYPE_OSOBA_FIZYCZNA = 0;
    public static final int CUSTOMER_TYPE_PODMIOT_GOSPODARCZY = 1;

    public CustomerDTO from(ComarchCustomerDTO comarchCustomerDTO) {
        log.info("converting from {}", comarchCustomerDTO);
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setIdExternalApi(comarchCustomerDTO.getId().longValue());
        customerDTO.setName(comarchCustomerDTO.getName());
        customerDTO.setCustomerCode(comarchCustomerDTO.getCustomerCode());
        customerDTO.setMail(comarchCustomerDTO.getMail());
        customerDTO.setPhoneNumber(comarchCustomerDTO.getPhoneNumber());

        AddressDTO addressDTO = fakturogenAddressMapper.from(comarchCustomerDTO.getAddress());

        customerDTO.setAddress(addressDTO);

        Integer customerType = comarchCustomerDTO.getCustomerType();

        if (customerType != null) {
            CustomerTypeDTO customerTypeDTO = fakturogenCustomerTypeMapper.from(comarchCustomerDTO);
            customerDTO.setCustomerType(customerTypeDTO);
            if (customerType.equals(CUSTOMER_TYPE_OSOBA_FIZYCZNA)) {
                customerDTO.setPesel(comarchCustomerDTO.getCustomerTaxNumber());
            } else if (customerType.equals(CUSTOMER_TYPE_PODMIOT_GOSPODARCZY)) {
                customerDTO.setNip(comarchCustomerDTO.getCustomerTaxNumber());
            }
        }
        log.info("mapping from {} = {}", comarchCustomerDTO, customerDTO);
        return customerDTO;
    }

    public ComarchCustomerDTO from(CustomerDTO customerDTO) {
        log.info("converting from {}", customerDTO);
        ComarchCustomerDTO comarchCustomerDTO = new ComarchCustomerDTO();
        if (customerDTO.getId() != null) {
            comarchCustomerDTO.setId(customerDTO.getId().intValue());
        }
        if (customerDTO.getName() != null) {
            comarchCustomerDTO.setName(customerDTO.getName());
        }
        if (customerDTO.getCustomerCode() != null) {
            comarchCustomerDTO.setCustomerCode(customerDTO.getCustomerCode());
        }
        if (customerDTO.getMail() != null) {
            comarchCustomerDTO.setMail(customerDTO.getMail());
        }
        if (customerDTO.getPhoneNumber() != null) {
            comarchCustomerDTO.setPhoneNumber(customerDTO.getPhoneNumber());
        }

        if (customerDTO.getCustomerType() != null) {
            if (customerDTO.getCustomerType().getId().equals(CUSTOMER_TYPE_OSOBA_FIZYCZNA)) {
                comarchCustomerDTO.setCustomerType(0);
                if (customerDTO.getPesel() != null) {
                    comarchCustomerDTO.setCustomerTaxNumber(customerDTO.getPesel());
                }
            } else {
                comarchCustomerDTO.setCustomerType(1);
                if (customerDTO.getNip() != null) {
                    comarchCustomerDTO.setCustomerTaxNumber(customerDTO.getNip());
                }
            }
        } else {
            comarchCustomerDTO.setCustomerType(1);
            if (customerDTO.getNip() != null) {
                comarchCustomerDTO.setCustomerTaxNumber(customerDTO.getNip());
            }
        }
        log.info("mapping from {} = {}", customerDTO, comarchCustomerDTO);
        return comarchCustomerDTO;
    }
}

