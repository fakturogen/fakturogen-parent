package pl.fakturogen.comarch.connector.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.model.ComarchToken;

import java.util.logging.Logger;

@Component
public class TokenResponseConverter {

    private static final Logger LOGGER = Logger.getLogger(TokenResponseConverter.class.getName());

    public ComarchToken toObject(String json) throws JsonProcessingException {

        LOGGER.info("toObject () = " + json);
        ObjectMapper mapper = new ObjectMapper();
        ComarchToken token = mapper.readValue(json, ComarchToken.class);
        LOGGER.info("toObject () = " + token);
        return token;
    }
}
