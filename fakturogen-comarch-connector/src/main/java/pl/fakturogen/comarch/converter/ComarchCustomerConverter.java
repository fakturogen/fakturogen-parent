package pl.fakturogen.comarch.converter;

import pl.fakturogen.comarch.api.customer.CustomerComarch;
import pl.fakturogen.invoice.web.dto.CustomerDTO;

public class ComarchCustomerConverter {

    public static final int CUSTOMER_TYPE_OSOBA_FIZYCZNA = 0;
    public static final int CUSTOMER_TYPE_PODMIOT_GOSPODARCZY = 1;

    public CustomerDTO from(CustomerComarch customerComarch){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(customerComarch.getName());

        Integer customerType = customerComarch.getCustomerType();
        if(customerType != null){
            if (customerType.equals(CUSTOMER_TYPE_OSOBA_FIZYCZNA)) {
//                customerDTO.setPes
            }
        }
        return customerDTO;
    }
}
