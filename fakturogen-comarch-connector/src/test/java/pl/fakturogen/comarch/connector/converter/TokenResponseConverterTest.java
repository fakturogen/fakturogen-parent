package pl.fakturogen.comarch.connector.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.fakturogen.comarch.connector.model.ComarchToken;

import static org.assertj.core.api.Assertions.assertThat;
@DisplayName("Converter for token")
class TokenResponseConverterTest {

    private static final String ACCESS_TOKEN = "GXwAb03xC+V1xbUzoSJ5YQ00009b8f35";
    private static final String TOKEN_TYPE = "bearer";
    private static final int EXPIRES = 600;

    @DisplayName(" - should return all fields")
    @Test
    void test1() throws JsonProcessingException {
        TokenResponseConverter tokenResponseConverter = new TokenResponseConverter();
        ComarchToken comarchToken = new ComarchToken();
        comarchToken.setAccessToken(ACCESS_TOKEN);
        comarchToken.setTokenType(TOKEN_TYPE);
        comarchToken.setExpires(EXPIRES);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(comarchToken);

        ComarchToken expected = new ComarchToken();
        expected.setAccessToken(ACCESS_TOKEN);
        expected.setTokenType(TOKEN_TYPE);
        expected.setExpires(EXPIRES);


        ComarchToken actual = tokenResponseConverter.toObject(json);

        Assertions.assertAll(
                () -> assertThat(actual).isNotNull(),
                () -> assertThat(actual.getAccessToken()).isEqualTo(expected.getAccessToken()),
                () -> assertThat(actual.getTokenType()).isEqualTo(expected.getTokenType()),
                () -> assertThat(actual.getExpires()).isEqualTo(expected.getExpires())
        );
    }

    @DisplayName(" - should give null fields")
    @Test
    void test2() throws JsonProcessingException {
        TokenResponseConverter tokenResponseConverter = new TokenResponseConverter();

        ComarchToken comarchToken = new ComarchToken();
        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(comarchToken);

        ComarchToken actual = tokenResponseConverter.toObject(json);

        Assertions.assertAll(
                () -> assertThat(actual.getAccessToken()).isNull(),
                () -> assertThat(actual.getTokenType()).isNull(),
                () -> assertThat(actual.getExpires()).isNull()
        );
    }
}