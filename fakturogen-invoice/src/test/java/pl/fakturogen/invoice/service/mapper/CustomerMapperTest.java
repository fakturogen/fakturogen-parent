package pl.fakturogen.invoice.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pl.fakturogen.invoice.dao.entity.Address;
import pl.fakturogen.invoice.dao.entity.Customer;
import pl.fakturogen.invoice.dao.entity.CustomerType;
import pl.fakturogen.invoice.web.dto.AddressDTO;
import pl.fakturogen.invoice.web.dto.CustomerDTO;
import pl.fakturogen.invoice.web.dto.CustomerTypeDTO;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("CustomerMapper specification")
public class CustomerMapperTest {
    private static final Long ID = 1L;
    private static final Long ID_EXTERNAL_API = 1L;
    private static final String NAME = "testowa nazwa";
    private static final String NIP = "123";
    private static final String PESEL = "123456";
    private static final String CUSTOMER_CODE = "0";
    private static final String MAIL = "testowy mail";
    private static final String PHONE_NUMBER = "123-456-789";
    private static final CustomerType CUSTOMER_TYPE = new CustomerType(1L, "podmiot gospodarczy");
    private static final CustomerTypeDTO CUSTOMER_TYPE_DTO = new CustomerTypeDTO(1L, "podmiot gospodarczy");

    private static final String STREET = "Testowa ulica";
    private static final String BUILDING_NUMBER = "10";
    private static final String FLAT_NUMBER = "8";
    private static final String POSTAL_CODE = "92-202";
    private static final String CITY = "Testowe miastio";



    private Address address;
    private AddressDTO addressDTO;
    private Address emptyAddress;
    private AddressDTO emptyAddressDTO;
    private Address partiallyEmptyAddress;
    private AddressDTO partiallyEmptyAddressDTO;

    private CustomerMapper customerMapper;
    private Customer customer;
    private CustomerDTO customerDTO;
    private Customer emptyCustomer;
    private CustomerDTO emptyCustomerDTO;
    private Customer partiallyEmptyCustomer;
    private CustomerDTO partiallyEmptyCustomerDTO;

    @BeforeEach
    void prepareTest() {
        customerMapper = new CustomerMapper(new AddressMapper());

        customer = new Customer();
        customer.setId(ID);
        customer.setIdExternalApi(ID_EXTERNAL_API);
        customer.setName(NAME);
        customer.setNip(NIP);
        customer.setCustomerCode(CUSTOMER_CODE);
        customer.setMail(MAIL);
        customer.setPhoneNumber(PHONE_NUMBER);
        customer.setCustomerType(CUSTOMER_TYPE);

        address = new Address();
        address.setId(ID);
        address.setIdExternalApi(ID_EXTERNAL_API);
        address.setStreet(STREET);
        address.setBuildingNumber(BUILDING_NUMBER);
        address.setFlatNumber(FLAT_NUMBER);
        address.setPostalCode(POSTAL_CODE);
        address.setCity(CITY);

        customer.setAddress(address);

        customerDTO = CustomerDTO.builder()
                .id(ID)
                .idExternalApi(ID_EXTERNAL_API)
                .name(NAME)
                .nip(NIP)
                .customerCode(CUSTOMER_CODE)
                .mail(MAIL)
                .phoneNumber(PHONE_NUMBER)
                .customerType(CUSTOMER_TYPE_DTO)
                .build();

        addressDTO = AddressDTO.builder()
                .id(ID)
                .idExternalApi(ID_EXTERNAL_API)
                .street(STREET)
                .buildingNumber(BUILDING_NUMBER)
                .flatNumber(FLAT_NUMBER)
                .postalCode(POSTAL_CODE)
                .city(CITY)
                .build();

        customerDTO.setAddress(addressDTO);

        emptyCustomer = new Customer();
        emptyAddress = new Address();
        emptyCustomer.setAddress(emptyAddress);

        emptyCustomerDTO = new CustomerDTO();
        emptyAddressDTO = new AddressDTO();
        emptyCustomerDTO.setAddress(emptyAddressDTO);

        partiallyEmptyCustomer = new Customer();
        partiallyEmptyCustomer.setId(ID);
        partiallyEmptyCustomer.setMail(MAIL);
        partiallyEmptyCustomer.setPesel(PESEL);

        partiallyEmptyAddress = new Address();
        partiallyEmptyAddress.setId(ID);
        partiallyEmptyAddress.setStreet(STREET);

        partiallyEmptyCustomer.setAddress(partiallyEmptyAddress);

        partiallyEmptyCustomerDTO = CustomerDTO.builder()
                .idExternalApi(ID)
                .name(NAME)
                .pesel(PESEL)
                .build();

        partiallyEmptyAddressDTO = AddressDTO.builder()
                .city(CITY)
                .street(STREET)
                .buildingNumber(BUILDING_NUMBER)
                .build();

        partiallyEmptyCustomerDTO.setAddress(partiallyEmptyAddressDTO);

    }

