package pl.fakturogen.comarch.connector.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.fakturogen.comarch.connector.model.ComarchProduct;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComarchProductConverterTest {

    private ObjectMapper objectMapper;
    private ComarchProductConverter comarchProductConverter;

    @BeforeEach
    public void init() {
        objectMapper = new ObjectMapper();
        comarchProductConverter = new ComarchProductConverter();
    }

    @Test
    public void givenEmptyProductJsonShouldConvertToEmptyProductComarch() throws JsonProcessingException {
        ComarchProduct expectedProduct = new ComarchProduct();
        ComarchProduct givenJsonProduct = new ComarchProduct();

        String givenJsonString = objectMapper.writeValueAsString(givenJsonProduct);
        ComarchProduct receivedComarchProduct = comarchProductConverter.from(givenJsonString);

        assertEquals(expectedProduct, receivedComarchProduct);
    }

    @Test
    public void givenProductJsonShouldConvertToProductComarch() throws JsonProcessingException {
        ComarchProduct expectedProduct = initializeProductWithFields();
        ComarchProduct givenJsonProduct = initializeProductWithFields();

        String givenJsonString = objectMapper.writeValueAsString(givenJsonProduct);
        ComarchProduct receivedComarchProduct = comarchProductConverter.from(givenJsonString);

        assertEquals(expectedProduct, receivedComarchProduct);
    }

    @Test
    public void givenEmptyProductListShouldReturnEmptyProductComarchList() throws JsonProcessingException {
        List<ComarchProduct> givenList = new ArrayList<>();
        List<ComarchProduct> expectedList = new ArrayList<>();

        String givenStringList = objectMapper.writeValueAsString(givenList);

        List<ComarchProduct> receivedProductList = comarchProductConverter.fromList(givenStringList);

        assertEquals(expectedList, receivedProductList);
    }

    @Test
    public void givenProductStringListShouldReturnProductComarchList() throws JsonProcessingException {
        List<ComarchProduct> givenList = new ArrayList<>();
        ComarchProduct firstProduct = initializeProductWithFields();
        ComarchProduct secondProduct = new ComarchProduct();
        secondProduct.setId(1111L);
        secondProduct.setProductCode("zzzZZZaaa");

        givenList.add(firstProduct);
        givenList.add(secondProduct);

        List<ComarchProduct> expectedList = List.of(firstProduct, secondProduct);

        String productStringList = objectMapper.writeValueAsString(givenList);

        List<ComarchProduct> receivedList = comarchProductConverter.fromList(productStringList);

        assertEquals(expectedList, receivedList);
    }

    private ComarchProduct initializeProductWithFields() {
        ComarchProduct product = new ComarchProduct();

        String $id = "22_55555_pp_aa";
        String name = "Test Name";
        String description = "Test Description";
        String itemCode = "o2i3o2l23k3";
        String productCode = "code of Product";
        String unitOfMeasurement = "Unit of Measurement";
        Integer rate = 111_222_333;
        Double saleNetPrice = 9999.99;
        Double saleGrossPrice = 123.123;
        Double quantity = 222.01;
        Long id = 7777L;

        product.set$id($id);
        product.setName(name);
        product.setDescription(description);
        product.setItemCode(itemCode);
        product.setProductCode(productCode);
        product.setUnitOfMeasurment(unitOfMeasurement);
        product.setRate(rate);
        product.setSaleNetPrice(saleNetPrice);
        product.setSaleGrossPrice(saleGrossPrice);
        product.setQuantity(quantity);
        product.setId(id);

        return product;
    }


}