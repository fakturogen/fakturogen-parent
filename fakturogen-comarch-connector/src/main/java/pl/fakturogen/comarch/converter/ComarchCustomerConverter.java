package pl.fakturogen.comarch.converter;

import pl.fakturogen.comarch.api.customer.ComarchCustomer;
import pl.fakturogen.invoice.web.dto.CustomerDTO;

public class ComarchCustomerConverter {

    public static final int CUSTOMER_TYPE_OSOBA_FIZYCZNA = 0;

    public CustomerDTO from(ComarchCustomer comarchCustomer){
        CustomerDTO customerDTO = new CustomerDTO();
        Integer customerType = comarchCustomer.getCustomerType();
        if(customerType != null){
            if (customerType.equals(CUSTOMER_TYPE_OSOBA_FIZYCZNA)) {
//                customerDTO.set
            }
        }
        return customerDTO;
    }
}
