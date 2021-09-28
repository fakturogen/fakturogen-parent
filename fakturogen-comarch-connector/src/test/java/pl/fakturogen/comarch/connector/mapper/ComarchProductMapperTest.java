package pl.fakturogen.comarch.connector.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.fakturogen.comarch.connector.dto.ComarchProductDTO;
import pl.fakturogen.comarch.connector.model.ComarchProduct;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author damian
 */

class ComarchProductMapperTest {

    private ComarchProductMapper comarchProductMapper;
    private ComarchProduct comarchProduct1;
    private ComarchProduct comarchProduct2;
    private ComarchProductDTO comarchProductDTO1;
    private ComarchProductDTO comarchProductDTO2;

    @BeforeEach
    public void init() {
        comarchProductMapper = new ComarchProductMapper();

        comarchProduct1 = new ComarchProduct();
        comarchProduct1.setName("PRODUCT NAME");
        comarchProduct1.setDescription("EXPECTED DESCRIPTION");
        comarchProduct1.setItemCode("Item code expected");
        comarchProduct1.setProductCode("Some product code");
        comarchProduct1.setUnitOfMeasurment("unit");
        comarchProduct1.setRate(22);
        comarchProduct1.setSaleNetPrice(9999.22);
        comarchProduct1.setSaleGrossPrice(10000.11);
        comarchProduct1.setQuantity(10000.11);
        comarchProduct1.setId(112L);

        comarchProduct2 = new ComarchProduct();
        comarchProduct2.setName("prod name");
        comarchProduct2.setDescription("some description");
        comarchProduct2.setItemCode("item code");
        comarchProduct2.setProductCode("product code");
        comarchProduct2.setUnitOfMeasurment("next unit");
        comarchProduct2.setRate(1);
        comarchProduct2.setSaleNetPrice(11.11);
        comarchProduct2.setSaleGrossPrice(12.23);
        comarchProduct2.setQuantity(1.0);
        comarchProduct2.setId(999911L);

        comarchProductDTO1 = new ComarchProductDTO();
        comarchProductDTO1.setName("PRODUCT NAME");
        comarchProductDTO1.setDescription("EXPECTED DESCRIPTION");
        comarchProductDTO1.setItemCode("Item code expected");
        comarchProductDTO1.setProductCode("Some product code");
        comarchProductDTO1.setUnitOfMeasurment("unit");
        comarchProductDTO1.setRate(22);
        comarchProductDTO1.setSaleNetPrice(9999.22);
        comarchProductDTO1.setSaleGrossPrice(10000.11);
        comarchProductDTO1.setQuantity(10000.11);
        comarchProductDTO1.setId(112L);

        comarchProductDTO2 = new ComarchProductDTO();
        comarchProductDTO2.setName("prod name");
        comarchProductDTO2.setDescription("some description");
        comarchProductDTO2.setItemCode("item code");
        comarchProductDTO2.setProductCode("product code");
        comarchProductDTO2.setUnitOfMeasurment("next unit");
        comarchProductDTO2.setRate(1);
        comarchProductDTO2.setSaleNetPrice(11.11);
        comarchProductDTO2.setSaleGrossPrice(12.23);
        comarchProductDTO2.setQuantity(1.0);
        comarchProductDTO2.setId(999911L);
    }

    @Test
    public void givenComarchProductShouldReturnDTO() {
        ComarchProduct givenProduct = comarchProduct1;
        ComarchProductDTO expectedProduct = comarchProductDTO1;

        ComarchProductDTO resultProduct = comarchProductMapper.from(givenProduct);

        assertEquals(expectedProduct, resultProduct);
    }

    @Test
    public void givenEmptyProductShouldReturnEmptyDTO() {
        ComarchProduct emptyProduct = new ComarchProduct();
        ComarchProductDTO emptyProductDTO = new ComarchProductDTO();
        ComarchProductDTO resultDTO = comarchProductMapper.from(emptyProduct);

        assertEquals(emptyProductDTO, resultDTO);
    }

    @Test
    public void givenProductListShouldReturnDTOList() {
        List<ComarchProduct> comarchProductList = List.of(comarchProduct1, comarchProduct2);
        List<ComarchProductDTO> expectedList = List.of(comarchProductDTO1, comarchProductDTO2);
        List<ComarchProductDTO> comarchProductDTOList = comarchProductMapper.fromList(comarchProductList);

        assertEquals(expectedList, comarchProductDTOList);

    }

    @Test
    public void givenEmptyProductListShouldReturnEmptyDTOList() {
        List<ComarchProduct> comarchProductList = new ArrayList<>();
        List<ComarchProductDTO> expectedList = new ArrayList<>();
        List<ComarchProductDTO> resultListDTO = comarchProductMapper.fromList(comarchProductList);

        assertEquals(expectedList, resultListDTO);
    }

    @Test
    public void givenSeveralItemListShouldReturnSeveralItemDtoList() {
        List<ComarchProduct> comarchProductList = List.of (
                comarchProduct1, comarchProduct2, comarchProduct1, comarchProduct2, comarchProduct1, comarchProduct2);
        int expectedSize = comarchProductList.size();

        List<ComarchProductDTO> resultListDTO = comarchProductMapper.fromList(comarchProductList);
        int resultSize = resultListDTO.size();

        assertEquals(expectedSize, resultSize);
    }
}