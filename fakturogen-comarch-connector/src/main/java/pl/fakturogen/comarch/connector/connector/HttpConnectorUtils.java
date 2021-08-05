package pl.fakturogen.comarch.connector.connector;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/**
 * @author ewa-git
 */

@Component
public class HttpConnectorUtils {


    private final ComarchApiTokenConnector comarchApiTokenConnector;


    public HttpConnectorUtils(ComarchApiTokenConnector comarchApiTokenConnector) {
        this.comarchApiTokenConnector = comarchApiTokenConnector;
    }

    public Response httpGetAll(String url) throws IOException {
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
        return response;
    }

    public Response httpGetById(String url, Long id) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Map<String, String> headersMap = new HashMap<>();

        String token = comarchApiTokenConnector.getToken().getAccessToken();
        String uri = url + "/" + id;
        headersMap.put("Authorization", "Bearer " + token);
        Headers headers = Headers.of(headersMap);

        Request request = new Request.Builder()
                .url(uri)
                .headers(headers)
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        return response;
    }


    public Response httpPost(String url, Object object) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Map<String, String> headersMap = new HashMap<>();
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();

        String token = comarchApiTokenConnector.getToken().getAccessToken();

        headersMap.put("Authorization", "Bearer " + token);
        Headers headers = Headers.of(headersMap);

        String json = mapper.writeValueAsString(object);

        RequestBody body = RequestBody.create(JSON, json);
        System.out.println(json);
        Request request = new Request.Builder()
                .url(url)
                .headers(headers)
                .post(body)
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        return response;

    }


}
