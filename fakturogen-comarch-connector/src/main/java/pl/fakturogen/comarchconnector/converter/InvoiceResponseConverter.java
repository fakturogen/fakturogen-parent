package pl.fakturogen.comarchconnector.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.model.ApiInvoice;

import java.util.List;
import java.util.logging.Logger;

@Component
public class InvoiceResponseConverter {

    private static final Logger LOGGER = Logger.getLogger(InvoiceResponseConverter.class.getName());

    public ApiInvoice from(String json) throws JsonProcessingException {
        LOGGER.info("from json string: " + json);
        ObjectMapper mapper = new ObjectMapper();
        ApiInvoice apiInvoice = mapper.readValue(json, ApiInvoice.class);
        /*List<ApiItem> items = apiInvoice.getItems().stream()
                .map(item -> mapper.convertValue(item, ApiItem.class))
                .collect(Collectors.toList());*/
        LOGGER.info("to object: " + apiInvoice);
        return apiInvoice;
    }

    public List<ApiInvoice> listFrom(String json) throws JsonProcessingException {
        LOGGER.info("From json string: " + json);
        ObjectMapper mapper = new ObjectMapper();
        List<ApiInvoice> apiInvoices = mapper.readValue(json, mapper.getTypeFactory()
                .constructCollectionType(List.class, ApiInvoice.class));
        //List<ApiItem> collect = apiInvoices.stream().map(item -> mapper.convertValue(item, ApiItem.class)).collect(Collectors.toList());
        return apiInvoices;
    }

}
