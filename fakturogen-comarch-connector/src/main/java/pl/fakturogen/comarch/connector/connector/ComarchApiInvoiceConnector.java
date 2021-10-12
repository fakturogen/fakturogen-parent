package pl.fakturogen.comarch.connector.connector;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.fakturogen.comarch.connector.converter.ComarchInvoiceConverter;
import pl.fakturogen.comarch.connector.dto.ComarchInvoiceDTO;
import pl.fakturogen.comarch.connector.exeption.ComarchConnectorException;
import pl.fakturogen.comarch.connector.exeption.ComarchConverterException;
import pl.fakturogen.comarch.connector.exeption.connector.ComarchHttpConnectorException;
import pl.fakturogen.comarch.connector.mapper.ComarchInvoiceMapper;
import pl.fakturogen.comarch.connector.model.ComarchInvoice;

import java.io.IOException;
import java.util.List;

/**
 * @author krzysiek
 */

@Slf4j
@Component
public class ComarchApiInvoiceConnector {

    private HttpConnectorUtils httpConnectorUtils;
    private ComarchInvoiceConverter comarchInvoiceConverter;
    private ComarchInvoiceMapper comarchInvoiceMapper;

    private String url = "https://app.erpxt.pl/api2/public/v1.2/invoices";

    public ComarchApiInvoiceConnector(HttpConnectorUtils httpConnectorUtils, ComarchInvoiceConverter comarchInvoiceConverter, ComarchInvoiceMapper comarchInvoiceMapper) {
        this.httpConnectorUtils = httpConnectorUtils;
        this.comarchInvoiceConverter = comarchInvoiceConverter;
        this.comarchInvoiceMapper = comarchInvoiceMapper;
    }

    public List<ComarchInvoice> getInvoices() throws ComarchConnectorException {
        log.info("getInvoices()");
        try {
            Response response = httpConnectorUtils.httpGetAll(url);
            List<ComarchInvoice> comarchInvoices = comarchInvoiceConverter.listFrom(response.body().string());

            log.info("getInvoices() = {}", comarchInvoices);
            return comarchInvoices;
        } catch (ComarchHttpConnectorException | IOException e) {
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
        } catch (ComarchHttpConnectorException | IOException e) {
            log.warn(e.getMessage(), e);
            throw new ComarchConnectorException(e.getMessage(), e);
        }
    }

    public Long create(ComarchInvoiceDTO comarchInvoiceDTO) throws ComarchConverterException {
        log.info("create({})", comarchInvoiceDTO);
        try{
            ComarchInvoice comarchInvoice = comarchInvoiceMapper.from(comarchInvoiceDTO);
            log.info("");
            String jsonToSend = comarchInvoiceConverter.from(comarchInvoice);
            Response response = httpConnectorUtils.httpPost(url, jsonToSend);
            String responseAsString = response.body().string();
            return Long.parseLong(responseAsString);

        } catch (ComarchConverterException | IOException | ComarchHttpConnectorException e) {
            throw new ComarchConverterException("Error during save invoice to external api", e);
        }
    }

}
