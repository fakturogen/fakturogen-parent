package pl.fakturogen.comarch.connector.mapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.model.ComarchCustomer;
import pl.fakturogen.comarch.connector.dto.CustomerTypeComarchDTO;

@Slf4j
@Component
public class ComarchCustomerTypeMapper {

    public static final int CUSTOMER_TYPE_OSOBA_FIZYCZNA = 0;
    public static final int CUSTOMER_TYPE_PODMIOT_GOSPODARCZY = 1;

    public CustomerTypeComarchDTO from(ComarchCustomer comarchCustomer) {
        log.info("converting from {}", comarchCustomer);
        CustomerTypeComarchDTO customerTypeComachDTO = new CustomerTypeComarchDTO();
        Integer customerType = comarchCustomer.getCustomerType();
        if (customerType != null) {
            if (customerType.equals(CUSTOMER_TYPE_OSOBA_FIZYCZNA)) {
                customerTypeComachDTO.setId(1L);
                customerTypeComachDTO.setDescription("osoba fizyczna");
            } else if (customerType.equals(CUSTOMER_TYPE_PODMIOT_GOSPODARCZY)) {
                customerTypeComachDTO.setId(2L);
                customerTypeComachDTO.setDescription("podmiot gospodarczy");
            }
        }
        log.info("mapping from {} = {}", comarchCustomer, customerTypeComachDTO);
        return customerTypeComachDTO;
    }
}
