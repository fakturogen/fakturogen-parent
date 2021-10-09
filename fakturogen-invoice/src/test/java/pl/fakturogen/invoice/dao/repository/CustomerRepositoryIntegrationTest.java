package pl.fakturogen.invoice.dao.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.fakturogen.invoice.config.InvoiceTestContextConfiguration;
import pl.fakturogen.invoice.dao.entity.Address;
import pl.fakturogen.invoice.dao.entity.Customer;
import pl.fakturogen.invoice.dao.entity.CustomerType;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * @author ewa-git
 */
@SpringBootTest(classes = InvoiceTestContextConfiguration.class)
public class CustomerRepositoryIntegrationTest {
    private static final Long ID_EXTERNAL_API = 1L;
    private static final String NAME = "testowa nazwa";
    private static final String NIP = "123";
    private static final String CUSTOMER_CODE = "0";
    private static final String MAIL = "testowy mail";
    private static final String PHONE_NUMBER = "123-456-789";
    private static final String CUSTOMER_TYPE_DESCRIPTION = "podmiot gospodarczy";

    private static final String STREET = "Testowa ulica";
    private static final String BUILDING_NUMBER = "10";
    private static final String FLAT_NUMBER = "8";
    private static final String POSTAL_CODE = "92-202";
    private static final String CITY = "Testowe miastio";

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerTypeRepository customerTypeRepository;
    @Autowired
    private AddressRepository addressRepository;

    Customer newCustomerToDatabase;
    CustomerType customerType;
    Address address;


    @BeforeEach
    void prepareTest() {
        newCustomerToDatabase = new Customer();

        newCustomerToDatabase.setIdExternalApi(ID_EXTERNAL_API);
        newCustomerToDatabase.setName(NAME);
        newCustomerToDatabase.setNip(NIP);
        newCustomerToDatabase.setCustomerCode(CUSTOMER_CODE);
        newCustomerToDatabase.setMail(MAIL);
        newCustomerToDatabase.setPhoneNumber(PHONE_NUMBER);

        customerType = new CustomerType();
        customerType.setDescription(CUSTOMER_TYPE_DESCRIPTION);
        customerTypeRepository.save(customerType);

        address = new Address();
        address.setStreet(STREET);
        address.setCity(CITY);
        address.setPostalCode(POSTAL_CODE);
        address.setBuildingNumber(BUILDING_NUMBER);
        address.setFlatNumber(FLAT_NUMBER);
        addressRepository.save(address);

        newCustomerToDatabase.setAddress(address);
        newCustomerToDatabase.setCustomerType(customerType);
    }

    @AfterEach
    void cleanTest() {
        newCustomerToDatabase = null;
        customerType = null;
        address = null;
    }

    @Test
    @DisplayName("List size should be 1")
    @Transactional
    void test1() {
        List<Customer> customerList = customerRepository.findAll();
        int listFromDatabaseSize = customerList.size();
        int expextedListSize = listFromDatabaseSize + 1;

        Customer savedCustomer = customerRepository.save(newCustomerToDatabase);
        List<Customer> listAfterAddingCustomer = customerRepository.findAll();
        int currentListSize = listAfterAddingCustomer.size();

        assertAll(
                () -> assertNotNull(savedCustomer, "saved customer is null"),
                () -> assertNotNull(savedCustomer.getId(), "Saved customer id is null"),
                () -> assertEquals(expextedListSize, currentListSize)
        );
    }

    @Test
    @DisplayName("Given id should return customer")
    @Transactional
    void test2() {
        Customer expectedCustomer = new Customer();
        expectedCustomer.setIdExternalApi(ID_EXTERNAL_API);
        expectedCustomer.setName(NAME);
        expectedCustomer.setNip(NIP);
        expectedCustomer.setCustomerCode(CUSTOMER_CODE);
        expectedCustomer.setMail(MAIL);
        expectedCustomer.setPhoneNumber(PHONE_NUMBER);

        CustomerType expectedCustomerType = new CustomerType();
        expectedCustomerType.setDescription(CUSTOMER_TYPE_DESCRIPTION);

        Address expectedAddress = new Address();
        expectedAddress.setStreet(STREET);
        expectedAddress.setCity(CITY);
        expectedAddress.setPostalCode(POSTAL_CODE);
        expectedAddress.setBuildingNumber(BUILDING_NUMBER);
        expectedAddress.setFlatNumber(FLAT_NUMBER);

        Customer savedCustomer = customerRepository.save(newCustomerToDatabase);
        Long customerId = savedCustomer.getId();
        expectedCustomer.setId(customerId);
        expectedCustomerType.setId(savedCustomer.getCustomerType().getId());
        expectedAddress.setId(savedCustomer.getAddress().getId());
        expectedCustomer.setCustomerType(expectedCustomerType);
        expectedCustomer.setAddress(expectedAddress);

        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        Customer customerFromDatabase = optionalCustomer.orElseThrow();

        assertAll(
                () -> assertEquals(expectedCustomer.getId(), customerFromDatabase.getId()),
                () -> assertEquals(expectedCustomer.getIdExternalApi(), customerFromDatabase.getIdExternalApi()),
                () -> assertEquals(expectedCustomer.getName(), customerFromDatabase.getName()),
                () -> assertEquals(expectedCustomer.getNip(), customerFromDatabase.getNip()),
                () -> assertEquals(expectedCustomer.getCustomerCode(), customerFromDatabase.getCustomerCode()),
                () -> assertEquals(expectedCustomer.getMail(), customerFromDatabase.getMail()),
                () -> assertEquals(expectedCustomer.getPhoneNumber(), customerFromDatabase.getPhoneNumber()),
                () -> assertEquals(expectedCustomer.getCustomerType().getId(), customerFromDatabase.getCustomerType().getId()),
                () -> assertEquals(expectedCustomer.getCustomerType().getDescription(), customerFromDatabase.getCustomerType().getDescription()),
                () -> assertEquals(expectedCustomer.getAddress().getId(), customerFromDatabase.getAddress().getId()),
                () -> assertEquals(expectedCustomer.getAddress().getIdExternalApi(), customerFromDatabase.getAddress().getIdExternalApi()),
                () -> assertEquals(expectedCustomer.getAddress().getCity(), customerFromDatabase.getAddress().getCity()),
                () -> assertEquals(expectedCustomer.getAddress().getStreet(), customerFromDatabase.getAddress().getStreet()),
                () -> assertEquals(expectedCustomer.getAddress().getBuildingNumber(), customerFromDatabase.getAddress().getBuildingNumber()),
                () -> assertEquals(expectedCustomer.getAddress().getFlatNumber(), customerFromDatabase.getAddress().getFlatNumber()),
                () -> assertEquals(expectedCustomer.getAddress().getPostalCode(), customerFromDatabase.getAddress().getPostalCode())
        );
    }

