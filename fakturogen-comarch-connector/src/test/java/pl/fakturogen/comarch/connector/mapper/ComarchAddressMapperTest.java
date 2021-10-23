package pl.fakturogen.comarch.connector.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import pl.fakturogen.comarch.connector.dto.ComarchAddressDTO;
import pl.fakturogen.comarch.connector.model.ComarchAddress;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("ComarchAddressMapper specification")
public class ComarchAddressMapperTest {

    private static final String ADDRESS_$ID = "2";
    private static final Integer ADDRESS_ID = 2;
    private static final String STREET = "testowa ulica";
    private static final String BUILDING_NUMBER = "1";
    private static final String FLAT_NUMBER = "1";
    private static final String POSTAL_CODE = "11-111";
    private static final String CITY = "testowa ullica";

    private ModelMapper modelMapper;
    private ComarchAddressMapper comarchAddressMapper;


    @BeforeEach
    void prepareTest() {
        modelMapper = new ModelMapper();
        comarchAddressMapper = new ComarchAddressMapper();
    }

    @Test
    @DisplayName("Should map provided ComarchAddress to ComarchAddressDTO class")
    public void test1() {
        ComarchAddressDTO expectedComarchAddress = initComarchAddressDTOObject();
        ComarchAddress givenComarchAddress = initComarchAddressObject();

        ComarchAddressDTO convertedComarchAddressDTO = comarchAddressMapper.from(givenComarchAddress);
        assertAll(

                () -> assertEquals(expectedComarchAddress.getId(), convertedComarchAddressDTO.getId()),
                () -> assertEquals(expectedComarchAddress.getStreet(), convertedComarchAddressDTO.getStreet()),
                () -> assertEquals(expectedComarchAddress.getBuildingNumber(), convertedComarchAddressDTO.getBuildingNumber()),
                () -> assertEquals(expectedComarchAddress.getFlatNumber(), convertedComarchAddressDTO.getFlatNumber()),
                () -> assertEquals(expectedComarchAddress.getPostalCode(), convertedComarchAddressDTO.getPostalCode()),
                () -> assertEquals(expectedComarchAddress.getCity(), convertedComarchAddressDTO.getCity()));
    }

    @Test
    @DisplayName("Should map provided empty ComarchAddress to  empty ComarchAddressDTO class")
    public void test2() {
        ComarchAddressDTO expectedComarchAddressDTO = new ComarchAddressDTO();

        ComarchAddress givenComarchAddress = new ComarchAddress();


        ComarchAddressDTO convertedComarchAddressDTO = comarchAddressMapper.from(givenComarchAddress);
        assertAll(
                () -> assertEquals(expectedComarchAddressDTO.getId(), convertedComarchAddressDTO.getId()),
                () -> assertEquals(expectedComarchAddressDTO.getStreet(), convertedComarchAddressDTO.getStreet()),
                () -> assertEquals(expectedComarchAddressDTO.getBuildingNumber(), convertedComarchAddressDTO.getBuildingNumber()),
                () -> assertEquals(expectedComarchAddressDTO.getFlatNumber(), convertedComarchAddressDTO.getFlatNumber()),
                () -> assertEquals(expectedComarchAddressDTO.getPostalCode(), convertedComarchAddressDTO.getPostalCode()),
                () -> assertEquals(expectedComarchAddressDTO.getCity(), convertedComarchAddressDTO.getCity()));
    }

    @Test
    @DisplayName("Should map provided ComarchAddressDTO to ComarchAddress class")
    public void test3() {
        ComarchAddress expectedComarchAddress = initComarchAddressObject();
        ComarchAddressDTO givenComarchAddressDTO = initComarchAddressDTOObject();

        ComarchAddress convertedComarchAddress = comarchAddressMapper.from(givenComarchAddressDTO);
        assertAll(
                () -> assertEquals(expectedComarchAddress.getId(), convertedComarchAddress.getId()),
                () -> assertEquals(expectedComarchAddress.getStreet(), convertedComarchAddress.getStreet()),
                () -> assertEquals(expectedComarchAddress.getBuildingNumber(), convertedComarchAddress.getBuildingNumber()),
                () -> assertEquals(expectedComarchAddress.getFlatNumber(), convertedComarchAddress.getFlatNumber()),
                () -> assertEquals(expectedComarchAddress.getPostalCode(), convertedComarchAddress.getPostalCode()),
                () -> assertEquals(expectedComarchAddress.getCity(), convertedComarchAddress.getCity()));
    }

    @Test
    @DisplayName("Should map provided empty ComarchAddressDTO to empty ComarchAddress class")
    public void test4() {
        ComarchAddress expectedComarchAddress = new ComarchAddress();

        ComarchAddressDTO givenAomarchAddressDTO = new ComarchAddressDTO();

        ComarchAddress convertedAddressCustomer = comarchAddressMapper.from(givenAomarchAddressDTO);


        assertAll(

                () -> assertEquals(expectedComarchAddress.getId(), convertedAddressCustomer.getId()),
                () -> assertEquals(expectedComarchAddress.getStreet(), convertedAddressCustomer.getStreet()),
                () -> assertEquals(expectedComarchAddress.getBuildingNumber(), convertedAddressCustomer.getBuildingNumber()),
                () -> assertEquals(expectedComarchAddress.getFlatNumber(), convertedAddressCustomer.getFlatNumber()),
                () -> assertEquals(expectedComarchAddress.getPostalCode(), convertedAddressCustomer.getPostalCode()),
                () -> assertEquals(expectedComarchAddress.getCity(), convertedAddressCustomer.getCity()));
    }

    public ComarchAddress initComarchAddressObject() {

        ComarchAddress comarchAddress = new ComarchAddress();
        comarchAddress.set$id(ADDRESS_$ID);
        comarchAddress.setId(ADDRESS_ID);
        comarchAddress.setStreet(STREET);
        comarchAddress.setBuildingNumber(BUILDING_NUMBER);
        comarchAddress.setFlatNumber(FLAT_NUMBER);
        comarchAddress.setPostalCode(POSTAL_CODE);
        comarchAddress.setCity(CITY);

        return comarchAddress;
    }

    public ComarchAddressDTO initComarchAddressDTOObject() {

        ComarchAddressDTO comarchAddressDTO = new ComarchAddressDTO();
        comarchAddressDTO.setId(ADDRESS_ID);
        comarchAddressDTO.setStreet(STREET);
        comarchAddressDTO.setBuildingNumber(BUILDING_NUMBER);
        comarchAddressDTO.setFlatNumber(FLAT_NUMBER);
        comarchAddressDTO.setPostalCode(POSTAL_CODE);
        comarchAddressDTO.setCity(CITY);

        return comarchAddressDTO;
    }
}
