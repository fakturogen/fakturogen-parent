package pl.fakturogen.comarch.connector.connector;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.exeption.ComarchConnectorException;
import pl.fakturogen.comarch.connector.exeption.connector.ComarchHttpConnectorException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ewa-git
 */

@Slf4j
@Component
public class HttpConnectorUtils {

    private final ComarchApiTokenConnector comarchApiTokenConnector;

    public HttpConnectorUtils(ComarchApiTokenConnector comarchApiTokenConnector) {
        this.comarchApiTokenConnector = comarchApiTokenConnector;
    }

    public Response httpGetAll(String url) throws ComarchHttpConnectorException {
        log.info("httpGetAll({})", url);
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            Map<String, String> headersMap = new HashMap<>();

            String token = comarchApiTokenConnector.getToken().getAccessToken();

            headersMap.put("Authorization", "Bearer " + token);
            Headers headers = Headers.of(headersMap);

            Request request = new Request.Builder()
                    .url(url)
                    .headers(headers)
                    .get()
                    .build();
            Call call = okHttpClient.newCall(request);
            Response response = call.execute();

            log.info("httpGetAll(...) = {}", response);
            return response;
        } catch (IOException e) {
            log.warn(e.getMessage(), e);
            throw new ComarchHttpConnectorException(e.getMessage(), e);
        } catch (ComarchConnectorException e) {
            log.warn(e.getMessage(), e);
            throw new ComarchHttpConnectorException(e.getMessage(), e);
        }
    }

    public Response httpGetById(String url, Long id) throws ComarchHttpConnectorException {
        log.info("httpGetById({})", url);
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            Map<String, String> headersMap = new HashMap<>();

            String token = comarchApiTokenConnector.getToken().getAccessToken();
            headersMap.put("Authorization", "Bearer " + token);
            Headers headers = Headers.of(headersMap);

            String uri = url + "/" + id;
            Request request = new Request.Builder()
                    .url(uri)
                    .headers(headers)
                    .get()
                    .build();
            Call call = okHttpClient.newCall(request);
            Response response = call.execute();

            log.info("httpGetById(...) = {}", response);
            return response;
        } catch (IOException e) {
            log.warn(e.getMessage(), e);
            throw new ComarchHttpConnectorException(e.getMessage(), e);
        } catch (ComarchConnectorException e) {
            log.warn(e.getMessage(), e);
            throw new ComarchHttpConnectorException(e.getMessage(), e);
        }
    }


    public Response httpPost(String url, Object object) throws ComarchHttpConnectorException {
        log.info("httpPost({}, {})", url, object);
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            Map<String, String> headersMap = new HashMap<>();

            String token = comarchApiTokenConnector.getToken().getAccessToken();
            headersMap.put("Authorization", "Bearer " + token);
            Headers headers = Headers.of(headersMap);

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(object);

            MediaType JSON = MediaType.get("application/json; charset=utf-8");
            RequestBody body = RequestBody.create(JSON, json);
            log.info("JSON: {}", json);

            Request request = new Request.Builder()
                    .url(url)
                    .headers(headers)
                    .post(body)
                    .build();
            Call call = okHttpClient.newCall(request);
            Response response = call.execute();

            log.info("httpPost(...) = {}", response);
            return response;
        } catch (IOException e) {
            log.warn(e.getMessage(), e);
            throw new ComarchHttpConnectorException(e.getMessage(), e);
        } catch (ComarchConnectorException e) {
            log.warn(e.getMessage(), e);
            throw new ComarchHttpConnectorException(e.getMessage(), e);
        }
    }
}
