package pl.fakturogen.comarch.connector.connector;

import okhttp3.Response;
import org.springframework.stereotype.Service;
import pl.fakturogen.comarch.connector.model.ComarchInvoice;
import pl.fakturogen.comarch.connector.converter.InvoiceResponseConverter;

import java.io.IOException;
import java.util.List;

@Service
public class ComarchApiInvoiceConnector {
    private String clientId;
    private String secret;
    private String url = "https://app.erpxt.pl/api2/public/v1.1/invoices";

    private HttpConnectorUtils httpConnectorUtils;
    private InvoiceResponseConverter invoiceResponseConverter;

    public ComarchApiInvoiceConnector(HttpConnectorUtils httpConnectorUtils, InvoiceResponseConverter invoiceResponseConverter) {
        this.httpConnectorUtils = httpConnectorUtils;
        this.invoiceResponseConverter = invoiceResponseConverter;
    }

    public List<ComarchInvoice> getInvoices() throws IOException {
        Response response = httpConnectorUtils.httpGetAll(url);

        return invoiceResponseConverter.listFrom(response.body().string());
    }
    public ComarchInvoice getInvoiceById(long id) throws IOException {
        Response response = httpConnectorUtils.httpGetById(url, id);

        return invoiceResponseConverter.from(response.body().string());
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}