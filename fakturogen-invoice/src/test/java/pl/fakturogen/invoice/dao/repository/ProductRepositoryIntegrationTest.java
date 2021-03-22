package pl.fakturogen.invoice.dao.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import pl.fakturogen.invoice.config.InvoiceTestContextConfig;
import pl.fakturogen.invoice.dao.entity.Product;
import pl.fakturogen.invoice.dao.entity.Rate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author rowinskidamian
 */

@SpringBootTest(classes = {InvoiceTestContextConfig.class})
class ProductRepositoryIntegrationTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void givenEntityWhenSaveShouldReturnIncreasedSizeByOne() {
        Product product = new Product();
        product.setName("Product name");
        product.setDescription("Product description");
        product.setSaleNetPrice(100.0);
        product.setSaleGrossPrice(100.0);
        product.setRate(Rate.R1);
        product.setIdExternalApi(123L);


        List<Product> productList = productRepository.findAll();
        int currentProductListSize = productList.size();
        int expectedProductListSize = currentProductListSize + 1;

        Product savedProduct = productRepository.save(product);
        List<Product> listAfterExtension = productRepository.findAll();
        int currentListSize = listAfterExtension.size();

        assertAll(
                () -> assertNotNull(savedProduct, "Saved Product is null"),
                () -> assertNotNull(savedProduct.getId(), "Saved Product id is null"),
                () -> assertEquals(expectedProductListSize, currentListSize, "Products entity list size is not"
                        + expectedProductListSize)
        );
    }

//    @SpringBootApplication
//    public static class TestConfiguration {
//
//    }


}