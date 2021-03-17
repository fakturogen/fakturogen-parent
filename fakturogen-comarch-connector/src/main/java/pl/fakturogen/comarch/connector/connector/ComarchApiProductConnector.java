package pl.fakturogen.comarch.connector.connector;

import com.fasterxml.jackson.core.JsonProcessingException;
import okhttp3.Response;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.converter.ComarchProductConverter;
import pl.fakturogen.comarch.connector.dto.ComarchProductDTO;
import pl.fakturogen.comarch.connector.mapper.ComarchProductMapper;
import pl.fakturogen.comarch.connector.model.ComarchProduct;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class ComarchApiProductConnector {

    private HttpConnectorUtils httpConnectorUtils;
    private ComarchProductConverter comarchProductConverter;
    private ComarchProductMapper comarchProductMapper;

    private final String productEndpoint = "https://app.erpxt.pl/api2/public/products";

    public ComarchApiProductConnector(HttpConnectorUtils httpConnectorUtils, ComarchProductConverter
            comarchProductConverter, ComarchProductMapper comarchProductMapper) {
        this.httpConnectorUtils = httpConnectorUtils;
        this.comarchProductConverter = comarchProductConverter;
        this.comarchProductMapper = comarchProductMapper;
    }

    public List<ComarchProductDTO> readAll() {
        List<ComarchProductDTO> resultList = new ArrayList<>();
        try {
            Response response = httpConnectorUtils.httpGetAll(productEndpoint);
            String responseString = response.body().string();
            List<ComarchProduct> comarchProductList = comarchProductConverter.fromList(responseString);
            resultList = comarchProductMapper.fromList(comarchProductList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public Optional<ComarchProductDTO> read(Long id) {
        Optional<ComarchProductDTO> optionalProduct = Optional.empty();
        try{
            Response response = httpConnectorUtils.httpGetById(productEndpoint, id);
            String responseString = response.body().string();
            ComarchProduct comarchProduct = comarchProductConverter.from(responseString);
            Map<String, Object> additionalProperties = comarchProduct.getAdditionalProperties();
            boolean codeIsPresent = additionalProperties.containsKey("Code");

            if(codeIsPresent && additionalProperties.get("Code").equals("EntityNotFoundException"))
                return optionalProduct;

            optionalProduct = Optional.of(comarchProductMapper.from(comarchProduct));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return optionalProduct;
    }

}
