package pl.fakturogen.comarch.connector.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.fakturogen.comarch.connector.exception.converter.ComarchConverterException;
import pl.fakturogen.comarch.connector.model.ComarchAddress;
import pl.fakturogen.comarch.connector.model.ComarchCustomer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author ewa-git
 */

@DisplayName("ComarchCustomerConverter specification")
public class ComarchCustomerConverterTest {
    private static final String CUSTOMER_$ID = "1";
    private static final Integer CUSTOMER_ID = 1;
    private static final String NAME = "testowa nazwa";
    private static final String CUSTOMER_TAX_NUMBER = "123";
    private static final String CUSTOMER_CODE = "123";
    private static final String MAIL = "testowy mail";
    private static final String PHONE_NUMBER = "123-456-789";
    private static final Integer CUSTOMER_TYPE = 0;
    private static final String ADDRESS_$ID = "2";
    private static final Integer ADDRESS_ID = 2;
    private static final String STREET = "testowa ulica";
    private static final String BUILDING_NUMBER = "1";
    private static final String FLAT_NUMBER = "1";
    private static final String POSTAL_CODE = "11-111";
    private static final String CITY = "testowa ullica";

    private ObjectMapper objectMapper;
    private ComarchCustomerConverter comarchCustomerConverter;

    @BeforeEach
    void prepareTest() {
        objectMapper = new ObjectMapper();
        comarchCustomerConverter = new ComarchCustomerConverter();
    }

    @Test
    @DisplayName("Should map provided jsonString to ComarchCustomer class")
    public void test1() throws JsonProcessingException, ComarchConverterException {
        ComarchCustomer expectedComarchCustomer = initComarchCustomerObject();
        ComarchCustomer givenJson = initComarchCustomerObject();
        String json = objectMapper.writeValueAsString(givenJson);
        ComarchCustomer convertedComarchCustomer = comarchCustomerConverter.from(json);
        assertAll(() -> assertEquals(expectedComarchCustomer.get$id(), convertedComarchCustomer.get$id()),
                () -> assertEquals(expectedComarchCustomer.getId(), convertedComarchCustomer.getId()),
                () -> assertEquals(expectedComarchCustomer.getName(), convertedComarchCustomer.getName()),
                () -> assertEquals(expectedComarchCustomer.getCustomerTaxNumber(), convertedComarchCustomer.getCustomerTaxNumber()),
                () -> assertEquals(expectedComarchCustomer.getCustomerCode(), convertedComarchCustomer.getCustomerCode()),
                () -> assertEquals(expectedComarchCustomer.getMail(), convertedComarchCustomer.getMail()),
                () -> assertEquals(expectedComarchCustomer.getPhoneNumber(), convertedComarchCustomer.getPhoneNumber()),
                () -> assertEquals(expectedComarchCustomer.getCustomerType(), convertedComarchCustomer.getCustomerType()),
                () -> assertEquals(expectedComarchCustomer.getAddress().get$id(), convertedComarchCustomer.getAddress().get$id()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getId(), convertedComarchCustomer.getAddress().getId()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getStreet(), convertedComarchCustomer.getAddress().getStreet()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getBuildingNumber(), convertedComarchCustomer.getAddress().getBuildingNumber()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getFlatNumber(), convertedComarchCustomer.getAddress().getFlatNumber()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getPostalCode(), convertedComarchCustomer.getAddress().getPostalCode()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getCity(), convertedComarchCustomer.getAddress().getCity()));
    }

