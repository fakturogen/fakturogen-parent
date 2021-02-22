package pl.fakturogen.comarchconnector.connector;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Component
public class ComarchApiTokenConnector {

    private String clientId;
    private String secret;
    private String url = "https://app.erpxt.pl/api2/public/token";

    public ComarchApiTokenConnector() {
    }

    @Autowired
    public ComarchApiTokenConnector(String clientId, String secret) {
        this.clientId = clientId;
        this.secret = secret;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

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
                .url(url)
                .headers(headers)
                .post(requestBody)
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        //z response wyciagnac token
        return response.body().string();
    }


}
