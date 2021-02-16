package pl.fakturogen.comarchconnector.connector;

import lombok.Setter;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Setter
public class ComarchApiTokenConnector {

    private String clientId;
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

        String json = response.body().string();

       /* ObjectMapper mapper = new ObjectMapper();
        ApiToken token = mapper.readValue(json, ApiToken.class);*/
        return response.body().string();
    }
}