    @Test
    @DisplayName("Should map provided empty jsonString to empty ComarchCustomer object")
    public void test2() throws JsonProcessingException, ComarchConverterException {

        ComarchAddress address = new ComarchAddress();
        ComarchCustomer expectedComarchCustomer = new ComarchCustomer();
        expectedComarchCustomer.setAddress(address);
        ComarchCustomer givenJson = new ComarchCustomer();
        givenJson.setAddress(address);
        String json = objectMapper.writeValueAsString(givenJson);
        ComarchCustomer convertedComarchCustomer = comarchCustomerConverter.from(json);
        assertAll(() -> assertEquals(expectedComarchCustomer.get$id(), convertedComarchCustomer.get$id()),
                () -> assertEquals(expectedComarchCustomer.getId(), convertedComarchCustomer.getId()),
                () -> assertEquals(expectedComarchCustomer.getName(), convertedComarchCustomer.getName()),
                () -> assertEquals(expectedComarchCustomer.getCustomerTaxNumber(), convertedComarchCustomer.getCustomerTaxNumber()),
                () -> assertEquals(expectedComarchCustomer.getCustomerCode(), convertedComarchCustomer.getCustomerCode()),
                () -> assertEquals(expectedComarchCustomer.getMail(), convertedComarchCustomer.getMail()),
                () -> assertEquals(expectedComarchCustomer.getPhoneNumber(), convertedComarchCustomer.getPhoneNumber()),
                () -> assertEquals(expectedComarchCustomer.getCustomerType(), convertedComarchCustomer.getCustomerType()),
                () -> assertEquals(expectedComarchCustomer.getAddress().get$id(), convertedComarchCustomer.getAddress().get$id()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getId(), convertedComarchCustomer.getAddress().getId()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getStreet(), convertedComarchCustomer.getAddress().getStreet()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getBuildingNumber(), convertedComarchCustomer.getAddress().getBuildingNumber()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getFlatNumber(), convertedComarchCustomer.getAddress().getFlatNumber()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getPostalCode(), convertedComarchCustomer.getAddress().getPostalCode()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getCity(), convertedComarchCustomer.getAddress().getCity()));
    }

    @Test
    @DisplayName("Should map ComarchCustomer object to json")
    public void test3() throws JsonProcessingException, ComarchConverterException {
        ComarchCustomer givenComarchCustomer = initComarchCustomerObject();
        ComarchCustomer expectedComarchCustomer = initComarchCustomerObject();
        String expectedJson = objectMapper.writeValueAsString(expectedComarchCustomer);
        String convertedJsonComarchCustomer = comarchCustomerConverter.from(givenComarchCustomer);
        assertEquals(expectedJson, convertedJsonComarchCustomer);
    }

    @Test
    @DisplayName("Should map emptyComarchCustomer object to empty json")
    public void test4() throws JsonProcessingException, ComarchConverterException {
        ComarchCustomer givenComarchCustomer = new ComarchCustomer();
        ComarchCustomer expectedComarchCustomer = new ComarchCustomer();
        String expectedJson = objectMapper.writeValueAsString(expectedComarchCustomer);
        String convertedJsonComarchCustomer = comarchCustomerConverter.from(givenComarchCustomer);
        assertEquals(expectedJson, convertedJsonComarchCustomer);
    }

