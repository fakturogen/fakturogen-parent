package pl.fakturogen.comarch.connector.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.fakturogen.comarch.connector.model.ComarchAddress;
import pl.fakturogen.comarch.connector.model.ComarchCustomer;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void test1() throws JsonProcessingException {
        ComarchCustomer expectedComarchCustomer = initComarchCustomerObject();
        String json = objectMapper.writeValueAsString(expectedComarchCustomer);
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



    public ComarchCustomer initComarchCustomerObject(){

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
