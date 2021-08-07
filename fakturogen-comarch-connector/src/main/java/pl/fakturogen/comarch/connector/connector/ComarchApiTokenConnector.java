package pl.fakturogen.comarch.connector.connector;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;
import pl.fakturogen.comarch.connector.model.ComarchToken;
import pl.fakturogen.comarch.connector.converter.TokenResponseConverter;

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
    private ApplicationArguments applicationArguments;

    public ComarchApiTokenConnector(TokenResponseConverter tokenResponseConverter, ApplicationArguments applicationArguments) {
        this.tokenResponseConverter = tokenResponseConverter;
        this.applicationArguments = applicationArguments;
        setCredentials();
    }

    private void setCredentials() {
        String[] sourceArgs = applicationArguments.getSourceArgs();
        clientId = sourceArgs[0];
        secret = sourceArgs[1];
    }

    public ComarchToken getToken() throws IOException { // throws ComarchApiTokenException
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

       /* //try catch

        try {
            Response response = call.execute();
            //z response wyciagnac token
            ResponseBody responseBody = response.body();
            // czy responseBody != null
            String json = response.body().string();
        } catch (IOException e) {
            // LOGGER.severe("Komunikat dla użytkownika na www", e);
            //throw new ComarchApiTokenException("Komunikat dla użytkownika na www", e);
        }*/

        Response response = call.execute();
        //z response wyciagnac token
        ResponseBody responseBody = response.body();
        // czy responseBody != null
        String json = response.body().string();

       ComarchToken comarchTokenDetail = tokenResponseConverter.toObject(json);

        return comarchTokenDetail;
    }


    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