    @Test
    @DisplayName("Should map ComarchCustomerList to ComarchCutomerJsonList")
    public void test5() throws JsonProcessingException, ComarchConverterException {
        ComarchCustomer comarchCustomer1 = initComarchCustomerObject();
        ComarchCustomer comarchCustomer2 = initComarchCustomerObject();
        List<ComarchCustomer> expectedComarchCustomerList = new ArrayList<>();
        expectedComarchCustomerList.add(comarchCustomer1);
        expectedComarchCustomerList.add(comarchCustomer2);

        ComarchCustomer givenComarchCustomer1 = initComarchCustomerObject();
        ComarchCustomer givenComarchCustomer2 = initComarchCustomerObject();
        List<ComarchCustomer> givenComarchCustomerList = new ArrayList<>();
        givenComarchCustomerList.add(givenComarchCustomer1);
        givenComarchCustomerList.add(givenComarchCustomer2);
        String givenJsonList = objectMapper.writeValueAsString(givenComarchCustomerList);

        List<ComarchCustomer> convertedComarchCustomerList = comarchCustomerConverter.fromList(givenJsonList);

        assertAll(
                () -> assertEquals(expectedComarchCustomerList.size(), convertedComarchCustomerList.size()),
                () -> assertEquals(expectedComarchCustomerList.get(0).get$id(), convertedComarchCustomerList.get(0).get$id()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getId(), convertedComarchCustomerList.get(0).getId()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getName(), convertedComarchCustomerList.get(0).getName()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getCustomerTaxNumber(), convertedComarchCustomerList.get(0).getCustomerTaxNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getCustomerCode(), convertedComarchCustomerList.get(0).getCustomerCode()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getMail(), convertedComarchCustomerList.get(0).getMail()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getPhoneNumber(), convertedComarchCustomerList.get(0).getPhoneNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getCustomerType(), convertedComarchCustomerList.get(0).getCustomerType()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().get$id(), convertedComarchCustomerList.get(0).getAddress().get$id()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().getId(), convertedComarchCustomerList.get(0).getAddress().getId()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().getStreet(), convertedComarchCustomerList.get(0).getAddress().getStreet()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().getBuildingNumber(), convertedComarchCustomerList.get(0).getAddress().getBuildingNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().getFlatNumber(), convertedComarchCustomerList.get(0).getAddress().getFlatNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().getPostalCode(), convertedComarchCustomerList.get(0).getAddress().getPostalCode()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().getCity(), convertedComarchCustomerList.get(0).getAddress().getCity()),
                () -> assertEquals(expectedComarchCustomerList.get(1).get$id(), convertedComarchCustomerList.get(1).get$id()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getId(), convertedComarchCustomerList.get(1).getId()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getName(), convertedComarchCustomerList.get(1).getName()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getCustomerTaxNumber(), convertedComarchCustomerList.get(1).getCustomerTaxNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getCustomerCode(), convertedComarchCustomerList.get(1).getCustomerCode()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getMail(), convertedComarchCustomerList.get(1).getMail()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getPhoneNumber(), convertedComarchCustomerList.get(1).getPhoneNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getCustomerType(), convertedComarchCustomerList.get(1).getCustomerType()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().get$id(), convertedComarchCustomerList.get(1).getAddress().get$id()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().getId(), convertedComarchCustomerList.get(1).getAddress().getId()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().getStreet(), convertedComarchCustomerList.get(1).getAddress().getStreet()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().getBuildingNumber(), convertedComarchCustomerList.get(1).getAddress().getBuildingNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().getFlatNumber(), convertedComarchCustomerList.get(1).getAddress().getFlatNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().getPostalCode(), convertedComarchCustomerList.get(1).getAddress().getPostalCode()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().getCity(), convertedComarchCustomerList.get(1).getAddress().getCity()));
    }

