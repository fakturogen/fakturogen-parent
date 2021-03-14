package pl.fakturogen.comarch.connector.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import pl.fakturogen.comarch.connector.dto.ComarchAddressDTO;
import pl.fakturogen.comarch.connector.dto.ComarchCustomerDTO;
import pl.fakturogen.comarch.connector.model.ComarchAddress;
import pl.fakturogen.comarch.connector.model.ComarchCustomer;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("ComarchCustomerMapper specification")
public class ComarchCustomerMapperTest {
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

    private ModelMapper modelMapper;
    private ComarchCustomerMapper comarchCustomerMapper;

    @BeforeEach
    void prepareTest() {
        modelMapper = new ModelMapper();
        comarchCustomerMapper = new ComarchCustomerMapper();
    }

    @Test
    @DisplayName("Should map provided ComarchCustomer to ComarchCustomerDTO class")
    public void test1() {
        ComarchCustomerDTO expectedComarchCustomer = initComarchCustomerDTOObject();
        ComarchCustomer givenComarchCustmer = initComarchCustomerObject();

        ComarchCustomerDTO convertedComarchCustomerDTO = comarchCustomerMapper.from(givenComarchCustmer);
        assertAll(
                () -> assertEquals(expectedComarchCustomer.getId(), convertedComarchCustomerDTO.getId()),
                () -> assertEquals(expectedComarchCustomer.getName(), convertedComarchCustomerDTO.getName()),
                () -> assertEquals(expectedComarchCustomer.getCustomerTaxNumber(), convertedComarchCustomerDTO.getCustomerTaxNumber()),
                () -> assertEquals(expectedComarchCustomer.getCustomerCode(), convertedComarchCustomerDTO.getCustomerCode()),
                () -> assertEquals(expectedComarchCustomer.getMail(), convertedComarchCustomerDTO.getMail()),
                () -> assertEquals(expectedComarchCustomer.getPhoneNumber(), convertedComarchCustomerDTO.getPhoneNumber()),
                () -> assertEquals(expectedComarchCustomer.getCustomerType(), convertedComarchCustomerDTO.getCustomerType()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getId(), convertedComarchCustomerDTO.getAddress().getId()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getStreet(), convertedComarchCustomerDTO.getAddress().getStreet()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getBuildingNumber(), convertedComarchCustomerDTO.getAddress().getBuildingNumber()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getFlatNumber(), convertedComarchCustomerDTO.getAddress().getFlatNumber()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getPostalCode(), convertedComarchCustomerDTO.getAddress().getPostalCode()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getCity(), convertedComarchCustomerDTO.getAddress().getCity()));
    }

    @Test
    @DisplayName("Should map provided empty ComarchCustomer to  empty ComarchCustomerDTO class")
    public void test2() {
        ComarchAddressDTO comarchAddressDTO = new ComarchAddressDTO();
        ComarchCustomerDTO expectedComarchCustomer = new ComarchCustomerDTO();
        expectedComarchCustomer.setAddress(comarchAddressDTO);

        ComarchAddress comarchAddress = new ComarchAddress();
        ComarchCustomer givenComarchCustmer = new ComarchCustomer();
        givenComarchCustmer.setAddress(comarchAddress);

        ComarchCustomerDTO convertedComarchCustomerDTO = comarchCustomerMapper.from(givenComarchCustmer);
        assertAll(
                () -> assertEquals(expectedComarchCustomer.getId(), convertedComarchCustomerDTO.getId()),
                () -> assertEquals(expectedComarchCustomer.getName(), convertedComarchCustomerDTO.getName()),
                () -> assertEquals(expectedComarchCustomer.getCustomerTaxNumber(), convertedComarchCustomerDTO.getCustomerTaxNumber()),
                () -> assertEquals(expectedComarchCustomer.getCustomerCode(), convertedComarchCustomerDTO.getCustomerCode()),
                () -> assertEquals(expectedComarchCustomer.getMail(), convertedComarchCustomerDTO.getMail()),
                () -> assertEquals(expectedComarchCustomer.getPhoneNumber(), convertedComarchCustomerDTO.getPhoneNumber()),
                () -> assertEquals(expectedComarchCustomer.getCustomerType(), convertedComarchCustomerDTO.getCustomerType()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getId(), convertedComarchCustomerDTO.getAddress().getId()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getStreet(), convertedComarchCustomerDTO.getAddress().getStreet()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getBuildingNumber(), convertedComarchCustomerDTO.getAddress().getBuildingNumber()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getFlatNumber(), convertedComarchCustomerDTO.getAddress().getFlatNumber()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getPostalCode(), convertedComarchCustomerDTO.getAddress().getPostalCode()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getCity(), convertedComarchCustomerDTO.getAddress().getCity()));
    }

