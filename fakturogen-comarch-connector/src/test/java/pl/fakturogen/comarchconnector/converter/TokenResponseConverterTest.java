package pl.fakturogen.comarchconnector.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.fakturogen.comarch.connector.model.ApiToken;
import pl.fakturogen.comarch.converter.TokenResponseConverter;

import static org.assertj.core.api.Assertions.assertThat;
@DisplayName("Converter for token")
class TokenResponseConverterTest {

    @DisplayName(" - should return all fields")
    @Test
    void test1() throws JsonProcessingException {
        TokenResponseConverter tokenResponseConverter = new TokenResponseConverter();

        String json = "{\"access_token\":\"GXwAb03xC+V1xbUzoSJ5YQ00009b8f35\",\"token_type\":\"bearer\",\"expires\":600}";


        ApiToken expected = new ApiToken();
        expected.setAccessToken("GXwAb03xC+V1xbUzoSJ5YQ00009b8f35");
        expected.setTokenType("bearer");
        expected.setExpires(600);


        ApiToken actual = tokenResponseConverter.toObject(json);

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

        String json = "";

        ApiToken actual = tokenResponseConverter.toObject(json);

        Assertions.assertAll(
                () -> assertThat(actual.getAccessToken()).isNull(),
                () -> assertThat(actual.getTokenType()).isNull(),
                () -> assertThat(actual.getExpires()).isNull()
        );
    }
}