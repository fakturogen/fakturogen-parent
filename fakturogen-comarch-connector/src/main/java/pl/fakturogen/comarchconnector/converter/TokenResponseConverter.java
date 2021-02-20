package pl.fakturogen.comarchconnector.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import pl.fakturogen.api.token.ApiToken;

import java.util.logging.Logger;

@Component
public class TokenResponseConverter {

    private static final Logger LOGGER = Logger.getLogger(TokenResponseConverter.class.getName());

    public ApiToken toObject(String json) throws JsonProcessingException {

        LOGGER.info("toObject () = " + json);
        ObjectMapper mapper = new ObjectMapper();

        ApiToken token = mapper.readValue(json, ApiToken.class);
        /*JsonNode node = mapper.readTree(json);
        ApiToken token = new ApiToken();
        token.setAccessToken(node.get("access_token").asText());
        token.setTokenType(node.get("token_type").asText());
        token.setExpires(node.get("expires").asInt());*/
        LOGGER.info("toObject () = " + token);
        return token;
    }
}
