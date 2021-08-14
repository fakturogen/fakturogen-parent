package pl.fakturogen.comarch.connector.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import pl.fakturogen.comarch.connector.dto.ComarchAddressDTO;
import pl.fakturogen.comarch.connector.dto.ComarchCustomerDTO;
import pl.fakturogen.comarch.connector.model.ComarchAddress;
import pl.fakturogen.comarch.connector.model.ComarchCustomer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author ewa-git
 */

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
        comarchCustomerMapper = new ComarchCustomerMapper(new ComarchAddressMapper());
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

    @Test
    @DisplayName("Should map ComarchCustomerList to ComarchCustomerDTOList")
    public void test5() {
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

        List<ComarchCustomerDTO> comarchCustomerDTOList = comarchCustomerMapper.fromList(givenComarchCustomerList);

        assertAll(
                () -> assertEquals(expectedComarchCustomerList.size(), comarchCustomerDTOList.size()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getId(), comarchCustomerDTOList.get(0).getId()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getName(), comarchCustomerDTOList.get(0).getName()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getCustomerTaxNumber(), comarchCustomerDTOList.get(0).getCustomerTaxNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getCustomerCode(), comarchCustomerDTOList.get(0).getCustomerCode()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getMail(), comarchCustomerDTOList.get(0).getMail()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getPhoneNumber(), comarchCustomerDTOList.get(0).getPhoneNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getCustomerType(), comarchCustomerDTOList.get(0).getCustomerType()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().getId(), comarchCustomerDTOList.get(0).getAddress().getId()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().getStreet(), comarchCustomerDTOList.get(0).getAddress().getStreet()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().getBuildingNumber(), comarchCustomerDTOList.get(0).getAddress().getBuildingNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().getFlatNumber(), comarchCustomerDTOList.get(0).getAddress().getFlatNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().getPostalCode(), comarchCustomerDTOList.get(0).getAddress().getPostalCode()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().getCity(), comarchCustomerDTOList.get(0).getAddress().getCity()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getId(), comarchCustomerDTOList.get(1).getId()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getName(), comarchCustomerDTOList.get(1).getName()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getCustomerTaxNumber(), comarchCustomerDTOList.get(1).getCustomerTaxNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getCustomerCode(), comarchCustomerDTOList.get(1).getCustomerCode()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getMail(), comarchCustomerDTOList.get(1).getMail()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getPhoneNumber(), comarchCustomerDTOList.get(1).getPhoneNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getCustomerType(), comarchCustomerDTOList.get(1).getCustomerType()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().getId(), comarchCustomerDTOList.get(1).getAddress().getId()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().getStreet(), comarchCustomerDTOList.get(1).getAddress().getStreet()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().getBuildingNumber(), comarchCustomerDTOList.get(1).getAddress().getBuildingNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().getFlatNumber(), comarchCustomerDTOList.get(1).getAddress().getFlatNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().getPostalCode(), comarchCustomerDTOList.get(1).getAddress().getPostalCode()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().getCity(), comarchCustomerDTOList.get(1).getAddress().getCity()));
    }

    @Test
    @DisplayName("Should map empty ComarchCustomerList to empty ComarchCutomerDTOList")
    public void test6() {
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

        List<ComarchCustomerDTO> convertedComarchCustomerDTOList = comarchCustomerMapper.fromList(givenComarchCustomerList);

        assertAll(
                () -> assertEquals(expectedComarchCustomerList.size(), convertedComarchCustomerDTOList.size()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getId(), convertedComarchCustomerDTOList.get(0).getId()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getName(), convertedComarchCustomerDTOList.get(0).getName()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getCustomerTaxNumber(), convertedComarchCustomerDTOList.get(0).getCustomerTaxNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getCustomerCode(), convertedComarchCustomerDTOList.get(0).getCustomerCode()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getMail(), convertedComarchCustomerDTOList.get(0).getMail()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getPhoneNumber(), convertedComarchCustomerDTOList.get(0).getPhoneNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getCustomerType(), convertedComarchCustomerDTOList.get(0).getCustomerType()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().getId(), convertedComarchCustomerDTOList.get(0).getAddress().getId()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().getStreet(), convertedComarchCustomerDTOList.get(0).getAddress().getStreet()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().getBuildingNumber(), convertedComarchCustomerDTOList.get(0).getAddress().getBuildingNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().getFlatNumber(), convertedComarchCustomerDTOList.get(0).getAddress().getFlatNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().getPostalCode(), convertedComarchCustomerDTOList.get(0).getAddress().getPostalCode()),
                () -> assertEquals(expectedComarchCustomerList.get(0).getAddress().getCity(), convertedComarchCustomerDTOList.get(0).getAddress().getCity()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getId(), convertedComarchCustomerDTOList.get(1).getId()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getName(), convertedComarchCustomerDTOList.get(1).getName()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getCustomerTaxNumber(), convertedComarchCustomerDTOList.get(1).getCustomerTaxNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getCustomerCode(), convertedComarchCustomerDTOList.get(1).getCustomerCode()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getMail(), convertedComarchCustomerDTOList.get(1).getMail()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getPhoneNumber(), convertedComarchCustomerDTOList.get(1).getPhoneNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getCustomerType(), convertedComarchCustomerDTOList.get(1).getCustomerType()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().getId(), convertedComarchCustomerDTOList.get(1).getAddress().getId()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().getStreet(), convertedComarchCustomerDTOList.get(1).getAddress().getStreet()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().getBuildingNumber(), convertedComarchCustomerDTOList.get(1).getAddress().getBuildingNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().getFlatNumber(), convertedComarchCustomerDTOList.get(1).getAddress().getFlatNumber()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().getPostalCode(), convertedComarchCustomerDTOList.get(1).getAddress().getPostalCode()),
                () -> assertEquals(expectedComarchCustomerList.get(1).getAddress().getCity(), convertedComarchCustomerDTOList.get(1).getAddress().getCity()));
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
