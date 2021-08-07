package pl.fakturogen.comarch.connector.connector;

import okhttp3.Response;
import org.springframework.stereotype.Service;
import pl.fakturogen.comarch.connector.converter.ComarchInvoiceConverter;
import pl.fakturogen.comarch.connector.model.ComarchInvoice;

import java.io.IOException;
import java.util.List;

@Service
public class ComarchApiInvoiceConnector {
    private String clientId;
    private String secret;
    private String url = "https://app.erpxt.pl/api2/public/v1.1/invoices";

    private HttpConnectorUtils httpConnectorUtils;
    private ComarchInvoiceConverter comarchInvoiceConverter;

    public ComarchApiInvoiceConnector(HttpConnectorUtils httpConnectorUtils, ComarchInvoiceConverter comarchInvoiceConverter) {
        this.httpConnectorUtils = httpConnectorUtils;
        this.comarchInvoiceConverter = comarchInvoiceConverter;
    }

    public List<ComarchInvoice> getInvoices() throws IOException {
        Response response = httpConnectorUtils.httpGetAll(url);

        return comarchInvoiceConverter.listFrom(response.body().string());
    }

    public ComarchInvoice getInvoiceById(long id) throws IOException {
        Response response = httpConnectorUtils.httpGetById(url, id);

        return comarchInvoiceConverter.from(response.body().string());
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
