package pl.fakturogen.comarch.connector;

import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ApiConnector {

/*    private String clientId;
    private String secret;
    private String url = "https://app.erpxt.pl/api2/public/token";

    public String getToken() throws IOException {
        String encoded  = Base64.getEncoder().withoutPadding().encodeToString((clientId + ":" + secret).getBytes());

        OkHttpClient okHttpClient = new OkHttpClient();
        Map<String, String> headersMap = new HashMap<>();

        headersMap.put("Authorization", "Basic " + encoded);
        headersMap.put("Content-Type", "application/x-www-form-urlencoded");
        Headers headers = Headers.of(headersMap);

        RequestBody requestBody = new FormBody.Builder()
                .add("grant_type","client_credentials")
                .build();

        Request request = new Request.Builder()
//                .addHeader("Authorization", "Basic " + encoded)
//                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .url(url)
                .headers(headers)
                .post(requestBody)
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        //z response wyciagnac token
        return response.body().string();
    }*/
    private final ApiTokenProvider apiTokenProvider;
/*    private String clientId;
    private String secret;*/

    public ApiConnector(ApiTokenProvider apiTokenProvider) {
        this.apiTokenProvider = apiTokenProvider;
    }


    public Response httpGet(String url) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Map<String, String> headersMap = new HashMap<>();

        Token token = apiTokenProvider.getToken();

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

    public void httpPost(String url, Object object){
        OkHttpClient okHttpClient = new OkHttpClient();
        Map<String, String> headersMap = new HashMap<>();

        Token token = apiTokenProvider.getToken();

        headersMap.put("Authorization", "Bearer " + token);
        Headers headers = Headers.of(headersMap);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), (byte[]) object);

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