    @Test
    @DisplayName("Given updated data should update customer in database")
    @Transactional
    void test3() {
        Customer expectedCustomer = new Customer();
        expectedCustomer.setIdExternalApi(123L);
        expectedCustomer.setName("New name");
        expectedCustomer.setNip("2");
        expectedCustomer.setCustomerCode("0");
        expectedCustomer.setMail("new email");
        expectedCustomer.setPhoneNumber("123-123-789");

        CustomerType expectedCustomerType = new CustomerType();
        expectedCustomerType.setDescription("CUSTOMER_TYPE_DESCRIPTION");

        Address expectedAddress = new Address();
        expectedAddress.setStreet("STREET");
        expectedAddress.setCity("CITY");
        expectedAddress.setPostalCode("92-400");
        expectedAddress.setBuildingNumber("1");
        expectedAddress.setFlatNumber("1");

        Customer savedCustomer = customerRepository.save(newCustomerToDatabase);
        Long customerId = savedCustomer.getId();
        expectedCustomer.setId(customerId);
        expectedCustomerType.setId(savedCustomer.getCustomerType().getId());
        expectedAddress.setId(savedCustomer.getAddress().getId());
        expectedCustomer.setCustomerType(expectedCustomerType);
        expectedCustomer.setAddress(expectedAddress);


        customerRepository.save(expectedCustomer);
        customerTypeRepository.save(expectedCustomerType);
        addressRepository.save(expectedAddress);
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        Customer updatedCustomer = optionalCustomer.orElseThrow();


        assertAll(
                () -> assertEquals(expectedCustomer.getId(), updatedCustomer.getId()),
                () -> assertEquals(expectedCustomer.getIdExternalApi(), updatedCustomer.getIdExternalApi()),
                () -> assertEquals(expectedCustomer.getName(), updatedCustomer.getName()),
                () -> assertEquals(expectedCustomer.getNip(), updatedCustomer.getNip()),
                () -> assertEquals(expectedCustomer.getCustomerCode(), updatedCustomer.getCustomerCode()),
                () -> assertEquals(expectedCustomer.getMail(), updatedCustomer.getMail()),
                () -> assertEquals(expectedCustomer.getPhoneNumber(), updatedCustomer.getPhoneNumber()),
                () -> assertEquals(expectedCustomer.getCustomerType().getId(), updatedCustomer.getCustomerType().getId()),
                () -> assertEquals(expectedCustomer.getCustomerType().getDescription(), updatedCustomer.getCustomerType().getDescription()),
                () -> assertEquals(expectedCustomer.getAddress().getId(), updatedCustomer.getAddress().getId()),
                () -> assertEquals(expectedCustomer.getAddress().getIdExternalApi(), updatedCustomer.getAddress().getIdExternalApi()),
                () -> assertEquals(expectedCustomer.getAddress().getCity(), updatedCustomer.getAddress().getCity()),
                () -> assertEquals(expectedCustomer.getAddress().getStreet(), updatedCustomer.getAddress().getStreet()),
                () -> assertEquals(expectedCustomer.getAddress().getBuildingNumber(), updatedCustomer.getAddress().getBuildingNumber()),
                () -> assertEquals(expectedCustomer.getAddress().getFlatNumber(), updatedCustomer.getAddress().getFlatNumber()),
                () -> assertEquals(expectedCustomer.getAddress().getPostalCode(), updatedCustomer.getAddress().getPostalCode())
        );

    }


    @Test
    @DisplayName("When delete should return current list size")
    @Transactional
    void test4() {
        List<Customer> initialCustomerList = customerRepository.findAll();
        int expectedCustomerListSize = initialCustomerList.size();

        Customer savedCustomer = customerRepository.save(newCustomerToDatabase);
        newCustomerToDatabase.setId(savedCustomer.getId());

        customerRepository.delete(newCustomerToDatabase);
        List<Customer> deletedCustomerList = customerRepository.findAll();
        int currentCustomerListSize = deletedCustomerList.size();

        assertEquals(expectedCustomerListSize, currentCustomerListSize);

    }


}
