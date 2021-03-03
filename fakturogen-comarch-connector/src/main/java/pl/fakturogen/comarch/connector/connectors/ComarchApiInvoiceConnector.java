package pl.fakturogen.comarch.connector.connectors;

import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ComarchApiInvoiceConnector {
    private String clientId;
    private String secret;
    private String url = "https://app.erpxt.pl/api2/public/v1.1/invoices";

    private HttpConnectorUtils httpConnectorUtils;

    public ComarchApiInvoiceConnector(HttpConnectorUtils httpConnectorUtils) {
        this.httpConnectorUtils = httpConnectorUtils;
    }
    public String getInvoices() throws IOException {
        Response response = httpConnectorUtils.httpGetAll(url);
        return response.body().string();
    }
    public String getInvoiceById(long id) throws IOException {
        Response response = httpConnectorUtils.httpGetById(url, id);
        return response.body().string();
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