    @Test
    @DisplayName("Should map empty ComarchCustomerList to empty ComarchCutomerJsonList")
    public void test6() throws JsonProcessingException, ComarchConverterException {
        ComarchAddress address = new ComarchAddress();
        ComarchCustomer comarchCustomer1 = new ComarchCustomer();
        comarchCustomer1.setAddress(address);
        ComarchCustomer comarchCustomer2 = new ComarchCustomer();
        comarchCustomer2.setAddress(address);
        List<ComarchCustomer> expectedComarchCustomerList = new ArrayList<>();
        expectedComarchCustomerList.add(comarchCustomer1);
        expectedComarchCustomerList.add(comarchCustomer2);

        ComarchCustomer givenComarchCustomer1 = new ComarchCustomer();
        givenComarchCustomer1.setAddress(address);
        ComarchCustomer givenComarchCustomer2 = new ComarchCustomer();
        givenComarchCustomer2.setAddress(address);
        List<ComarchCustomer> givenComarchCustomerList = new ArrayList<>();
        givenComarchCustomerList.add(givenComarchCustomer1);
        givenComarchCustomerList.add(givenComarchCustomer2);
        String givenJsonList = objectMapper.writeValueAsString(givenComarchCustomerList);

        List<ComarchCustomer> convertedComarchCustomerList = comarchCustomerConverter.fromList(givenJsonList);

        assertAll(
                () -> assertEquals(expectedComarchCustomerList.size(), convertedComarchCustomerList.size()),
                () -> assertEquals(expectedComarchCustomerList.get(0).get$id(), convertedComarchCustomerList.get(0).get$id()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getId(), convertedComarchCustomerList.get(0).getId()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getName(), convertedComarchCustomerList.get(0).getName()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getCustomerTaxNumber(), convertedComarchCustomerList.get(0).getCustomerTaxNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getCustomerCode(), convertedComarchCustomerList.get(0).getCustomerCode()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getMail(), convertedComarchCustomerList.get(0).getMail()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getPhoneNumber(), convertedComarchCustomerList.get(0).getPhoneNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getCustomerType(), convertedComarchCustomerList.get(0).getCustomerType()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().get$id(), convertedComarchCustomerList.get(0).getAddress().get$id()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().getId(), convertedComarchCustomerList.get(0).getAddress().getId()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().getStreet(), convertedComarchCustomerList.get(0).getAddress().getStreet()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().getBuildingNumber(), convertedComarchCustomerList.get(0).getAddress().getBuildingNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().getFlatNumber(), convertedComarchCustomerList.get(0).getAddress().getFlatNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().getPostalCode(), convertedComarchCustomerList.get(0).getAddress().getPostalCode()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().getCity(), convertedComarchCustomerList.get(0).getAddress().getCity()),
                () -> assertEquals(expectedComarchCustomerList.get(1).get$id(), convertedComarchCustomerList.get(1).get$id()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getId(), convertedComarchCustomerList.get(1).getId()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getName(), convertedComarchCustomerList.get(1).getName()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getCustomerTaxNumber(), convertedComarchCustomerList.get(1).getCustomerTaxNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getCustomerCode(), convertedComarchCustomerList.get(1).getCustomerCode()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getMail(), convertedComarchCustomerList.get(1).getMail()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getPhoneNumber(), convertedComarchCustomerList.get(1).getPhoneNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getCustomerType(), convertedComarchCustomerList.get(1).getCustomerType()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().get$id(), convertedComarchCustomerList.get(1).getAddress().get$id()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().getId(), convertedComarchCustomerList.get(1).getAddress().getId()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().getStreet(), convertedComarchCustomerList.get(1).getAddress().getStreet()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().getBuildingNumber(), convertedComarchCustomerList.get(1).getAddress().getBuildingNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().getFlatNumber(), convertedComarchCustomerList.get(1).getAddress().getFlatNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().getPostalCode(), convertedComarchCustomerList.get(1).getAddress().getPostalCode()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().getCity(), convertedComarchCustomerList.get(1).getAddress().getCity()));
    }


    public ComarchCustomer initComarchCustomerObject() {

        ComarchAddress comarchAddress = new ComarchAddress();
        comarchAddress.set$id(ADDRESS_$ID);
        comarchAddress.setId(ADDRESS_ID);
        comarchAddress.setStreet(STREET);
        comarchAddress.setBuildingNumber(BUILDING_NUMBER);
        comarchAddress.setFlatNumber(FLAT_NUMBER);
        comarchAddress.setPostalCode(POSTAL_CODE);
        comarchAddress.setCity(CITY);

        ComarchCustomer comarchCustomer = new ComarchCustomer();
        comarchCustomer.set$id(CUSTOMER_$ID);
        comarchCustomer.setId(CUSTOMER_ID);
        comarchCustomer.setName(NAME);
        comarchCustomer.setCustomerTaxNumber(CUSTOMER_TAX_NUMBER);
        comarchCustomer.setCustomerCode(CUSTOMER_CODE);
        comarchCustomer.setMail(MAIL);
        comarchCustomer.setPhoneNumber(PHONE_NUMBER);
        comarchCustomer.setCustomerType(CUSTOMER_TYPE);
        comarchCustomer.setAddress(comarchAddress);

        return comarchCustomer;
    }

}
