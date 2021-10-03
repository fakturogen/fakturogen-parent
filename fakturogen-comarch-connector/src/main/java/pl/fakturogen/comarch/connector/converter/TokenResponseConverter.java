package pl.fakturogen.comarch.connector.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.exeption.converter.ComarchConverterException;
import pl.fakturogen.comarch.connector.model.ComarchToken;

@Slf4j
@Component
public class TokenResponseConverter {

    public ComarchToken toObject(String json) throws ComarchConverterException {
        log.info("toObject({})", json);
        try {
            ObjectMapper mapper = new ObjectMapper();
            ComarchToken comarchToken = mapper.readValue(json, ComarchToken.class);
            log.info("toObject(...) = {}", comarchToken);
            return comarchToken;
        } catch (JsonProcessingException e) {
            log.warn(e.getMessage(), e);
            throw new ComarchConverterException(e.getMessage(), e);
        }
    }
}
