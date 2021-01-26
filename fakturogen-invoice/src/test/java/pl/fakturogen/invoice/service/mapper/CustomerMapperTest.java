package pl.fakturogen.invoice.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pl.fakturogen.invoice.dao.entity.Customer;
import pl.fakturogen.invoice.dao.entity.CustomerType;
import pl.fakturogen.invoice.web.dto.CustomerDTO;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CustomerMapper specification")
public class CustomerMapperTest {
    private static final Long ID = 1L;
    private static final Long ID_EXTERNAL_API = 1L;
    private static final String NAME = "testowa nazwa";
    private static final String CUSTOMER_TAX_NUMBER = "123";
    private static final String CUSTOMER_CODE = "0";
    private static final String MAIL = "testowy mail";
    private static final String PHONE_NUMBER = "123-456-789";
    private static final CustomerType CUSTOMER_TYPE = new CustomerType(1L, "podmiot gospodarczy");


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
        customer.setCustomerTaxNumber(CUSTOMER_TAX_NUMBER);
        customer.setCustomerCode(CUSTOMER_CODE);
        customer.setMail(MAIL);
        customer.setPhoneNumber(PHONE_NUMBER);
        customer.setCustomerType(CUSTOMER_TYPE);

        customerDTO = CustomerDTO.builder()
                .id(ID)
                .idExternalApi(ID_EXTERNAL_API)
                .name(NAME)
                .customerTaxNumber(CUSTOMER_TAX_NUMBER)
                .customerCode(CUSTOMER_CODE)
                .mail(MAIL)
                .phoneNumber(PHONE_NUMBER)
                .customerType(CUSTOMER_TYPE)
                .build();

        emptyCustomer = new Customer();
        emptyCustomerDTO = new CustomerDTO();

        partiallyEmptyCustomer = new Customer();
        partiallyEmptyCustomer.setId(ID);
        partiallyEmptyCustomer.setMail(MAIL);

        partiallyEmptyCustomerDTO = CustomerDTO.builder()
                .idExternalApi(ID)
                .name(NAME)
                .build();
    }

    @Nested
    @DisplayName("Maapping from Customer to CustomerDTO")
    class CustomerToCustomerDTO {

        @Test
        @DisplayName("Should map provided customer to customerDTO")
        void test1() {
            CustomerDTO mappedCustomerDTO = customerMapper.from(customer);
            assertAll(() -> assertEquals(customer.getId(), mappedCustomerDTO.getId()),
                    () -> assertEquals(customer.getIdExternalApi(), mappedCustomerDTO.getIdExternalApi()),
                    () -> assertEquals(customer.getName(), mappedCustomerDTO.getName()),
                    () -> assertEquals(customer.getCustomerTaxNumber(), mappedCustomerDTO.getCustomerTaxNumber()),
                    () -> assertEquals(customer.getCustomerCode(), mappedCustomerDTO.getCustomerCode()),
                    () -> assertEquals(customer.getMail(), mappedCustomerDTO.getMail()),
                    () -> assertEquals(customer.getPhoneNumber(), mappedCustomerDTO.getPhoneNumber()),
                    () -> assertEquals(customer.getCustomerType(), mappedCustomerDTO.getCustomerType()));
        }

        @Test
        @DisplayName("Should map provided empty customer to empty customerDTO")
        void test2() {
            CustomerDTO mappedCustomerDTO = customerMapper.from(emptyCustomer);
            assertAll(() -> assertEquals(emptyCustomer.getId(), mappedCustomerDTO.getId()),
                    () -> assertEquals(emptyCustomer.getIdExternalApi(), mappedCustomerDTO.getIdExternalApi()),
                    () -> assertEquals(emptyCustomer.getName(), mappedCustomerDTO.getName()),
                    () -> assertEquals(emptyCustomer.getCustomerTaxNumber(), mappedCustomerDTO.getCustomerTaxNumber()),
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
                    () -> assertEquals(partiallyEmptyCustomer.getCustomerTaxNumber(), mappedCustomerDTO.getCustomerTaxNumber()),
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
                    () -> assertEquals(customerDTO.getCustomerTaxNumber(), mappedCustomer.getCustomerTaxNumber()),
                    () -> assertEquals(customerDTO.getCustomerCode(), mappedCustomer.getCustomerCode()),
                    () -> assertEquals(customerDTO.getMail(), mappedCustomer.getMail()),
                    () -> assertEquals(customerDTO.getPhoneNumber(), mappedCustomer.getPhoneNumber()),
                    () -> assertEquals(customerDTO.getCustomerType(), mappedCustomer.getCustomerType()));
        }

        @Test
        @DisplayName("Should map provided empty customerDTO to empty customer")
        void test2() {
            Customer mappedCustomer = customerMapper.from(emptyCustomerDTO);
            assertAll(() -> assertEquals(emptyCustomerDTO.getId(), mappedCustomer.getId()),
                    () -> assertEquals(emptyCustomerDTO.getIdExternalApi(), mappedCustomer.getIdExternalApi()),
                    () -> assertEquals(emptyCustomerDTO.getName(), mappedCustomer.getName()),
                    () -> assertEquals(emptyCustomerDTO.getCustomerTaxNumber(), mappedCustomer.getCustomerTaxNumber()),
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
                    () -> assertEquals(partiallyEmptyCustomerDTO.getCustomerTaxNumber(), mappedCustomer.getCustomerTaxNumber()),
                    () -> assertEquals(partiallyEmptyCustomerDTO.getCustomerCode(), mappedCustomer.getCustomerCode()),
                    () -> assertEquals(partiallyEmptyCustomerDTO.getMail(), mappedCustomer.getMail()),
                    () -> assertEquals(partiallyEmptyCustomerDTO.getPhoneNumber(), mappedCustomer.getPhoneNumber()),
                    () -> assertEquals(partiallyEmptyCustomerDTO.getCustomerType(), mappedCustomer.getCustomerType()));
        }
    }

}
