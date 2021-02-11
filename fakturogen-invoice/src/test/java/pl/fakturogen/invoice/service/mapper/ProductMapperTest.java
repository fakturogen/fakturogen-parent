package pl.fakturogen.invoice.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pl.fakturogen.invoice.dao.entity.Product;
import pl.fakturogen.invoice.dao.entity.Rate;
import pl.fakturogen.invoice.web.dto.ProductDTO;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest {

    private Product product;
    private Product emptyProduct;
    private Product partEmptyProduct;
    private ProductDTO productDTO;
    private ProductDTO emptyProductDTO;
    private ProductDTO partEmptyProductDTO;
    private ProductMapper productMapper;

    @BeforeEach
    void init() {
        product = new Product();
        product.setName("nazwa produktu");
        product.setDescription("testowa nazwa produktu");
        product.setItemCode("item code 111");
        product.setUnitOfMeasurement("szt");
        product.setSaleNetPrice(11.22);
        product.setSaleGrossPrice((11.22 * 1.04));
        product.setRate(Rate.R6);
        product.setIdExternalApi(9999L);

        emptyProduct = new Product();

        partEmptyProduct = new Product();
        partEmptyProduct.setName("PRODUCT TEST NAME");
        partEmptyProduct.setId(1);
        partEmptyProduct.setSaleNetPrice(99_999_999);

        productDTO = new ProductDTO();
        productDTO.setName("nazwa produktu");
        productDTO.setDescription("testowa nazwa produktu");
        productDTO.setItemCode("item code 111");
        productDTO.setUnitOfMeasurement("szt");
        productDTO.setSaleNetPrice(11.22);
        productDTO.setSaleGrossPrice(11.22 * 1.04);
        productDTO.setRate(Rate.R6);
        productDTO.setIdExternalApi(9999L);

        emptyProductDTO = new ProductDTO();

        partEmptyProductDTO = new ProductDTO();
        partEmptyProductDTO.setName("PRODUCT TEST NAME");
        partEmptyProductDTO.setSaleNetPrice(99_999_999);

        productMapper = new ProductMapper();
    }

    @Nested
    class ProductToDTO {
        @Test
        void givenProductShouldReturnProductDTO() {
            ProductDTO productDTOresult = productMapper.from(product);
            assertEquals(productDTO, productDTOresult);
        }

        @Test
        void givenEmptyProductShouldReturnEmptyProductDTO() {
            ProductDTO productDTOresult = productMapper.from(emptyProduct);
            assertEquals(emptyProductDTO, productDTOresult);
        }

        @Test
        void givenPartlyEmptyProductShouldReturnPartlyEmptyProductDTO() {
            ProductDTO productDTOresult = productMapper.from(partEmptyProduct);
            assertEquals(partEmptyProductDTO, productDTOresult);
        }

    }


    @Nested
    class DTOtoProduct {
        @Test
        void givenProductDTOShouldReturnProduct() {
            Product productResult = productMapper.from(productDTO);
            assertEquals(product, productResult);
        }

        @Test
        void givenEmptyProductDTOShouldReturnEmptyProduct() {
            Product productResult = productMapper.from(emptyProductDTO);
            assertEquals(emptyProduct, productResult);
        }

        @Test
        void givenPartlyEmptyProductDTOShouldReturnPartlyEmptyProduct() {
            ProductDTO productResultDTO = productMapper.from(partEmptyProduct);
            assertEquals(productResultDTO, partEmptyProductDTO);
        }

    }


}