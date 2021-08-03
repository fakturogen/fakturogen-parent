package pl.fakturogen.comarch.connector.connector;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import org.springframework.stereotype.Service;
import pl.fakturogen.comarch.connector.converter.ComarchInvoiceConverter;
import pl.fakturogen.comarch.connector.exeption.ComarchConnectorException;
import pl.fakturogen.comarch.connector.exeption.connector.ComarchHttpConnectorException;
import pl.fakturogen.comarch.connector.model.ComarchInvoice;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class ComarchApiInvoiceConnector {
    private String url = "https://app.erpxt.pl/api2/public/v1.1/invoices";

    private HttpConnectorUtils httpConnectorUtils;
    private ComarchInvoiceConverter comarchInvoiceConverter;

    public ComarchApiInvoiceConnector(HttpConnectorUtils httpConnectorUtils, ComarchInvoiceConverter comarchInvoiceConverter) {
        this.httpConnectorUtils = httpConnectorUtils;
        this.comarchInvoiceConverter = comarchInvoiceConverter;
    }

    public List<ComarchInvoice> getInvoices() throws ComarchConnectorException {
        log.info("getInvoices()");
        try {
            Response response = httpConnectorUtils.httpGetAll(url);
            List<ComarchInvoice> comarchInvoices = comarchInvoiceConverter.listFrom(response.body().string());

            log.info("getInvoices() = {}", comarchInvoices);
            return comarchInvoices;
        } catch (JsonProcessingException e) {
            log.warn(e.getMessage(), e);
            throw new ComarchConnectorException(e.getMessage(), e);
        } catch (IOException e) {
            log.warn(e.getMessage(), e);
            throw new ComarchConnectorException(e.getMessage(), e);
        } catch (ComarchHttpConnectorException e) {
            log.warn(e.getMessage(), e);
            throw new ComarchConnectorException(e.getMessage(), e);
        }
    }

    public ComarchInvoice getInvoiceById(Long id) throws ComarchConnectorException {
        log.info("getInvoiceById({})", id);
        try {
            Response response = httpConnectorUtils.httpGetById(url, id);
            ComarchInvoice comarchInvoice = comarchInvoiceConverter.from(response.body().string());

            log.info("getInvoiceById({}) = {}", id, comarchInvoice);
            return comarchInvoice;
        } catch (JsonProcessingException e) {
            log.warn(e.getMessage(), e);
            throw new ComarchConnectorException(e.getMessage(), e);
        } catch (IOException e) {
            log.warn(e.getMessage(), e);
            throw new ComarchConnectorException(e.getMessage(), e);
        } catch (ComarchHttpConnectorException e) {
            log.warn(e.getMessage(), e);
            throw new ComarchConnectorException(e.getMessage(), e);
        }
    }
}
