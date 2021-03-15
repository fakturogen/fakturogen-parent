package pl.fakturogen.comarch.connector.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.fakturogen.comarch.connector.dto.ComarchProductDTO;
import pl.fakturogen.invoice.dao.entity.Rate;
import pl.fakturogen.invoice.web.dto.ProductDTO;

import static org.junit.jupiter.api.Assertions.*;

class FakturogenProductMapperTest {

    public FakturogenProductMapper fakturogenProductMapper;

    @BeforeEach
    public void init() {
        fakturogenProductMapper = new FakturogenProductMapper();
    }

    @Test
    public void givenComarchProductDTOShouldReturnProductDTO() {
        ComarchProductDTO givenProduct = new ComarchProductDTO();

        givenProduct.setName("product name");
        givenProduct.setDescription("description");
        givenProduct.setItemCode("11zz");
        givenProduct.setUnitOfMeasurment("some unit");
        givenProduct.setSaleNetPrice(99.99);
        givenProduct.setSaleGrossPrice(111.11);
        givenProduct.setRate(1);
        givenProduct.setId(111L);


        ProductDTO expectedDTO = new ProductDTO();
        expectedDTO.setName("product name");
        expectedDTO.setDescription("description");
        expectedDTO.setItemCode("11zz");
        expectedDTO.setUnitOfMeasurement("some unit");
        expectedDTO.setSaleNetPrice(99.99);
        expectedDTO.setSaleGrossPrice(111.11);
        Rate rate = Rate.valueOf("R" + 1);
        expectedDTO.setRate(rate);
        expectedDTO.setIdExternalApi(111L);

        ProductDTO resultDTO = fakturogenProductMapper.from(givenProduct);

        assertEquals(expectedDTO, resultDTO);

    }

}