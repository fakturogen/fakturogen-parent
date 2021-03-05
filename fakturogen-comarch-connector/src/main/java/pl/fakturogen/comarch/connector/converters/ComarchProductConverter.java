package pl.fakturogen.comarch.connector.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.model.ComarchProduct;

import java.util.List;

@Component
@Slf4j
public class ComarchProductConverter {

    public ComarchProduct from(String productJson) throws JsonProcessingException {
        log.info("from {{}}", productJson);
        ObjectMapper mapper = new ObjectMapper();
        ComarchProduct product = mapper.readValue(productJson, ComarchProduct.class);
        log.info("to {{}}", product);
        return product;
    }

    public List<ComarchProduct> fromList(String productListJson) throws JsonProcessingException {
        log.info("from {{}}", productListJson);
        ObjectMapper mapper = new ObjectMapper();

        List<ComarchProduct> product = mapper.readValue(productListJson, new TypeReference<>() {});
        log.info("to {{}}", product);
        return product;
    }
}
