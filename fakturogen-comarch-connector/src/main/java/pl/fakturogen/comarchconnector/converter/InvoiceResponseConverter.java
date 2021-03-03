package pl.fakturogen.comarchconnector.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.model.ApiInvoice;
import pl.fakturogen.comarch.connector.model.ApiItem;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class InvoiceResponseConverter {

    private static final Logger LOGGER = Logger.getLogger(InvoiceResponseConverter.class.getName());

    public ApiInvoice from(String json) throws JsonProcessingException {
        LOGGER.info("from json string: " + json);
        ObjectMapper mapper = new ObjectMapper();
        ApiInvoice apiInvoice = mapper.readValue(json, ApiInvoice.class);
        List<ApiItem> items = apiInvoice.getItems().stream()
                .map(item -> mapper.convertValue(item, ApiItem.class))
                .collect(Collectors.toList());
        LOGGER.info("to object: " + apiInvoice);
        return apiInvoice;
    }

}
