package pl.fakturogen.comarch.connector.connector;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.converter.ComarchConverter;

@Slf4j
@Component
public class HttpConnectorUtilsDecorator {
    private final HttpConnectorUtils httpConnectorUtils;

    public HttpConnectorUtilsDecorator(HttpConnectorUtils httpConnectorUtils) {
        this.httpConnectorUtils = httpConnectorUtils;
    }

    public <O> O httpGet(String url, Long id, ComarchConverter<O> converter) throws Exception {
        log.info("httpGet({})", url);
        Response response = httpConnectorUtils.httpGetById(url, id);

        ResponseBody responseBody = response.body();
        if (responseBody != null) {
            String responseString = responseBody.string();
            O convertedResponse = converter.convert(responseString);

            log.info("httpGet() = {}", convertedResponse);
            return convertedResponse;
        }

        return null;
    }
}
