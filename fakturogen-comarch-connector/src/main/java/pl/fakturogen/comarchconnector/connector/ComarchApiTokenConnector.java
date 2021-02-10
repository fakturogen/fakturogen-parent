package pl.fakturogen.comarchconnector.connector;

import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class ComarchApiTokenConnector {

    public String token() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Map<String, String> headersMap = new HashMap<>();
        headersMap.put("Autorization:", String.valueOf(Base64.getEncoder().encode(("key"+":"+"secret").getBytes())));
        Headers headers = Headers.of(headersMap);

        Request request = new Request.Builder()
                .url("")
                .headers(headers)
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        //z response wyciagnac token
        return "";

    }
}
