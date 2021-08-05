package pl.fakturogen.comarch.connector.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.model.ComarchCustomer;

import java.util.List;
/**
 * @author ewa-git
 */

@Component
@Slf4j
public class ComarchCustomerConverter {

    public ComarchCustomer from(String customerJson) throws JsonProcessingException {
        log.info("from {}", customerJson);
        ObjectMapper mapper = new ObjectMapper();
        ComarchCustomer comarchCustomer = mapper.readValue(customerJson, ComarchCustomer.class);
        log.info("mapping from {} = {}", customerJson, comarchCustomer);
        return comarchCustomer;
    }

    public String from(ComarchCustomer comarchCustomer) throws JsonProcessingException {
        log.info("from {}", comarchCustomer);
        ObjectMapper mapper = new ObjectMapper();
        String customerJson = mapper.writeValueAsString(comarchCustomer);
        log.info("mapping from {} = {}", comarchCustomer, customerJson);
        return customerJson;
    }

    public List<ComarchCustomer> fromList(String customerListJson) throws JsonProcessingException {
        log.info("from {}", customerListJson);
        ObjectMapper mapper = new ObjectMapper();
        List<ComarchCustomer> comarchCustomers = mapper.readValue(customerListJson, new TypeReference<>(){});
        log.info("mapping from {} = {}", customerListJson, comarchCustomers);
        return comarchCustomers;
    }

}
