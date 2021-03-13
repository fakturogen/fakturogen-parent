package pl.fakturogen.comarch.connector.mapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.dto.ComarchProductDTO;
import pl.fakturogen.invoice.dao.entity.Rate;
import pl.fakturogen.invoice.web.dto.ProductDTO;


@Component
@Slf4j
public class FakturogenProductMapper {

    public ProductDTO from(ComarchProductDTO comarchProduct) {
        log.info("from ({})", comarchProduct);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(comarchProduct.getName());
        productDTO.setDescription(comarchProduct.getDescription());
        productDTO.setItemCode(comarchProduct.getItemCode());
        productDTO.setUnitOfMeasurement(comarchProduct.getUnitOfMeasurment());
        productDTO.setSaleNetPrice(comarchProduct.getSaleNetPrice());
        productDTO.setSaleGrossPrice(comarchProduct.getSaleGrossPrice());
        Rate rate = Rate.valueOf("R" + comarchProduct.getRate());
        productDTO.setRate(rate);
        productDTO.setIdExternalApi(comarchProduct.getId());

        log.info("to ({})", productDTO);
        return productDTO;
    }

}
