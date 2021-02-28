package pl.fakturogen.web.controller.rest;

import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fakturogen.comarch.connector.connectors.HttpConnectorUtils;

import java.io.IOException;

@RestController
@RequestMapping("/api/get/customer")
public class ConnectorUtilsController {
    public final static String BASE_URL = "/app.erpxt.pl/api2/public/customers";
    private final HttpConnectorUtils httpConnectorUtils;

    public ConnectorUtilsController(HttpConnectorUtils httpConnectorUtils) {
        this.httpConnectorUtils = httpConnectorUtils;
    }

    @GetMapping
    public String list() throws IOException {
        Response response = httpConnectorUtils.httpGetAll(BASE_URL);
        return response.body().string();
    }
}
