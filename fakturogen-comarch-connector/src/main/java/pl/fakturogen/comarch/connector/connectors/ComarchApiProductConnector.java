package pl.fakturogen.comarch.connector.connectors;

import okhttp3.Response;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.converters.ComarchProductConverter;
import pl.fakturogen.comarch.connector.dto.ComarchProductDTO;
import pl.fakturogen.comarch.connector.mapper.ComarchProductMapper;
import pl.fakturogen.comarch.connector.model.ComarchProduct;

import java.io.IOException;
import java.util.List;

@Component
public class ComarchApiProductConnector {

    private HttpConnectorUtils httpConnectorUtils;
    private ComarchProductConverter comarchProductConverter;
    private ComarchProductMapper comarchProductMapper;

    private final String getAllEndpoint = "https://app.erpxt.pl/api2/public/products";
    private final String getByIdEndpoint = "https://app.erpxt.pl/api2/public/products/";

    public ComarchApiProductConnector(HttpConnectorUtils httpConnectorUtils, ComarchProductConverter
            comarchProductConverter, ComarchProductMapper comarchProductMapper) {
        this.httpConnectorUtils = httpConnectorUtils;
        this.comarchProductConverter = comarchProductConverter;
        this.comarchProductMapper = comarchProductMapper;
    }

    public List<ComarchProductDTO> getAllProductList () throws IOException {
        Response response = httpConnectorUtils.httpGetAll(getAllEndpoint);
        String responseString = response.body().string();
        List<ComarchProduct> comarchProductList = comarchProductConverter.fromList(responseString);
        return comarchProductMapper.fromList(comarchProductList);
    }

    public ComarchProductDTO getProductById(Long id) throws IOException {
        Response response = httpConnectorUtils.httpGetById(getByIdEndpoint, id);
        String responseString = response.body().string();
        ComarchProduct comarchProduct = comarchProductConverter.from(responseString);
        return comarchProductMapper.from(comarchProduct);
    }

}
