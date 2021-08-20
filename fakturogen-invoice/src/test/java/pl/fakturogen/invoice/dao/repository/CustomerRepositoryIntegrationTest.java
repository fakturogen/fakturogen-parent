package pl.fakturogen.invoice.dao.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.fakturogen.invoice.config.CustomerTestContextConfig;
import pl.fakturogen.invoice.dao.entity.Customer;
import pl.fakturogen.invoice.dao.entity.CustomerType;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * @author ewa-git
 */
@SpringBootTest(classes = CustomerTestContextConfig.class)
public class CustomerRepositoryIntegrationTest {
    private static final Long ID = 1L;
    private static final Long ID_EXTERNAL_API = 1L;
    private static final String NAME = "testowa nazwa";
    private static final String NIP = "123";
    private static final String CUSTOMER_CODE = "0";
    private static final String MAIL = "testowy mail";
    private static final String PHONE_NUMBER = "123-456-789";
    private static final CustomerType CUSTOMER_TYPE = new CustomerType(1L, "podmiot gospodarczy");

    CustomerRepository customerRepository;
    Customer newCustomerToDatabase;


    @Autowired
    public CustomerRepositoryIntegrationTest(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @BeforeEach
    void prepareTest() {


        newCustomerToDatabase = new Customer();
        newCustomerToDatabase.setId(ID);
        newCustomerToDatabase.setIdExternalApi(ID_EXTERNAL_API);
        newCustomerToDatabase.setName(NAME);
        newCustomerToDatabase.setNip(NIP);
        newCustomerToDatabase.setCustomerCode(CUSTOMER_CODE);
        newCustomerToDatabase.setMail(MAIL);
        newCustomerToDatabase.setPhoneNumber(PHONE_NUMBER);
//        newCustomerToDatabase.setCustomerType(CUSTOMER_TYPE);
    }

    @Test
    @DisplayName("List size should be 1")
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
    void test2() {
        Customer expectedCustomer = new Customer();
        expectedCustomer.setIdExternalApi(ID_EXTERNAL_API);
        expectedCustomer.setName(NAME);
        expectedCustomer.setNip(NIP);
        expectedCustomer.setCustomerCode(CUSTOMER_CODE);
        expectedCustomer.setMail(MAIL);
        expectedCustomer.setPhoneNumber(PHONE_NUMBER);

        Customer savedCustomer = customerRepository.save(newCustomerToDatabase);
        Long customerId = savedCustomer.getId();
        expectedCustomer.setId(customerId);

        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        Customer customerFromDatabase = optionalCustomer.orElseThrow();

        assertAll(
                () -> assertEquals(expectedCustomer.getId(), customerFromDatabase.getId()),
                () -> assertEquals(expectedCustomer.getIdExternalApi(), customerFromDatabase.getIdExternalApi()),
                () -> assertEquals(expectedCustomer.getName(), customerFromDatabase.getName()),
                () -> assertEquals(expectedCustomer.getNip(), customerFromDatabase.getNip()),
                () -> assertEquals(expectedCustomer.getCustomerCode(), customerFromDatabase.getCustomerCode()),
                () -> assertEquals(expectedCustomer.getMail(), customerFromDatabase.getMail()),
                () -> assertEquals(expectedCustomer.getPhoneNumber(), customerFromDatabase.getPhoneNumber())
        );
    }


}
