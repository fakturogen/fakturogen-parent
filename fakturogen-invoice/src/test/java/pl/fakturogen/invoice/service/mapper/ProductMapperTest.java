package pl.fakturogen.invoice.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.fakturogen.invoice.dao.entity.Product;
import pl.fakturogen.invoice.dao.entity.Rate;
import pl.fakturogen.invoice.web.dto.ProductDTO;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ProductMapperTest {

    private Product product;
    private ProductDTO productDTO;

    @BeforeEach
    void init() {
        product = new Product();
        product.setId(1);
        product.setName("nazwa produktu");
        product.setDescription("testowa nazwa produktu");
        product.setItemCode("item code 111");
        product.setUnitOfMeasurement("szt");
        product.setSaleNetPrice(11.22);
        product.setSaleGrossPrice((11.22*1.04));
        product.setRate(Rate.R6);
        product.setIdExternalApi(9999);

        productDTO = new ProductDTO();
        productDTO.setName("nazwa produktu");
        productDTO.setDescription("testowa nazwa produktu");
        productDTO.setItemCode("item code 111");
        productDTO.setUnitOfMeasurement("szt");
        productDTO.setSaleNetPrice(11.22);
        productDTO.setSaleGrossPrice(11.22*1.04);
        productDTO.setRate(Rate.R6);
        productDTO.setIdExternalApi(9999);
    }

    @Test
    void givenProductShouldReturnProductDTO() {
        ProductMapper productMapper = new ProductMapper();
        ProductDTO productDTOresult = productMapper.from(product);

        assertAll(
                () -> assertThat(productDTOresult.getName()).isEqualTo(productDTO.getName()),
                () -> assertThat(productDTOresult.getDescription()).isEqualTo(productDTO.getDescription()),
                () -> assertThat(productDTOresult.getItemCode()).isEqualTo(productDTO.getItemCode()),
                () -> assertThat(productDTOresult.getUnitOfMeasurement()).isEqualTo(productDTO.getUnitOfMeasurement()),
                () -> assertThat(productDTOresult.getSaleNetPrice()).isEqualTo(productDTO.getSaleNetPrice()),
                () -> assertThat(productDTOresult.getSaleGrossPrice()).isEqualTo(productDTO.getSaleGrossPrice()),
                () -> assertThat(productDTOresult.getRate()).isEqualTo(productDTO.getRate()),
                () -> assertThat(productDTOresult.getIdExternalApi()).isEqualTo(productDTO.getIdExternalApi())
        );

    }

}