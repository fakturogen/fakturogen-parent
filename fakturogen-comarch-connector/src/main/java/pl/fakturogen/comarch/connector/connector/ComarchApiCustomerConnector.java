package pl.fakturogen.comarch.connector.connector;

import com.fasterxml.jackson.core.JsonProcessingException;
import okhttp3.Response;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.converter.ComarchCustomerConverter;
import pl.fakturogen.comarch.connector.dto.ComarchCustomerDTO;
import pl.fakturogen.comarch.connector.exeption.connector.ComarchHttpConnectorException;
import pl.fakturogen.comarch.connector.exeption.converter.ComarchConverterException;
import pl.fakturogen.comarch.connector.mapper.ComarchCustomerMapper;
import pl.fakturogen.comarch.connector.model.ComarchCustomer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * @author ewa-git
 */

@Component
public class ComarchApiCustomerConnector {

    private HttpConnectorUtils httpConnectorUtils;
    private HttpConnectorUtilsDecorator httpConnectorUtilsDecorator;
    private ComarchCustomerConverter comarchCustomerConverter;
    private ComarchCustomerMapper comarchCustomerMapper;

    private final String url = "https://app.erpxt.pl/api2/public/customers";

    public ComarchApiCustomerConnector(HttpConnectorUtils httpConnectorUtils,
                                       HttpConnectorUtilsDecorator httpConnectorUtilsDecorator,
                                       ComarchCustomerConverter comarchCustomerConverter,
                                       ComarchCustomerMapper comarchCustomerMapper) {
        this.httpConnectorUtils = httpConnectorUtils;
        this.httpConnectorUtilsDecorator = httpConnectorUtilsDecorator;
        this.comarchCustomerConverter = comarchCustomerConverter;
        this.comarchCustomerMapper = comarchCustomerMapper;
    }

    public Optional<ComarchCustomerDTO> read(Long id) {
        Optional<ComarchCustomerDTO> optionalCustomerDTO = Optional.empty();
        try {
            ComarchCustomer comarchCustomer = httpConnectorUtilsDecorator.httpGet(url, id, comarchCustomerConverter);
            optionalCustomerDTO = Optional.of(comarchCustomerMapper.from(comarchCustomer));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return optionalCustomerDTO;
    }

    public List<ComarchCustomerDTO> readAll() {
        List<ComarchCustomerDTO> comarchCustomerDTOList = new ArrayList<>();
        try {
            Response response = httpConnectorUtils.httpGetAll(url);
            String responseString = response.body().string();
            List<ComarchCustomer> comarchCustomerList = comarchCustomerConverter.fromList(responseString);
            comarchCustomerDTOList = comarchCustomerMapper.fromList(comarchCustomerList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ComarchHttpConnectorException e) {
            e.printStackTrace();
        } catch (ComarchConverterException e) {
            e.printStackTrace();
        }
        return comarchCustomerDTOList;
    }

    public Long create(ComarchCustomerDTO comarchCustomerDTO) {
        Long externalId = 0L;
        try {
            Response response = httpConnectorUtils.httpPost(url, comarchCustomerDTO);
            String responseString = response.body().string();
            externalId = Long.parseLong(responseString);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ComarchHttpConnectorException e) {
            e.printStackTrace();
        }
        return externalId;
    }

}
