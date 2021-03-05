package pl.fakturogen.comarch.connector.connectors;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Service;
import pl.fakturogen.comarch.connector.model.ApiToken;
import pl.fakturogen.comarch.connector.converters.TokenResponseConverter;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class ComarchApiTokenConnector {
    private String clientId;
    private String secret;
    private String url = "https://app.erpxt.pl/api2/public/token";

    private TokenResponseConverter tokenResponseConverter;

    public ComarchApiTokenConnector(TokenResponseConverter tokenResponseConverter) {
        this.tokenResponseConverter = tokenResponseConverter;
    }

    public ApiToken getToken() throws IOException {
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
        ResponseBody responseBody = response.body();

        String json = response.body().string();

       ApiToken apiTokenDetail = tokenResponseConverter.toObject(json);

        return apiTokenDetail;
    }


    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
