package pl.fakturogen.comarch.connector.connector;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.converter.ComarchCustomerConverter;
import pl.fakturogen.comarch.connector.dto.ComarchCustomerDTO;
import pl.fakturogen.comarch.connector.exeption.ComarchConnectorException;
import pl.fakturogen.comarch.connector.exeption.ComarchHttpConnectorException;
import pl.fakturogen.comarch.connector.mapper.ComarchCustomerMapper;
import pl.fakturogen.comarch.connector.model.ComarchCustomer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ewa-git
 */
@Slf4j
@Component
public class ComarchApiCustomerConnector {

    private HttpConnectorUtils httpConnectorUtils;
    private HttpConnectorUtilsDecorator httpConnectorUtilsDecorator;
    private ComarchCustomerConverter comarchCustomerConverter;
    private ComarchCustomerMapper comarchCustomerMapper;


    @Value("${comarchApiCustomerConnector.url}")
    public String url;
    //   private final String url = "https://app.erpxt.pl/api2/public/customers";

    public ComarchApiCustomerConnector(HttpConnectorUtils httpConnectorUtils,
                                       HttpConnectorUtilsDecorator httpConnectorUtilsDecorator,
                                       ComarchCustomerConverter comarchCustomerConverter,
                                       ComarchCustomerMapper comarchCustomerMapper) {
        this.httpConnectorUtils = httpConnectorUtils;
        this.httpConnectorUtilsDecorator = httpConnectorUtilsDecorator;
        this.comarchCustomerConverter = comarchCustomerConverter;
        this.comarchCustomerMapper = comarchCustomerMapper;
    }

    public Optional<ComarchCustomerDTO> read(Long id) throws ComarchConnectorException {
        Optional<ComarchCustomerDTO> optionalCustomerDTO = Optional.empty();
        try {
            ComarchCustomer comarchCustomer = (ComarchCustomer) httpConnectorUtilsDecorator.httpGet(url, id, comarchCustomerConverter);
            optionalCustomerDTO = Optional.of(comarchCustomerMapper.from(comarchCustomer));
        } catch (ComarchHttpConnectorException e) {
            log.warn(e.getMessage());
            throw new ComarchConnectorException(e.getMessage(), e);
        } catch (Exception e){
            log.warn(e.getMessage());
            throw new ComarchConnectorException(e.getMessage(), e);
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
        }
        return externalId;
    }

}
