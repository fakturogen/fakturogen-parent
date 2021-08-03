package pl.fakturogen.comarch.connector.connector;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.converter.ComarchConverter;
import pl.fakturogen.comarch.connector.exeption.ComarchConnectorException;
import pl.fakturogen.comarch.connector.exeption.connector.ComarchHttpConnectorException;

import java.io.IOException;

@Slf4j
@Component
public class HttpConnectorUtilsDecorator {
    private final HttpConnectorUtils httpConnectorUtils;

    public HttpConnectorUtilsDecorator(HttpConnectorUtils httpConnectorUtils) {
        this.httpConnectorUtils = httpConnectorUtils;
    }

    public <O> O httpGet(String url, Long id, ComarchConverter<O> converter) throws ComarchHttpConnectorException {
        log.info("httpGet({})", url);
        try {
            Response response = httpConnectorUtils.httpGetById(url, id);
            ResponseBody responseBody = response.body();
            if (responseBody != null) {
                String responseString = responseBody.string();
                O convertedResponse = converter.convert(responseString);

                log.info("httpGet() = {}", convertedResponse);
                return convertedResponse;
            }

            log.info("httpGet() = null");
            return null;
        } catch (IOException e) {
            log.warn(e.getMessage(), e);
            throw new ComarchHttpConnectorException(e.getMessage(), e);
        } catch (ComarchConnectorException e) {
            log.warn(e.getMessage(), e);
            throw new ComarchHttpConnectorException(e.getMessage(), e);
        }
    }
}
