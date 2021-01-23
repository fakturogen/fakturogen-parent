package pl.fakturogen.invoice.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pl.fakturogen.invoice.dao.entity.Address;
import pl.fakturogen.invoice.web.dto.AddressDTO;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("AddressMapper specification")
public class AddressMapperTest {
    private static final Long ID = 1L;
    private static final Long ID_EXTERNAL_API = 1L;
    private static final String STREET = "Testowa ulica";
    private static final String BUILDING_NUMBER = "10";
    private static final String FLAT_NUMBER = "8";
    private static final String POSTAL_CODE = "92-202";
    private static final String CITY = "Testowe miastio";


    private AddressMapper addressMapper;
    private Address address;
    private AddressDTO addressDTO;
    private Address emptyAddress;
    private AddressDTO emptyAddressDTO;
    private Address partiallyEmptyAddress;
    private AddressDTO partiallyEmptyAddressDTO;

    @BeforeEach
    void prepareTest() {
        address = new Address();
        address.setId(ID);
        address.setIdExternalApi(ID_EXTERNAL_API);
        address.setStreet(STREET);
        address.setBuildingNumber(BUILDING_NUMBER);
        address.setFlatNumber(FLAT_NUMBER);
        address.setPostalCode(POSTAL_CODE);
        address.setCity(CITY);

        addressDTO = AddressDTO.builder()
                .id(ID)
                .idExternalApi(ID_EXTERNAL_API)
                .street(STREET)
                .buildingNumber(BUILDING_NUMBER)
                .flatNumber(FLAT_NUMBER)
                .postalCode(POSTAL_CODE)
                .city(CITY)
                .build();

        emptyAddress = new Address();
        emptyAddressDTO = new AddressDTO();

        partiallyEmptyAddress = new Address();
        partiallyEmptyAddress.setId(ID);
        partiallyEmptyAddress.setStreet(STREET);

        partiallyEmptyAddressDTO = AddressDTO.builder()
                .city(CITY)
                .street(STREET)
                .buildingNumber(BUILDING_NUMBER)
                .build();

        addressMapper = new AddressMapper();
    }

    @Nested
    class AddressToAddressDTO {

        @Test
        @DisplayName("Should map provided address to addressDTO")
        void test1() {
            AddressDTO mappedAddressDTO = addressMapper.from(address);
            assertAll(() -> assertEquals(address.getId(), mappedAddressDTO.getId()),
                    () -> assertEquals(address.getIdExternalApi(), mappedAddressDTO.getIdExternalApi()),
                    () -> assertEquals(address.getStreet(), mappedAddressDTO.getStreet()),
                    () -> assertEquals(address.getBuildingNumber(), mappedAddressDTO.getBuildingNumber()),
                    () -> assertEquals(address.getFlatNumber(), mappedAddressDTO.getFlatNumber()),
                    () -> assertEquals(address.getPostalCode(), mappedAddressDTO.getPostalCode()),
                    () -> assertEquals(address.getCity(), mappedAddressDTO.getCity()));
        }

        @Test
        @DisplayName("Should map provided empty address to empty addressDTO")
        void test2(){
            AddressDTO mappedAddressDTO = addressMapper.from(emptyAddress);
            assertAll(
                    () -> assertEquals(emptyAddress.getId(), mappedAddressDTO.getId()),
                    () -> assertEquals(emptyAddress.getIdExternalApi(), mappedAddressDTO.getIdExternalApi()),
                    () -> assertEquals(emptyAddress.getStreet(), mappedAddressDTO.getStreet()),
                    () -> assertEquals(emptyAddress.getBuildingNumber(), mappedAddressDTO.getBuildingNumber()),
                    () -> assertEquals(emptyAddress.getFlatNumber(), mappedAddressDTO.getFlatNumber()),
                    () -> assertEquals(emptyAddress.getPostalCode(), mappedAddressDTO.getPostalCode()),
                    () -> assertEquals(emptyAddress.getCity(), mappedAddressDTO.getCity()));
        }
    }
}
