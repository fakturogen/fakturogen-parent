package pl.fakturogen.invoice.dao.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.fakturogen.invoice.config.InvoiceTestContextConfig;
import pl.fakturogen.invoice.dao.entity.Product;
import pl.fakturogen.invoice.dao.entity.Rate;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author rowinskidamian
 */

@SpringBootTest(classes = {InvoiceTestContextConfig.class})
class ProductRepositoryIntegrationTest {

    @Autowired
    public ProductRepositoryIntegrationTest(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    ProductRepository productRepository;
    Product productInit;

    @BeforeEach
    public void init() {
        productInit = new Product();
        productInit.setName("Product name");
        productInit.setDescription("Product description");
        productInit.setSaleNetPrice(100.0);
        productInit.setSaleGrossPrice(100.0);
        productInit.setRate(Rate.R1);
        productInit.setIdExternalApi(123L);
    }

    @Test
    public void givenProductEntityWhenSaveShouldReturnIncreasedSizeByOne() {
        List<Product> productList = productRepository.findAll();
        int currentProductListSize = productList.size();
        int expectedProductListSize = currentProductListSize + 1;

        Product savedProduct = productRepository.save(productInit);
        List<Product> listAfterExtension = productRepository.findAll();
        int currentListSize = listAfterExtension.size();

        assertAll(
                () -> assertNotNull(savedProduct, "Saved Product is null"),
                () -> assertNotNull(savedProduct.getId(), "Saved Product id is null"),
                () -> assertEquals(expectedProductListSize, currentListSize, "Products entity list size is not"
                        + expectedProductListSize)
        );
    }

    @Test
    public void givenProductIdShouldFindProduct() {
        Product productExpected = new Product();
        productExpected.setName("Product name");
        productExpected.setDescription("Product description");
        productExpected.setSaleNetPrice(100.0);
        productExpected.setSaleGrossPrice(100.0);
        productExpected.setRate(Rate.R1);
        productExpected.setIdExternalApi(123L);

        Product savedProduct = productRepository.save(productInit);
        Long productId = savedProduct.getId();
        productExpected.setId(productId);

        Optional<Product> optionalProduct = productRepository.findById(productId);

        Product productFound = optionalProduct.orElseThrow();

        assertAll(() -> assertEquals(productExpected.getId(), productFound.getId()),
                () -> assertEquals(productExpected.getName(), productFound.getName()),
                () -> assertEquals(productExpected.getDescription(), productFound.getDescription()),
                () -> assertEquals(productExpected.getSaleNetPrice(), productFound.getSaleNetPrice()),
                () -> assertEquals(productExpected.getSaleGrossPrice(), productFound.getSaleGrossPrice()),
                () -> assertEquals(productExpected.getRate(), productFound.getRate()),
                () -> assertEquals(productExpected.getIdExternalApi(), productFound.getIdExternalApi()));
    }

    @Test
    public void givenProductUpdateDataShouldUpdateProduct() {
        Product productExpected = new Product();
        productExpected.setName("Product New Name");
        productExpected.setDescription("Product NEW DESC");
        productExpected.setSaleNetPrice(99995.0);
        productExpected.setSaleGrossPrice(12323.0);
        productExpected.setRate(Rate.R2);
        productExpected.setIdExternalApi(2222233331L);

        Product savedProduct = productRepository.save(productInit);
        Long productId = savedProduct.getId();
        productExpected.setId(productId);

        productRepository.save(productExpected);
        Optional<Product> optionalProduct = productRepository.findById(productId);
        Product updatedProduct = optionalProduct.orElseThrow();


        assertAll(() -> assertEquals(productExpected.getId(), updatedProduct.getId()),
                () -> assertEquals(productExpected.getName(), updatedProduct.getName()),
                () -> assertEquals(productExpected.getDescription(), updatedProduct.getDescription()),
                () -> assertEquals(productExpected.getSaleNetPrice(), updatedProduct.getSaleNetPrice()),
                () -> assertEquals(productExpected.getSaleGrossPrice(), updatedProduct.getSaleGrossPrice()),
                () -> assertEquals(productExpected.getRate(), updatedProduct.getRate()),
                () -> assertEquals(productExpected.getIdExternalApi(), updatedProduct.getIdExternalApi()));
    }

    @Test
    public void givenProductEntityWhenSaveAndDeleteShouldReturnCurrentListSize() {
        List<Product> productList = productRepository.findAll();
        int expectedProductListSize = productList.size();

        Product savedProduct = productRepository.save(productInit);
        productInit.setId(savedProduct.getId());

        productRepository.delete(productInit);
        List<Product> listAfterDelete = productRepository.findAll();
        int currentListSize = listAfterDelete.size();

        assertEquals(expectedProductListSize, currentListSize, "Products entity list size is not"
                        + expectedProductListSize);
    }


}