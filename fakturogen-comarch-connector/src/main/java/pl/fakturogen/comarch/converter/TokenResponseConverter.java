package pl.fakturogen.comarch.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.model.ApiToken;

import java.util.logging.Logger;

@Component
public class TokenResponseConverter {

    private static final Logger LOGGER = Logger.getLogger(TokenResponseConverter.class.getName());

    public ApiToken toObject(String json) throws JsonProcessingException {

        LOGGER.info("toObject () = " + json);
        ObjectMapper mapper = new ObjectMapper();
        ApiToken token = mapper.readValue(json, ApiToken.class);
        LOGGER.info("toObject () = " + token);
        return token;
    }
}