    @Nested
    @DisplayName("Mapping from Customer to CustomerDTO")
    class CustomerToCustomerDTO {

        @Test
        @DisplayName("Should map provided customer to customerDTO")
        void test1() {
            CustomerDTO mappedCustomerDTO = customerMapper.from(customer);
            assertAll(() -> assertEquals(customer.getId(), mappedCustomerDTO.getId()),
                    () -> assertEquals(customer.getIdExternalApi(), mappedCustomerDTO.getIdExternalApi()),
                    () -> assertEquals(customer.getName(), mappedCustomerDTO.getName()),
                    () -> assertEquals(customer.getNip(), mappedCustomerDTO.getNip()),
                    () -> assertEquals(customer.getPesel(), mappedCustomerDTO.getPesel()),
                    () -> assertEquals(customer.getCustomerCode(), mappedCustomerDTO.getCustomerCode()),
                    () -> assertEquals(customer.getMail(), mappedCustomerDTO.getMail()),
                    () -> assertEquals(customer.getPhoneNumber(), mappedCustomerDTO.getPhoneNumber()),
                    () -> assertEquals(customer.getCustomerType().getId(), mappedCustomerDTO.getCustomerType().getId()),
                    () -> assertEquals(customer.getCustomerType().getDescription(), mappedCustomerDTO.getCustomerType().getDescription()),
                    () -> assertEquals(customer.getAddress().getId(), mappedCustomerDTO.getAddress().getId()),
                    () -> assertEquals(customer.getAddress().getIdExternalApi(), mappedCustomerDTO.getAddress().getIdExternalApi()),
                    () -> assertEquals(customer.getAddress().getStreet(), mappedCustomerDTO.getAddress().getStreet()),
                    () -> assertEquals(customer.getAddress().getBuildingNumber(), mappedCustomerDTO.getAddress().getBuildingNumber()),
                    () -> assertEquals(customer.getAddress().getFlatNumber(), mappedCustomerDTO.getAddress().getFlatNumber()),
                    () -> assertEquals(customer.getAddress().getPostalCode(), mappedCustomerDTO.getAddress().getPostalCode()),
                    () -> assertEquals(customer.getAddress().getCity(), mappedCustomerDTO.getAddress().getCity()));
        }

        @Test
        @DisplayName("Should map provided empty customer to empty customerDTO")
        void test2() {
            CustomerDTO mappedCustomerDTO = customerMapper.from(emptyCustomer);
            assertAll(() -> assertEquals(emptyCustomer.getId(), mappedCustomerDTO.getId()),
                    () -> assertEquals(emptyCustomer.getIdExternalApi(), mappedCustomerDTO.getIdExternalApi()),
                    () -> assertEquals(emptyCustomer.getName(), mappedCustomerDTO.getName()),
                    () -> assertEquals(emptyCustomer.getNip(), mappedCustomerDTO.getNip()),
                    () -> assertEquals(emptyCustomer.getPesel(), mappedCustomerDTO.getPesel()),
                    () -> assertEquals(emptyCustomer.getCustomerCode(), mappedCustomerDTO.getCustomerCode()),
                    () -> assertEquals(emptyCustomer.getMail(), mappedCustomerDTO.getMail()),
                    () -> assertEquals(emptyCustomer.getPhoneNumber(), mappedCustomerDTO.getPhoneNumber()),
                    () -> assertEquals(emptyCustomer.getCustomerType(), mappedCustomerDTO.getCustomerType()),
                    () -> assertEquals(emptyCustomer.getAddress().getId(), mappedCustomerDTO.getAddress().getId()),
                    () -> assertEquals(emptyCustomer.getAddress().getIdExternalApi(), mappedCustomerDTO.getAddress().getIdExternalApi()),
                    () -> assertEquals(emptyCustomer.getAddress().getStreet(), mappedCustomerDTO.getAddress().getStreet()),
                    () -> assertEquals(emptyCustomer.getAddress().getBuildingNumber(), mappedCustomerDTO.getAddress().getBuildingNumber()),
                    () -> assertEquals(emptyCustomer.getAddress().getFlatNumber(), mappedCustomerDTO.getAddress().getFlatNumber()),
                    () -> assertEquals(emptyCustomer.getAddress().getPostalCode(), mappedCustomerDTO.getAddress().getPostalCode()),
                    () -> assertEquals(emptyCustomer.getAddress().getCity(), mappedCustomerDTO.getAddress().getCity()));
        }

