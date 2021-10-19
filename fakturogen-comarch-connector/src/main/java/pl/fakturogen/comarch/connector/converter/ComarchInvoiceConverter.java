package pl.fakturogen.comarch.connector.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.exeption.ComarchConverterException;
import pl.fakturogen.comarch.connector.model.ComarchInvoice;
import pl.fakturogen.invoice.dao.entity.Customer;

import javax.print.attribute.standard.MediaSize;
import java.util.List;
import java.util.logging.Logger;

@Slf4j
@Component
public class ComarchInvoiceConverter {

    private static final Logger LOGGER = Logger.getLogger(ComarchInvoiceConverter.class.getName());

    public ComarchInvoice from(String json) throws JsonProcessingException {
        LOGGER.info("from json string: " + json);
        ObjectMapper mapper = new ObjectMapper();
        ComarchInvoice comarchInvoice = mapper.readValue(json, ComarchInvoice.class);

        LOGGER.info("to object: " + comarchInvoice);
        return comarchInvoice;
    }

    public String from(ComarchInvoice comarchInvoice) throws ComarchConverterException{
        try {
            log.info("from object: " + comarchInvoice);
            ObjectMapper mapper = new ObjectMapper();
            String jsonInvoice = mapper.writeValueAsString(comarchInvoice);
            log.info("To string: {}", jsonInvoice);
            return jsonInvoice;
        } catch (JsonProcessingException ex) {
            log.warn(ex.getMessage(), ex);
            throw new ComarchConverterException("Error while parsing Comarch Invoice data to JSON.", ex);
        }
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
