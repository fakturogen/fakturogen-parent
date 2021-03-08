package pl.fakturogen.comarch.connector.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.model.ComarchInvoice;

import java.util.List;
import java.util.logging.Logger;

@Component
public class InvoiceResponseConverter {

    private static final Logger LOGGER = Logger.getLogger(InvoiceResponseConverter.class.getName());

    public ComarchInvoice from(String json) throws JsonProcessingException {
        LOGGER.info("from json string: " + json);
        ObjectMapper mapper = new ObjectMapper();
        ComarchInvoice comarchInvoice = mapper.readValue(json, ComarchInvoice.class);
        /*List<ApiItem> items = apiInvoice.getItems().stream()
                .map(item -> mapper.convertValue(item, ApiItem.class))
                .collect(Collectors.toList());*/
        LOGGER.info("to object: " + comarchInvoice);
        return comarchInvoice;
    }

    public List<ComarchInvoice> listFrom(String json) throws JsonProcessingException {
        LOGGER.info("From json string: " + json);
        ObjectMapper mapper = new ObjectMapper();
        List<ComarchInvoice> comarchInvoices = mapper.readValue(json, mapper.getTypeFactory()
                .constructCollectionType(List.class, ComarchInvoice.class));
        //List<ApiItem> collect = apiInvoices.stream().map(item -> mapper.convertValue(item, ApiItem.class)).collect(Collectors.toList());
        return comarchInvoices;
    }

}