        @Test
        @DisplayName("Should map provided partially empty customer to partially empty customerDTO")
        void test3() {
            CustomerDTO mappedCustomerDTO = customerMapper.from(partiallyEmptyCustomer);
            assertAll(() -> assertEquals(partiallyEmptyCustomer.getId(), mappedCustomerDTO.getId()),
                    () -> assertEquals(partiallyEmptyCustomer.getIdExternalApi(), mappedCustomerDTO.getIdExternalApi()),
                    () -> assertEquals(partiallyEmptyCustomer.getName(), mappedCustomerDTO.getName()),
                    () -> assertEquals(partiallyEmptyCustomer.getNip(), mappedCustomerDTO.getNip()),
                    () -> assertEquals(partiallyEmptyCustomer.getPesel(), mappedCustomerDTO.getPesel()),
                    () -> assertEquals(partiallyEmptyCustomer.getCustomerCode(), mappedCustomerDTO.getCustomerCode()),
                    () -> assertEquals(partiallyEmptyCustomer.getMail(), mappedCustomerDTO.getMail()),
                    () -> assertEquals(partiallyEmptyCustomer.getPhoneNumber(), mappedCustomerDTO.getPhoneNumber()),
                    () -> assertEquals(partiallyEmptyCustomer.getCustomerType(), mappedCustomerDTO.getCustomerType()),
                    () -> assertEquals(partiallyEmptyCustomer.getAddress().getId(), mappedCustomerDTO.getAddress().getId()),
                    () -> assertEquals(partiallyEmptyCustomer.getAddress().getIdExternalApi(), mappedCustomerDTO.getAddress().getIdExternalApi()),
                    () -> assertEquals(partiallyEmptyCustomer.getAddress().getStreet(), mappedCustomerDTO.getAddress().getStreet()),
                    () -> assertEquals(partiallyEmptyCustomer.getAddress().getBuildingNumber(), mappedCustomerDTO.getAddress().getBuildingNumber()),
                    () -> assertEquals(partiallyEmptyCustomer.getAddress().getFlatNumber(), mappedCustomerDTO.getAddress().getFlatNumber()),
                    () -> assertEquals(partiallyEmptyCustomer.getAddress().getPostalCode(), mappedCustomerDTO.getAddress().getPostalCode()),
                    () -> assertEquals(partiallyEmptyCustomer.getAddress().getCity(), mappedCustomerDTO.getAddress().getCity()));

        }
    }

    @Nested
    @DisplayName("Maapping from CustomerDTO to Customer")
    class CustomerDTOToCustomer{
        @Test
        @DisplayName("Should map provided customerDTO to customer")
        void test1() {
            Customer mappedCustomer = customerMapper.from(customerDTO);
            assertAll(() -> assertEquals(customerDTO.getId(), mappedCustomer.getId()),
                    () -> assertEquals(customerDTO.getIdExternalApi(), mappedCustomer.getIdExternalApi()),
                    () -> assertEquals(customerDTO.getName(), mappedCustomer.getName()),
                    () -> assertEquals(customerDTO.getNip(), mappedCustomer.getNip()),
                    () -> assertEquals(customerDTO.getPesel(), mappedCustomer.getPesel()),
                    () -> assertEquals(customerDTO.getCustomerCode(), mappedCustomer.getCustomerCode()),
                    () -> assertEquals(customerDTO.getMail(), mappedCustomer.getMail()),
                    () -> assertEquals(customerDTO.getPhoneNumber(), mappedCustomer.getPhoneNumber()),
                    () -> assertEquals(customerDTO.getCustomerType().getId(), mappedCustomer.getCustomerType().getId()),
                    () -> assertEquals(customerDTO.getCustomerType().getDescription(), mappedCustomer.getCustomerType().getDescription()),
                    () -> assertEquals(customerDTO.getAddress().getId(), mappedCustomer.getAddress().getId()),
                    () -> assertEquals(customerDTO.getAddress().getIdExternalApi(), mappedCustomer.getAddress().getIdExternalApi()),
                    () -> assertEquals(customerDTO.getAddress().getStreet(), mappedCustomer.getAddress().getStreet()),
                    () -> assertEquals(customerDTO.getAddress().getBuildingNumber(), mappedCustomer.getAddress().getBuildingNumber()),
                    () -> assertEquals(customerDTO.getAddress().getFlatNumber(), mappedCustomer.getAddress().getFlatNumber()),
                    () -> assertEquals(customerDTO.getAddress().getPostalCode(), mappedCustomer.getAddress().getPostalCode()),
                    () -> assertEquals(customerDTO.getAddress().getCity(), mappedCustomer.getAddress().getCity()));
        }

