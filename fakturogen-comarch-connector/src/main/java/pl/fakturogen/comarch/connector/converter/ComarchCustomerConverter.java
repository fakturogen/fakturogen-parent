package pl.fakturogen.comarch.connector.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.exeption.ComarchConverterException;
import pl.fakturogen.comarch.connector.model.ComarchCustomer;

import java.util.List;

/**
 * @author ewa-git
 */

@Component
@Slf4j
public class ComarchCustomerConverter implements ComarchConverter {

    @Override
    public ComarchCustomer convert(String bodyString) throws ComarchConverterException {
        return from(bodyString);
    }

    public ComarchCustomer from(String customerJson) throws ComarchConverterException {
        log.info("from {}", customerJson);
        try {
            ObjectMapper mapper = new ObjectMapper();
            ComarchCustomer comarchCustomer = mapper.readValue(customerJson, ComarchCustomer.class);
            log.info("mapping from {} = {}", customerJson, comarchCustomer);
            return comarchCustomer;
        } catch (JsonProcessingException e) {
            log.warn(e.getMessage(), e);
            throw new ComarchConverterException("Error while parsing JSON with Comarch Customer data.", e);
        }

    }

    public String from(ComarchCustomer comarchCustomer) throws ComarchConverterException {
        log.info("from {}", comarchCustomer);
        try {
            ObjectMapper mapper = new ObjectMapper();
            String customerJson = mapper.writeValueAsString(comarchCustomer);
            log.info("mapping from {} = {}", comarchCustomer, customerJson);
            return customerJson;
        } catch (JsonProcessingException e) {
            log.warn(e.getMessage(), e);
            throw new ComarchConverterException("Error while parsing Comarch Customer data to JSON.", e);
        }
    }

    public List<ComarchCustomer> fromList(String customerListJson) throws ComarchConverterException {
        log.info("from {}", customerListJson);
        try{
            ObjectMapper mapper = new ObjectMapper();
            List<ComarchCustomer> comarchCustomers = mapper.readValue(customerListJson, new TypeReference<>() {
            });
            log.info("mapping from {} = {}", customerListJson, comarchCustomers);
            return comarchCustomers;
        }catch (JsonProcessingException e){
            log.warn(e.getMessage(), e);
            throw new ComarchConverterException("Error while parsing JSON list with Comarch Customer data.", e);
        }

    }


}
