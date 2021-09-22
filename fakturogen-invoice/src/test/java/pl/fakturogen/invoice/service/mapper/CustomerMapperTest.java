package pl.fakturogen.invoice.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pl.fakturogen.invoice.dao.entity.Customer;
import pl.fakturogen.invoice.dao.entity.CustomerType;
import pl.fakturogen.invoice.web.dto.CustomerDTO;
import pl.fakturogen.invoice.web.dto.CustomerTypeDTO;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author ewa-git
 */

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


    private CustomerMapper customerMapper;
    private Customer customer;
    private CustomerDTO customerDTO;
    private Customer emptyCustomer;
    private CustomerDTO emptyCustomerDTO;
    private Customer partiallyEmptyCustomer;
    private CustomerDTO partiallyEmptyCustomerDTO;

    @BeforeEach
    void prepareTest() {
        customerMapper = new CustomerMapper();

        customer = new Customer();
        customer.setId(ID);
        customer.setIdExternalApi(ID_EXTERNAL_API);
        customer.setName(NAME);
        customer.setNip(NIP);
        customer.setCustomerCode(CUSTOMER_CODE);
        customer.setMail(MAIL);
        customer.setPhoneNumber(PHONE_NUMBER);
        customer.setCustomerType(CUSTOMER_TYPE);

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

        emptyCustomer = new Customer();
        emptyCustomerDTO = new CustomerDTO();

        partiallyEmptyCustomer = new Customer();
        partiallyEmptyCustomer.setId(ID);
        partiallyEmptyCustomer.setMail(MAIL);
        partiallyEmptyCustomer.setPesel(PESEL);

        partiallyEmptyCustomerDTO = CustomerDTO.builder()
                .idExternalApi(ID)
                .name(NAME)
                .pesel(PESEL)
                .build();
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
                    () -> assertEquals(customer.getCustomerType().getDescription(), mappedCustomerDTO.getCustomerType().getDescription()));
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
                    () -> assertEquals(emptyCustomer.getCustomerType(), mappedCustomerDTO.getCustomerType()));
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
                    () -> assertEquals(partiallyEmptyCustomer.getCustomerType(), mappedCustomerDTO.getCustomerType()));
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
                    () -> assertEquals(customerDTO.getCustomerType().getDescription(), mappedCustomer.getCustomerType().getDescription()));
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
                    () -> assertEquals(emptyCustomerDTO.getCustomerType(), mappedCustomer.getCustomerType()));
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
                    () -> assertEquals(partiallyEmptyCustomerDTO.getCustomerType(), mappedCustomer.getCustomerType()));
        }
    }

}