        @Test
        @DisplayName("Should map provided empty customerDTO to empty customer")
        void test2() {
            Customer mappedCustomer = customerMapper.from(emptyCustomerDTO);
            assertAll(() -> assertEquals(emptyCustomerDTO.getId(), mappedCustomer.getId()),
                    () -> assertEquals(emptyCustomerDTO.getIdExternalApi(), mappedCustomer.getIdExternalApi()),
                    () -> assertEquals(emptyCustomerDTO.getName(), mappedCustomer.getName()),
                    () -> assertEquals(emptyCustomerDTO.getNip(), mappedCustomer.getNip()),
                    () -> assertEquals(emptyCustomerDTO.getPesel(), mappedCustomer.getPesel()),
                    () -> assertEquals(emptyCustomerDTO.getCustomerCode(), mappedCustomer.getCustomerCode()),
                    () -> assertEquals(emptyCustomerDTO.getMail(), mappedCustomer.getMail()),
                    () -> assertEquals(emptyCustomerDTO.getPhoneNumber(), mappedCustomer.getPhoneNumber()),
                    () -> assertEquals(emptyCustomerDTO.getCustomerType(), mappedCustomer.getCustomerType()),
                    () -> assertEquals(emptyCustomerDTO.getAddress().getId(), mappedCustomer.getAddress().getId()),
                    () -> assertEquals(emptyCustomerDTO.getAddress().getIdExternalApi(), mappedCustomer.getAddress().getIdExternalApi()),
                    () -> assertEquals(emptyCustomerDTO.getAddress().getStreet(), mappedCustomer.getAddress().getStreet()),
                    () -> assertEquals(emptyCustomerDTO.getAddress().getBuildingNumber(), mappedCustomer.getAddress().getBuildingNumber()),
                    () -> assertEquals(emptyCustomerDTO.getAddress().getFlatNumber(), mappedCustomer.getAddress().getFlatNumber()),
                    () -> assertEquals(emptyCustomerDTO.getAddress().getPostalCode(), mappedCustomer.getAddress().getPostalCode()),
                    () -> assertEquals(emptyCustomerDTO.getAddress().getCity(), mappedCustomer.getAddress().getCity()));
        }

        @Test
        @DisplayName("Should map provided partially empty customerDTO to partially empty customer")
        void test3() {
            Customer mappedCustomer = customerMapper.from(partiallyEmptyCustomerDTO);
            assertAll(() -> assertEquals(partiallyEmptyCustomerDTO.getId(), mappedCustomer.getId()),
                    () -> assertEquals(partiallyEmptyCustomerDTO.getIdExternalApi(), mappedCustomer.getIdExternalApi()),
                    () -> assertEquals(partiallyEmptyCustomerDTO.getName(), mappedCustomer.getName()),
                    () -> assertEquals(partiallyEmptyCustomerDTO.getNip(), mappedCustomer.getNip()),
                    () -> assertEquals(partiallyEmptyCustomerDTO.getPesel(), mappedCustomer.getPesel()),
                    () -> assertEquals(partiallyEmptyCustomerDTO.getCustomerCode(), mappedCustomer.getCustomerCode()),
                    () -> assertEquals(partiallyEmptyCustomerDTO.getMail(), mappedCustomer.getMail()),
                    () -> assertEquals(partiallyEmptyCustomerDTO.getPhoneNumber(), mappedCustomer.getPhoneNumber()),
                    () -> assertEquals(partiallyEmptyCustomerDTO.getCustomerType(), mappedCustomer.getCustomerType()),
                    () -> assertEquals(partiallyEmptyCustomerDTO.getAddress().getId(), mappedCustomer.getAddress().getId()),
                    () -> assertEquals(partiallyEmptyCustomerDTO.getAddress().getIdExternalApi(), mappedCustomer.getAddress().getIdExternalApi()),
                    () -> assertEquals(partiallyEmptyCustomerDTO.getAddress().getStreet(), mappedCustomer.getAddress().getStreet()),
                    () -> assertEquals(partiallyEmptyCustomerDTO.getAddress().getBuildingNumber(), mappedCustomer.getAddress().getBuildingNumber()),
                    () -> assertEquals(partiallyEmptyCustomerDTO.getAddress().getFlatNumber(), mappedCustomer.getAddress().getFlatNumber()),
                    () -> assertEquals(partiallyEmptyCustomerDTO.getAddress().getPostalCode(), mappedCustomer.getAddress().getPostalCode()),
                    () -> assertEquals(partiallyEmptyCustomerDTO.getAddress().getCity(), mappedCustomer.getAddress().getCity()));
        }
    }

}