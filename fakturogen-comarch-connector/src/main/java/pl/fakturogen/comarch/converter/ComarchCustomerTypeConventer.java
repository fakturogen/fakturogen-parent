package pl.fakturogen.comarch.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.api.customer.CustomerComarch;
import pl.fakturogen.invoice.web.dto.CustomerTypeDTO;

@Slf4j
@Component
public class ComarchCustomerTypeConventer {

    public static final int CUSTOMER_TYPE_OSOBA_FIZYCZNA = 0;
    public static final int CUSTOMER_TYPE_PODMIOT_GOSPODARCZY = 1;

    public CustomerTypeDTO from(CustomerComarch customerComarch) {
        log.info("converting from {}", customerComarch);
        CustomerTypeDTO customerTypeDTO = new CustomerTypeDTO();
        Integer customerType = customerComarch.getCustomerType();
        if (customerType != null) {
            if (customerType.equals(CUSTOMER_TYPE_OSOBA_FIZYCZNA)) {
                customerTypeDTO.setId(1L);
                customerTypeDTO.setDescription("osoba fizyczna");
            } else if (customerType.equals(CUSTOMER_TYPE_PODMIOT_GOSPODARCZY)) {
                customerTypeDTO.setId(2L);
                customerTypeDTO.setDescription("podmiot gospodarczy");
            }
        }
        log.info("mapping from {} = {}", customerComarch, customerTypeDTO);
        return customerTypeDTO;
    }
}
