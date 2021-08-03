package pl.fakturogen.comarch.connector.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.exeption.converter.ComarchConverterException;
import pl.fakturogen.comarch.connector.model.ComarchCustomer;

import java.util.List;

@Slf4j
@Component
public class ComarchCustomerConverter implements ComarchConverter<ComarchCustomer> {

    @Override
    public ComarchCustomer convert(String bodyString) throws ComarchConverterException {
        return from(bodyString);
    }

    ComarchCustomer from(String customerJson) throws ComarchConverterException {
        log.info("from({})", customerJson);
        try {
            ObjectMapper mapper = new ObjectMapper();
            ComarchCustomer comarchCustomer = mapper.readValue(customerJson, ComarchCustomer.class);
            log.info("from(...) = {}", comarchCustomer);
            return comarchCustomer;
        } catch (JsonProcessingException e) {
            log.warn(e.getMessage(), e);
            throw new ComarchConverterException("Error while parsing JSON with Comarch Customer data.", e);
        }
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