    @Test
    @DisplayName("Should map provided ComarchCustomerDTO to ComarchCustomer class")
    public void test3() {
        ComarchCustomer expectedComarchCustomer = initComarchCustomerObject();
        ComarchCustomerDTO givenComarchCustmerDTO = initComarchCustomerDTOObject();

        ComarchCustomer convertedComarchCustomer = comarchCustomerMapper.from(givenComarchCustmerDTO);
        assertAll(
                () -> assertEquals(expectedComarchCustomer.getId(), convertedComarchCustomer.getId()),
                () -> assertEquals(expectedComarchCustomer.getName(), convertedComarchCustomer.getName()),
                () -> assertEquals(expectedComarchCustomer.getCustomerTaxNumber(), convertedComarchCustomer.getCustomerTaxNumber()),
                () -> assertEquals(expectedComarchCustomer.getCustomerCode(), convertedComarchCustomer.getCustomerCode()),
                () -> assertEquals(expectedComarchCustomer.getMail(), convertedComarchCustomer.getMail()),
                () -> assertEquals(expectedComarchCustomer.getPhoneNumber(), convertedComarchCustomer.getPhoneNumber()),
                () -> assertEquals(expectedComarchCustomer.getCustomerType(), convertedComarchCustomer.getCustomerType()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getId(), convertedComarchCustomer.getAddress().getId()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getStreet(), convertedComarchCustomer.getAddress().getStreet()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getBuildingNumber(), convertedComarchCustomer.getAddress().getBuildingNumber()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getFlatNumber(), convertedComarchCustomer.getAddress().getFlatNumber()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getPostalCode(), convertedComarchCustomer.getAddress().getPostalCode()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getCity(), convertedComarchCustomer.getAddress().getCity()));
    }

    @Test
    @DisplayName("Should map provided empty ComarchCustomerDTO to empty ComarchCustomer class")
    public void test4() {
        ComarchAddress comarchAddress = new ComarchAddress();
        ComarchCustomer expectedComarchCustomer = new ComarchCustomer();
        expectedComarchCustomer.setAddress(comarchAddress);

        ComarchAddressDTO comarchAddressDTO = new ComarchAddressDTO();
        ComarchCustomerDTO givenComarchCustmerDTO = new ComarchCustomerDTO();
        givenComarchCustmerDTO.setAddress(comarchAddressDTO);

        ComarchCustomer convertedComarchCustomer = comarchCustomerMapper.from(givenComarchCustmerDTO);
        assertAll(
                () -> assertEquals(expectedComarchCustomer.getId(), convertedComarchCustomer.getId()),
                () -> assertEquals(expectedComarchCustomer.getName(), convertedComarchCustomer.getName()),
                () -> assertEquals(expectedComarchCustomer.getCustomerTaxNumber(), convertedComarchCustomer.getCustomerTaxNumber()),
                () -> assertEquals(expectedComarchCustomer.getCustomerCode(), convertedComarchCustomer.getCustomerCode()),
                () -> assertEquals(expectedComarchCustomer.getMail(), convertedComarchCustomer.getMail()),
                () -> assertEquals(expectedComarchCustomer.getPhoneNumber(), convertedComarchCustomer.getPhoneNumber()),
                () -> assertEquals(expectedComarchCustomer.getCustomerType(), convertedComarchCustomer.getCustomerType()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getId(), convertedComarchCustomer.getAddress().getId()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getStreet(), convertedComarchCustomer.getAddress().getStreet()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getBuildingNumber(), convertedComarchCustomer.getAddress().getBuildingNumber()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getFlatNumber(), convertedComarchCustomer.getAddress().getFlatNumber()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getPostalCode(), convertedComarchCustomer.getAddress().getPostalCode()),
                () -> assertEquals(expectedComarchCustomer.getAddress().getCity(), convertedComarchCustomer.getAddress().getCity()));
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

    public ComarchCustomerDTO initComarchCustomerDTOObject() {

        ComarchAddressDTO comarchAddressDTO = new ComarchAddressDTO();
        comarchAddressDTO.setId(ADDRESS_ID);
        comarchAddressDTO.setStreet(STREET);
        comarchAddressDTO.setBuildingNumber(BUILDING_NUMBER);
        comarchAddressDTO.setFlatNumber(FLAT_NUMBER);
        comarchAddressDTO.setPostalCode(POSTAL_CODE);
        comarchAddressDTO.setCity(CITY);

        ComarchCustomerDTO comarchCustomerDTO = new ComarchCustomerDTO();
        comarchCustomerDTO.setId(CUSTOMER_ID);
        comarchCustomerDTO.setName(NAME);
        comarchCustomerDTO.setCustomerTaxNumber(CUSTOMER_TAX_NUMBER);
        comarchCustomerDTO.setCustomerCode(CUSTOMER_CODE);
        comarchCustomerDTO.setMail(MAIL);
        comarchCustomerDTO.setPhoneNumber(PHONE_NUMBER);
        comarchCustomerDTO.setCustomerType(CUSTOMER_TYPE);
        comarchCustomerDTO.setAddress(comarchAddressDTO);

        return comarchCustomerDTO;
    }
}
