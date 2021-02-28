package pl.fakturogen.comarch.connector.connectors;

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

@Component
public class HttpConnectorUtils {


    private final ComarchApiTokenConnector comarchApiTokenConnector;
    private final ObjectMapper mapper;

    public HttpConnectorUtils(ComarchApiTokenConnector comarchApiTokenConnector, ObjectMapper mapper) {
        this.comarchApiTokenConnector = comarchApiTokenConnector;
        this.mapper = mapper;
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
        String uri = url + "/"+id;
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


    public void httpPost(String url, Object object) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Map<String, String> headersMap = new HashMap<>();

        String token = comarchApiTokenConnector.getToken().getAccessToken();

        headersMap.put("Authorization", "Bearer " + token);
        Headers headers = Headers.of(headersMap);


        String json = mapper.writeValueAsString(object);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);

        Request request = new Request.Builder()
                .url(url)
                .headers(headers)
                .post(body)
                .build();
        Call call = okHttpClient.newCall(request);

    }
    // ta klasa zawiera listę adresów, pod które są wysyłane zapytania do Comarchu
    // udostępnia metody, które przyjmują typ np. Product i działa na request i response,
    // wysyła na zewnąrz request i otrzymuje response, w którym jest JSON z odpowiedzią z Comarchu, odpowiedź przekazuje
    // do odpowiedniego serwisu, który wywołał tą klasę i serwis przerabia JSONa (wykorzystuje Converter) i serwis wysyła
    // dalej odpowiedź do ComarchDataProvider i ten do ExternalApiDataProvider

}
